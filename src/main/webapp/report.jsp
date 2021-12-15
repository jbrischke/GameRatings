<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<%@include file="Navbar.jsp"%>
<html>
    <body>

        <div id = "leftbox">
            <div id="wrapperDiv">
                <div id="gameName" style="width:50%;padding:50px;float:left">${games.name}</div>
                <div id="div2" style="width:50%;padding:50px;float:right"><img id="gameURL" src="${games.gameURL}" alt=""></div>
            </div>


            <p id="gameDescription">${games.description}</p>

            <p class="apiInformation">Cheapest Price: ${price.currentLowestPrice}</p>
            <p class="apiInformation">Currency: ${price.currency}</p>
            <p class="apiInformation">Developer: ${price.developer}</p>
            <p class="apiInformation">Name: ${price.name}</p>
            <p class="apiInformation">Release Date: ${price.releaseDate}</p>

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