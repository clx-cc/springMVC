<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>helloWorld</title>
    <script type="text/javascript" src="js/jquery-3.6.1.js"></script>
    <script type="text/javascript">
        $(function(){
            $("button").click(function (){
                $.ajax({
                    url:"returnStringObject.do",
                    data:{
                        name:"ccc",
                        age:22
                    },
                    type:"post",
                    dataType:"text",
                    success:function (resp){
                        //resp从服务器端返回的是一个json格式的字符串
                        //jquery会把这个json格式的字符串转换为json对象，赋值给resp形参
                        // alert(resp.name +"  "+ resp.age)
                        // $.each(resp,function (i,n){
                        //     alert(i+": "+" "+n.name+"  "+n.age)
                        // })
                        alert(resp)
                    }

                })
            })
        })
    </script>
</head>
<body>
    <p>处理器方法返回String表示视图名称</p>
    <form action="returnString-view.do" method="post">
        姓名：<input type="text" name="name"/><br />
        年龄：<input type="text" name="age"/><br />
        <button>提交参数</button>
    </form>
    <p>处理器方法返回String表示完整视图路径，此时不能配置视图解析器</p>
    <form action="returnString-view2.do" method="post">
        姓名：<input type="text" name="name"/><br />
        年龄：<input type="text" name="age"/><br />
        <button>提交参数</button>
    </form>
    <br />
    <button id="btn">发送ajax请求</button>





</body>
</html>
