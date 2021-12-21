<nav class="navbar sticky-top navbar-dark bg-danger">
    <!-- Header amb el banner de la web -->
    <a class="navbar-brand" href="index.jsp">
        <img id="banner-img" src="img/bioinfo-banner.jpg" 
             class="d-inline-block align-middle" alt="Banner Bioinformatica">
    </a>
    <!-- Men� navegaci� visitants (que no estan registrats) -->
    <nav class="nav nav-pills flex-column flex-sm-row">
        <a class='flex-sm-fill text-sm-center nav-link active opt-menu' 
           href='login.jsp'>Login</a>
        <a class='flex-sm-fill text-sm-center nav-link opt-menu' 
           href='news.jsp'>News</a>
    <!-- Men� navegaci� usuaris registrats Intranet. -->
    <% if(session.getAttribute("user")!=null) { %>
        <a class='flex-sm-fill text-sm-center nav-link opt-menu' 
           href='./intranet/adn.jsp'>ADNValidator</a>
        <a class='flex-sm-fill text-sm-center nav-link opt-menu' 
           href='./intranet/listAllPatients.jsp'>List Patients</a>
        <a class='flex-sm-fill text-sm-center nav-link opt-menu' 
           href='./intranet/adn-gen.jsp'>ADN Gen (Pt14Opt)</a>
        <% if(session.getAttribute("admin")!=null) { %>
        <!-- Men� navegaci� usuaris registrats Intranet com a admin. -->
            <a class='flex-sm-fill text-sm-center nav-link opt-menu' 
               href='./intranet/admin/addPatient.jsp'>Add Patient</a>
    <%      
            } 
        }
    %>
    </nav>
</nav>
