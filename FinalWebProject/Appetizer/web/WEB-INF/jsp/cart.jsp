<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="il8n.content"/>

<!DOCTYPE html>
<html>
    <head>
        <title><fmt:message key="cart.title"/></title>
        <c:import url="/WEB-INF/jsp/parts/meta.html"/>
        <c:import url="/WEB-INF/jsp/parts/links.html"/>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body style="background-image: url('resources/images/bg.jpg'); color: #FFF">
        <c:import url="/WEB-INF/jsp/parts/header.jsp"/>

        <div class="container" style="margin-top: 150px">
            <c:choose>
                <c:when test="${not empty requestScope.cartItems}">
                    <div class="row ftco-animate" style="margin: 0 12% 0 12%">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th style="text-align: left">
                                        <fmt:message key="cart.dish"/>
                                    </th>
                                    <th>
                                        <fmt:message key="cart.price"/>
                                    </th>
                                    <th>
                                        <fmt:message key="cart.quantity"/>
                                    </th>
                                    <th>
                                        <fmt:message key="cart.subtotal"/>
                                    </th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.cartItems}" var="cartItem">
                                    <tr>
                                        <td style="text-align: left">
                                            <div class="row">
                                                <div class="col-sm-2">
                                                    <img src="${cartItem.dish.imagePath}" width="50px" height="50px" class="img-thumbnail">
                                                </div>
                                                <div class="col-sm-10">
                                                    <label class="m-0">${cartItem.dish.name}</label>
                                                    <br>
                                                    <label class="m-0">${cartItem.dish.description}</label>
                                                </div>
                                            </div>
                                        </td>
                                        <td>$${cartItem.dish.price}</td>
                                        <td>
                                            <a style="text-decoration: none"
                                               href="controller?command=update_quantity&sign=minus&cartItemId=${cartItem.id}">
                                                <button class="btn btn-info btn-sm" style="width: 30px">-</button>
                                            </a>
                                            <span style="width: 10px;">${cartItem.quantity}</span>
                                            <a style="text-decoration: none"
                                               href="controller?command=update_quantity&sign=plus&cartItemId=${cartItem.id}">
                                                <button class="btn btn-info btn-sm" style="width: 30px">+</button>
                                            </a>
                                        </td>
                                        <td class="text-center">$${cartItem.quantity * cartItem.dish.price}</td>
                                        <td>
                                            <a href="controller?command=delete_from_cart&cartItemId=${cartItem.id}">
                                                <button class="btn btn-danger btn-sm">
                                                    <i class="fa fa-trash-o"></i>
                                                </button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td style="text-align: left">
                                        <a href="controller?command=show_menu_page" class="btn btn-warning">
                                            <i class="fa fa-angle-left"></i>
                                            <fmt:message key="cart.continue"/>
                                        </a>
                                    </td>
                                    <td colspan="2" class="hidden-xs">
                                        <a href="controller?command=clear_cart" class="btn btn-danger btn-block">
                                            <fmt:message key="cart.clear"/>
                                            <i class="fa fa-close"></i>
                                        </a>
                                    </td>
                                    <td class="hidden-xs text-center">
                                        <strong><fmt:message key="cart.total"/> $${requestScope.totalPrice}</strong>
                                    </td>
                                    <td>
                                        <a href="controller?command=add_order" class="btn btn-success btn-block">
                                            <fmt:message key="cart.checkout"/>
                                            <i class="fa fa-angle-right"></i>
                                        </a>

                                    </td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="alert alert-info alert-dismissible fade show" style="margin: 0 25% 0 25%" role="alert">
                        <strong>Your cart is empty</strong>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
    <c:import url="/WEB-INF/jsp/parts/loader.html"/>
    <c:import url="/WEB-INF/jsp/parts/scripts.html"/>
</html>
