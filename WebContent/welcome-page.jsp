<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
<meta name="google-signin-client_id" content="297258148076-j805fq52tmevgrl451mhmo3tkvit2bcn.apps.googleusercontent.com">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Welcome</title>
</head>
<body>


<!--  forward to index page for login if user info is not in session  -->
<% if (session.getAttribute("userName") == null) {%>
<jsp:forward page="/index.jsp"/>
<% } %>

<h3>Welcome  ${userName}</h3>



<!--  
<a href="https://mail.google.com/mail/u/0/?logout&hl=en">Sign out</a>
<a href="#" onclick="signOut()">Sign out</a>
-->

<button onclick="signOut()">Sign Out</button>


<script>
  function signOut() {
    
  	gapi.auth2.getAuthInstance().signOut().then(function () {
      console.log('User signed out.');
      location.reload();
      
      
      window.location.href="http://localhost:8080/File_Upload_01/index.jsp";
    });
  }
  
  function onLoad() {
      gapi.load('auth2', function() {
        gapi.auth2.init();
      });
    }
  
</script>

</body>
</html>