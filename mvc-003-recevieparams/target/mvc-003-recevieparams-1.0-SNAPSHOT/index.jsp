<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>helloWorld</title>
</head>
<body>
    <p>逐个接收参数---请求参数和方法名形参名一致</p>
    <form action="receiveProperty.do" method="post">
        姓名：<input type="text" name="name"/><br />
        年龄：<input type="text" name="age"/><br />
        <button>提交参数</button>
    </form>

    <br/>
    <p>逐个接收参数---请求参数和方法名形参名不一致</p>
    <form action="receiveParam.do" method="post">
        姓名：<input type="text" name="rname"/><br />
        年龄：<input type="text" name="rage"/><br />
        <button>提交参数</button>
    </form>

    <p>使用对象接收请求参数</p>
    <form action="receiveObeject.do" method="post">
        姓名：<input type="text" name="name"/><br />
        年龄：<input type="text" name="age"/><br />
        <button>提交参数</button>
    </form>





</body>
</html>
