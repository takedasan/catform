ELEMENT.locale(ELEMENT.lang.ja)
var form = new Vue({
	el: '#input',
	data: {
		ok: false,
		error: false,
		formData: {
			title: '',
			date: '',
			imageList: []
		}
	},
	methods: {
		post: function () {
			var that = this;
			$.ajax({
				url: '/action/input/post',
				type: 'post',
				data: JSON.stringify(this.formData),
				contentType: 'application/json'

			}).then(
				function (response) {
					that.ok = true;
					that.error = false;
					that.formData.title = '';
					that.formData.date = '';
					that.formData.imageList = [];
				},
				function () {
					that.ok = false;
					that.error = true;
				});
		},
		handleSuccess(response, file, fileList) {
			this.formData.imageList.push({ name: file.name, url: file.url });
		},
		handleRemove(file, fileList) {
			console.log(file, fileList);
		},
		handlePreview(file) {
			console.log(file);
		},
		onTopMenuCLick() {
			window.location.href = "list"
		},
		onUploadMenuCLick() {
			window.location.href = "input"
		},
	}
})