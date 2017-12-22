package dailyCouponExpirationTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dbdao.CouponDBDAO;
import javaBean.Coupon;

/**
 * 
 * @author Saar.Carmel
 *
 */
public class DailyCouponExpirationTask implements Runnable {
	private CouponDBDAO couponDBDAO;
	private boolean quit = false;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public DailyCouponExpirationTask() {
		super();
		System.out.println(
				simpleDateFormat.format(new Date()) + " DailyCouponExpirationTask.dailyCouponExpirationTask() starts");
		System.out.println(simpleDateFormat.format(new Date())
				+ " DailyCouponExpirationTask.dailyCouponExpirationTask() finishes");
	}

	@Override
	public void run() {

		ArrayList<Coupon> coupons;
		coupons = new ArrayList<>();
		long id;
		id = 1;
		for (Coupon coupon : coupons) {
			coupon = this.couponDBDAO.getCoupon(id);
			coupons.add(coupon);
			id++;
			Date today = new Date();
			Date endDate = coupon.getEndDate();
			if (endDate.before(today)) {
				coupon = null;
			}
		}
	}

	public void stopTask() {
		quit = true;
		if (quit) {
			Thread.currentThread().interrupt();
		}
	}
}