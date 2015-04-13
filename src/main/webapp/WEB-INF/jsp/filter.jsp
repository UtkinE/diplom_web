<%@ page import="java.util.Map" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <script type="text/javascript" src="/resources/js/dygraph-combined.js"></script>
  <link rel="stylesheet" type="text/css" href="<c:url value='resources/css/style.css'/>" />
  <link rel="stylesheet" type="text/css" href="resources/css/latest.css" />
  <script type="text/javascript" src="resources/js/jquery.1.4.2.js"></script>
  <script type="text/javascript" src="resources/js/latest.js"></script>
</head>
<form:form method="post" action="/filter_post">
<input type="hidden" name="name1" value="">
<table cellpadding="0" cellspacing="0" border="0" width="100%">
  <tbody>
    <tr>
      <%
        Map<Integer,String> map = (Map<Integer,String>)request.getAttribute("ts");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
        String dateFrom = (request.getAttribute("dateFrom") != null) ? sdf.format((Date)request.getAttribute("dateFrom")) : "";
        String dateTill = (request.getAttribute("dateTill") != null) ? sdf.format((Date)request.getAttribute("dateTill")) : "";

      %>
      <td><label>Select date of mensuration</label></td>
      <td><p><input type="text" class="datepickerTimeField" name="dateFrom" value=<%=dateFrom%>></p><td>
      <td><p><input type="text" class="datepickerTimeField" name="dateTill" value=<%=dateTill%>></p><td>
      <td>
        <select name="ts_select">
          <%for(int j=1;j<7;j++){%>
          <option value=<%=j%>><%=map.get(j)%></option>
          <%}%>
        </select>
      </td>
    </tr>
      <td colspan="3"><input type="submit" value="Find"></td>
  </tbody>
</table>
</form:form>

<body>
<table width="100%" cellspacing="0" cellpadding="0" border="0">
  <tr>
    <%@include file="show.jsp"%>
  </tr>
</table>

