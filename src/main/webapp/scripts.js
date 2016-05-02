$(document).ready(function () {
    var $chb = $('input.chb');
    $chb.click(function () {
        $chb.prop('checked', false);
        $(this).prop('checked', true);
    });
});

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
            document.getElementById("textY").style.borderColor = "red";
        }
        if (!x_valid) {
            document.getElementById("xSel").style.borderStyle = "solid";
            document.getElementById("xSel").style.borderWidth = "1px";
            document.getElementById("xSel").style.borderColor = "red";
        }
    }
}

function xSelected(btn) {
    document.getElementById("hiddenX").value = btn.value;
    var elems = document.getElementsByClassName("xBtn");
    for (var i = 0; i < elems.length; i++) {
        elems[i].style.backgroundColor = "";
    }
    btn.style.backgroundColor = "#4CAF50";
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
        var rad = parseFloat(document.getElementById("hiddenX").value);

        if (!isNaN(rad)) {
            var k = rad * 1.25;
            var l = document.img.width / 2;
            y = y * k / l;
            x = x * k / l;
        } else {
            alert("Set R first!");
            return;
        }
        window.location = "../lab8/main?XSelector=" + x + "&YSelector=" + y + "&RSelector=" + rad;
    }
});