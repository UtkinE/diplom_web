<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:if  test="${!empty dataMensList}">
  <table>
    <tr>
      <td>1</td>
      <td>2</td>
      <td>3</td>
      <td>4</td>
      <td>5</td>
      <td>6</td>
    </tr>
<c:forEach items="${dataMensList}" var="dataMens">
    <tr>
      <td>{dataMens.timeMensuration}</td>
      <td>{dataMens.column1}</td>
      <td>{dataMens.column2}</td>
      <td>{dataMens.column3}</td>
      <td>{dataMens.column4}</td>
      <td>{dataMens.column5}</td>
    </tr>
</c:forEach>
  </table>
</c:if>
</body>
</html>
