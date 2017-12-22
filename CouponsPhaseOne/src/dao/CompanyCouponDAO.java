package dao;

import couponsException.DaoException;
import javaBean.Company;
import javaBean.Coupon;

/**
 * 
 * @author Saar.Carmel
 *
 */
public interface CompanyCouponDAO {

	/**
	 * 
	 * @param company
	 * @param coupon
	 * @throws DaoException
	 */
	public void createCompanyCoupon(Company company, Coupon coupon) throws DaoException;

	/**
	 * 
	 * @param company
	 * @param coupon
	 */
	public void removeCompanyCoupon(Company company, Coupon coupon);
}