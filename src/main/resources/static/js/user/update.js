Date.prototype.format = function(format) {
    var date = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S+": this.getMilliseconds()
    };
    if (/(y+)/i.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
    }
    for (var k in date) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
        }
    }
    return format;
}
var vm=new Vue(
  {
    el:'#student',
    data:{
      student:[   ],
      userId:'',
    },
    created:function(){
      var self=this;
      var number=window.location.href.split("=")[1];
      $.ajax({
      type: 'GET',
      dataType:'json',
      async:false,
      url: '../../user/studentdetail/'+number,
      success: function(data){
          console.log(data);
          self.student=data.student;
          self.userId=data.userId;
    },
    error:function(){
      alert("获取失败");
    }
     });
        var date = new Date(this.student.dob).format("yyyy-MM-dd");
        this.student.dob=date;
    },
    methods:{
    }
  })

