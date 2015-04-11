<%@ page import="java.util.Map" %>
<form:form method="post" action="/filter_post">
<input type="hidden" name="name1" value="">
<table cellpadding="0" cellspacing="0" border="0" width="100%">
  <tbody>
    <tr>
      <%
        Map<Integer,String> map = (Map<Integer,String>)request.getAttribute("ts");
      %>
      <td><label>Select date of mensuration</label></td>
      <td><p><input type="text" class="datepickerTimeField" name="date"></p><td>
      <td>
        <select>
          <%for(int j=1;j<7;j++){%>
          <option value="1"><%=map.get(j)%></option>
          <%}%>
        </select>
      </td>
    </tr>
      <td colspan="3"><input type="submit" value="Find"></td>
  </tbody>
</table>
</form:form>

