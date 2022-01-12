<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="profileImg" value="/res/img/defaultprofile.png"/>
<c:if test="${sessionScope.loginUser.profileimg !=null}">
    <c:set var="profileImg" value="/images/user/${sessionScope.loginUser.iuser}/${sessionScope.loginUser.profileimg}"/>
</c:if>

<h1>프로필</h1>
<div id="data" data-iuser="${sessionScope.loginUser.iuser}"></div>
<div class="flex-container flex-direction-column flex-align-center">
    <div id="profile-view" class="circular--img wh-300 pointer"><img src="${profileImg}"></div>
    <input type="file" id="profile-file" class="hidden" accept="image/*">
    <div>아이디 : ${sessionScope.loginUser.uid}</div>
    <div>이름 : ${sessionScope.loginUser.nm}</div>
    <div>
        성별 : ${sessionScope.loginUser.gender ==1 ? '남성' : '여성'}
    </div>
    <div>가입일시 : ${sessionScope.loginUser.rdt}</div>
</div>