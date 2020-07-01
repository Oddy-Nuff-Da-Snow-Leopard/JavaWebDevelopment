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

        <div class="container" style="margin-top: 150px;">
            <div class="row ftco-animate" style="margin: 0 10% 0 10%; text-align: center">
                <div>Order #${requestScope.order.id} Info</div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Dish id</th>
                            <th>Dish name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.cartItems}" var="cartItem">
                            <tr>
                                <td>${cartItem.dish.id}</td>
                                <td>${cartItem.dish.name}</td>
                                <td>${cartItem.quantity}</td>
                                <td>$${cartItem.quantity * cartItem.dish.price}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td>
                                <a href="controller?command=show_order_history_page" class="btn btn-warning">
                                    Go back
                                </a>
                            </td>
                            <td colspan="2">
                                <c:if test="${requestScope.order.comment != null}">
                                    <div class="input-group input-group-sm">
                                        <input class="form-control" type="text" placeholder="${requestScope.order.comment}" readonly>
                                    </div>
                                </c:if>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </body>
    <c:import url="/WEB-INF/jsp/parts/loader.html"/>
    <c:import url="/WEB-INF/jsp/parts/scripts.html"/>
</html>