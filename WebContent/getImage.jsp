<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.patryk.adaramelech.DBTools"%>
<%
	String id = request.getParameter("id");

	DBTools db = new DBTools();
	Connection con = db.getConnction();
	try {

		PreparedStatement ps = con.prepareStatement("select * from products where id=?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Blob blob = rs.getBlob("image");
			byte byteArray[] = blob.getBytes(1, (int) blob.length());

			response.setContentType("image/gif");
			OutputStream os = response.getOutputStream();
			os.write(byteArray);
			os.flush();
			os.close();
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
%>