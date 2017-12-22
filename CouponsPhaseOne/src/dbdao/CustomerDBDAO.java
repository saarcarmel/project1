package dbdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import dao.CustomerDAO;
import javaBean.Coupon;
import javaBean.Customer;

/**
 * 
 * @author Saar.Carmel
 *
 */
public class CustomerDBDAO implements CustomerDAO {
	private Customer customer = null;
	private Collection<Coupon> coupons = null;
	private Collection<Customer> customers = null;
	private Connection connection = null;
	private String url = "jdbc:mysql://localhost/coupons?useSSL=false";
	private String username = "root";
	private String password = "root";

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
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException sqlException) {
			System.out.println("SQL Exception");
		}
		return connection;
	}

	public CustomerDBDAO() {
		super();
	}

	@Override
	public void createCustomer(Customer customer) {
		loadDriver();
		connection = getConnection();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException classNotFoundException1) {
			classNotFoundException1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/coupons?useSSL=false", "root", "root");
		} catch (SQLException sqlException1) {
		}
		try {
			Statement statement1 = connection.createStatement();

			String sql1 = "INSERT INTO coupons.customer (id, custName, password) VALUES ('" + customer.getId() + "', '"
					+ customer.getCustName() + "', '" + customer.getPassword() + "')";
			statement1.executeUpdate(sql1);
		} catch (SQLException e) {
		}
	}

	@Override
	public void removeCustomer(Customer customer) {
		loadDriver();
		connection = getConnection();
		try {
			Statement statement1 = connection.createStatement();
			String sql1 = "DELETE FROM coupons.customer WHERE id='" + customer.getId() + "';";
			statement1.executeUpdate(sql1);
		} catch (SQLException e) {
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		loadDriver();
		connection = getConnection();
		try {
			Statement statement1 = connection.createStatement();
			String sql1 = "UPDATE coupons.customer SET custName='" + customer.getCustName() + "', password='"
					+ customer.getPassword() + "' WHERE id='" + customer.getId() + "';";
			statement1.executeUpdate(sql1);
		} catch (SQLException e) {
		}
	}

	@Override
	public Customer getCustomer(long id) {
		loadDriver();
		connection = getConnection();
		try {
			Statement statement1 = connection.createStatement();
			String sql1 = "SELECT * FROM coupons.customer WHERE id=" + id;
			ResultSet resultSet1 = statement1.executeQuery(sql1);
			while (resultSet1.next()) {
				System.out.println("customer [");
				System.out.println(" id = " + resultSet1.getString("id") + " ");
				System.out.println(" custName = " + resultSet1.getString("custName") + " ");
				System.out.println(" password = " + resultSet1.getString("root") + " ");
				System.out.println("]");
				System.out.println("");
			}
		} catch (SQLException e) {
		}
		return customer;
	}

	@Override
	public Collection<Customer> getAllCustomers() {
		for (Customer customer : customers) {
			customers.add(customer);
		}
		return customers;
	}

	@Override
	public Collection<Coupon> getCoupons() {
		for (Coupon coupon : coupons) {
			coupons.add(coupon);
		}
		return coupons;
	}

	@Override
	public boolean login(String custName, String password) {
		boolean login;
		login = true;
		if (!(this.customer.getCustName().equals(custName))) {
			login = false;
		}
		if (!(this.customer.getPassword().equals(password))) {
			login = false;
		}
		return login;
	}
}