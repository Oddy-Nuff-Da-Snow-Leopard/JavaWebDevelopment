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
    <body>
        <c:import url="/WEB-INF/jsp/parts/header.jsp"/>

        <section class="hero-wrap hero-wrap-2"
                 style="background-image: url('resources/images/bg-3.jpg');"
                 data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-end justify-content-center">
                    <div class="col-md-9 ftco-animate text-center">
                        <h1 class="mb-2 bread">Our Specialties</h1>
                    </div>
                </div>
            </div>
        </section>

        <div class="alert-holder ftco-animate">
            <c:if test="${sessionScope.user == null}">
                <div class="alert alert-info alert-dismissible fade show" role="alert">
                    <fmt:message key="message.wantToMakeAnOrder"/>
                    <a href="controller?command=show_sign_in_page" style="color: #b21f2d">
                        <fmt:message key="message.signIn"/>
                    </a>
                    <fmt:message key="message.or"/>
                    <a href="controller?command=show_sign_up_page" style="color: #fd7e14">
                        <fmt:message key="message.register"/>
                    </a>
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
        </div>

        <section class="ftco-section">
            <div class="container-fluid px-4">
                <div class="row justify-content-center mb-5 pb-2">
                    <div class="col-md-7 text-center heading-section ftco-animate">
                        <span class="subheading">Specialties</span>
                        <h2 class="mb-4">Our Menu</h2>
                    </div>
                </div>
                <form action="controller" method="post">
                    <div class="row">
                        <c:forEach items="${requestScope.dishesCategories}" var="dishCategory">
                            <div class="col-md-6 col-lg-4 menu-wrap">
                                <div class="heading-menu text-center ftco-animate">
                                    <h3>${dishCategory.category}</h3>
                                </div>
                                <c:forEach items="${requestScope.dishes}" var="dish">
                                    <c:if test="${dishCategory.id == dish.categoryId}">
                                        <div class="menus d-flex ftco-animate">
                                            <div class="menu-img img"
                                                 style="background-image: url('${dish.imagePath}')">
                                            </div>
                                            <div class="text">
                                                <div class="d-flex">
                                                    <div class="one-half">
                                                        <h3>${dish.name}</h3>
                                                    </div>
                                                    <div class="one-forth">
                                                        <span class="price">$${dish.price}</span>
                                                    </div>
                                                </div>
                                                <p><span>${dish.description}</span></p>
                                            </div>
                                            <c:if test="${sessionScope.user.roleId == 2}">
                                                <input type="checkbox" name="dishId" value="${dish.id}">
                                            </c:if>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </c:forEach>
                    </div>
                    <c:if test="${sessionScope.user.roleId == 2}">
                        <button class="btn btn-primary p-3 px-xl-4 py-xl-3">
                            <fmt:message key="menu.addDishesToCart"/>
                            <input type="hidden" name="command" value="add_to_cart"/>
                        </button>
                    </c:if>
                </form>
            </div>
        </section>
    </body>

    <c:import url="/WEB-INF/jsp/parts/footer.jsp"/>
    <c:import url="/WEB-INF/jsp/parts/loader.html"/>
    <c:import url="/WEB-INF/jsp/parts/scripts.html"/>

    <script>
        $(document).on('click', '.menus', function (e) {
            var $checkbox = $(':checkbox', this);
            if (e.target !== $checkbox[0]) {
                $checkbox.prop('checked', !$checkbox.prop('checked'));
            }
        });
    </script>
</html>