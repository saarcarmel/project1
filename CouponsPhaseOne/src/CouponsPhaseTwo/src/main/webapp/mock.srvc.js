(function() {
	var module = angular.module("myApp");
	module.service("mockServiceHTTP", mockServiceHTTPCtor);
	function Company(id, name) {
		this.id = id;
		this.name = name;
	}
	function Coupon(id, name) {
		this.id = id;
		this.name = name;
	}
	function Customer(id, name) {
		this.id = id;
		this.name = name;
	}
	function mockServiceHTTPCtor($q) {
		this.companies = [ new Company(1, "Company1"),
				new Company(2, "Company2") ];
		this.coupons = [ new Coupon(1, "Coupon1"), new Coupon(2, "Coupon2") ];
		this.customers = [ new Customer(1, "Customer1"),
				new Customer(2, "Customer2") ];
		this.getCompanies = function() {
			var deferred = $q.defer();
			deferred.resolve({
				status : 200,
				data : this.companies
			});
			return deferred.promise;
		}
		this.getCoupons = function() {
			var deferred = $q.defer();
			deferred.resolve({
				status : 200,
				data : this.coupons
			});
			return deferred.promise;
		}
		this.getCustomers = function() {
			var deferred = $q.defer();
			deferred.resolve({
				status : 200,
				data : this.customers
			});
			return deferred.promise;
		}
		this.getCompany = function() {
			var deferred = $q.defer();
			deferred.resolve({
				status : 200,
				data : this.companies
			});
			return deferred.promise;
		}
		this.getCoupon = function() {
			var deferred = $q.defer();
			deferred.resolve({
				status : 200,
				data : this.coupons
			});
			return deferred.promise;
		}
		this.getCustomer = function() {
			var deferred = $q.defer();
			deferred.resolve({
				status : 200,
				data : this.customers
			});
			return deferred.promise;
		}
		this.getCompanyFailure = function() {
			return $q.reject({
				status : 404,
				data : 'company not found'
			});
		}
		this.getCouponFailure = function() {
			return $q.reject({
				status : 404,
				data : 'coupon not found'
			});
		}
		this.getCustomerFailure = function() {
			return $q.reject({
				status : 404,
				data : 'customer not found'
			});
		}
		// in the future
		// return $http.get('URL');
		this.addCompany = function(company) {
			this.companies.push(company);
			var deferred = $q.defer();
			deferred.resolve({
				status : 200,
				data : this.companies
			});
			return deferred.promise;
		}
		this.addCoupon = function(coupon) {
			this.coupons.push(coupon);
			var deferred = $q.defer();
			deferred.resolve({
				status : 200,
				data : this.coupons
			});
			return deferred.promise;
		}
		this.addCustomer = function(customer) {
			this.customers.push(customer);
			var deferred = $q.defer();
			deferred.resolve({
				status : 200,
				data : this.customers
			});
			return deferred.promise;
		}
		this.removeCompany = function(company) {
			this.companies.pop(company);
			var deferred = $q.defer();
			deferred.resolve({
				status : 200,
				data : this.companies
			});
			return deferred.promise;
		}
		this.removeCoupon = function(coupon) {
			this.coupons.pop(coupon);
			var deferred = $q.defer();
			deferred.resolve({
				status : 200,
				data : this.coupons
			});
			return deferred.promise;
		}
		this.removeCustomer = function(customer) {
			this.customers.pop(customer);
			var deferred = $q.defer();
			deferred.resolve({
				status : 200,
				data : this.customers
			});
			return deferred.promise;
		}
		// in the future
		// return $http.post('URL', company);
		// return $http.post('URL', coupon);
		// return $http.post('URL', customer);
	}
})();