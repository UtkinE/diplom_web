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
    <link rel="stylesheet" type="text/css" href="resources/css/latest.css" />
    <link rel="stylesheet" type="text/css" href="<c:url value='resources/css/style.css'/>" />
    <script type="text/javascript" src="resources/js/jquery.1.4.2.js"></script>
    <script type="text/javascript" src="resources/js/latest.js"></script>
    <script src="resources/selector/chosen.jquery.js" type="text/javascript"></script>
    <script src="resources/selector/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" href="resources/selector/docsupport/prism.css">
    <link rel="stylesheet" href="resources/selector/chosen.css">
</head>
<body>
<header class="header">
<form:form method="post" action="/fider">
<table cellpadding="0" cellspacing="0" border="0" width="100%">
    <tbody>
    <tr>
        <%
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
            String dateFrom = (request.getAttribute("dateFrom") != null) ? sdf.format((Date)request.getAttribute("dateFrom")) : "";
            String dateTill = (request.getAttribute("dateTill") != null) ? sdf.format((Date)request.getAttribute("dateTill")) : "";

        %>
        <td><label>Select date of mensuration</label></td>
        <td><p><input type="text" class="datepickerTimeField" name="dateFrom" value=<%=dateFrom%>></p><td>
        <td><p><input type="text" class="datepickerTimeField" name="dateTill" value=<%=dateTill%>></p><td>
    </tr>
    <tr>
        <td>
            <div>
                <em>   Into This</em>
                <select name="ts_select1" class="chosen-select">
                    <option value=""></option>
                    <option value="1">Подволошная</option>
                    <option value="2">Бойцы</option>
                    <option value="3">Кузино</option>
                    <option value="4">Сабик</option>
                    <option value="5">Сарга</option>
                    <option value="6">Шаля</option>
                </select>
                </div>
        </td>
        <td>
            <select name="ts_select2" class="chosen-select">
                <option value="1">Подволошная</option>
                <option value="2">Бойцы</option>
                <option value="3">Кузино</option>
                <option value="4">Сабик</option>
                <option value="5">Сарга</option>
                <option value="6">Шаля</option>
            </select>
        </td>
        <td>
            <select name="fider12_select" multiple class="chosen-select">
                <option value="1">Фидер 1</option>
                <option value="2">Фидер 2</option>
                <option value="3">Фидер 3</option>
                <option value="4">Фидер 4</option>
                <option value="5">Фидер 5</option>
                <option value="6">Фидер 6</option>
                <option value="7">Фидер 7</option>
                <option value="8">Фидер 8</option>
                <option value="9">Выпрямитель 9</option>
                <option value="10">Выпрямитель 10</option>
            </select>
        </td>
        <td>
            <select name="fider34_select" multiple class="chosen-select">
                <option value="1">Фидер 1</option>
                <option value="2">Фидер 2</option>
                <option value="3">Фидер 3</option>
                <option value="4">Фидер 4</option>
                <option value="5">Фидер 5</option>
                <option value="6">Фидер 6</option>
                <option value="7">Фидер 7</option>
                <option value="8">Фидер 8</option>
                <option value="9">Выпрямитель 9</option>
                <option value="10">Выпрямитель 10</option>
            </select>
        </td>
    </tr>
    <td colspan="3"><input type="submit" value="Find" name="find"></td>
    </tbody>
</table>
<script type="text/javascript">
    var config = {
        '.chosen-select'           : {},
        '.chosen-select-deselect'  : {allow_single_deselect:true},
        '.chosen-select-no-single' : {disable_search_threshold:10},
        '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
        '.chosen-select-width'     : {width:"95%"}
    }
    for (var selector in config) {
        $(selector).chosen(config[selector]);
    }
</script>
</form:form>

</header><!-- .header-->

<div class="middle">
    <div class="container">
        <main class="content">
<table width="100%" cellspacing="0" cellpadding="0" border="0">
    <tr>
        <%@include file="show.jsp"%>
    </tr>
</table>