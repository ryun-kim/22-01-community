<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
    <c:if test="${sessionScope.loginuser != null}">
        <a href="/board/write?icategory=${requestScope.icategory}">글쓰기</a>
    </c:if>
    <h1>게시글 리스트</h1>
    <c:choose>
        <c:when test="${fn:length(requestScope.list) ==0}">
            글이 없습니다.
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>no</th>
                    <th>title</th>
                    <th>hits</th>
                    <th>writer</th>
                    <th>reg date</th>
                </tr>
            </table>
            <c:forEach items="${requestScope.list}" var="itme">
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                    <td>5</td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
