(function() {
	var module = angular.module("myApp");
	module.controller("GetCustomersCtrl", GetCustomersCtrlCtor);
	function GetCustomersCtrlCtor(mockServiceHTTP) {
		this.customers = [];
		var self = this;
		var promise = mockServiceHTTP.getCustomers();
		promise.then(function(resp) {
			// alert(resp.data);
			self.customers = resp.data;
		}, function(err) {
			alert(err.data);
		});
	}
})();