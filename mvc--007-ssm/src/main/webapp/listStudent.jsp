
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示学生列表</title>
    <script type="text/javascript" src="js/jquery-3.6.1.js"></script>
    <script type="text/javascript">
        $(function(){
                $.ajax({
                    url:"student/getList.do",
                    type:"get",
                    dataType:"json",
                    success:function (data){
                        $.each(data,function (i,item){
                            $("#info").append("<tr>")
                                .append("<td>"+item.id+"</td>")
                                .append("<td>"+item.name+"</td>")
                                .append("<td>"+item.age+"</td>")
                                .append("</tr>")
                        })
                    }

                })
        })
    </script>
</head>
<body>
<div align="center">
    <table>
        <thead>
            <tr>
                <td>id</td>
                <td>name</td>
                <td>age</td>
            </tr>
        </thead>
        <tbody id="info">

        </tbody>
    </table>
</div>
</body>
</html>
