
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Mvc CRUD</title>
        <style type="text/css">
            table{
                border-collapse: collapse;
                margin: 0 auto;
            }

            th{background: green; color: white;}
            
            th, td{
                padding: 10px;
            }

            tfoot{
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1 align="center">Spring Web MVC CRUD</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="row" items="${products}">
                    <tr>
                        <td>${row.pid}</td>
                        <td>${row.pname}</td>
                        <td>${row.price}</td>
                        <td>${row.qty}</td>
                        <td><a href="<%= request.getContextPath()%>/edit">Edit</a></td>
                        <td><a href="<%= request.getContextPath()%>/delete">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="6">
                        <a href="<%= request.getContextPath() %>/insertPage">Insert Product Page</a>
                    </td>
                </tr>
            </tfoot>
        </table>



    </body>
</html>
