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
import couponsException.DaoException;
import facade.CompanyFacade;
import javaBean.Coupon;

@Path("companyresource")
public class CompanyResource {

	@Context
	HttpServletRequest request;
	@Context
	private HttpServletResponse response;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {

		if (request.getSession().getAttribute("company") == null)
			return "NOT AUTHERIZED!!! PLEASE LOGIN FIRST!!!!!!!!!!";
		if (request.getSession().getAttribute("company").equals("ok"))
			return "company!";

		return "Unknown error!!!";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getCoupon/{id}")
	public Coupon getCoupon(@PathParam("{id}") long id) {
		CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login("company1", "pass1",
				CouponClientType.ADMIN);
		return companyFacade.getCoupon(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllCoupons")
	public Collection<Coupon> getAllCoupons() {
		CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login("company1", "pass1",
				CouponClientType.ADMIN);
		return companyFacade.getAllCoupons();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/createCoupon")
	public void createCustomer(Coupon coupon) throws DaoException {
		CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login("company1", "pass1",
				CouponClientType.ADMIN);
		companyFacade.createCoupon(coupon);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("updateCoupon/{index}")
	public void updateCoupon(@PathParam("index") int index, Coupon coupon) throws DaoException {
		CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login("company1", "pass1",
				CouponClientType.ADMIN);
		companyFacade.updateCoupon(coupon);
	}

	@DELETE
	@Path("removeCoupon/{index}")
	public void removeCoupon(@PathParam("index") int index) throws DaoException {
		CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login("company1", "pass1",
				CouponClientType.ADMIN);
		Coupon coupon = new Coupon();
		coupon.setId(index);
		companyFacade.removeCoupon(coupon);
	}
}