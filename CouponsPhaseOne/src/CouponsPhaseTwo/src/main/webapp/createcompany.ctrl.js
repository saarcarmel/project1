(function() {
	var module = angular.module("myApp");
	module.controller("CreateCompanyCtrl", CreateCompanyCtrlCtor);
	// Ctor method for the CreateCompanyCtrl
	function CreateCompanyCtrlCtor(mockServiceHTTP) {
		this.success = false;
		this.failure = false;
		this.createCompany = function() {
			console.log(this.newCompany);
			if (this.newCompany == undefined || this.newCompany.id == undefined
					|| this.newCompany.name == undefined) {
				this.success = false;
				this.failure = true;
				return;
			}
			this.success = false;
			this.failure = false;
			var self = this;
			var promisePost = mockServiceHTTP.addCompany(this.newCompany);
			promisePost.then(function(resp) {
				// alert(resp.data);
				self.companies = resp.data;
				self.newCompany = {};
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