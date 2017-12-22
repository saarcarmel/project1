package CouponsGroupId.CouponsPhaseTwo;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import couponClientType.CouponClientType;
import couponSystem.CouponSystem;
import facade.CustomerFacade;
import javaBean.Coupon;

@Path("customerresource")
public class CustomerResource {

	@Context
	HttpServletRequest request;
	@Context
	private HttpServletResponse response;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {

		if (request.getSession().getAttribute("customer") == null)
			return "NOT AUTHERIZED!!! PLEASE LOGIN FIRST!!!!!!!!!!";
		if (request.getSession().getAttribute("customer").equals("ok"))
			return "customer!";

		return "Unknown error!!!";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/purchaseCoupon")
	public void purchaseCoupon(Coupon coupon) {
		CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstance().login("customer1", "pass1",
				CouponClientType.ADMIN);
		customerFacade.purchaseCoupon(coupon);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllPurchasedCoupons")
	public Collection<Coupon> getAllPurchasedCoupons() {
		CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstance().login("customer1", "pass1",
				CouponClientType.ADMIN);
		return customerFacade.getAllPurchasedCoupons();
	}
}