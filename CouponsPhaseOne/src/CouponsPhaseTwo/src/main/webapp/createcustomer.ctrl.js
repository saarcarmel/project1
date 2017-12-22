(function() {
	var module = angular.module("myApp");
	module.controller("CreateCustomerCtrl", CreateCustomerCtrlCtor);
	// Ctor method for the CreateCustomerCtrl
	function CreateCustomerCtrlCtor(mockServiceHTTP) {
		this.success = false;
		this.failure = false;
		this.createCustomer = function() {
			console.log(this.newCustomer);
			if (this.newCustomer == undefined || this.newCustomer.id == undefined
					|| this.newCustomer.name == undefined) {
				this.success = false;
				this.failure = true;
				return;
			}
			this.success = false;
			this.failure = false;
			var self = this;
			var promisePost = mockServiceHTTP.addCustomer(this.newCustomer);
			promisePost.then(function(resp) {
				// alert(resp.data);
				self.customers = resp.data;
				self.newCustomer = {};
				self.success = true;
				self.failure = false;
			}, function(err) {
				alert(err.data);
				self.success = false;
				self.failure = true;
			});
		}
	}
})();