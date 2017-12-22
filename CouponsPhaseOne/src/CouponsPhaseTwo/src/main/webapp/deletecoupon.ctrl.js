(function() {
	var module = angular.module("myApp");
	module.controller("DeleteCouponCtrl", DeleteCouponCtrlCtor);
	// Ctor method for the DeleteCouponCtrl
	function DeleteCouponCtrlCtor(mockServiceHTTP) {
		this.success = false;
		this.failure = false;
		this.deleteCoupon = function() {
			console.log(this.newCoupon);
			if (this.newCoupon == undefined || this.newCoupon.id == undefined
					|| this.newCoupon.name == undefined) {
				this.success = false;
				this.failure = true;
				return;
			}
			this.success = false;
			this.failure = false;
			var self = this;
			var promisePost = mockServiceHTTP.removeCoupon(this.newCoupon);
			promisePost.then(function(resp) {
				// alert(resp.data);
				self.coupons = resp.data;
				self.newCoupon = {};
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