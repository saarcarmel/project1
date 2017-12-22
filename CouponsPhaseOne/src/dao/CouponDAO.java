package dao;

import java.util.Collection;

import couponType.CouponType;
import couponsException.DaoException;
import javaBean.Coupon;

/**
 * 
 * @author Saar.Carmel
 *
 */
public interface CouponDAO {

	/**
	 * 
	 * @param coupon
	 * @throws DaoException
	 */
	public void createCoupon(Coupon coupon) throws DaoException;

	/**
	 * 
	 * @param coupon
	 * @throws DaoException
	 */
	public void removeCoupon(Coupon coupon) throws DaoException;

	/**
	 * 
	 * @param coupon
	 * @throws DaoException
	 */
	public void updateCoupon(Coupon coupon) throws DaoException;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Coupon getCoupon(long id) throws DaoException;

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public Collection<Coupon> getAllCoupons() throws DaoException;

	/**
	 * 
	 * @param couponType
	 * @return
	 */
	public Collection<Coupon> getCouponByType(CouponType couponType);
}