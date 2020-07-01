<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="il8n.content"/>

<!DOCTYPE html>
<html lang="${locale}">
    <head>
        <title><fmt:message key="menu.title"/></title>
        <c:import url="/WEB-INF/jsp/parts/meta.html"/>
        <c:import url="/WEB-INF/jsp/parts/links.html"/>
    </head>
    <body style="background-image: url('resources/images/bg.jpg'); color: white">
        <c:import url="/WEB-INF/jsp/parts/header.jsp"/>
        <div class="container">
            <div class="row" style="margin: 150px 25% 0 25%;">
                <form action="controller" method="post" class="form-inline">
                    <input style="color: white" type="text" readonly class="form-control-plaintext" 
                           value="Enter new dish category name: ">
                    <div class="form-group mr-3">
                        <input type="text" class="form-control-lg">
                    </div>
                    <button type="submit" class="btn btn-info">Add category</button>
                </form>
            </div>
        </div>
    </body>
    <c:import url="/WEB-INF/jsp/parts/loader.html"/>
    <c:import url="/WEB-INF/jsp/parts/scripts.html"/>
</html>
