<%--
  Created by IntelliJ IDEA.
  User: 26390
  Date: 2023/3/8
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <div align="center">
        <form action="${pageContext.request.contextPath}/student/addStudent.do" method="post">
            <table>
                <tr>
                    <td>姓名：</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>年龄：</td>
                    <td><input type="text" name="age"></td>
                </tr>
                <tr>
                    <td>年龄：</td>
                    <td><input type="submit" value="注册"></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>
