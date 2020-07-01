<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="il8n.content"/>

<!DOCTYPE html>
<html lang="${locale}">
    <head>
        <title><fmt:message key="signUp.title"/></title>
        <c:import url="/WEB-INF/jsp/parts/meta.html"/>
        <c:import url="/WEB-INF/jsp/parts/links.html"/>

        <link rel="stylesheet" 
              href="resources/sign-up-page/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" href="resources/sign-up-page/css/style.css">
    </head>

    <body>
        <c:import url="/WEB-INF/jsp/parts/header.jsp"/>

        <div class="wrapper"
             style="background-image: url('resources/sign-up-page/images/bg-signUp.jpeg');">

            <div class="inner">

                <div class="alert-holder col-md-12 ftco-animate">
                    <c:if test="${sessionScope.signUpPageMessage!=null}">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            <fmt:message key="${sessionScope.signUpPageMessage}"/>
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <c:remove var="signUpPageMessage"/>
                    </c:if>
                </div>

                <div class="image-holder">
                    <img src="resources/sign-up-page/images/chef.jpg">
                </div>

                <form action="controller" method="post">

                    <h3><fmt:message key="signUp.signUp"/></h3>
                    <div class="form-group">
                        <input class="form-control"
                               id="firstName" name="firstName" 
                               type="text" pattern="^[A-Z]{1}[a-z]{1,20}|[А-Я]{1}[а-я]{1,20}$"
                               placeholder="<fmt:message key="signUp.firstName"/>"
                               required>
                        <input class="form-control"
                               id="lastName" name="lastName" 
                               type="text" pattern="^[A-Z]{1}[a-z]{1,25}|[А-Я]{1}[а-я]{1,25}$"
                               placeholder="<fmt:message key="signUp.lastName"/>"
                               required>
                    </div>

                    <div class="form-wrapper">
                        <select class="form-control" style="font-size: 14px"
                                id="gender" name="gender" required>
                            <option value="" disabled selected><fmt:message key="signUp.gender"/></option>
                            <option value="male"><fmt:message key="signUp.gender.male"/></option>
                            <option value="female"><fmt:message key="signUp.gender.female"/></option>
                            <option value="other"><fmt:message key="signUp.gender.other"/></option>
                        </select>
                        <i class="zmdi zmdi-caret-down" style="font-size: 20px;"></i>
                    </div>

                    <div class="form-wrapper">
                        <input class="form-control"
                               id="username" name="username" 
                               type="text" pattern="^[a-zA-ZА-Яа-я][a-zA-ZА-Яа-я0-9-_\.]{3,20}$" 
                               placeholder="<fmt:message key="signUp.username"/>"
                               required>
                        <i class="zmdi zmdi-account"></i>
                    </div>

                    <div class="form-wrapper">
                        <input class="form-control"
                               id="phoneNumber" name="phoneNumber"
                               type="tel"
                               placeholder="<fmt:message key="signUp.phoneNumber"/>"
                               required>
                        <i class="zmdi zmdi-phone"></i>
                    </div>

                    <div class="form-wrapper">
                        <input class="form-control"
                               id="email" name="email"
                               type="email" pattern="^(.+)@(.+)$"
                               placeholder="<fmt:message key="signUp.emailAddress"/>"
                               required>
                        <i class="zmdi zmdi-email"></i>
                    </div>

                    <div class="form-wrapper">
                        <input class="form-control"
                               id="password" name="password"
                               type="password" pattern="^[a-zA-ZА-Яа-я0-9_\.]{4,30}$"
                               placeholder="<fmt:message key="signUp.password"/>"
                               required>
                        <i class="zmdi zmdi-lock-outline"></i>
                    </div>

                    <div class="form-wrapper">
                        <input class="form-control"
                               id="confirmedPassword" name="confirmedPassword"
                               type="password" pattern="^[a-zA-ZА-Яа-я0-9_\.]{4,30}$"
                               placeholder="<fmt:message key="signUp.confirmPassword"/>"
                               required>
                        <i class="zmdi zmdi-lock-outline"></i>
                    </div>

                    <button class="joinButton">
                        <fmt:message key="signUp.joinUs"/>
                        <i class="zmdi zmdi-long-arrow-right"></i>
                        <input type="hidden" name="command" value="sign_up"/>
                    </button>

                </form>
            </div>
        </div>
    </body>
    <c:import url="/WEB-INF/jsp/parts/loader.html"/>
    <c:import url="/WEB-INF/jsp/parts/scripts.html"/>
    <script src="resources/sign-up-page/jquery.maskedinput/jquery.maskedinput.js"></script>
    <script>
        $('document').ready(function () {
            $("#phoneNumber").mask("+999-(99)-999-99-99");
        });
    </script>

</html>
