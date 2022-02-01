<%@page import="java.util.*" %>
<%@page import="users.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Boostrap CSS only -->
        <!--
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous"> -->
        <!--VENDORS-->
        <link rel="stylesheet" href="vendors/bootstrap-4.1.3-dist/css/bootstrap.min.css">
        <script src="vendors/jquery/jquery-3.3.1.min.js"></script>
        <!--CONTROL-->
        <script type="text/javascript" src="./js/control/utils.js"></script>
        <script type="text/javascript" src="./js/control/index.js"></script>
        <title>PT152-ADMIN</title>
    </head>
    <body>
        <%  
            // Ens assegurem que estem davant d'un admin.
            if(session.getAttribute("user")==null){
                response.sendRedirect("login.jsp");
            } else {
                if(!session.getAttribute("role").equals("ADMIN")){
                    response.sendRedirect("login.jsp");
                }
            }
            // Ara si, llegim la llista d'usuaris.
            List<User> usersList = new ArrayList<User>();
            if(request.getAttribute("usersList")!=null) {
                usersList = (List<User>) request.getAttribute("usersList"); 
            } 
         %>
         <header>
        <!-- Ull amb les rutes. En aquest cas és .. (carpeta anterior) /templates -->
            <%@include file="../templates/menu.jsp" %>
        </header>
        <main class="container">
            <h3>Hola 
                <%=session.getAttribute("user") %>
                aquesta es la llista d'usuaris de la App</h3>
            <table class="table table-striped">    
                <thead>
                    <th scope='col'>Username</th>
                    <!-- <th scope='col'>Password</th> -->
                    <th scope='col'>Role</th>
                </thead>
            <%
                for(User user: usersList) {
            %>        
            <tr>
                    <td scope="row">
                        <%=user.getUsername()%>
                    </td>
                    <!--
                    <td width="40%">
                        
                    </td>
                    -->
                    <td scope="row">
                        <%=user.getRole()%>
                    </td>
               </tr>
            <%
              }
            %>
            </table>
        </main>
    </body>
    <!-- <footer>
        
    </footer> -->
</html>
