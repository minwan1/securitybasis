<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//code.jquery.com/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS --> 
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"> <!-- 합쳐지고 최소화된 옵션 테마 --> 
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css"> <!-- 합쳐지고 최소화된 최신 자바스크립트 --> 
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>


<style type="text/css">

body {
	background: #eee !important;	
}

.wrapper {	
	margin-top: 80px;
  margin-bottom: 80px;
}

.form-signin {
  max-width: 380px;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0,0,0,0.1);  

  .form-signin-heading,
	.checkbox {
	  margin-bottom: 30px;
	}

	.checkbox {
	  font-weight: normal;
	}

	.form-control {
	  position: relative;
	  font-size: 16px;
	  height: auto;
	  padding: 10px;
		@include box-sizing(border-box);

		&:focus {
		  z-index: 2;
		}
	}

	input[type="text"] {
	  margin-bottom: -1px;
	  border-bottom-left-radius: 0;
	  border-bottom-right-radius: 0;
	}

	input[type="password"] {
	  margin-bottom: 20px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
}

.textCenter{
	text-align:center
}


</style>

<title>Insert title here</title>
</head>
<body>

  <div class="wrapper">
    <form action="/j_spring_security_check" method="post" id="form_login"  class="form-signin">       
      <h2 class="form-signin-heading textCenter">Sign In</h2>
      <input type="text" class="form-control" name="j_username" placeholder="Email Address" id="j_username" required="" autofocus="" />
      <input type="password" class="form-control" name="j_password" placeholder="Password" id="j_password" required=""/>      
      <label class="checkbox">
        <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
      </label>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>   
      <button type="button" class="btn btn-lg btn-primary btn-block" id="facebookLogin">Facebook</button> 
    </form>
  </div>
  
  <div class="wrapper">
    <div class="form-signin">       
      <h2 class="form-signin-heading textCenter">Sign Up</h2>
      <input type="text" class="form-control" id="userId"/>
      <input type="password" class="form-control" id="userPassword"/>    
      <br>  
      <button type="button" class="btn btn-lg btn-primary btn-block" id="create">Sign Up</button>   
    </div>
  </div>
  
  
  <form action="/signin/facebook" method="POST" id="facebook_connect">
		<input type="hidden" name="scope" value="public_profile,user_friends,email" />
	</form>




<script type="text/javascript">

$("#btn_login").on("click",function(){
	
	$("#form_login").submit();
	
});

$("#create").on("click",function(){
	
	console.log($("#userId").val());
	console.log($("#userPassword").val());
 	 $.ajax({
         type:"POST",
         url:"/create",
         data:{userId:$("#userId").val(),userPassword:$("#userPassword").val()},
         dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
         success : function(data) {
               // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
               // TODO
               alert("회원가입 성공");
         }
   }); 
 	 
 	 
 	 function facebookLogin(){
 		$("#facebook_connect").submit();
 	 }
});

</script>
</body>
</html>