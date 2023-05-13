<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>helloWorld</title>
</head>
<body>
    <p>forward实现请求转发操作</p>
    <form action="doForward.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age"><br/>
        <button>提交</button>
    </form>
    <br/>
    <p>redirect实现重定向操作</p>
    <form action="doRedirect.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age"><br/>
        <button>提交</button>
    </form>

</body>
</html>
