<%-- 
    Document   : Palette
    Created on : Dec 20, 2021, 5:39:18 PM
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
                    <th>Colours</th>
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
                        <td>${sample.g}</td>
                        <td>${sample.t}</td>
                        <td>${sample.sL}</td>
                        <td>${sample.sC}</td>
                        <td>${sample.sH}</td>
                        <td>${sample.rT}</td>
                        <td>${sample.deltaE}</td>  
                        <td style="background-color:${sample.hexColor};">
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        
       <%-- <a href="sampledata">data</a>
        <table border="1" cellpadding="5">
            <thead>
                <tr>
                    <th>Sample 1</th>
                    <th>Sample 2</th>
                    <th>Sample 3</th>
                    <th>Sample 4</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><img src="resources\sample1.jpg" height ="500" alt=""/> </td>
                    <td><img src="resources\sample2.jpg" height ="500" alt=""/></td>
                    <td><img src="resources\sample3.jpg" height ="500" alt=""/></td>
                    <td><img src="resources\sample4.png" height ="500" alt=""/></td>
                </tr>
                <tr>                    
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>

        
       
       --%>
        
    </body>
</html>
