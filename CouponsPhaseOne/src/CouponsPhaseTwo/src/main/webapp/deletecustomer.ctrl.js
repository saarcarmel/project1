(function() {
	var module = angular.module("myApp");
	module.controller("DeleteCustomerCtrl", DeleteCustomerCtrlCtor);
	// Ctor method for the DeleteCustomerCtrl
	function DeleteCustomerCtrlCtor(mockServiceHTTP) {
		this.success = false;
		this.failure = false;
		this.deleteCustomer = function() {
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
			var promisePost = mockServiceHTTP.removeCustomer(this.newCustomer);
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