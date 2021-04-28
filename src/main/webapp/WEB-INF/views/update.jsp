<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <h2>Board Update</h2>
    <form:form action="/board/update" method="post" modelAttribute="boardVO">
    <table border="1" align="center">
        <input type="hidden" name="seq" value="${boardInfo.seq}">
        <tr>
            <th>ID</th>
            <td><input type="text" name="id" value="${boardInfo.id}"></td>
        </tr>
        <tr>
            <th>TITLE</th>
            <td><input type="text" name="title" value="${boardInfo.title}"></td>
        </tr>
        <tr>
            <th>CONTENT</th>
            <td>
                <textarea name="content">${boardInfo.content}</textarea>
            </td>
        </tr>
    </table>
    <div>
        <input type="submit" value="UPDATE">
    </div>
    </form:form>
</body>
</html>