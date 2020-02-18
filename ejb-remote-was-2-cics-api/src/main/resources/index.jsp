<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WP101490 Java Application for Outbound Exercises</title>
</head>
<body>

<b>WP101490 Java Application for Outbound Exercises</b>
<br/>
<br/>
<%= new java.util.Date() %>
<br/>
<br/>

<form action="InvokeWas2BatchServlet" method="post">

Data to send to external address space:
<br>
<input type="text" name="input_bytes" size="64" maxlength="120"/>
<br/>
<br/>

OLA Register Name (max 12 chars):
<br/> 
<input type="text" name="reg_name" size="16" maxlength="16"/>
<br/>
<br/>
OLA Service Name (max 256 chars):
<br/>
<input type="text" name="service_name" size="128" maxlength="256"/>
<br/>
<br/>
Number of times to call external address space:
<br/>
<input type="text" name="loop" value="1">
<br/>
<br/>

<input type="submit" name="run1" value="Run WAS-&gt;External address space test">
<br/>
<br/>
<br/>
</form>

</body>
</html>