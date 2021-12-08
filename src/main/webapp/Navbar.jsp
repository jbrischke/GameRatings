<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <div class="navbar-header">
            </div>
            <ul class="nav navbar-nav justify-content-center">
                <li><a class="navbar-brand" href="index.jsp">Home</a></li>
                <c:forEach var="role" items="${userRole}">
                    <c:if test="${role.roleName=='admin'}">
                        <li><a class="navbar-brand" href="admininitalize">Admin</a></li>
                    </c:if>
                </c:forEach>
                <l1 class="navbar-brand">Logged in as: <c:out value="${sessionScope.user}" /></l1>
                <li><a class="navbar-brand" href="logout">Logout</a></li>
            </ul>
        </div>
    </nav>
</div>