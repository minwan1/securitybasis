<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/j_spring_security_check" method="post" id="form_login">
	ID : <input type="text" name="j_username" id="j_username"><br />    <!-- 폼으로  아디를 j_username,비번을 j_password로 보내주면 자동으로 인메모리 디비이든 일반데이터베이스이든 확인함  -->
	PW : <input type="text" name="j_password" id="j_password"><br />
	<button id="btn_login">로그인</button>
	<input type="submit" value="전송">
</form>

<%-- <form action="<c:url value="j_spring_security_check" />" method="post">
	ID : <input type="text" name="j_username"> <br />
	PW : <input type="text" name="j_password"> <br />
	<input type="submit" value="LOGIN"> <br />
</form>
 --%>

네임 얻어오는 방법 pageontext.request.userprincipal.name
<a href="pageContext.request.contextpath/j_spring_security_logout"> log out</a>
//주소쪽을 변경해서 로그아웃을할수있다.

<script type="text/javascript">
$("#btn_login").on("click",function(){
	
	$("#form_login").submit();
	
});
</script>
</body>
</html>