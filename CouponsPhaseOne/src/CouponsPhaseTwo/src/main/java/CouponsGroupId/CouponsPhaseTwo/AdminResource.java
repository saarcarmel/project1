package CouponsGroupId.CouponsPhaseTwo;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import couponClientType.CouponClientType;
import couponSystem.CouponSystem;
import facade.AdminFacade;
import javaBean.Company;
import javaBean.Customer;

@Path("adminresource")
public class AdminResource {

	@Context
	HttpServletRequest request;
	@Context
	private HttpServletResponse response;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {

		if (request.getSession().getAttribute("admininstrator") == null)
			return "NOT AUTHERIZED!!! PLEASE LOGIN FIRST!!!!!!!!!!";
		if (request.getSession().getAttribute("admininstrator").equals("ok"))
			return "admin!";

		return "Unknown error!!!";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getCompany/{id}")
	public Company getCompany(@PathParam("{id}") long id) {
		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstance().login("admin", "1234",
				CouponClientType.ADMIN);
		return adminFacade.getCompany(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllCompanies")
	public Collection<Company> getAllCompanies() {
		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstance().login("admin", "1234",
				CouponClientType.ADMIN);
		return adminFacade.getAllCompanies();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/createCompany")
	public void createCompany(Company company) {
		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstance().login("admin", "1234",
				CouponClientType.ADMIN);
		adminFacade.createCompany(company);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("updateCompany/{index}")
	public void updateCompany(@PathParam("index") int index, Company company) {
		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstance().login("admin", "1234",
				CouponClientType.ADMIN);
		adminFacade.updateCompany(company);
	}

	@DELETE
	@Path("removeCompany/{index}")
	public void removeCompany(@PathParam("index") int index) {
		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstance().login("admin", "1234",
				CouponClientType.ADMIN);
		Company company = new Company();
		company.setId(index);
		adminFacade.removeCompany(company);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getCustomer/{id}")
	public Customer getCustomer(@PathParam("{id}") long id) {
		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstance().login("admin", "1234",
				CouponClientType.ADMIN);
		return adminFacade.getCustomer(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllCustomers")
	public Collection<Customer> getAllCustomers() {
		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstance().login("admin", "1234",
				CouponClientType.ADMIN);
		return adminFacade.getAllCustomers();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/createCustomer")
	public void createCustomer(Customer customer) {
		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstance().login("admin", "1234",
				CouponClientType.ADMIN);
		adminFacade.createCustomer(customer);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("updateCustomer/{index}")
	public void updateCustomer(@PathParam("index") int index, Customer customer) {
		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstance().login("admin", "1234",
				CouponClientType.ADMIN);
		adminFacade.updateCustomer(customer);
	}

	@DELETE
	@Path("removeCustomer/{index}")
	public void removeCustomer(@PathParam("index") int index) {
		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstance().login("admin", "1234",
				CouponClientType.ADMIN);
		Customer customer = new Customer();
		customer.setId(index);
		adminFacade.removeCustomer(customer);
	}
}