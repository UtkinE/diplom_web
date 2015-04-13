<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.eutkin.data.entity.EntityJoin" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Balance of power</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='resources/css/style.css'/>" />
    <link rel="stylesheet" type="text/css" href="resources/css/latest.css" />
    <script type="text/javascript" src="resources/js/jquery.1.4.2.js"></script>
    <script type="text/javascript" src="resources/js/latest.js"></script>
</head>
<body>

<% String sClass = "";
    int i = 0;
    List<EntityJoin> entities = (List<EntityJoin>) request.getAttribute("entities");
    DecimalFormat df = new DecimalFormat("#.###");

%>

    <header class="header">

    </header><!-- .header-->

    <div class="middle">
        <div class="container">
            <main class="content">
                <table width="100%" cellspacing="0" cellpadding="0" border="0">
                    <tr>
                        <%@include file="filter.jsp"%>
                    </tr>
                </table>
            <div class="datagrid">
                <table>
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Balance of power</th>
                        </tr>
                        </thead>
            <tbody>
            <%
                if(entities.isEmpty()) {
            %>
            <tr><td colspan="3">No such result</td></tr>
            <%
            } else {
            for(EntityJoin entity : entities) {
                if (i % 2 != 0) sClass = "alt";
                else sClass = "td";
                i += 1;
            %>
                <tr class="<%=sClass%>">
                    <td><%=entity.getDate_mens()%></td>
                    <td><%=df.format(entity.getPower())%></td>
                </tr>
            <%}%>
            </tbody>
    </table>
</div>
            </main><!-- .content -->
        </div><!-- .container-->
        <aside class="left-sidebar">
            <strong>Left Sidebar:</strong> Text
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->



<footer class="footer">
    <strong>Footer:</strong> Text
</footer><!-- .footer -->

<%
    }
%>
</body>
</html>
