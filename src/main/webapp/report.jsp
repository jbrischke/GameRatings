<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<%@include file="Navbar.jsp"%>
<html>
    <body>

        <div id = "leftbox">
            <table width="100%">
                <tr>
                    <td id="gameName">${games.name}</td>
                    <td rowspan="2"><img id="gameURL" src="${games.gameURL}" alt=""></td>
                </tr>

            </table>

            <p id="gameDescription">${games.description}</p>

            <table class="center">
                <tr>
                    <td class="apiInformation">Cheapest Price: 17.99$ ${price.currentLowestPrice}</td>
                </tr>
                <tr>
                    <td class="apiInformation">Currency: USD ${price.currency}</td>
                </tr>
                <tr>
                    <td class="apiInformation">Developer: Mojang ${price.developer}</td>
                </tr>
                <tr>
                    <td class="apiInformation">Name: Minecraft ${price.name}</td>
                </tr>
                <tr>
                    <td class="apiInformation">Release Date: 5/20/1994 ${price.releaseDate}</td>
                </tr>
            </table>
        </div>

        <div id="middlebox">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Hours Played</th>
                        <th scope="col">Opinion</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="report" items="${games.reports}">
                        <tr>
                            <td>${report.hoursPlayed}</td>
                            <td>${report.description}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div id = "rightbox">
            <form action="AddReport">
                    <label for="addReportHoursPlayed"><h3>Hours Played</h3></label>
                    <input type="text" class="form-control" placeholder="Hours Played" name="addReportHoursPlayed" id="addReportHoursPlayed"><br>
                    <label for="addReportOpinion"><h3>Opinion</h3></label>
                    <textarea class="form-control" id="addReportOpinion"  name="addReportOpinion"></textarea>
                    <input type="hidden" id="inReportID" name="inReportID" value="${games.id}">
                    <input type="hidden" name="gameName" value="${games.name}">
                <button type="submit" name="submit" class="btn btn-primary" value="Report">Add Report</button>
            </form>
        </div>

    </body>
</html>