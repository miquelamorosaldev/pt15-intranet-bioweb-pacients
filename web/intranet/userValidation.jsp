<% 
   if(session.getAttribute("user")!=null) {
       out.println("Welcome " + session.getAttribute("user").toString());
   } else {
       response.sendRedirect("../login.jsp?error=1");
   }
   /* if(!sessionOK) {  
       response.sendRedirect("../login.jsp?error=1");
   }     
   */ 
   // Si l'usuari ha fet el login correctament.
   /* if(session.getAttribute("user")!=null) { 
       // Validem la sessió i la cookie.
       Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (!cookie.getName().equals(cookieName)) {
                response.sendRedirect("login.jsp?error=1");
            }
       } 
   }
   */
%>