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
    </style>
</head>
<body>
    <div style="text-align: left">
        <form action="insert" method="post">
            <textarea name="reply"></textarea>
            <input type="submit" value="댓글달기">
        </form>
    </div>
    <table border="1px" width="200px">
        <c:forEach var="li" items="${list}">
            <tr>
                <td>
                    ${li.reply}<br>
                    <button><a href="#"></a>수정</button>
                    <button><a href="#"></a>삭제</button>
                    <form action="insert" method="post">
                        <input type="hidden" name="root" value="${li.root}">
                        <input type="hidden" name="indent" value="${li.indent}">
                        <input type="hidden" name="step" value="${li.step}">
                        <textarea name="reply"></textarea>
                        <input type="submit" value="답글달기">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>