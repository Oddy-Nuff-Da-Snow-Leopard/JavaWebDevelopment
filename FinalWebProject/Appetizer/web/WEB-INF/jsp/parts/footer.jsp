<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="il8n.content"/>

<!-- FOOTER -->
<footer class="ftco-footer ftco-bg-dark ftco-section">

    <div class="container-fluid px-md-5 px-3">
        <div class="row mb-5">

            <div class="col-md-6 col-lg-3">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Appetizer</h2>
                    <p><fmt:message key="footer.description"/></p>
                    <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-3">
                        <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                    </ul>
                </div>
            </div>

            <div class="col-md-6 col-lg-3">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2"><fmt:message key="footer.openHours"/></h2>
                    <ul class="list-unstyled open-hours">
                        <li class="d-flex">
                            <span><fmt:message key="footer.monday"/></span><span>9:00 - 24:00</span>
                        </li>
                        <li class="d-flex">
                            <span><fmt:message key="footer.tuesday"/></span><span>9:00 - 24:00</span>
                        </li>
                        <li class="d-flex">
                            <span><fmt:message key="footer.wednesday"/></span><span>9:00 - 24:00</span>
                        </li>
                        <li class="d-flex">
                            <span><fmt:message key="footer.thursday"/></span><span>9:00 - 24:00</span>
                        </li>
                        <li class="d-flex">
                            <span><fmt:message key="footer.friday"/></span><span>9:00 - 02:00</span>
                        </li>
                        <li class="d-flex">
                            <span><fmt:message key="footer.saturday"/></span><span>9:00 - 02:00</span>
                        </li>
                        <li class="d-flex">
                            <span><fmt:message key="footer.sunday"/></span><span> 9:00 - 02:00</span>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="col-md-6 col-lg-3">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2"><fmt:message key="footer.contactInformation"/></h2>
                    <p><fmt:message key="footer.phone"/>: + 375-33-632-24-01 <br>
                        <fmt:message key="footer.email"/>: <a href="mailto:appetizer@gmail.com">appetizer@gmail.com</a></p>
                </div>
            </div>

            <div class="col-md-6 col-lg-3">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2"><fmt:message key="footer.newsletter"/></h2>
                    <p><fmt:message key="footer.newsletter.description"/></p>
                    <form action="#" class="subscribe-form">
                        <div class="form-group">
                            <input type="text" class="form-control mb-2 text-center" placeholder="<fmt:message key="footer.newsletter.enterEmail"/>">
                            <input type="submit" value="<fmt:message key="footer.newsletter.subscribe"/>" class="form-control submit px-3">
                        </div>
                    </form>
                </div>
            </div>

        </div>

        <div class="row">
            <div class="col-md-12 text-center">
                <p>
                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> 
                    All rights reserved | Powered by <a href="https://vk.com/styrofoam">Styrofoam</a>
                </p>
            </div>
        </div>

    </div>
</footer>