<%@ page import="java.util.ArrayList" %>
<%@ page import="tools.Result" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .content{
        margin-top: 50px;
    }
    .inputs{
        width: 50%;
        float: left;
        padding-top: 50px;
    }
    .wrapper{
        margin: auto;
        width: 980px;
    }
    .area{
        width: 50%;
        float: right;
        padding: auto;
        text-align: center;
    }
    .area::before{
        content: "Area:";
        display: block;
    }
    header>p{
        font-family: sans-serif;
        width: 300px;
        padding: 5px;
        text-align: center;
        margin: auto;
        color: #004dff;

    }
    form{
        font-family: sans-serif;
    }
    header>p:first-child{
        font-size: 25px !important;
    }
    header>p:nth-child(2){
        font-size: 20px;
    }
    header>p:nth-child(3){
        font-size: 18px;
    }
    form>p>input,button,select{
        margin-left: 10px;
    }
    form>p>button{
        width: 30px;
        height: 30px;
    }
</style>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <title>ПИП Лаба №8</title>
</head>
<body>
<script>
    <%@include file="scripts.js"%>
</script>
<div class="wrapper">
    <header>
        <p>Трофимлва Анастасия Михайловна</p>
        <p>Группа P3202</p>
        <p>Вариант 228</p>
    </header>
    <div class="content">
        <p><strong><%
            if (session.getAttribute("success") != null) {%>
            <%=session.getAttribute("success")%>
            <%}%>
        </strong></p>
        <div class="inputs">
            <form method="GET" action="/lab8/main">
            <p id="rad">Select X:
                                <button type="button" name="XSelector" class="chb" onclick="xSelected(this)" value="1">1</button>
                                <button type="button" name="XSelector" class="chb" onclick="xSelected(this)" value="2">2</button>
                                <button type="button" name="XSelector" class="chb" onclick="xSelected(this)" value="3">3</button>
                                <button type="button" name="XSelector" class="chb" onclick="xSelected(this)" value="4">4</button>
                                <button type="button" name="XSelector" class="chb" onclick="xSelected(this)" value="5">5</button>
            </p>
            <p>Y value {-5..5}:
                    <input type="text" id="textY" name="Y" placeholder="-5..5" onchange="validateForm()" onkeydown="javascript:if(13==event.keyCode){return false;}" required>
            </p>
                <p id="rad">Select R:
                    <select size="5" submit>
                        <option value="1" name="RSelector" class="radBtn">1</option>
                        <option value="1.5" name="RSelector" class="radBtn">1.5</option>
                        <option value="2" name="RSelector" class="radBtn">2</option>
                        <option value="2.5" name="RSelector" class="radBtn">2.5</option>
                        <option value="3" name="RSelector" class="radBtn">3</option>
                    </select>
                </p>
                <input type="hidden" id="hiddenR" name="RSelector"></input>
                <button type="submit" id="ok" disabled="true">OK</button>
            </form>
        </div>
        <div class="area">
            <p><img name='img' src='http://savepic.ru/9612611.png' id="graph" style="position: relative;"/></p>
        </div>
        <table border="1" style="border-color: blue">
            <caption>Result table</caption>
            <tr>
                <td>X</td>
                <td>Y</td>
                <td>R</td>
                <td>Contain</td>
            </tr>
            <%
                ArrayList<Result> res = (ArrayList) session.getAttribute("results");
                if (res != null) {
                    for (int i = 0; i < res.size(); i++) {
            %>
            <tr>
                <td>
                    <%= res.get(i).x %>
                </td>
                <td>
                    <%= res.get(i).y %>
                </td>
                <td>
                    <%= res.get(i).r %>
                </td>
                <td>
                    <%= res.get(i).inArea %>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </div>
</div>
</body>
</html>