<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page language="java" import="java.io.*" import="java.util.*"
	import="java.util.Date" import="java.text.SimpleDateFormat"
	import="java.sql.* "%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String dbDriver = "com.mysql.jdbc.Driver"; 
		String connectionURL = "jdbc:mysql://localhost:3306/demoprj";
		
		String dbName = "demoprj"; 
        String dbUsername = "root"; 
        String dbPassword = ""; 
		
		/*Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		Connection connection1 = null;
		Statement statement1 = null;
		ResultSet rs1 = null;*/

		Class.forName(dbDriver);
		Connection con1 = DriverManager.getConnection(connectionURL, 
                dbUsername,  
                dbPassword); 
		
		
		Statement statement1 = con1.createStatement();
		ResultSet rs1 = statement1.executeQuery("SELECT * FROM demo");

		while (rs1.next()) {
			out.println(rs1.getString("string"));
		}

		statement1.close();
		rs1.close();

		Statement statement2 = con1.createStatement();
		ResultSet rs2 = statement2.executeQuery("SELECT * FROM user");

		while (rs2.next()) {
			out.println(rs2.getString("Name"));
		}

		statement2.close();
		rs2.close();
		
		con1.close();
	%>

</body>
</html>