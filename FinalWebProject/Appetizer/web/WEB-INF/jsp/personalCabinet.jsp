<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="il8n.content"/>

<!DOCTYPE html>
<html lang="${locale}">
    <head>
        <title><fmt:message key="personalCabinet.title"/></title>
        <c:import url="/WEB-INF/jsp/parts/meta.html"/>
        <c:import url="/WEB-INF/jsp/parts/links.html"/>
    </head>
    <body style="background-image: url('resources/images/bg.jpg'); color: #FFF">
        <c:import url="/WEB-INF/jsp/parts/header.jsp"/>

        <section class="ftco-section">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 d-flex align-self-stretch ftco-animate text-center">
                        <div class="media block-6 services d-block">
                            <div class="media-body p-2 mt-3">
                                <h3 class="heading h3">
                                    User info
                                </h3>
                                <p>${sessionScope.user.firstName}</p>
                            </div>
                        </div>      
                    </div>

                    <div class="col-md-4 d-flex align-self-stretch ftco-animate text-center">
                        <div class="media block-6 services d-block">
                            <div class="media-body p-2 mt-3">
                                <h3 class="heading h3">
                                    Actions
                                </h3>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <c:if test="${sessionScope.user.roleId == 1}">
                                        <p>
                                            <a href="controller?command=show_orders_list_page" class="btn btn-primary py-3 px-3">
                                                Show orders pending verification
                                            </a>
                                        </p>
                                    </c:if>
                                    <c:if test="${sessionScope.user.roleId == 2}">
                                        <p>
                                            <a href="controller?command=show_order_history_page" class="btn btn-primary py-3 px-3">
                                                Show order history
                                            </a>
                                        </p>
                                    </c:if>
                                </div>
                            </div>
                        </div>      
                    </div>

                    <div class="col-md-4 d-flex align-self-stretch ftco-animate text-center">
                        <div class="media block-6 services d-block">
                            <div class="media-body p-2 mt-3">
                                <h3 class="heading h3">Edit user info</h3>
                            </div>
                        </div>      
                    </div>
                </div>
            </div>
        </section>

    </body>
    <c:import url="/WEB-INF/jsp/parts/footer.jsp"/>
    <c:import url="/WEB-INF/jsp/parts/loader.html"/>
    <c:import url="/WEB-INF/jsp/parts/scripts.html"/>
</html>