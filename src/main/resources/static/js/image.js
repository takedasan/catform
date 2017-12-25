ELEMENT.locale(ELEMENT.lang.ja)
var form = new Vue({
    el: '#app',
    data: {
        imageList: []
    },
    created: function () {
        this.init();
    },
    methods: {
        init: function () {
            var that = this;
            $.ajax({
                url: 'action/list/recent',
                type: 'post',
                success: function (list) {
                    for (var i = 0; i < list.length; i++) {
                        that.imageList.push({ id: i, title: list[i].title, filePath: list[i].imageList[0], date: list[i].postDate })
                    }
                }
            });
        },
        onTopMenuCLick() {
            console.log('ほげほげ');
        },
        getCardSize() {
            return 24 / (this.imageList.length + 1);
        }
    }
})