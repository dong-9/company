<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Board Insert Page</title>
    <style>
        h2 {text-align: center}
        div {text-align: center}
    </style>
</head>
<body>
    <h2>Board Insert</h2>
    <form:form action="/board/insert" method="post" modelAttribute="boardVO">
    <table border="1" align="center">
        <tr>
            <th>ID</th>
            <td>
                <input type="text" name="id" placeholder="ID">
                <form:errors path="id"/>
            </td>
        </tr>
        <tr>
            <th>TITLE</th>
            <td>
                <input type="text" name="title" placeholder="TITLE">
                <form:errors path="title"/>
            </td>
        </tr>
        <tr>
            <th>CONTENT</th>
            <td>
                <textarea cols="10" name="content"></textarea>
                <form:errors path="content"/>
            </td>
        </tr>
    </table>
    <div>
        <input type="submit" value="insert">
    </div>
    </form:form>
</body>
</html>