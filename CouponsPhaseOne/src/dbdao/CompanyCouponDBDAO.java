package dbdao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import couponSystem.CouponSystem;
import couponsException.DaoException;
import dao.CompanyCouponDAO;
import javaBean.Company;
import javaBean.Coupon;

/**
 * 
 * @author Saar.Carmel
 *
 */
public class CompanyCouponDBDAO implements CompanyCouponDAO {

	private Connection connection;
	private Coupon coupon;
	private long Company_id;
	private long Coupon_id;

	/**
	 * 
	 * @return
	 */
	public long getCompany_id() {
		return Company_id;
	}

	/**
	 * 
	 * @param company_id
	 */
	public void setCompany_id(long company_id) {
		Company_id = company_id;
	}

	/**
	 * 
	 * @return
	 */
	public long getCoupon_id() {
		return Coupon_id;
	}

	/**
	 * 
	 * @param coupon_id
	 */
	public void setCoupon_id(long coupon_id) {
		Coupon_id = coupon_id;
	}

	/**
	 * 
	 */
	public void createCompanyCoupon(Company company, Coupon coupon) throws DaoException {
		loadDriver();
		connection = getConnection();
		CreateCompanyCouponStatement();
	}

	/**
	 * 
	 */
	public void removeCompanyCoupon(Company company, Coupon coupon) {
		loadDriver();
		connection = getConnection();
	}

	public static void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException classNotFoundException) {
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
	 * @throws DaoException
	 */
	public void CreateCompanyCouponStatement() throws DaoException {
		try {
			Statement statement = connection.createStatement();
			String sqlCompID = "UPDATE coupons.company_coupon SET comp_id='" + getCompany_id() + "';";
			statement.executeUpdate(sqlCompID);
			String sqlCouponId = "UPDATE coupons.company_coupon SET coupon_id='" + getCoupon_id() + "';";
			statement.executeUpdate(sqlCouponId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 
	 * @throws DaoException
	 */
	public void RemoveCompanyCouponStatement() throws DaoException {
		try {
			Statement statement = connection.createStatement();
			String sql = "DELETE FROM coupons.company_coupon WHERE coupon_id='" + coupon.getId() + "';";
			statement.executeUpdate(sql);
		} catch (SQLException e) {

			System.out.println("SQL Exception");
			throw new DaoException(e);
		}
	}
}