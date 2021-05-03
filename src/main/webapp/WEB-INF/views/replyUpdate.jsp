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
    <h2>Board Reply Update</h2>
    <form:form action="/board/updateReply" method="post" modelAttribute="boardReplyVO">
    <table border="1" align="center">
        <form:hidden path="idx" />
        <form:hidden path="seq" />
        <tr>
            <th>REPLY</th>
            <td>
                <form:input path="reply"/>
                <form:errors path="reply" />
            </td>
        </tr>
    </table>
    <div>
        <input type="submit" value="UPDATE">
    </div>
    </form:form>
</body>
</html>