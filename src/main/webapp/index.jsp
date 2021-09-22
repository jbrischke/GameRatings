<%@include file="head.jsp"%>
<html>
<%@include file="Navbar.jsp"%>

<style>
    body {
        background-image: url("images/mUjHF6.jpg");
        background-color: #cccccc;
    }
</style>

<body>

    <h2>User Display Exercise</h2>
    <form action="searchUser">
        <label for="searchTerm">Search</label>
        <input type="text" id="searchTerm" name="searchTerm">
        <button type="submit" class="btn btn-primary" name="submit" value="search">search</button>
        <button type="submit" class="btn btn-primary" name="submit" value="viewAll">view all users</button>
    </form>

    <a href="login.jsp">login</a>

</html>