package facade;

import java.util.ArrayList;
import java.util.Collection;
import couponClientFacade.CouponClientFacade;
import couponType.CouponType;
import couponsException.DaoException;
import dbdao.CompanyCouponDBDAO;
import dbdao.CouponDBDAO;
import javaBean.Company;
import javaBean.Coupon;

/**
 * 
 * @author Saar.Carmel
 *
 */
public class CompanyFacade implements CouponClientFacade {
	private Company company = new Company();
	private CouponDBDAO couponDBDAO = new CouponDBDAO();
	private CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();
	private ArrayList<Coupon> coupons = null;

	public CompanyFacade() {
		super();
	}

	/**
	 * 
	 * @param coupon
	 * @throws DaoException
	 */
	public void createCoupon(Coupon coupon) throws DaoException {
		companyCouponDBDAO.createCompanyCoupon(company, coupon);
		couponDBDAO.createCoupon(coupon);
		coupons.add(coupon);
		company.setCoupons(coupons);
	}

	/**
	 * 
	 * @param coupon
	 * @throws DaoException
	 */
	public void removeCoupon(Coupon coupon) throws DaoException {
		companyCouponDBDAO.removeCompanyCoupon(company, coupon);
		couponDBDAO.removeCoupon(coupon);
		coupons.remove(coupon);
		company.setCoupons(coupons);
	}

	/**
	 * 
	 * @param coupon
	 * @throws DaoException
	 */
	public void updateCoupon(Coupon coupon) throws DaoException {
		couponDBDAO.updateCoupon(coupon);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Coupon getCoupon(long id) {
		return couponDBDAO.getCoupon(id);
	}

	/**
	 * 
	 * @return
	 */
	public Collection<Coupon> getAllCoupons() {
		return couponDBDAO.getAllCoupons();
	}

	/**
	 * 
	 * @param couponType
	 * @return
	 */
	public Collection<Coupon> getCouponByType(CouponType couponType) {
		return couponDBDAO.getCouponByType(couponType);
	}

	@Override
	public CouponClientFacade login(String name, String password, String clientType) {
		return null;
	}
}