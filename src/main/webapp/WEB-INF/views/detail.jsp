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
    <h2>Board Info</h2>
    <table border="1" align="center">
        <tr>
            <th>#</th>
            <td>${boardInfo.seq}</td>
        </tr>
        <tr>
            <th>ID</th>
            <td>${boardInfo.id}</td>
        </tr>
        <tr>
            <th>TITLE</th>
            <td>${boardInfo.title}</td>
        </tr>
        <tr>
            <th>CONTENT</th>
            <td>${boardInfo.content}</td>
        </tr>
        <tr>
            <th>regdate</th>
            <td>${boardInfo.regDate}</td>
        </tr>
    </table>
    <div>
        <button><a href="/board/update?seq=${boardInfo.seq}">UPDATE</a></button>
    </div>
    <div id="reply-box">
        <h3>REPLY</h3>
        <table border="1" align="center" width="200px">
            <c:forEach var="list" items="${replyList}" varStatus="vs">
            <tr>
                <td><h5>${list.reply}</h5></td>
            </tr>
            </c:forEach>
        </table>
        <form action="/board/insertReply" method="post">
            <input type="hidden" name="seq" value="${boardInfo.seq}">
            <textarea name="reply"></textarea>
            <input type="submit" value="reply">
        </form>
    </div>
</body>
</html>