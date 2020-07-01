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
    <body style="background-image: url('resources/images/bg.jpg'); color: #FFF">

        <c:import url="/WEB-INF/jsp/parts/header.jsp"/>

        <div class="container ftco-animate" style="margin-top: 120px;">
            <h4 style="color: #e4606d">Order #${requestScope.order.id} Info</h4>
            <div>
                <h5 class="h5">Customer Information:</h5>
                <ul>
                    <li>Id: ${requestScope.customer.id}</li>
                    <li>First name: ${requestScope.customer.firstName}</li>
                    <li>Last name: ${requestScope.customer.lastName}</li>
                    <li>Username: ${requestScope.customer.username}</li>
                    <li>Email: ${requestScope.customer.email}</li>
                    <li>Phone number: ${requestScope.customer.phoneNumber}</li>
                </ul>
                <h5 class="h5">Order Summary:</h5>
                <ul>
                    <li>Total price
                        <span class="total">$${order.totalPrice}</span>
                    </li>
                </ul>
            </div>
            <div class="row" style="margin: 0 10% 0 10%">
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
                                <a href="controller?command=show_orders_list_page" class="btn btn-warning">
                                    Go back
                                </a>
                            </td>
                            <td colspan="2">
                                <a onclick="this.href = 'controller?command=cancel_order&orderId=${requestScope.order.id}&comment='
                                                + document.getElementById('comment').value"
                                   class="btn btn-danger btn-block">
                                    Cancel order
                                </a>
                            </td>
                            <td>
                                <a onclick="this.href = 'controller?command=confirm_order&orderId=${requestScope.order.id}&comment='
                                                + document.getElementById('comment').value"
                                   class="btn btn-success btn-block">
                                    Сonfirm order
                                </a>
                            </td>
                        </tr>
                    </tfoot>
                </table>
                <div class="input-group input-group-sm">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Comment</span>
                    </div>
                    <input class="form-control" id="comment" name="comment" type="text" 
                           placeholder="Leave comment here..." required>
                </div>
            </div>
        </div>
    </body>
    <c:import url="/WEB-INF/jsp/parts/loader.html"/>
    <c:import url="/WEB-INF/jsp/parts/scripts.html"/>
</html>