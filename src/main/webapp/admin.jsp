<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<%@include file="Navbar.jsp"%>

<html>
<body>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Picture</th>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Description</th>
        <th scope="col">
            <button onclick="AddGame()" id="btn03"><i class="material-icons">add</i></button>
            <div id="id03" class="modal">
                <span onclick="document.getElementById('id03').style.display='none'" class="close" title="Close Modal">×</span>
                <form class="modal-content" action="adminFunctions">
                    <div class="container">
                        <h1>Add Record</h1>
                        <div class="form-group">
                            <label for="gameURl">Picture URL</label>
                            <input type="text" class="form-control" id="gameURl" name="gameURl" aria-describedby="URL" placeholder="Enter URL">
                        </div>
                        <div class="form-group">
                            <label for="gameName">Name</label>
                            <input type="text" class="form-control" id="gameName" name="gameName" aria-describedby="Name" placeholder="Enter Name">
                        </div>
                        <div class="form-group">
                            <label for="description">Add Description</label>
                            <textarea class="form-control" rows="2" id="description" name="description" aria-describedby="Description" placeholder="Enter Description"></textarea>
                        </div>
                        <div class="clearfix">
                            <button type="button" onclick="document.getElementById('id03').style.display='none'" class="cancelbtn">Cancel</button>
                            <button type="submit" name="submit" class="addbtn" value="addGame">Add Game</button>
                        </div>
                    </div>
                </form>
            </div>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="game" items="${games}">
        <tr class="table-active">
            <td><img class="rounded float-left" src="${game.gameURL}"/></td>
            <td>${game.id}</td>
            <td>${game.name}</td>
            <td id="adminGameDescription">${game.description}</td>
            <td>
                <button onclick="EditGame('${game.id}', '${game.gameURL}', '${game.name}', '${game.description}')" id="btn01"><i class="material-icons">edit</i></button>
                <div id="id01" class="modal">
                    <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">×</span>
                    <form class="modal-content" action="adminFunctions">
                        <div class="container">
                            <h1 id="editGameID">Edit information</h1>
                            <div class="form-group">
                                <label for="updateURl">Picture URL</label>
                                <input type="text" class="form-control" id="updateURl" name="updateURl" aria-describedby="URL" placeholder="Enter URL">
                            </div>
                            <div class="form-group">
                                <label for="updateName">Game Name</label>
                                <input type="text" class="form-control" id="updateName" name="updateName" aria-describedby="Name" placeholder="Enter Name">
                            </div>
                            <div class="form-group">
                                <label for="updateDescription">Game Description</label>
                                <textarea class="form-control" rows="2" id="updateDescription" name="updateDescription" aria-describedby="Description" placeholder="Enter Description"></textarea>
                            </div>
                            <div class="clearfix">
                                <input type="hidden" class="form-control padding" id="updateID" name="updateID" value="${game.id}" aria-describedby="URL">
                                <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
                                <button type="submit" name="submit" class="updatebtn" value="update">Update Game</button>
                            </div>
                        </div>
                    </form>
                </div>
                <button onclick="AreYouSure(${game.id})" id="btn02"><i class="material-icons">delete</i></button>
                <div id="id02" class="modal">
                    <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">×</span>
                    <form class="modal-content" action="adminFunctions">
                        <div class="container">
                            <h1>Delete Account</h1>
                            <p id="delquestion">Are you sure you want to delete id </p>
                            <div class="center">
                                <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
                                <input type="hidden" class="form-control" id="deleteID" value="${game.id}" name="deleteID" aria-describedby="ID">
                                <button type="submit" class="deletebtn" name="submit" value="deleteRecord">delete</button>
                            </div>
                        </div>
                    </form>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">User Name</th>
        <th scope="col">Name</th>
        <th scope="col">Email Verified</th>
        <th scope="col">roleName</th>
        <th scope="col">Change Role</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr class="table-active">
            <td>${user.userName}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <c:forEach var="role" items="${user.roles}">
                <td>${role.roleName}</td>
            <form action="adminFunctions">
                <div class="form-group">
                    <td>
                        <label>
                            <select class="form-select form-select-lg mb-3" name="newRole">
                                <option value="admin" name="userRole">Admin</option>
                                <option selected value="user" name="userRole">User</option>
                            </select>
                        </label>
                        <input type="hidden" id="userID" value="${user.user_id}" name="userID">
                        <button type="submit" name="submit" value="updateUser">Update User</button>
                    </td>
                </div>
            </form>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>