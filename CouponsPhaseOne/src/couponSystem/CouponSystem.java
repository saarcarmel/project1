package couponSystem;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import connectionPool.ConnectionPool;
import couponClientFacade.CouponClientFacade;
import couponClientType.CouponClientType;
import dailyCouponExpirationTask.DailyCouponExpirationTask;
import facade.AdminFacade;
import facade.CompanyFacade;
import facade.CustomerFacade;

/**
 * 
 * @author Saar.Carmel
 *
 */
public class CouponSystem {
	private static final CouponSystem INSTANCE = new CouponSystem();
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private DailyCouponExpirationTask task;
	private Thread thread;

	private static ConnectionPool connectionPool;

	/**
	 * 
	 * @return
	 */
	public static CouponSystem getInstance() {
		return INSTANCE;
	}

	private CouponSystem() {
		super();
		System.out.println(simpleDateFormat.format(new Date()) + " CouponSystem.CouponSystem() starts");
		task = new DailyCouponExpirationTask();
		thread = new Thread(task);
		thread.start();
		System.out.println(simpleDateFormat.format(new Date()) + " CouponSystem.CouponSystem() finishes");
	}

	/**
	 * 
	 * @param name
	 * @param password
	 * @param type
	 * @return
	 */
	public CouponClientFacade login(String name, String password, CouponClientType type) {
		System.out.println(simpleDateFormat.format(new Date()) + " CouponSystem.login() starts");
		CouponClientFacade couponClientFacade;
		couponClientFacade = null;
		if ((name == "admin") && (password == "1234") && (type == CouponClientType.ADMIN)) {
			couponClientFacade = new AdminFacade();
		}
		if ((name == "company1") && (password == "pass1") && (type == CouponClientType.COMPANY)) {
			couponClientFacade = new CompanyFacade();
		}
		if ((name == "customer1") && (password == "pass1") && (type == CouponClientType.CUSTOMER)) {
			couponClientFacade = new CustomerFacade();
		}
		System.out.println(simpleDateFormat.format(new Date()) + " CouponSystem.login() finishes");
		return couponClientFacade;
	}

	public void shutdown() {
		System.out.println(simpleDateFormat.format(new Date()) + " CouponSystem.shutdown() starts");
		task.stopTask();
		System.out.println(simpleDateFormat.format(new Date()) + " CouponSystem.shutdown() finishes");
	}

	static {
		String url = "jdbc:mysql://localhost:3306/coupons?useSSL=false";
		String username = "root";
		String password = "root";
		try {
			connectionPool = new ConnectionPool(url, username, password);
		} catch (SQLException e) {
			System.out.println("Cannot create connection pool. " + "reason: " + e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * 
	 * @return
	 */
	public static ConnectionPool getConnectionPool() {
		return connectionPool;
	}
}