<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="il8n.content"/>

<!DOCTYPE html>
<html lang="${locale}">
    <head>
        <title></title>
        <c:import url="/WEB-INF/jsp/parts/meta.html"/>
        <c:import url="/WEB-INF/jsp/parts/links.html"/>
        <link rel="stylesheet" href="resources/css/flaticon.css">
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
                        <h1 class="mb-2 bread">About</h1>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section ftco-wrap-about ftco-no-pb">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-sm-10 wrap-about ftco-animate text-center">
                        <div class="heading-section mb-4 text-center">
                            <span class="subheading">About</span>
                            <h2 class="mb-4">Appetizer Restaurant</h2>
                        </div>
                        <p>On her way she met a copy.</p>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section bg-light">
            <div class="container">
                <div class="row justify-content-center mb-5 pb-2">
                    <div class="col-md-7 text-center heading-section ftco-animate">
                        <span class="subheading">Services</span>
                        <h2 class="mb-4">Catering Services</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 d-flex align-self-stretch ftco-animate text-center">
                        <div class="media block-6 services d-block">
                            <div class="icon d-flex justify-content-center align-items-center">
                                <span class="flaticon-cake"></span>
                            </div>
                            <div class="media-body p-2 mt-3">
                                <h3 class="heading">Birthday Party</h3>
                                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
                            </div>
                        </div>      
                    </div>
                    <div class="col-md-4 d-flex align-self-stretch ftco-animate text-center">
                        <div class="media block-6 services d-block">
                            <div class="icon d-flex justify-content-center align-items-center">
                                <span class="flaticon-meeting"></span>
                            </div>
                            <div class="media-body p-2 mt-3">
                                <h3 class="heading">Business Meetings</h3>
                                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
                            </div>
                        </div>    
                    </div>
                    <div class="col-md-4 d-flex align-self-stretch ftco-animate text-center">
                        <div class="media block-6 services d-block">
                            <div class="icon d-flex justify-content-center align-items-center">
                                <span class="flaticon-tray"></span>
                            </div>
                            <div class="media-body p-2 mt-3">
                                <h3 class="heading">Wedding Party</h3>
                                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
                            </div>
                        </div>      
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center mb-5 pb-2">
                    <div class="col-md-7 text-center heading-section ftco-animate">
                        <span class="subheading">Chef</span>
                        <h2 class="mb-4">Our Master Chef</h2>
                    </div>
                </div>	
                <div class="row">
                    <div class="col-md-6 col-lg-3 ftco-animate">
                        <div class="staff">
                            <div class="img" style="background-image: url(resources/images/chef-4.jpg);"></div>
                            <div class="text pt-4">
                                <h3>John Smooth</h3>
                                <span class="position mb-2">Restaurant Owner</span>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 ftco-animate">
                        <div class="staff">
                            <div class="img" style="background-image: url(resources/images/chef-2.jpg);"></div>
                            <div class="text pt-4">
                                <h3>Rebeca Welson</h3>
                                <span class="position mb-2">Head Chef</span>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 ftco-animate">
                        <div class="staff">
                            <div class="img" style="background-image: url(resources/images/chef-3.jpg);"></div>
                            <div class="text pt-4">
                                <h3>Kharl Branyt</h3>
                                <span class="position mb-2">Chef</span>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 ftco-animate">
                        <div class="staff">
                            <div class="img" style="background-image: url(resources/images/chef-1.jpg);"></div>
                            <div class="text pt-4">
                                <h3>Luke Simon</h3>
                                <span class="position mb-2">Chef</span>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>

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