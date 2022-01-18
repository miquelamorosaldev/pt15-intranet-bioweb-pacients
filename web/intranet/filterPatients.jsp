<%@page import="patients.IPatientsDAO" %>
<%@page import="patients.PatientsMemoryDAO" %>
<%@page import="patients.Patient" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DAWBIO2-WEB-Patients</title>
        <link rel="stylesheet" href="../vendors/bootstrap-4.1.3-dist/css/bootstrap.min.css">
        <script src="../vendors/jquery/jquery-3.3.1.min.js"></script>
        <link rel="stylesheet" href="../css/styles.css">
    </head>
    <body>
        <header>
            <!-- Ull amb les rutes. En aquest cas és .. (carpeta anterior) /templates -->
            <%@include file="../templates/menu.jsp" %>
            <%@include file="./userValidation.jsp" %>
        </header>
        <main>
            <div class="container mw-100"> 
                    <h3>FILTER Patients</h3>
                    <!-- Aquí irá el formulario de filtro -->
                    <form class="form-inline" id="filter_form" method="post" action="Patients">
                        <div class="form-group row">
                            <label class="input-group-prepend col-sm-2" for="classfication_filter">
                                RH Filter
                            </label>

                            <select class="form-control custom-select col-sm-3" name="category" id="category">
                                <option value="-">---</option>
                                <option value="+">RH+</option>
                                <option value="-">RH-</option>
                            </select>

                            <label class="input-group-prepend col-sm-2" for="classfication_filter">
                                Weight Filter (MIN-MAX)
                            </label>
                            <input type="number" name="weight-min" placeholder="20"></input>
                            <input type="number" name="weight-max" placeholder="200"></input>
                            <button type="submit" form="filter_form" 
                                    class="btn btn-primary col-sm-2" 
                                    name="action" value="filterPatients">Filter</button>
                        </div>
                    </form>
                    <!-- 
                        Aquí irá la lista de resultados 
                        después de aplicar el filtro. 
                    -->
                    <ul>
                    <% 
                        PatientsMemoryDAO daoPatients = new PatientsMemoryDAO();
                        List<Patient> resultList = daoPatients.listAllPatients();
                        for(Patient pa: resultList) {
                    %>
                    <li><%=pa.toString()%></li>
                    <% 
                        }
                    %>
                    </ul>
                    <p><%=resultList.size()%> pacientes encontrados.</p>
            </div>
        </main>
        <footer>
            <%@include file="../templates/footer.jsp" %>
        </footer>
    </body>
</html>
