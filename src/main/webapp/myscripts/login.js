function loginAction(){
	//清空span
	$("#name").html("");
		//参数
	var name = $("#username").val().trim();
	var password = $("#password").val().trim();
	
	console.log(name);
	console.log(password);
	
	//开关
	var ok=true;
	
	 if(name==""){
		 $("#name").html("用户名不能为空");
		 ok=false;
	 }
	 if(password==""){
		 $("#name").html("密码不能为空");
		 ok=false;
	 }
	 console.log("ajax");
	 if(ok){
		 $.ajax({
			url:path+"/user/login.do",
		 	type:"post",
		 	data:{"name":name,"password":password},
		 	dataType:'json',
		 	success:function(result){
		 		if(result.state==0){
		 			var user = result.data;
		 			console.log("cookie  user======"+user);
		 			addCookie("userId",user.id,2);
		 			window.location.href="index.html";
		 		}else if(result.state==1){
				    $("#name").html(result.message);
				 }
		 		
		 	},
			error:function(){
				alert("登录失败");
			}
		 });
		 
	 }
}

/**
 * 注册
 */
function registAction(){
	//参数
	var user_name = $("#user_name").val().trim();
	var name = $("#name").val().trim();
	var phone = $("#phone").val().trim();
	var reg_pwd = $("#reg_pwd").val().trim();
	var final_pwd = $("#final_pwd").val().trim();
	
	//开关
	var ok=true;
	
	 if(user_name==""){
		 $("#names").html("用户名不能为空");
		 ok=false;
	 }
	 if(password==""){
		 $("#names").html("密码不能为空");
		 ok=false;
	 }
	
	
	alert('11');
	
}









function registAction(){
	
	alert(222);
	
}



//切换到登录界面
function showlog(){
	$("#reg_page").hide();
	$("#log_page").show();
}

//切换到注册界面
function showreg(){
	console.log(11111);
	$("#log_page").hide();
	$("#reg_page").show();
}