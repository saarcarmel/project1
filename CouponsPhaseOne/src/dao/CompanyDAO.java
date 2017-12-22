package dao;

import java.util.Collection;

import javaBean.Company;
import javaBean.Coupon;

/**
 * 
 * @author Saar.Carmel
 *
 */
public interface CompanyDAO {

	/**
	 * 
	 * @param company
	 */
	public void createCompany(Company company);

	/**
	 * 
	 * @param company
	 */
	public void removeCompany(Company company);

	/**
	 * 
	 * @param company
	 */
	public void updateCompany(Company company);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Company getCompany(long id);

	/**
	 * 
	 * @return
	 */
	public Collection<Company> getAllCompanies();

	/**
	 * 
	 * @return
	 */
	public Collection<Coupon> getCoupons();

	/**
	 * 
	 * @param compName
	 * @param password
	 * @return
	 */
	public boolean login(String compName, String password);
}