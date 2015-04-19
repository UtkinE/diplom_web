

<div id="graphdiv" style="width:1000px; height:500px;"></div>
<%
    StringBuilder sb = (StringBuilder)request.getAttribute("entities");
%>
<script type="text/javascript">
    g = new Dygraph(

            // containing div
            document.getElementById("graphdiv"),

            // CSV or path to a CSV file.
            <%=sb.toString()%>,
            {
                showRoller: true,
                title: 'Daily Temperatures in New York vs. San Francisco',
                ylabel: 'Temperature (F)',
                legend: 'always',
                labelsDivStyles: { 'textAlign': 'right' }
            }


    );
</script>
</div>
</main><!-- .content -->
</div><!-- .container-->
<aside class="left-sidebar">
    <strong>Left Sidebar:</strong> Text
</aside><!-- .left-sidebar -->

</div><!-- .middle-->
</body>
</html>