<%-- 
    Document   : sampledata
    Created on : Dec 20, 2021, 8:08:09 PM
    Author     : Connor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sample Data</h1>
        
        <table border="1" cellpadding="5">
            <thead>
                <tr>
                    <th>Pair</th>
                    <th>Item</th>
                    <th>Lightness</th>
                    <th>Alpha</th>
                    <th>Beta</th>
                    <th>Chroma</th>
                    <th>Hue</th>
                    <th>Hue Mean</th>
                    <th>G</th>
                    <th>T</th>
                    <th>sL</th>
                    <th>sC</th>
                    <th>sH</th>
                    <th>rT</th>
                    <th>Delta E</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${sampleData}" var="sample">
                    <tr>
                        <td>${sample.pair}</td>
                        <td>${sample.i}</td>
                        <td>${sample.lightness}</td>
                        <td>${sample.alpha}</td>
                        <td>${sample.beta}</td>
                        <td>${sample.chroma}</td>
                        <td>${sample.hue}</td>
                        <td>${sample.hueMean}</td>
                        <td>${sample.G}</td>
                        <td>${sample.T}</td>
                        <td>${sample.sL}</td>
                        <td>${sample.sC}</td>
                        <td>${sample.sH}</td>
                        <td>${sample.rT}</td>
                        <td>${sample.deltaE}</td>  
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        
        
    </body>
</html>
