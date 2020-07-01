<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="il8n.content"/>

<!DOCTYPE html>
<html lang="${locale}">
    <head>
        <title><fmt:message key="error.title"/></title>
        <c:import url="/WEB-INF/jsp/parts/meta.html"/>
        <c:import url="/WEB-INF/jsp/parts/links.html"/>
    </head>

    <body style="background-image:url(resources/images/error.jpg); background-size: cover">
        <div class="container">
            <div class="align-items-center">
                <div class="column">
                    <p>
                    <h2 style="text-align: center">
                        <fmt:message key="error.anErrorHasOccurred"/>
                    </h2>
                    <h2 style="text-align: center;">
                        <a style="color: #000" href="controller?command=show_home_page">
                            <fmt:message key="error.backHome"/>
                        </a>
                    </h2>
                    <p>
                </div>
            </div>
        </div>
    </body>
    <c:import url="/WEB-INF/jsp/parts/loader.html"/>
    <c:import url="/WEB-INF/jsp/parts/scripts.html"/>
</html>