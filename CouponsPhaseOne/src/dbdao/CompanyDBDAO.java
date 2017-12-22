package dbdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import dao.CompanyDAO;
import javaBean.Company;
import javaBean.Coupon;

/**
 * 
 * @author Saar.Carmel
 *
 */
public class CompanyDBDAO implements CompanyDAO {

	private Company company = null;
	private Collection<Company> companies = null;
	private Collection<Coupon> coupons = null;
	private Connection connection = null;
	private String url = "jdbc:mysql://localhost/coupons?useSSL=false";
	private String username = "root";
	private String password = "root";

	public CompanyDBDAO() {
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
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException sqlException) {
			System.out.println("SQL Exception");
		}
		return connection;
	}

	@Override
	public void createCompany(Company company) {
		loadDriver();
		connection = getConnection();
		try {
			Statement statement1 = connection.createStatement();

			String sql1 = "INSERT INTO coupons.company (id, compName, password, email) VALUES ('" + company.getId()
					+ "', '" + company.getCompName() + "', '" + company.getPassword() + "', '" + company.getEmail()
					+ "')";
			statement1.executeUpdate(sql1);
		} catch (SQLException e) {
		}
	}

	@Override
	public void removeCompany(Company company) {
		loadDriver();
		connection = getConnection();
		try {
			Statement statement1 = connection.createStatement();
			String sql1 = "DELETE FROM coupons.company WHERE id='" + company.getId() + "';";
			statement1.executeUpdate(sql1);
		} catch (SQLException e) {
		}
	}

	@Override
	public void updateCompany(Company company) {
		loadDriver();
		connection = getConnection();
		try {
			Statement statement1 = connection.createStatement();
			String sql1 = "UPDATE coupons.company SET compName='" + company.getCompName() + "', password='"
					+ company.getPassword() + "', email='" + company.getEmail() + "' WHERE id='" + company.getId()
					+ "';";
			statement1.executeUpdate(sql1);
		} catch (SQLException e) {
		}
	}

	@Override
	public Company getCompany(long id) {
		loadDriver();
		connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM coupons.company WHERE id=" + id;
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				// System.out.println("company [");
				// System.out.println(" id = " + resultSet.getString("id") + "
				// ");
				// System.out.println(" compName = " +
				// resultSet.getString("compName") + " ");
				// System.out.println(" password = " +
				// resultSet.getString("root") + " ");
				// System.out.println(" email = " + resultSet.getString("email")
				// + " ");
				// System.out.println("]");
				// System.out.println("");
			}
		} catch (SQLException e) {
		}
		return company;
	}

	@Override
	public Collection<Company> getAllCompanies() {
		for (Company company : companies) {
			companies.add(company);
		}
		return companies;
	}

	@Override
	public Collection<Coupon> getCoupons() {
		for (Coupon coupon : coupons) {
			coupons.add(coupon);
		}
		return coupons;
	}

	@Override
	public boolean login(String compName, String password) {
		boolean login;
		login = true;
		if (!(this.company.getCompName().equals(compName))) {
			login = false;
		}
		if (!(this.company.getPassword().equals(password))) {
			login = false;
		}
		return login;
	}
}