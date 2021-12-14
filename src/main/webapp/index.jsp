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
            <h1 class="mt-5">Click a picture to submit a report</h1>

            <c:forEach var="game" items="${games}">
                <input type="image" onclick="ReportGame('${game.id}', '${game.gameURL}', '${game.name}', '${game.description}')" src="${game.gameURL}" class="btImg" alt="">

                <div id="id04" class="modal">
                    <span onclick="document.getElementById('id04').style.display='none'" class="close" title="Close Modal">×</span>

                    <form class="modal-content">

                        <h1 id="modelHeaderGameDisplay">View Information - Add Report</h1>

                        <div id = "leftbox">
                            <table width="100%">
                                <tr>
                                    <td id="gameInfoID">
                                    </td>
                                    <td rowspan="2">
                                        <img id="gameURL" src="" alt="">
                                    </td>
                                </tr>
                                <tr>
                                    <td id="gameName">
                                    </td>
                                </tr>
                            </table>
                            <p id="gameDescription"></p>

                            <table class="center">
                                <tr>
                                    <td class="apiInformation">Cheapest Price: 17,49$</td>
                                </tr>
                                <tr>
                                    <td class="apiInformation">Developer: Mojang</td>
                                </tr>
                                <tr>
                                    <td class="apiInformation">Name: Minecraft</td>
                                </tr>
                                <tr>
                                    <td class="apiInformation">Seller: google.com</td>
                                </tr>
                            </table>
                        </div>

                        <div id = "middlebox">
                            <table class="center">
                                <thead class="thead-dark">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">First</th>
                                    <th scope="col">Last</th>
                                    <th scope="col">Handle</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>

                        <div id = "rightbox">
                            <form>
                                <div class="form-group">
                                    <label for="addReportHoursPlayed"><h3>Hours Played</h3></label>
                                    <input type="text" class="form-control" placeholder="Hours Played" id="addReportHoursPlayed"><br>
                                    <label for="addReportOpinion"><h3>Opinion</h3></label>
                                    <textarea class="form-control" id="addReportOpinion" rows="2"></textarea>
                                    <button type="submit" class="btn btn-primary" onclick="ReportGame()"  id="addReportButton">Add Report</button>
                                </div>
                            </form>
                        </div>
                        <button type="button" onclick="document.getElementById('id04').style.display='none'" class="cancel">Cancel</button>
                    </form>
                </div>
            </c:forEach>

        </main>
    </c:otherwise>
</c:choose>
</body>
</html>

