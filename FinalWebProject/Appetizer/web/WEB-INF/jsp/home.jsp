<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="il8n.content"/>

<!DOCTYPE html>
<html lang="${locale}">
    <head>
        <title><fmt:message key="home.title"/></title>
        <c:import url="/WEB-INF/jsp/parts/meta.html"/>
        <c:import url="/WEB-INF/jsp/parts/links.html"/>
    </head>

    <body>
        <c:import url="/WEB-INF/jsp/parts/header.jsp"/>

        <!-- SLIDERS -->
        <section class="home-slider owl-carousel js-fullheight">

            <div class="slider-item js-fullheight" style="background-image: url(resources/images/bg-1.jpg);">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row slider-text js-fullheight justify-content-center align-items-center" data-scrollax-parent="true">
                        <div class="col-md-12 col-sm-12 text-center ftco-animate">
                            <h1 class="mb-4 mt-5">
                                Our Delicious Specialties
                            </h1>
                            <p>
                                <a href="controller?command=show_order_page" class="btn btn-primary p-3 px-xl-4 py-xl-3">
                                    <fmt:message key="home.orderNow"/>
                                </a>
                                <a href="controller?command=show_menu_page" class="btn btn-white btn-outline-white p-3 px-xl-4 py-xl-3">
                                    <fmt:message key="home.viewMenu"/>
                                </a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="slider-item js-fullheight" style="background-image: url(resources/images/bg-2.jpg);">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row slider-text js-fullheight justify-content-center align-items-center" data-scrollax-parent="true">
                        <div class="col-md-12 col-sm-12 text-center ftco-animate">
                            <h1 class="mb-4 mt-5">The Best Place to Kick of Your Day</h1>
                            <p>
                                <a href="controller?command=show_order_page" class="btn btn-primary p-3 px-xl-4 py-xl-3">
                                    <fmt:message key="home.orderNow"/>
                                </a>
                                <a href="controller?command=show_menu_page" class="btn btn-white btn-outline-white p-3 px-xl-4 py-xl-3">
                                    <fmt:message key="home.viewMenu"/>
                                </a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="slider-item js-fullheight" style="background-image: url(resources/images/bg-3.jpg);">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">
                        <div class="col-md-12 col-sm-12 text-center ftco-animate">
                            <h1 class="mb-4 mt-5">Creamy Hot and Ready to Serve</h1>
                            <p>
                                <a href="controller?command=show_order_page" class="btn btn-primary p-3 px-xl-4 py-xl-3">
                                    <fmt:message key="home.orderNow"/>
                                </a>
                                <a href="controller?command=show_menu_page" class="btn btn-white btn-outline-white p-3 px-xl-4 py-xl-3">
                                    <fmt:message key="home.viewMenu"/>
                                </a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- MAP -->
        <section class="ftco-section ftco-wrap-about ftco-no-pb">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-sm-10 wrap-about ftco-animate text-center">
                        <div class="heading-section mb-4 text-center">
                            <span class="subheading">Where you can find us?</span>
                            <h2 class="mb-4">
                                <fmt:message key="home.ourRestaurantOnTheMap"/>
                            </h2>
                        </div>
                    </div>
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1175.510775042657!2d27.553055158147696!3d53.89582090951551!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x46dbcfc2b0fb8529%3A0x2d7b8406db6b7be7!2z0YPQuy4g0JrQsNGA0LvQsCDQnNCw0YDQutGB0LAgNSwg0JzQuNC90YHQug!5e0!3m2!1sru!2sby!4v1574252454904!5m2!1sru!2sby" width="1600" height="700" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
                </div>
            </div>
        </section>
    </body>

    <c:import url="/WEB-INF/jsp/parts/footer.jsp"/>
    <c:import url="/WEB-INF/jsp/parts/loader.html"/>
    <c:import url="/WEB-INF/jsp/parts/scripts.html"/>
</html>