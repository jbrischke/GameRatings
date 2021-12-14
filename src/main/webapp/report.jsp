<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<%@include file="Navbar.jsp"%>

<html>
    <body>

        <div id = "leftbox">
            <table width="100%">
                    <tr>
                        <td rowspan="2">
                            <img id="gameURL" src="${games.gameURL}" alt="">
                        </td>
                    </tr>
                    <tr>
                        <td id="gameName">${games.name}</td>
                    </tr>
                    <p id="gameDescription">${games.description}</p>
            </table>

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

    </body>
</html>