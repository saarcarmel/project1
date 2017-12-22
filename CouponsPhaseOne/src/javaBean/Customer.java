package javaBean;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Saar.Carmel
 *
 */

@XmlRootElement
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String custName;
	private String password;
	private Collection<Coupon> coupons;

	public Customer() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param custName
	 * @param password
	 * @param coupons
	 */
	public Customer(long id, String custName, String password, Collection<Coupon> coupons) {
		super();
		this.id = id;
		this.custName = custName;
		this.password = password;
		this.coupons = coupons;
	}

	/**
	 * 
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * 
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return
	 */
	public Collection<Coupon> getCoupons() {
		return coupons;
	}

	/**
	 * 
	 * @param coupons
	 */
	public void setCoupons(Collection<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public String toString() {
		return "Customer [\n id = " + id + ", \n custName = " + custName + ", \n password = " + password
				+ ", \n coupons = " + coupons + "\n]\n";
	}
}