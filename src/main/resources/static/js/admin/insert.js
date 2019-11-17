var vm=new Vue(
    {
        el: '#student',
        data: {
            userId: '',
        },
        created: function () {
            var user = window.location.href.split("=")[1];
            this.userId = user;
        }

    })