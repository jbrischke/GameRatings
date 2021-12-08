<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<html>
<body>

<c:choose>
    <c:when test="${empty sessionScope.user}">
        <c:set var="user" value="${userName.userName}" scope="session" />
        <c:set var="userRole" value="${userName.roles}" scope="session" />
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${empty sessionScope.user}">
        <main role="main" class="container">
            <h1 class="mt-5">RatingsAnonymous</h1>
            <p class="lead">Login and you will be able to interact with any Game on record and submit reports for any selected Game</p>
            <p><a href="logIn" class="btn btn-danger" role="button">Log in</a></p>
        </main>
        <footer class="footer">
            <div class="container">
                <h2 class=".text-dark">Thank you for checking out the site</h2>
            </div>
        </footer>
    </c:when>
    <c:otherwise>
        <%@include file="Navbar.jsp"%>
        <main role="main" class="container">
            <h1 class="mt-5">RatingsAnonymous</h1>
            <h2 class=".text-dark">Thank you for logging in <c:out value="${sessionScope.user}" /></h2>
        </main>
    </c:otherwise>
</c:choose>
</body>
</html>

