package dao;

import java.util.Collection;

import javaBean.Coupon;
import javaBean.Customer;

/**
 * 
 * @author Saar.Carmel
 *
 */
public interface CustomerDAO {

	/**
	 * 
	 * @param customer
	 */
	public void createCustomer(Customer customer);

	/**
	 * 
	 * @param customer
	 */
	public void removeCustomer(Customer customer);

	/**
	 * 
	 * @param customer
	 */
	public void updateCustomer(Customer customer);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Customer getCustomer(long id);

	/**
	 * 
	 * @return
	 */
	public Collection<Customer> getAllCustomers();

	/**
	 * 
	 * @return
	 */
	public Collection<Coupon> getCoupons();

	/**
	 * 
	 * @param custName
	 * @param password
	 * @return
	 */
	public boolean login(String custName, String password);
}