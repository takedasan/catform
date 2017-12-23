ELEMENT.locale(ELEMENT.lang.ja)
var form = new Vue({
	el: '#input',
	data: {
		formData: {
			title: '',
			date: '',
			imageList: []
		}
	},
	methods: {
		post: function () {
			$.ajax({
				url: '/action/input/post',
				type: 'post',
				data: JSON.stringify(this.formData),
				contentType: 'application/json'
			});
		},
		handleSuccess(response, file, fileList) {
			console.log(file);
			this.formData.imageList.push({ name: file.name, url: file.url });
		},
		handleRemove(file, fileList) {
			console.log(file, fileList);
		},
		handlePreview(file) {
			console.log(file);
		}
	}
})