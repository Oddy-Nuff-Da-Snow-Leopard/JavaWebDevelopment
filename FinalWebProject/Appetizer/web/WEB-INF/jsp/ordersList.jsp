<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="il8n.content"/>

<!DOCTYPE html>
<html lang="${locale}">
    <head>
        <title><fmt:message key="ordersList"/></title>
        <c:import url="/WEB-INF/jsp/parts/meta.html"/>
        <c:import url="/WEB-INF/jsp/parts/links.html"/>
    </head>
    <body style="background-image: url('resources/images/bg.jpg'); color: white">
        <c:import url="/WEB-INF/jsp/parts/header.jsp"/>

        <div class="container" style="margin-top: 200px;">
            <div class="row ftco-animate" style="margin: 0 10% 0 10%;">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Order #</th>
                            <th>Order date</th>
                            <th>Order total price</th>
                            <th>View</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.orders}" var="order">
                            <tr>
                                <th scope="row">${order.id}</th>
                                <td>
                                    <fmt:formatDate value="${order.date}" pattern="dd-MM-yyyy"/>
                                </td>
                                <td>
                                    $${order.totalPrice}
                                </td>
                                <td>
                                    <a href="controller?command=show_order_info_page&orderId=${order.id}">View</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
    <c:import url="/WEB-INF/jsp/parts/loader.html"/>
    <c:import url="/WEB-INF/jsp/parts/scripts.html"/>
</html>