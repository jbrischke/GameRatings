<%@include file="Navbar.jsp"%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#gameTable').DataTable();
    } );
</script>
<html>
<body>

<div class="container">
    <form action="adminFunctions" class="form-inline">
        <div class="form-group">
            <input type="text" class="form-control" id="gameURl" name="gameURl" aria-describedby="URL" placeholder="Enter URl">
            <textarea class="form-control" rows="2" id="description" name="description" aria-describedby="Description" placeholder="Enter Description"></textarea>
        </div>
        <button type="submit" name="submit" value="addGame" class="btn btn-primary p-3">Insert Game</button>
    </form>


    <form action="adminFunctions" class="form-inline">
        <div class="form-group">
            <input type="text" class="form-control" id="deleteID" name="deleteID" aria-describedby="ID" placeholder="Enter ID">
        </div>
        <button type="submit" name="submit" value="deleteRecord" class="btn btn-primary">Delete Game</button>
    </form>

    <form action="adminFunctions" class="form-inline">
        <div class="form-group">
            <input type="text" class="form-control" id="updateID" name="updateID" aria-describedby="URL" placeholder="Enter ID">
            <input type="text" class="form-control" id="updateURl" name="updateURl" aria-describedby="URL" placeholder="Enter URl">
            <textarea class="form-control" rows="2" id="updateDescription" name="updateDescription" aria-describedby="Description" placeholder="Enter Description"></textarea>
        </div>
        <button type="submit" name="submit" value="update" class="btn btn-primary p-3">Update Game</button>
    </form>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">Picture</th>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
            </tr>
        </thead>
        <tbody>
                <c:forEach var="game" items="${games}">
                    <tr>
                        <td><img src="${game.gameURL}" width="100" height="200" class="column"/></td>
                        <td>${game.id}</td>
                        <td>Name</td>
                        <td id="descriptionCSS">${game.description}</td>
                    </tr>
                </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>