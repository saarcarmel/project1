package dbdao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import couponSystem.CouponSystem;
import couponsException.DaoException;
import dao.CustomerCouponDAO;
import javaBean.Customer;
import javaBean.Coupon;

/**
 * 
 * @author Saar.Carmel
 *
 */
public class CustomerCouponDBDAO implements CustomerCouponDAO {
	private Connection connection;
	private Coupon coupon;
	private long Customer_id;
	private long Coupon_id;

	/**
	 * 
	 * @return
	 */
	public long getCustomer_id() {
		return Customer_id;
	}

	/**
	 * 
	 * @param customer_id
	 */
	public void setCustomer_id(long customer_id) {
		Customer_id = customer_id;
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

	public void createCustomerCoupon(Customer customer, Coupon coupon) {
		loadDriver();
		connection = getConnection();
		CreateCustomerCouponStatement();
	}

	public void removeCustomerCoupon(Customer customer, Coupon coupon) {
		loadDriver();
		connection = getConnection();
	}

	public static void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException classNotFoundException) {
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

	public void CreateCustomerCouponStatement() {
		try {
			Statement statement = connection.createStatement();
			String sqlCompID = "UPDATE coupons.customer_coupon SET comp_id='" + getCustomer_id() + "';";
			statement.executeUpdate(sqlCompID);
			String sqlCouponId = "UPDATE coupons.customer_coupon SET coupon_id='" + getCoupon_id() + "';";
			statement.executeUpdate(sqlCouponId);
		} catch (SQLException e) {
			System.out.println("SQL Exception");
		}
	}

	/**
	 * 
	 * @throws DaoException
	 */
	public void RemoveCustomerCouponStatement() throws DaoException {
		try {
			Statement statement = connection.createStatement();
			String sql = "DELETE FROM coupons.customer_coupon WHERE coupon_id='" + coupon.getId() + "';";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();

			System.out.println("SQL Exception");
			throw new DaoException(e);
		}
	}
}