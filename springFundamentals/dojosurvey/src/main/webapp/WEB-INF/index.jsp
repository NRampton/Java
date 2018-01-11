<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>We'd like to know a little bit about you for our files...</title>
</head>
<body>
    <div id="wrapper">
        <form action="/submit" method="POST">
            <label>Your Name: <input type="text" name="name"></label><br>
            <label>Dojo Location: <input type="text" name="location"></label><br>
            <label>Favorite Language: <select name="language">
                <option value="python">Python</option>
                <option value="java">Java</option>
                <option value="javaScript">JavaScript</option>
                <option value="profanity">Profanity</option>
            </select></label><br>
            <label>Comment (optional): <textarea name="comment" cols="30" rows="3"></textarea></label><br>
            <button type="submit">Button</button>
        </form>
    </div>
</body>
</html>