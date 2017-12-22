ELEMENT.locale(ELEMENT.lang.ja)
var form = new Vue({
	el: '#input',
	data: {
		title: '',
		date: ''
	},
	methods: {
		post: function () {
			$.ajax({
				url: '/action/input',
				type: 'post',
				data: JSON.stringify(this.date),
				contentType: 'application/json'
			});
		}
	}
})