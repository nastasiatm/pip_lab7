<%@ page import="java.util.ArrayList" %>
<%@ page import="tools.Result" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
      #head {
        font: 150% serif;
        background: #F1AD2E;
        text-align: center;
      }
      #head:hover {
        color: #B83129;
      }
      .radius {
        border: 1px solid black;
        padding: 15px;
        margin-bottom: 10px;
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
        content: \Graph:\;
        display: block;
      }
      form{
        font-family: serif;
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
    <title>Labwork №8</title>
</head>
<body>
<script>
    function validateForm() {
        var y_val = document.getElementById("textY").value;
        y_val = y_val.replace(",", ".");
        var x_val = document.getElementById("hiddenX").value;
        var y_valid = !((y_val == "") || !(!isNaN(parseFloat(y_val)) && isFinite(y_val)) || (y_val > 5) || (y_val < -3));
        var x_valid = !isNaN(parseFloat(x_val));
        if (y_valid && x_valid) {
            document.getElementById("ok").disabled = false;
            document.getElementById("textY").style.borderColor = "";
            document.getElementById("xSel").style.borderStyle = "";
            document.getElementById("xSel").style.borderWidth = "";
            document.getElementById("xSel").style.borderColor = "";
        } else {
            document.getElementById("ok").disabled = true;
            if (!y_valid) {
                document.getElementById("textY").style.borderColor = "#F1AD2E";
            }
            if (!x_valid) {
                document.getElementById("xSel").style.borderStyle = "solid";
                document.getElementById("xSel").style.borderWidth = "1px";
                document.getElementById("xSel").style.borderColor = "#F1AD2E";
            }
        }
    }

    function xSelected(btn) {
        document.getElementById("hiddenX").value = btn.value;
        var elems = document.getElementsByClassName("xBtn");
        for (var i = 0; i < elems.length; i++) {
            elems[i].style.backgroundColor = "";
        }
        btn.style.backgroundColor = "#FFCC00";
        validateForm();
    }

    $(document).ready(function () {
        document.getElementById("graph").onclick = function (e) {
            var x = e.offsetX == undefined ? e.layerX : e.offsetX - 100;
            var y = e.offsetY == undefined ? e.layerY : e.offsetY;
            if (y <= 100)
                y = 100 - y;
            else
                y = -y + 100;
            var rad = parseFloat(document.getElementById("rad").value);

            if (!isNaN(rad)) {
                var k = rad * 1.25;
                var l = document.img.width / 2;
                y = y * k / l;
                x = x * k / l;
            } else {
                alert("Error! Set R!");
                return;
            }
            window.location = "../Lab8/main?XSelector=" + x + "&YSelector=" + y + "&RSelector=" + rad;
        }
    });
</script>
<div class="wrapper">
    <header id="head" align="center" style="border-radius: 65px 0px" class="radius">
        <p>Трофимова Анастасия Михайловна</p>
        <p>Группа P3202</p>
        <p>Вариант 228</p>
    </header>
    <div class="content">
        <div class="inputs">
            <form method="GET" action="/Lab8/main">
            <p id="xSel">Select X:
                <button type="button" name="XSelector" class="xBtn" onclick="xSelected(this)" value="1">1</button>
                <button type="button" name="XSelector" class="xBtn" onclick="xSelected(this)" value="2">2</button>
                <button type="button" name="XSelector" class="xBtn" onclick="xSelected(this)" value="3">3</button>
                <button type="button" name="XSelector" class="xBtn" onclick="xSelected(this)" value="4">4</button>
                <button type="button" name="XSelector" class="xBtn" onclick="xSelected(this)" value="5">5</button>
            </p>
            <p>Y value {-5..5}:
                            <input type="text" id="textY" name="YSelector" placeholder="-5..5" onchange="validateForm()"
                                onkeydown="javascript:if(13==event.keyCode){return false;}" required>
            </p>
            <p>Select R:
                <select size="3" id="rad" name="RSelector">
                    <option value="1"  selected class="radSel">1</option>
                    <option value="1.5" class="radSel">1.5</option>
                    <option value="2" class="radSel">2</option>
                    <option value="2.5" class="radSel">2.5</option>
                    <option value="3" class="radSel">3</option>
                </select>
            </p>
            <input type="hidden" id="hiddenX" name="XSelector"></input>
            <button type="submit" id="ok" disabled="true">Ok!</button>
            </form>
        </div>
        <div class="area">
            <p><img name='img' src='http://savepic.ru/9582599.png' id="graph" style="position: relative;"/></p>
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
                ArrayList<Result> res = (ArrayList)application.getAttribute("res");
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