package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import couponClientType.CouponClientType;
import couponSystem.CouponSystem;
import couponType.CouponType;
import dbdao.CompanyDBDAO;
import dbdao.CouponDBDAO;
import dbdao.CustomerDBDAO;
import facade.AdminFacade;
import facade.CompanyFacade;
import facade.CustomerFacade;
import javaBean.Company;
import javaBean.Coupon;
import javaBean.Customer;

/**
 * 
 * @author Saar.Carmel
 *
 */
public class Test {
	static Connection connection = null;

	static Company company1 = new Company();
	static Company company2 = new Company();

	static Coupon coupon1 = new Coupon();
	static Coupon coupon2 = new Coupon();
	static Coupon coupon3 = new Coupon();
	static Coupon coupon4 = new Coupon();
	static Coupon coupon5 = new Coupon();
	static Coupon coupon6 = new Coupon();
	static Coupon coupon7 = new Coupon();

	static Customer customer1 = new Customer();
	static Customer customer2 = new Customer();

	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	static String url = "jdbc:mysql://localhost/coupons?useSSL=false";
	static String userName = "root";
	static String password = "root";

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(simpleDateFormat.format(new Date()) + " Test.main() starts");

		CouponSystem couponSystem = CouponSystem.getInstance();

		AdminFacade adminFacade = (AdminFacade) couponSystem.login("admin", "1234", CouponClientType.ADMIN);
		if (adminFacade == null) {
			System.out.println("Login failed!");
			return;
		}

		CompanyFacade companyFacade = (CompanyFacade) couponSystem.login("company1", "pass1", CouponClientType.COMPANY);
		if (companyFacade == null) {
			System.out.println("Login failed!");
			return;
		}
		CustomerFacade customerFacade = (CustomerFacade) couponSystem.login("customer1", "pass1",
				CouponClientType.CUSTOMER);
		if (customerFacade == null) {
			System.out.println("Login failed!");
			return;
		}

		coupon1 = new Coupon(1, "coupon1", new Date(), new Date(), 10, CouponType.RESTAURANTS, "message1", 100.0,
				"image1");
		coupon2 = new Coupon(2, "coupon2", new Date(), new Date(), 20, CouponType.ELECTRICITY, "message2", 200.0,
				"image2");
		coupon3 = new Coupon(3, "coupon3", new Date(), new Date(), 30, CouponType.FOOD, "message3", 300.0, "image3");
		coupon4 = new Coupon(4, "coupon4", new Date(), new Date(), 40, CouponType.HEALTH, "message4", 200.0, "image4");
		coupon5 = new Coupon(5, "coupon5", new Date(), new Date(), 50, CouponType.SPORTS, "message5", 200.0, "image5");
		coupon6 = new Coupon(6, "coupon6", new Date(), new Date(), 60, CouponType.CAMPING, "message6", 200.0, "image6");
		coupon7 = new Coupon(7, "coupon7", new Date(), new Date(), 70, CouponType.TRAVELLING, "message7", 700.0,
				"image7");

		setCompany1();
		setCompany2();

		setCoupon1();
		setCoupon2();
		setCoupon3();
		setCoupon4();
		setCoupon5();
		setCoupon6();
		setCoupon7();

		setCustomer1();
		setCustomer2();

		adminFacade.toString();
		companyFacade.toString();
		customerFacade.toString();

		loadDriver();
		connection = getConnection();

		createStatementCoupon();
		createStatementCompany();
		createStatementCustomer();

		CouponDBDAO couponDBDAO1 = new CouponDBDAO();

		// couponDBDAO1.createCoupon(coupon1); // Keep this for code reuse
		// couponDBDAO1.createCoupon(coupon2); // Keep this for code reuse
		// couponDBDAO1.createCoupon(coupon3); // Keep this for code reuse
		// couponDBDAO1.createCoupon(coupon4); // Keep this for code reuse
		// couponDBDAO1.createCoupon(coupon5); // Keep this for code reuse
		// couponDBDAO1.createCoupon(coupon6); // Keep this for code reuse
		// couponDBDAO1.createCoupon(coupon7); // Keep this for code reuse

		couponDBDAO1.getCoupon(1);
		System.out.println("couponDBDAO1.getCoupon(1) = ");
		System.out.println(couponDBDAO1.getCoupon(1));

