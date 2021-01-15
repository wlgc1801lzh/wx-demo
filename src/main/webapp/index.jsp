<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>微信登录</title>
    <style>
        #userinfo {
            text-align: center;
        }

        #userinfo #avatar {
            display: block;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <div id="userinfo">
        <img id="avatar" src="${avatar}">
        <h4>${nickname}</h4>
        <p>${province}</p>
        <p>${city}</p>
        <p>${openid}</p>
    </div>
</body>
</html>