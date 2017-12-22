(function() {
	var module = angular.module("myApp");
	module.controller("GetCompaniesCtrl", GetCompaniesCtrlCtor);
	function GetCompaniesCtrlCtor(mockServiceHTTP) {
		this.companies = [];
		var self = this;
		var promise = mockServiceHTTP.getCompanies();
		promise.then(function(resp) {
			// alert(resp.data);
			self.companies = resp.data;
		}, function(err) {
			alert(err.data);
		});
	}
})();