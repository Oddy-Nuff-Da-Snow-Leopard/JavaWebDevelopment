<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale"
       value="${not empty param.locale
                ? param.locale
                : not empty locale ? locale : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="il8n.content"/>

<style>
    #language{
        vertical-align: middle;
        padding: 0;
        margin: 0;
        width: 22px;
        height: 22px;
        text-indent: 100%;
        border: 0;
        cursor: pointer;
        background-repeat: no-repeat;
    }
</style>

<div class="py-1 bg-black top">
    <div class="container">
        <div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
            <div class="col-lg-12 d-block">
                <div class="row d-flex">
                    <div class="col-md pr-4 d-flex topper align-items-center">
                        <form method="post" action="controller?command=change_locale">
                            <span class="text">Language: </span>
                            <input id="language" name="locale" type="submit" value="en_EN"
                                   style="background: url(resources/icons/english-flag.png) center"/>
                            <input id="language" name="locale" type="submit" value="ru_RU"
                                   style="background: url(resources/icons/russian-flag.png) center"/>
                        </form>
                    </div>
                    <div class="col-md pr-4 d-flex topper align-items-center">
                        <div class="icon mr-2 d-flex justify-content-center align-items-center">
                            <span class="icon-phone2"></span>
                        </div>
                        <span class="text">+ 375-33-632-24-01</span>
                    </div>
                    <div class="col-md pr-4 d-flex topper align-items-center">
                        <div class="icon mr-2 d-flex justify-content-center align-items-center">
                            <span class="icon-paper-plane"></span>
                        </div>
                        <span class="text">appetizer@gmail.com</span>
                    </div>
                    <div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right justify-content-end">
                        <p class="mb-0 register-link">
                            <span>
                                <fmt:message key="header.top.openDays"/>:
                            </span>
                            <span>
                                <fmt:message key="header.top.monday"/> - <fmt:message key="header.top.sunday"/>
                            </span>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="controller?command=show_home_page">Appetizer</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> 
            <fmt:message key="header.nav.menu"/>
        </button>
        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">

                <li class="nav-item active">
                    <a href="controller?command=show_home_page" class="nav-link">
                        <fmt:message key="header.nav.home"/>
                    </a>
                </li>

                <li class="nav-item">
                    <a href="controller?command=show_about_page" class="nav-link">
                        <fmt:message key="header.nav.about"/>
                    </a>
                </li>

                <li class="nav-item">
                    <a href="controller?command=show_menu_page" class="nav-link">
                        <fmt:message key="header.nav.menu"/>
                    </a>
                </li>

                <c:if test="${sessionScope.user == null}">
                    <li class="nav-item">
                        <a href="controller?command=show_sign_in_page" class="nav-link">
                            <fmt:message key="header.nav.signIn"/>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="controller?command=show_sign_up_page" class="nav-link">
                            <fmt:message key="header.nav.signUp"/>
                        </a>
                    </li>
                </c:if>

                <c:if test="${user != null}">
                    <li class="nav-item">
                        <a href="controller?command=show_personal_cabinet_page" class="nav-link">
                            <fmt:message key="header.nav.personalCabinet"/>
                        </a>
                    </li>
                </c:if>

                <c:if test="${user != null}">
                    <li class="nav-item" >
                        <a href="controller?command=logout" class="nav-link">
                            <fmt:message key="header.nav.logout"/>
                        </a>
                    </li>
                </c:if>

                <c:if test="${user.roleId == 2}">
                    <li class="nav-item">
                        <a href="controller?command=show_cart_page" class="nav-link">
                            <fmt:message key="header.nav.myCart"/>
                            <span
                                class="icon icon-shopping_cart">
                            </span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>


