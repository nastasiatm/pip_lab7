/**
 * Created by nasta_000 on 03.04.2016.
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

    public class WebFormServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            out.print("<!DOCTYPE html>\n" +
            "<html lang = \"en\">\n" +
            "<head>\n" +
                    "<meta charset=\"UTF-8\"> \n" +
                    "<title>Labwork №7</title>\n" +
                    "<style>\n" +
                    ".content{\n" +
                    "margin-top: 50px;\n" +
                    "}\n" +
                    ".inputs{\n" +
                    "width: 50%;\n" +
                    "float: left;\n" +
                    "padding-top: 50px;\n" +
                    "}n" +
                    ".wrapper{\n" +
                    "margin: auto;\n" +
                    "width: 980px;\n" +
                    "}\n" +
                    ".area{\n" +
                    "width: 50%;\n" +
                    "float: right;\n" +
                    "padding: auto;\n" +
                    "text-align: center;\n" +
                    "}\n" +
                    ".area::before{\n" +
                    "content: \"Область:\";\n" +
                    "display: block;\n" +
                    "}\n" +
                    "header>p{\n" +
                    "font-family: sans-serif;\n" +
                    "width: 300px;\n" +
                    "padding: 5px;\n" +
                    "text-align: center;\n" +
                    "margin: auto;\n" +
                    "color: #004dff;\n" +

                    "}\n" +
                    "form{\n" +
                    "font-family: serif;\n" +
                    "}\n" +
                    "form>p>input,button,select{\n" +
                    "margin-left: 10px;\n" +
                    "}\n" +
                    "form>p>button{\n" +
                    "width: 30px;\n" +
                    "height: 30px;\n" +
                    "}\n" +
                    ".radius {\n" +
                    "border: 1px solid black;\n" +
                    "padding: 15px;\n" +
                    "margin-bottom: 10px;\n" +
                    "}\n" +
                    "#head {\n" +
                    "font: 150% serif;\n" +
                    "background: #F1AD2E;\n" +
                    "}\n" +
                    "</style>\n"+
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"wrapper\">\n" +
                    "<header id=\"head\" align= \"center\" style=\"border-radius: 65px 0px\" class=\"radius\">\n" +
                    "<font>\n" +
                    "Трофимова Анастасия Михайловна<Br>\n" +
                    "Группа P3202<Br>\n" +
                    "Вариант 218\n" +
                    "</font>\n" +
                    "</header>\n" +
                    "<div class=\"content\">\n" +
                    "<div class=\"inputs\">\n" +
                    "<form method=\"GET\" id=\"forma\" action=\"/Lab7/main\">\n" +
                    "<p>R:\n" +
                    "<input type=\"radio\" name=\"R\" value=\"1\">1\n" +
                    "<input type=\"radio\" name=\"R\" value=\"2\">2\n" +
                    "<input type=\"radio\" name=\"R\" value=\"3\">3\n" +
                    "<input type=\"radio\" name=\"R\" value=\"3\">4\n" +
                    "<input type=\"radio\" name=\"R\" value=\"5\">5\n" +
                    "</p>\n" +
                    "<p>Y:\n" +
                    "<input type=\"text\" id=\"textY\" name=\"Y\" placeholder=\"-5..5\" onchange=\"validateForm()\" onkeydown=\"javascript:if(13==event.keyCode){return false;}\" required>\n" +
            "</p>\n" +
            "<p>X:\n" +
            "<input class=\"txt1\" id=\"idX\" type=\"submit\" name=\"X\" value=\"1\">\n" +
            "<input class=\"txt1\" id=\"idX\" type=\"submit\" name=\"X\" value=\"2\">\n" +
            "<input class=\"txt1\" id=\"idX\" type=\"submit\" name=\"X\" value=\"3\">\n" +
            "<input class=\"txt1\" id=\"idX\" type=\"submit\" name=\"X\" value=\"4\">\n" +
            "<input class=\"txt1\" id=\"idX\" type=\"submit\" name=\"X\" value=\"5\">\n" +
            "</p>\n" +
            "</form>\n" +
            "</div>\n" +
            "<div class=\"area\">\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>\n" +
            "<script>\n" +
            "function validateForm(){\n" +
            "var _y=document.getElementById(\"textY\").value;\n" +
            "_y=_y.replace(\",\",\".\");\n" +
            "var _yvalid=!((y_val == \"\") || !(!isNaN(parseFloat(_y)) && isFinite(_y)) || (_y > 5) || (_y < -5));\n" +
            "if (_yvalid) {\n" +
            "document.getElementById(\"idX\").disabled=false;\n" +
            "}else{\n" +
            "document.getElementById(\"idX\").disabled=true;\n" +
            "}\n" +
            "}\n" +
            "</script>\n");
            out.close();
        }
    }

