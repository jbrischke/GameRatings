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

<form action="adminFunctions" class="form-inline">
    <div class="form-group">
        <label for="gameURl">Picture URl</label>
        <input type="text"
               class="form-control"
               id="gameURl"
               name="gameURl"
               aria-describedby="URL"
               placeholder="Enter URl">
        <label for="description">Description</label>
        <input type="text"
               class="form-control"
               id="description"
               name="description"
               aria-describedby="Description"
               placeholder="Enter Description">
    </div>
    <button type="submit" name="submit" value="addGame" class="btn btn-primary">Insert Game</button>
    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View all Games</button>
</form>


<form action="adminFunctions" class="form-inline">
    <div class="form-group">
        <label for="deleteID">Game ID</label>
        <input type="text"
               class="form-control"
               id="deleteID"
               name="deleteID"
               aria-describedby="ID"
               placeholder="Enter URl">
    </div>
    <button type="submit" name="submit" value="deleteRecord" class="btn btn-primary">View all Games</button>
</form>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="gameTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Link</th>
        <th>Description</th>
        </thead>
        <tbody>
        <c:forEach var="game" items="${games}">
            <tr>
                <td>${game.id}</td>
                <td>${game.gameURL}</td>
                <td>${game.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>