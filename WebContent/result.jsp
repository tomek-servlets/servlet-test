
<%
String message = request.getParameter("message");
if(message != null){
	out.print(message);
}
%>