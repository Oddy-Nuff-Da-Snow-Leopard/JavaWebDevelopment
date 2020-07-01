<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="il8n.content"/>

<!DOCTYPE html>
<html lang="${locale}">
    <head>
        <title><fmt:message key="signIn.title"/></title>
        <c:import url="/WEB-INF/jsp/parts/meta.html"/>
        <c:import url="/WEB-INF/jsp/parts/links.html"/>

        <link rel="stylesheet"
              href="resources/sign-in-page/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" href="resources/sign-in-page/css/style.css">
    </head>

    <body>
        <c:import url="/WEB-INF/jsp/parts/header.jsp"/>

        <div class="wrapper"
             style="background-image: url('resources/sign-in-page/images/bg-signIn.jpg');">

            <div class="inner">

                <div class="ftco-animate">
                    <c:if test="${sessionScope.signInPageMessage!=null}">
                        <div class="alert-holder alert alert-danger alert-dismissible fade show" role="alert">
                            <fmt:message key="${sessionScope.signInPageMessage}"/>
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <c:remove var="signInPageMessage"/>
                    </c:if>
                </div>

                <form action="controller" method="post">

                    <h3><fmt:message key="signIn.signIn"/></h3>

                    <div class="form-wrapper">
                        <input class="form-control"
                               id="email" name="email"
                               type="email" pattern="^(.+)@(.+)$"
                               placeholder="<fmt:message key="signIn.email"/>" required>
                        <i class="zmdi zmdi-email"></i>
                    </div>

                    <div class="form-wrapper">
                        <input class="form-control"
                               id="password" name="password"
                               type="password" pattern="^[a-zA-ZА-Яа-я0-9_\.]{4,30}$"
                               placeholder="<fmt:message key="signIn.password"/>"
                               required>
                        <i class="zmdi zmdi-lock-outline"></i>
                    </div>

                    <div class="forgot-wrapper">
                        <a href="#">
                            <fmt:message key="signIn.forgotPassword"/>
                        </a>
                    </div>

                    <div class="form-group">
                        <input class="agree-term"
                               id="remember-me" name="remember-me" 
                               type="checkbox"/>
                        <label for="remember-me" class="label-agree-term">
                            <span></span>
                            <fmt:message key="signIn.rememberMe"/>
                        </label>
                    </div>

                    <button>
                        <fmt:message key="signIn.logIn"/>
                        <i class="zmdi zmdi-long-arrow-right"></i>
                    </button>
                    <input type="hidden" name="command" value="sign_in"/>

                    <div class="no-account">
                        <span>
                            <fmt:message key="signIn.dontHaveAnAccount"/>
                        </span>
                        <a href="controller?command=show_sign_up_page">
                            <fmt:message key="signIn.signUpNow"/>
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </body>
    <c:import url="/WEB-INF/jsp/parts/loader.html"/>
    <c:import url="/WEB-INF/jsp/parts/scripts.html"/>
</html>
