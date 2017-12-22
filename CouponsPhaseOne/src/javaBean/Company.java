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
public class Company implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String compName;
	private String password;
	private String email;
	private Collection<Coupon> coupons;

	public Company() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param compName
	 * @param password
	 * @param email
	 * @param coupons
	 */
	public Company(long id, String compName, String password, String email, Collection<Coupon> coupons) {
		super();
		this.id = id;
		this.compName = compName;
		this.password = password;
		this.email = email;
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
	public String getCompName() {
		return compName;
	}

	/**
	 * 
	 * @param compName
	 */
	public void setCompName(String compName) {
		this.compName = compName;
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
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
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
		return "Company [\n id = " + id + ", \n compName = " + compName + ", \n password = " + password
				+ ", \n email = " + email + ", \n coupons = " + coupons + "\n]\n";
	}
}