

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            table{
                border: 1px solid black;
                padding: 20px;
                margin: 0 auto;
            }
            td{
                padding: 10px;
            }
            input{padding: 10px;}
        </style>
    </head>
    <body>
        <h1 align="center">Edit product</h1>
        <p align="center">
            <font color="green">
            <c:if test="${sm != null}">
                ${sm}
            </c:if>
            </font>   
            <font color="red">
            <c:if test="${em != null}">
                ${em}
            </c:if>
            </font>   
        </p>
        <form action="<%= request.getContextPath()%>/updateProduct" method="post">
            <table>
                <tr>
                    <td>Product Name</td>
                    <td>:</td>
                    <td>
                        <input type="hidden" name="pid" value="${product.pid}"/>
                        <input type="text" name="pname" value="${product.pname}"/>
                    </td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td>:</td>
                    <td><input type="text" name="price" value="${product.price}"/></td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td>:</td>
                    <td><input type="text" name="qty" value="${product.qty}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td><input type="submit" name="btn" value="Update"/></td>
                </tr>
                <tr>
                    <td colspan="3" style="text-align: center">
                        <a href="<%= request.getContextPath()%>/">List Page</a>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