		couponDBDAO1.getCoupon(2);
		System.out.println("couponDBDAO1.getCoupon(2) = ");
		System.out.println(couponDBDAO1.getCoupon(2));

		couponDBDAO1.getCoupon(3);
		System.out.println("couponDBDAO1.getCoupon(3) = ");
		System.out.println(couponDBDAO1.getCoupon(3));

		couponDBDAO1.getCoupon(4);
		System.out.println("couponDBDAO1.getCoupon(4) = ");
		System.out.println(couponDBDAO1.getCoupon(4));

		couponDBDAO1.getCoupon(5);
		System.out.println("couponDBDAO1.getCoupon(5) = ");
		System.out.println(couponDBDAO1.getCoupon(5));

		couponDBDAO1.getCoupon(6);
		System.out.println("couponDBDAO1.getCoupon(6) = ");
		System.out.println(couponDBDAO1.getCoupon(6));

		couponDBDAO1.getCoupon(7);
		System.out.println("couponDBDAO1.getCoupon(7) = ");
		System.out.println(couponDBDAO1.getCoupon(7));

		couponDBDAO1.getAllCoupons();

		couponDBDAO1.updateCoupon(coupon1);
		couponDBDAO1.updateCoupon(coupon2);
		couponDBDAO1.updateCoupon(coupon3);
		couponDBDAO1.updateCoupon(coupon4);
		couponDBDAO1.updateCoupon(coupon5);
		couponDBDAO1.updateCoupon(coupon6);
		couponDBDAO1.updateCoupon(coupon7);

		// couponDBDAO1.removeCoupon(coupon1); // Keep this for code reuse
		// couponDBDAO1.removeCoupon(coupon2); // Keep this for code reuse
		// couponDBDAO1.removeCoupon(coupon3); // Keep this for code reuse
		// couponDBDAO1.removeCoupon(coupon4); // Keep this for code reuse
		// couponDBDAO1.removeCoupon(coupon5); // Keep this for code reuse
		// couponDBDAO1.removeCoupon(coupon6); // Keep this for code reuse
		// couponDBDAO1.removeCoupon(coupon7); // Keep this for code reuse

		CompanyDBDAO companyDBDAO1 = new CompanyDBDAO();

		// companyDBDAO1.createCompany(company1); // Keep this for code reuse
		// companyDBDAO1.createCompany(company2); // Keep this for code reuse

		companyDBDAO1.getCompany(1);
		companyDBDAO1.getCompany(2);

		companyDBDAO1.updateCompany(company1);
		companyDBDAO1.updateCompany(company2);

		// companyDBDAO1.removeCompany(company1); // Keep this for code reuse
		// companyDBDAO1.removeCompany(company2); // Keep this for code reuse

		CustomerDBDAO customerDBDAO1 = new CustomerDBDAO();

		// customerDBDAO1.createCustomer(customer1); // Keep this for code reuse
		// customerDBDAO1.createCustomer(customer2); // Keep this for code reuse

		customerDBDAO1.getCustomer(1);
		customerDBDAO1.getCustomer(2);

		customerDBDAO1.updateCustomer(customer1);
		customerDBDAO1.updateCustomer(customer2);

		// customerDBDAO1.removeCustomer(customer1); // Keep this for code reuse
		// customerDBDAO1.removeCustomer(customer2); // Keep this for code reuse

