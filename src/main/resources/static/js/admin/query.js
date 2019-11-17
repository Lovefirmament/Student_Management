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
      pageStudentList:[   ],
      userId:'',
  },
    created:function(){
      var self=this;
      $.ajax({
      type: 'GET',
      dataType:'json',
      url: '../../admin/student?'+ new Date().getTime(),
          async:false,
      success: function(data){
        console.log(data);
          self.pageStudentList=data.pageStudentList;
          self.userId=data.userId;
          self.dateConver();
    },
    error:function(){
      alert("获取失败");
    }
  });

  },
    methods:{
      pageBefore:function(){
        var self=this;
        $.ajax({
        type: 'GET',
        dataType:'json',
        url: '../../admin/student?pageCurrent='+self.pageStudentList.pageBefore,
        success: function(data){
            self.pageStudentList=data.pageStudentList;
            self.userId=data.userId;
            self.dateConver();
            },
      error:function(){
        alert("获取失败");
      }
       });
     },
  pageAfter:function(){
    var self=this;
    $.ajax({
    type: 'GET',
    dataType:'json',
    url: 'http://localhost:8080/admin/student?pageCurrent='+self.pageStudentList.pageAfter,
    success: function(data){
        self.pageStudentList=data.pageStudentList;
        self.userId=data.userId;
        self.dateConver();
  },
  error:function(){
    alert("获取失败");
  }
  });

   },
   pageIndex:function(){
     var self=this;
     $.ajax({
     type: 'GET',
     dataType:'json',
     url: '../../admin/student?pageCurrent=1',
     success: function(data){
         self.pageStudentList=data.pageStudentList;
         self.userId=data.userId;
         self.dateConver();
   },
   error:function(){
     alert("获取失败");
   }
   });
    },
   pageEnd:function(){
     var self=this;
     $.ajax({
     type: 'GET',
     dataType:'json',
     url: '../../admin/student?pageCurrent='+self.pageStudentList.pageNumber,
     success: function(data){
         self.pageStudentList=data.pageStudentList;
         self.userId=data.userId;
         self.dateConver();
         console.log(data);
   },
   error:function(){
     alert("获取失败");
   }
   });
    },
   dateConver:function () {
       for(var i=0;i<=this.pageStudentList.list.length-1;i++) {
           var date = new Date(this.pageStudentList.list[i].dob).format("yyyy-MM-dd");
           this.pageStudentList.list[i].dob = date;
       }
   },
    }
  })
