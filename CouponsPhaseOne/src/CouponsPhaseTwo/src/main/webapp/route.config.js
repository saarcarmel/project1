(function() {
	var module = angular.module("myApp");
	module.config([ '$locationProvider', function($locationProvider) {
		$locationProvider.hashPrefix('');
	} ]);
	// router config
	module.config(function($stateProvider, $urlRouterProvider) {
		$stateProvider
		.state("getCompanies", {
			url : "/getcompanies",
			templateUrl : "getcompanies.html",
			controller : "GetCompaniesCtrl as g"
		}).state("getCoupons", {
			url : "/getcoupons",
			templateUrl : "getcoupons.html",
			controller : "GetCouponsCtrl as g"
		}).state("getCustomers", {
			url : "/getcustomers",
			templateUrl : "getcustomers.html",
			controller : "GetCustomersCtrl as g"
		}).state("getCompany", {
			url : "/getcompany",
			templateUrl : "getcompany.html",
			controller : "GetCompanyCtrl as g"
		}).state("getCoupon", {
			url : "/getcoupon",
			templateUrl : "getcoupon.html",
			controller : "GetCouponCtrl as g"
		}).state("getCustomer", {
			url : "/getcustomer",
			templateUrl : "getcustomer.html",
			controller : "GetCustomerCtrls as g"
		}).state("createCompany", {
			url : "/createcompany",
			templateUrl : "createcompany.html",
			controller : "CreateCompanyCtrl as c"
		}).state("createCoupon", {
			url : "/createcoupon",
			templateUrl : "createcoupon.html",
			controller : "CreateCouponCtrl as c"
		}).state("createCustomer", {
			url : "/createcustomer",
			templateUrl : "createcustomer.html",
			controller : "CreateCustomerCtrl as c"
		}).state("deleteCompany", {
			url : "/deletecompany",
			templateUrl : "deletecompany.html",
			controller : "DeleteCompanyCtrl as c"
		}).state("deleteCoupon", {
			url : "/deletecoupon",
			templateUrl : "deletecoupon.html",
			controller : "DeleteCouponCtrl as c"
		}).state("deleteCustomer", {
			url : "/deletecustomer",
			templateUrl : "deletecustomer.html",
			controller : "DeleteCustomerCtrl as c"
		}).state("updateCompany", {
			url : "/updatecompany",
			templateUrl : "updatecompany.html",
			controller : "UpdateCompanyCtrl as c"
		}).state("updateCoupon", {
			url : "/updatecoupon",
			templateUrl : "updatecoupon.html",
			controller : "UpdateCouponCtrl as c"
		}).state("updateCustomer", {
			url : "/updatecustomer",
			templateUrl : "updatecustomer.html",
			controller : "UpdateCustomerCtrl as c"
		});
		$urlRouterProvider.when("", "/"); // first browsing postfix is
		// empty --> route it to /main
		// $urlRouterProvider.otherwise('/404'); // when no switch case matches
		// --> route to /404
	});
})();