package facade;

import java.util.Collection;
import couponClientFacade.CouponClientFacade;
import dbdao.CompanyDBDAO;
import dbdao.CustomerDBDAO;
import javaBean.Company;
import javaBean.Customer;

/**
 * 
 * @author Saar.Carmel
 *
 */
public class AdminFacade implements CouponClientFacade {
	private CompanyDBDAO companyDBDAO = new CompanyDBDAO();
	private CustomerDBDAO customerDBDAO = new CustomerDBDAO();

	public AdminFacade() {
		super();
	}

	/**
	 * 
	 * @param company
	 */
	public void createCompany(Company company) {
		companyDBDAO.createCompany(company);
	}

	/**
	 * 
	 * @param company
	 */
	public void removeCompany(Company company) {
		companyDBDAO.removeCompany(company);
	}

	/**
	 * 
	 * @param company
	 */
	public void updateCompany(Company company) {
		companyDBDAO.updateCompany(company);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Company getCompany(long id) {
		return companyDBDAO.getCompany(id);
	}

	/**
	 * 
	 * @return
	 */
	public Collection<Company> getAllCompanies() {
		return companyDBDAO.getAllCompanies();
	}

	/**
	 * 
	 * @param customer
	 */
	public void createCustomer(Customer customer) {
		customerDBDAO.createCustomer(customer);
	}

	/**
	 * 
	 * @param customer
	 */
	public void removeCustomer(Customer customer) {
		customerDBDAO.removeCustomer(customer);
	}

	/**
	 * 
	 * @param customer
	 */
	public void updateCustomer(Customer customer) {
		customerDBDAO.updateCustomer(customer);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Customer getCustomer(long id) {
		return customerDBDAO.getCustomer(id);
	}

	/**
	 * 
	 * @return
	 */
	public Collection<Customer> getAllCustomers() {
		return customerDBDAO.getAllCustomers();
	}

	@Override
	public CouponClientFacade login(String name, String password, String clientType) {
		return null;
	}
}