package dbdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import couponSystem.CouponSystem;
import couponType.CouponType;
import couponsException.DaoException;
import dao.CouponDAO;
import javaBean.Coupon;

/**
 * 
 * @author Saar.Carmel
 *
 */
public class CouponDBDAO implements CouponDAO {
	private Connection connection = null;

	public CouponDBDAO() {
		super();
	}

	public static void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException classNotFoundException) {
			classNotFoundException.printStackTrace();
			System.out.println("Class Not Found Exception");
		}
	}

	/**
	 * 
	 * @return
	 */
	public Connection getConnection() {
		try {
			connection = CouponSystem.getConnectionPool().getConnection();
		} catch (SQLException sqlException) {
			System.out.println("SQL Exception");
		}
		return connection;
	}

	/**
	 * 
	 * @param connection
	 */
	public void releaseConnection(Connection connection) {
		CouponSystem.getConnectionPool().free(connection);
	}

	@Override
	public void createCoupon(Coupon coupon) throws DaoException {
		loadDriver();
		connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			String sqlId = "INSERT INTO coupons.coupon (id) VALUES " + (coupon.getId());
			statement.executeUpdate(sqlId);
			String sqlTitle = "INSERT INTO coupons.coupon (title) VALUES " + (coupon.getTitle());
			statement.executeUpdate(sqlTitle);
			String sqlStartDate = "INSERT INTO coupons.coupon (startDate) VALUES " + (coupon.getStartDate());
			statement.executeUpdate(sqlStartDate);
			String sqlEndDate = "INSERT INTO coupons.coupon (endDate) VALUES " + (coupon.getEndDate());
			statement.executeUpdate(sqlEndDate);
			String sqlAmount = "INSERT INTO coupons.coupon (amount) VALUES " + (coupon.getAmount());
			statement.executeUpdate(sqlAmount);
			String sqlType = "INSERT INTO coupons.coupon (type) VALUES " + (coupon.getType());
			statement.executeUpdate(sqlType);
			String sqlMessage = "INSERT INTO coupons.coupon (message) VALUES " + (coupon.getMessage());
			statement.executeUpdate(sqlMessage);
			String sqlPrice = "INSERT INTO coupons.coupon (price) VALUES " + (coupon.getPrice());
			statement.executeUpdate(sqlPrice);
			String sqlImage = "INSERT INTO coupons.coupon (image) VALUES " + (coupon.getImage());
			statement.executeUpdate(sqlImage);
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			releaseConnection(connection);
		}
	}

	@Override
	public void removeCoupon(Coupon coupon) throws DaoException {
		loadDriver();
		connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "DELETE FROM coupons.coupon WHERE id='" + coupon.getId() + "';";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			releaseConnection(connection);
		}
	}

	@Override
	public void updateCoupon(Coupon coupon) {
		loadDriver();
		connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			String sqlTitle = "UPDATE coupons.coupon SET title='" + coupon.getTitle() + "';";
			statement.executeUpdate(sqlTitle);
			String sqlStartDate = "UPDATE coupons.coupon SET startDate='" + getSqlDate(coupon.getStartDate()) + "';";
			statement.executeUpdate(sqlStartDate);
			String sqlEndDate = "UPDATE coupons.coupon SET endDate='" + getSqlDate(coupon.getEndDate()) + "';";
			statement.executeUpdate(sqlEndDate);
			String sqlAmount = "UPDATE coupons.coupon SET amount='" + coupon.getAmount() + "';";
			statement.executeUpdate(sqlAmount);
			String sqlType = "UPDATE coupons.coupon SET type='" + coupon.getType() + "';";
			statement.executeUpdate(sqlType);
			String sqlMessage = "UPDATE coupons.coupon SET message='" + coupon.getMessage() + "';";
			statement.executeUpdate(sqlMessage);
			String sqlPrice = "UPDATE coupons.coupon SET price='" + coupon.getPrice() + "';";
			statement.executeUpdate(sqlPrice);
			String sqlImage = "UPDATE coupons.coupon SET image='" + coupon.getImage() + "';";
			statement.executeUpdate(sqlImage);
		} catch (SQLException e) {
			System.out.println("SQL Exception");
		}
	}

	@Override
	public Coupon getCoupon(long id) {
		Coupon coupon = new Coupon();
		long id1 = coupon.getId();
		String title1 = coupon.getTitle();
		Date startDate1 = coupon.getStartDate();
		Date endDate1 = coupon.getEndDate();
		int amount1 = coupon.getAmount();
		CouponType couponType1 = coupon.getType();
		String message1 = coupon.getMessage();
		double price1 = coupon.getPrice();
		String image1 = coupon.getImage();
		loadDriver();
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM coupons.coupon WHERE id=" + id;
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println("coupon [");
				id1 = resultSet.getLong("id");
				System.out.println(" id1 = " + id1 + " ");
				coupon.setId(id1);

				title1 = resultSet.getString("title");
				System.out.println(" title1 = " + title1 + " ");
				coupon.setTitle(title1);

				startDate1 = resultSet.getDate("startDate");
				System.out.println(" startDate = " + startDate1 + " ");
				coupon.setStartDate(startDate1);

				endDate1 = resultSet.getDate("endDate");
				System.out.println(" endDate = " + endDate1 + " ");
				coupon.setEndDate(endDate1);

				amount1 = resultSet.getInt("amount");
				System.out.println(" amount = " + amount1);
				coupon.setAmount(amount1);

				couponType1 = CouponType.valueOf(resultSet.getString("type"));
				System.out.println(" type = " + couponType1 + " ");
				coupon.setType(couponType1);

				message1 = resultSet.getString("message");
				System.out.println(" message = " + resultSet.getString("message") + " ");
				coupon.setMessage(message1);

				price1 = resultSet.getDouble("price");
				System.out.println(" price = " + resultSet.getString("price") + " ");
				coupon.setPrice(price1);

				image1 = resultSet.getString("image");
				System.out.println(" image = " + resultSet.getString("image") + " ");
				coupon.setImage(image1);

				System.out.println("]");
				System.out.println("");
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception");
		} finally {
		}
		return coupon;
	}

	@Override
	public Collection<Coupon> getAllCoupons() {
		ArrayList<Coupon> coupons;
		coupons = new ArrayList<>();
		Coupon coupon1;
		long id = 1;
		for (Coupon coupon : coupons) {
			coupon1 = this.getCoupon(id);
			coupons.add(coupon1);
			System.out.println(coupon);
			id++;
		}
		return coupons;
	}

	@Override
	public Collection<Coupon> getCouponByType(CouponType couponType) {
		Collection<Coupon> coupons;
		coupons = null;
		return coupons;
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public java.sql.Date getSqlDate(Date date) {
		return new java.sql.Date(date.getTime());
	}
}