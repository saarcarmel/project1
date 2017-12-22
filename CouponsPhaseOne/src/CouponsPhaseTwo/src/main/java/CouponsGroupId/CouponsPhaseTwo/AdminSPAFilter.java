package CouponsGroupId.CouponsPhaseTwo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

import facade.AdminFacade;
//import loggerPackage.Log;

/**
 * A filter which checks that a user tries to enter anywhere inside Admin Single
 * Page Application is having a AdminFacade object in his session of the request
 * If not - he will be redirected to login page
 */

@Path("adminspafilter")
public class AdminSPAFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Log.info("AdminSPAfFilter -> doFilter");

		if (((HttpServletRequest) request).getSession(false).getAttribute("Facade") instanceof AdminFacade) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect("login.html");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}