<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<h1>회원가입 페이지</h1>
<form action="/user/join" method="post" id="join-Frm">
    <div><label>아이디 : <input type="text" name="uid" required></label></div>
    <div><input type="button" value="아이디 중복 체크" id="id-btn-chk"><span id="id-Chk-Msg"></span> </div>
    <div><label>비밀번호 : <input type="password" name="upw" required></label></div>
    <div><label>비밀번호 확인 : <input type="password" id="upw-chk" required></label></div>
    <div><label>이름 : <input type="text" name="nm" required></label></div>
    <div>
        <label>female <input type="radio" name="gender" value="2" checked></label>
        <label>male <input type="radio" name="gender" value="1"></label>
    </div>
    <div>
        <input type="submit" value="JOIN">
        <input type="reset" value="RESET">
    </div>
</form>