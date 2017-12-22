package facade;

import java.util.ArrayList;
import java.util.Collection;

import couponClientFacade.CouponClientFacade;
import couponType.CouponType;
import dbdao.CustomerCouponDBDAO;
import javaBean.Coupon;
import javaBean.Customer;

/**
 * 
 * @author Saar.Carmel
 *
 */
public class CustomerFacade implements CouponClientFacade {
	private Customer customer = new Customer();
	private CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
	private ArrayList<Coupon> coupons = null;
	private ArrayList<Coupon> couponsByType = null;
	private ArrayList<Coupon> couponsByPrice = null;

	public CustomerFacade() {
		super();
	}

	/**
	 * 
	 * @param coupon
	 */
	public void purchaseCoupon(Coupon coupon) {
		customerCouponDBDAO.createCustomerCoupon(customer, coupon);
		coupons.add(coupon);
		customer.setCoupons(coupons);
	}

	/**
	 * 
	 * @return
	 */
	public Collection<Coupon> getAllPurchasedCoupons() {
		return customer.getCoupons();
	}

	/**
	 * 
	 * @param type
	 * @return
	 */
	public Collection<Coupon> getAllPurchasedCouponsByType(CouponType type) {
		couponsByType = null;
		for (Coupon coupon : coupons) {
			if (coupon.getType() == type)
				couponsByType.add(coupon);
		}
		return couponsByType;
	}

	/**
	 * 
	 * @param price
	 * @return
	 */
	public Collection<Coupon> getAllPurchasedCouponsByPrice(double price) {
		couponsByPrice = null;
		for (Coupon coupon : coupons) {
			if (coupon.getPrice() == price)
				couponsByPrice.add(coupon);
		}
		return couponsByPrice;
	}

	@Override
	public CouponClientFacade login(String name, String password, String clientType) {
		return null;
	}
}