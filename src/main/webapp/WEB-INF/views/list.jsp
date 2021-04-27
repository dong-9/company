<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Board Page</title>
    <style>
        h2 {text-align: center}
        div {text-align: center}
    </style>
</head>
<body>
    <h2>Board List</h2>
    <table border="1" align="center">
        <tr>
            <th>#</th>
            <th>ID</th>
            <th>TITLE</th>
            <th>regdate</th>
        </tr>
        <c:forEach var="list" items="${boardList}">
        <tr>
            <td>${list.seq}</td>
            <td>${list.userId}</td>
            <td><a href="detail?seq=${list.seq}">${list.title}</a></td>
            <td>${list.regDate}</td>
        </tr>
        </c:forEach>
    </table>
    <div>
        <button><a href=""></a></button>
    </div>
</body>
</html>