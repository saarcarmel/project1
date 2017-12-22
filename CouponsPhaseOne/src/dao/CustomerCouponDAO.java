package dao;

import javaBean.Customer;
import javaBean.Coupon;

/**
 * 
 * @author Saar.Carmel
 *
 */
public interface CustomerCouponDAO {

	/**
	 * 
	 * @param customer
	 * @param coupon
	 */
	public void createCustomerCoupon(Customer customer, Coupon coupon);

	/**
	 * 
	 * @param customer
	 * @param coupon
	 */
	public void removeCustomerCoupon(Customer customer, Coupon coupon);
}