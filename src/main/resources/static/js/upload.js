ELEMENT.locale(ELEMENT.lang.ja)
var form1 = new Vue({
	el : '#input',
	data : {
		date : ''
	},
	methods : {
		post : function() {
			$.ajax({
				url : '/input',
				type : 'post',
				data : JSON.stringify(this.date),
				contentType : 'application/json'
			});
		}
	}
})