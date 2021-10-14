<%@include file="Navbar.jsp"%>
<%@include file="head.jsp"%>
<html>
<style>
    body {
        background-image: url("images/mUjHF6.jpg");
        background-color: #cccccc;
    }
</style>
<body>
<h2>This page is to test uploading images to my games database</h2>

<form action="searchUser.php">
    <label for="img">Select image:</label>
    <input type="file" id="img" name="img" accept="image/*">
    <input type="submit">
</form>

</body>
</html>