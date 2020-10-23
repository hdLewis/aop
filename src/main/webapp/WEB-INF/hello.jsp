<%--
  Created by IntelliJ IDEA.
  User: vedeng
  Date: 2020/10/22
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>

<div id="http"></div>
<form action="${pageContext.request.contextPath}/rest"
      method="post">
    <select name="_method"
            onchange="if(this.value=='GET') { this.parentNode.method='get';} else {  this.parentNode.method='post'; } ">
        <option value="GET">get</option>
        <option value="POST" selected="selected">post</option>
        <option value="PUT">put</option>
        <option value="DELETE">delete</option>
    </select> <input name="msg" value="msg"> <input
        type="submit" value="rest">
</form>

</body>
<script type="text/javascript">
    $.ajax({
        type:'get',
        url : "${pageContext.request.contextPath}/rest",
        data : {
            msg : "getmsg"
        },
        success : function(res) {
            $("#http").append("<br>"+res + "&nbsp; using $.ajax  GET<br>");
        }

    });

    $.ajax({
        type:'post',
        url : "${pageContext.request.contextPath}/rest",
        data : {
            msg : "postmsg"
        },
        success : function(res) {
            $("#http").append("<br>"+res + "&nbsp; using $.ajax POST<br>");
        }

    });

    $.ajax({
        type:'post',
        url : "${pageContext.request.contextPath}/rest",
        data : {
            _method : "PUT",
            msg : "putmsg"
        },
        success : function(res) {
            $("#http").append("<br>"+res + "&nbsp; using $.ajax  _PUT<br>");
        },
        error:function(res){
            alert(res)
        }

    });

    $.ajax({
        type : "POST",
        url : "${pageContext.request.contextPath}/rest/110",
        data : {
            _method : "DELETE",
            msg : "delmsg110"
        },
        success : function(res) {
            $("#http").append("<br>"+res + "&nbsp; using $.ajax  _DELETE<br>");

        }

    });

    $.ajax({
        type : "POST",
        url : "${pageContext.request.contextPath}/rest",
        data : {
            _method : "DELETE",
            msg : "delete "
        },
        success : function(res) {
            $("#http").append("<br>"+res + "&nbsp; using $.ajax  _DELETE<br>");

        }

    });
</script>

</html>
