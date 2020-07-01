<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="il8n.content"/>

<!DOCTYPE html>
<html lang="${locale}">
    <head>
        <title><fmt:message key="orderHistory.title"/></title>
        <c:import url="/WEB-INF/jsp/parts/meta.html"/>
        <c:import url="/WEB-INF/jsp/parts/links.html"/>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    </head>

    <body style="background-image: url('resources/images/bg.jpg'); color: white">

        <c:import url="/WEB-INF/jsp/parts/header.jsp"/>

        <div class="container" style="margin-top: 150px;">
            <div class="row ftco-animate" style="margin: 0 10% 0 10%; text-align: center" >
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Order #</th>
                            <th>Order date</th>
                            <th>Order total price</th>
                            <th>Status</th>
                            <th>View</th>
                        </tr>
                    </thead>
                    <c:set var="countPage" scope="request" value="${0}"/>
                    <c:forEach varStatus="count" items="${sessionScope.orders}" var="order">
                        <c:if test="${countPage >= sessionScope.ordersFirstRow && countPage < sessionScope.ordersLastRow}">
                            <tbody>
                                <tr>
                                    <th>${count.count}</th>
                                    <td>
                                        <fmt:formatDate value="${order.date}" pattern="dd-MM-yyyy"/>
                                    </td>
                                    <td>
                                        $${order.totalPrice}
                                    </td>
                                    <td>
                                        <c:if test="${order.statusId == 1}">
                                            <label style="margin: 0; color: skyblue">Pending</label>
                                        </c:if>
                                        <c:if test="${order.statusId == 2}">
                                            <label style="margin: 0; color: greenyellow">Awaiting paiment</label>
                                        </c:if>
                                        <c:if test="${order.statusId == 3}">
                                            <label style="margin: 0; color: red">Cancelled</label>
                                        </c:if>
                                        <c:if test="${order.statusId == 5}">
                                            <label style="margin: 0">Paid</label>
                                        </c:if>
                                        <c:if test="${order.statusId == 6}">
                                            <label style="margin: 0">Issued</label>
                                        </c:if>
                                    </td>
                                    <td>
                                        <a href="controller?command=show_order_content_page&orderId=${order.id}">View</a>
                                    </td>
                                </tr>
                            </c:if>
                            <c:set var="countPage" value="${countPage + 1}"></c:set>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="row ftco-animate" style="text-align: center">
            <div class="col-3"></div>
            <div class="col-2">
                <form action="controller" method="post">
                    <c:if test="${sessionScope.ordersFirstRow > 0}">
                        <input type="hidden" name="firstRow" value="ordersFirstRow">
                        <input type="hidden" name="lastRow" value="ordersLastRow">
                        <input type="hidden" name="numberOfPages" value="ordersNumberOfPages">
                        <input type="hidden" name="currentPageNumber" value="ordersCurrentPageNumber">
                        <input type="hidden" name="command" value="show_previous_page">
                        <button class="btn btn-info">
                            <i class="fa fa-angle-left"></i>
                            Previous page
                        </button>
                    </c:if>
                </form>
            </div>
            <div class="col-2">
                <p>
                    Page
                    <c:out value="${sessionScope.ordersCurrentPageNumber}"/>
                    Of
                    <c:out value=" ${sessionScope.ordersNumberOfPages}"/>
                </p>
            </div>
            <div class="col-2">
                <form action="controller" method="post">
                    <c:if test="${countPage > sessionScope.ordersLastRow}">
                        <input type="hidden" name="firstRow" value="ordersFirstRow">
                        <input type="hidden" name="lastRow" value="ordersLastRow">
                        <input type="hidden" name="numberOfPages" value="ordersNumberOfPages">
                        <input type="hidden" name="currentPageNumber" value="ordersCurrentPageNumber">
                        <input type="hidden" name="command" value="show_next_page">
                        <button class="btn btn-info">
                            Next page
                            <i class="fa fa-angle-right"></i>
                        </button>
                    </c:if>
                </form>
            </div>
            <div class="col-3"></div>
        </div>
    </body>
    <c:import url="/WEB-INF/jsp/parts/loader.html"/>
    <c:import url="/WEB-INF/jsp/parts/scripts.html"/>
</html>