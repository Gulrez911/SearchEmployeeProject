<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">


        <title>User Login.</title>
        <style>
            * {
                box-sizing: border-box;
            }
            body {
                margin: 0;
                font-family: Arial;
                font-size: 17px;
            }
            #myVideo {
                position: fixed;
                right: 0;
                bottom: 0;
                min-width: 100%;
                min-height: 100%;
            }
            .content {
                position: fixed;
                bottom: 50%;
                background: rgba(0, 0, 0, 0.5);
                color: #f1f1f1;
                width: 100%;
                padding: 20px;
            }
            #myBtn {
                width: 200px;
                font-size: 18px;
                padding: 10px;
                border: none;
                background: #000;
                color: #fff;
                cursor: pointer;
            }
            #myBtn:hover {
                background: #ddd;
                color: black;
            }
        </style>
    </head>
    <body>
        <video autoplay muted loop id="myVideo">
            <source src="<%=request.getContextPath()%>/resources/images/vid.mp4"
                    type="video/mp4">
            <!-- Your browser does not support HTML5 video.eeeve -->
        </video>
        <div class="content">
            <form:form action="authenticate" method="post" commandName="employee">
                <table align="center">
                    <tr>
                        <td style="color: white">User Name:</td>
                        <td><form:input name="email" path="email" type="email" id="nm" /></td>
                    </tr>
                    <tr>
                        <td style="color: white">Password:</td>
                        <td><form:input name="password" path="password" type="password"
                                    id="pw" /></td>
                    </tr>
                    <tr>
                        <td><form:select path="category" name="userType">

                                <form:options items="${userTypes}" />

                            </form:select></td>

                        <td colspan="2" align="right"><input type="submit"
                                                             value="LOGIN" id="bt"></td>
                    </tr>

                </table>
                <div style="color: red">${error}</div> 
            </form:form>
        </div> 



        <div class="content1">

            <button id="myBtn" onclick="myFunction()">Pause</button>
        </div>

        <script>
            var video = document.getElementById("myVideo");
            var btn = document.getElementById("myBtn");
            function myFunction() {
                if (video.paused) {
                    video.play();
                    btn.innerHTML = "Pause";
                } else {
                    video.pause();
                    btn.innerHTML = "Play";
                }
            }
        </script>

        <!-- /* #nm {
        background-image: url('/WEB-INF/images/un.png');
        background-repeat: no-repeat;
        background-position: left;
        background-size: 25px;
        border-radius: 25px
}
#bt {
        /*  border: 1px solid;
    padding: 10px;
    box-shadow: 3px 4px; */
        border-radius: 25px
}
#pw {
        border-radius: 25px
}
#slt items:hover select {
        display: block;
        border-radius: 10px
}
#lbl {
        font-weight: bold;
}
#fm {
        -->
        <!-- 	} */ -->

        <%-- <body	background="<%=request.getContextPath()%>/resources/images/india-wallpaper.jpg">
        --%>

        <!-- <fieldset
                style="width: 500px; margin: 50px auto; padding: 5px; box-shadow: 5px 7px">
                <legend>
                        <h1 style="color: white; text-align: center;">Login</h1>
                </legend> -->



        <!-- 	</fieldset> -->



    </body>
</html>