		couponSystem.shutdown();
		System.out.println(simpleDateFormat.format(new Date()) + " Test.main() finishes");
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
	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException sqlException1) {
		}
		return connection;
	}

	public static void setCompany1() {
		Company company1;
		company1 = new Company();
		company1.setId(1);
		company1.setCompName("compName1");
		company1.setPassword("pass1");
		company1.setEmail("a@example.com");
		System.out.println(company1);
	}

	public static void setCompany2() {
		Company company2;
		company2 = new Company();
		company2.setId(2);
		company2.setCompName("compName2");
		company2.setPassword("pass2");
		company2.setEmail("b@example.com");
		System.out.println(company2);
	}

	public static void setCoupon1() {
		coupon1.setId(1);
		coupon1.setTitle("coupon1");
		String startDateInString1 = "2016-01-01";
		Date startDate1;
		try {
			startDate1 = simpleDateFormat.parse(startDateInString1);
			coupon1.setStartDate(startDate1);
		} catch (ParseException e1) {
		}
		String endDateInString1 = "2016-01-31";
		Date endDate1;
		try {
			endDate1 = simpleDateFormat.parse(endDateInString1);
			coupon1.setEndDate(endDate1);
		} catch (ParseException e1) {
		}
		coupon1.setAmount(10);
		coupon1.setType(CouponType.RESTAURANTS);
		coupon1.setMessage("message1");
		coupon1.setPrice(100.0);
		coupon1.setImage("image1");
		System.out.println(coupon1);
	}

	public static void setCoupon2() {
		coupon2 = new Coupon();
		coupon2.setId(2);
		coupon2.setTitle("coupon2");
		String startDateInString2 = "2016-02-01";
		Date startDate2;
		try {
			startDate2 = simpleDateFormat.parse(startDateInString2);
			coupon2.setStartDate(startDate2);
		} catch (ParseException e1) {
		}
		String endDateInString2 = "2016-02-29";
		Date endDate2;
		try {
			endDate2 = simpleDateFormat.parse(endDateInString2);
			coupon2.setEndDate(endDate2);
		} catch (ParseException e1) {
		}
		coupon2.setAmount(20);
		coupon2.setType(CouponType.ELECTRICITY);
		coupon2.setMessage("message2");
		coupon2.setPrice(200.0);
		coupon2.setImage("image2");
		System.out.println(coupon2);
	}

	public static void setCoupon3() {
		Coupon coupon3;
		coupon3 = new Coupon();
		coupon3.setId(3);
		coupon3.setTitle("coupon3");
		String startDateInString3 = "2016-03-01";
		Date startDate3;
		try {
			startDate3 = simpleDateFormat.parse(startDateInString3);
			coupon3.setStartDate(startDate3);
		} catch (ParseException e1) {
		}
		String endDateInString3 = "2016-03-31";
		Date endDate3;
		try {
			endDate3 = simpleDateFormat.parse(endDateInString3);
			coupon3.setEndDate(endDate3);
		} catch (ParseException e1) {
		}
		coupon3.setAmount(30);
		coupon3.setType(CouponType.FOOD);
		coupon3.setMessage("message3");
		coupon3.setPrice(300.0);
		coupon3.setImage("image3");
		System.out.println(coupon3);

	}

	public static void setCoupon4() {
		Coupon coupon4;
		coupon4 = new Coupon();
		coupon4.setId(4);
		coupon4.setTitle("coupon4");
		String startDateInString4 = "2016-04-01";
		Date startDate4;
		try {
			startDate4 = simpleDateFormat.parse(startDateInString4);
			coupon4.setStartDate(startDate4);
		} catch (ParseException e1) {
		}
		String endDateInString4 = "2016-04-30";
		Date endDate4;
		try {
			endDate4 = simpleDateFormat.parse(endDateInString4);
			coupon4.setEndDate(endDate4);
		} catch (ParseException e1) {
		}
		coupon4.setAmount(40);
		coupon4.setType(CouponType.HEALTH);
		coupon4.setMessage("message4");
		coupon4.setPrice(400.0);
		coupon4.setImage("image4");
		System.out.println(coupon4);

	}

	public static void setCoupon5() {
		Coupon coupon5;
		coupon5 = new Coupon();
		coupon5.setId(5);
		coupon5.setTitle("coupon5");
		String startDateInString5 = "2016-05-01";
		Date startDate5;
		try {
			startDate5 = simpleDateFormat.parse(startDateInString5);
			coupon5.setStartDate(startDate5);
		} catch (ParseException e1) {
		}
		String endDateInString5 = "2016-05-31";
		Date endDate5;
		try {
			endDate5 = simpleDateFormat.parse(endDateInString5);
			coupon5.setEndDate(endDate5);
		} catch (ParseException e1) {
		}
		coupon5.setAmount(50);
		coupon5.setType(CouponType.SPORTS);
		coupon5.setMessage("message5");
		coupon5.setPrice(500.0);
		coupon5.setImage("image5");
		System.out.println(coupon5);
	}

	public static void setCoupon6() {
		Coupon coupon6;
		coupon6 = new Coupon();
		coupon6.setId(6);
		coupon6.setTitle("coupon6");
		String startDateInString6 = "2016-06-01";
		Date startDate6;
		try {
			startDate6 = simpleDateFormat.parse(startDateInString6);
			coupon6.setStartDate(startDate6);
		} catch (ParseException e1) {
		}
		String endDateInString6 = "2016-06-30";
		Date endDate6;
		try {
			endDate6 = simpleDateFormat.parse(endDateInString6);
			coupon6.setEndDate(endDate6);
		} catch (ParseException e1) {
		}
		coupon6.setAmount(60);
		coupon6.setType(CouponType.CAMPING);
		coupon6.setMessage("message6");
		coupon6.setPrice(600.0);
		coupon6.setImage("image6");
		System.out.println(coupon6);

	}

	public static void setCoupon7() {
		Coupon coupon7;
		coupon7 = new Coupon();
		coupon7.setId(7);
		coupon7.setTitle("coupon7");
		String startDateInString7 = "2016-07-01";
		Date startDate7;
		try {
			startDate7 = simpleDateFormat.parse(startDateInString7);
			coupon7.setStartDate(startDate7);
		} catch (ParseException e1) {
		}
		String endDateInString7 = "2016-07-31";
		Date endDate7;
		try {
			endDate7 = simpleDateFormat.parse(endDateInString7);
			coupon7.setEndDate(endDate7);
		} catch (ParseException e1) {
		}
		coupon7.setAmount(70);
		coupon7.setType(CouponType.TRAVELLING);
		coupon7.setMessage("message7");
		coupon7.setPrice(700.0);
		coupon7.setImage("image7");
		System.out.println(coupon7);
	}

	public static void setCustomer1() {
		Customer customer1;
		customer1 = new Customer();
		customer1.setId(1);
		customer1.setCustName("custName1");
		customer1.setPassword("pass1");
		System.out.println(customer1);
	}

	public static void setCustomer2() {
		Customer customer2;
		customer2 = new Customer();
		customer2.setId(2);
		customer2.setCustName("custName2");
		customer2.setPassword("pass2");
		System.out.println(customer2);
	}

	public static void createStatementCompany() {
		try {
			Statement statementCompany = connection.createStatement();
			String sqlCompany = "SELECT * FROM coupons.company ORDER BY id";
			ResultSet resultSetCompany = statementCompany.executeQuery(sqlCompany);
			while (resultSetCompany.next()) {
				System.out.println(" company [");
				System.out.println(" id = " + resultSetCompany.getString("id") + " ");
				System.out.println(" compName = " + resultSetCompany.getString("compName") + " ");
				System.out.println(" password = " + resultSetCompany.getString("root") + " ");
				System.out.println(" email = " + resultSetCompany.getString("email") + " ");
				System.out.println("]");
				System.out.println("");
			}
		} catch (SQLException e) {
		}

	}

	public static void createStatementCoupon() {
		try {
			Statement statementCoupon = connection.createStatement();
			String sqlCoupon = "SELECT * FROM coupons.coupon ORDER BY id";
			ResultSet resultSetCoupon = statementCoupon.executeQuery(sqlCoupon);
			while (resultSetCoupon.next()) {
				System.out.println("coupon [");
				System.out.println(" id = " + resultSetCoupon.getString("id") + " ");
				System.out.println(" title = " + resultSetCoupon.getString("title") + " ");
				System.out.println(" startDate = " + resultSetCoupon.getString("startDate") + " ");
				System.out.println(" endDate = " + resultSetCoupon.getString("endDate") + " ");
				System.out.println(" amount = " + resultSetCoupon.getString("amount") + " ");
				System.out.println(" type = " + resultSetCoupon.getString("type") + " ");
				System.out.println(" message = " + resultSetCoupon.getString("message") + " ");
				System.out.println(" price = " + resultSetCoupon.getString("price") + " ");
				System.out.println(" image = " + resultSetCoupon.getString("image") + " ");
				System.out.println("]");
				System.out.println("");
			}
		} catch (SQLException e) {
		}
	}

	public static void createStatementCustomer() {
		try {
			Statement statementCustomer = connection.createStatement();
			String sqlCustomer = "SELECT * FROM coupons.customer ORDER BY id";
			ResultSet resultSetCustomer = statementCustomer.executeQuery(sqlCustomer);
			while (resultSetCustomer.next()) {
				System.out.println("customer [");
				System.out.println(" id = " + resultSetCustomer.getString("id") + " ");
				System.out.println(" custName = " + resultSetCustomer.getString("custName") + " ");
				System.out.println(" password = " + resultSetCustomer.getString("password") + " ");
				System.out.println("]");
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}