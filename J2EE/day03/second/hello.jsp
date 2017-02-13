         <%@ page language="java" import="java.util.*" %>
         <%@ page contentType="text/html" %>
         <html>
            <head>
               <title>Hello JSP</title>
            </head>
            <body>
               <%!
                    int cnt = 1;
                    public void jspInit() {
                        System.out.println("jspInit() called");
                    }
                    public void jspDetroy() {
                        System.out.println("jspDestroy() called");
                    }
                %>
                <h2>Hello DAC</h2>
                <% cnt++; %>
                <% if(cnt % 2 == 0) { %>
                     Even Count : <%= cnt %>
                <% } else { %>
                     Odd Count : <%= cnt %>
                <% } %>
                <h3>Cur Time: <%= new Date().toString() %> </h3>
                <%-- This is Simple JSP Page --%>
            </body>
         </html>



