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
                    "#head {\n" +
                        "font: 150% serif;\n" +
                        "background: #F1AD2E;\n" +
                        "text-align: center;\n" +
                    "}\n" +
                    "#head:hover {\n" +
                        "color: #B83129;\n" +
                        "}\n" +
                    ".radius {\n" +
                        "border: 1px solid black;\n" +
                        "padding: 15px;\n" +
                        "margin-bottom: 10px;\n" +
                    "}\n" +
                    ".inputs{\n" +
                        "width: 50%;\n" +
                        "float: left;\n" +
                        "padding-top: 50px;\n" +
                    "}\n" +
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
                        "content: \"Graph:\";\n" +
                        "display: block;\n" +
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

                "</style>\n"+
                    "</head>\n" +
                        "<body>\n" +
                            "<div class=\"wrapper\">\n" +
                                "<header id=\"head\" align=\"center\" style=\"border-radius: 65px 0px\" class=\"radius\">\n" +
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
                                            "<input type=\"radio\" name=\"R\" value=\"1\" required>1\n " +
                                            "<input type=\"radio\" name=\"R\" value=\"2\" required>2\n " +
                                            "<input type=\"radio\" name=\"R\" value=\"3\" required>3\n " +
                                            "<input type=\"radio\" name=\"R\" value=\"3\" required>4\n " +
                                            "<input type=\"radio\" name=\"R\" value=\"5\" required>5\n " +
                                        "</p>\n" +
                                        "<p>Y:\n" +
                                            "<input type=\"text\" id=\"textY\" name=\"Y\" placeholder=\"-5..5\" onchange=\"validateForm()\" onkeydown=\"javascript:if(13==event.keyCode){return false;}\"  required>\n" +
                                        "</p>\n" +
                                        "<p>X:\n" +
                                            "<input class=\"dotX\" id=\"idX1\" type=\"submit\" name=\"X\" value=\"1\">\n" +
                                            "<input class=\"dotX\" id=\"idX2\" type=\"submit\" name=\"X\" value=\"2\">\n" +
                                            "<input class=\"dotX\" id=\"idX3\" type=\"submit\" name=\"X\" value=\"3\">\n" +
                                            "<input class=\"dotX\" id=\"idX4\" type=\"submit\" name=\"X\" value=\"4\">\n" +
                                            "<input class=\"dotX\" id=\"idX5\" type=\"submit\" name=\"X\" value=\"5\">\n" +
                                        "</p>\n" +
                                    "</form>\n" +
                                "</div>\n" +
                                "<div class=\"area\">\n" +
                                "<img src=\"http://savepic.ru/9271508.png\">\n" +
                                "</div>\n" +
                            "</div>\n" +
                            "</div>\n" +
                        "</body>\n" +
            "</html>\n" +
            "<script>\n" +
                "function validateForm(){\n" +
                    "var _y = document.getElementById(\"textY\").value;\n" +
                    "_y = _y.replace(\",\",\".\");\n" +
                    "var _yvalid = !((_y == \"\") || !(!isNaN(parseFloat(_y)) && isFinite(_y)) || (_y > 5) || (_y < -5));\n" +
                    "if (_yvalid) {\n" +
                        "document.getElementById(\"idX1\").disabled=false;\n" +
                        "document.getElementById(\"idX2\").disabled=false;\n" +
                        "document.getElementById(\"idX3\").disabled=false;\n" +
                        "document.getElementById(\"idX4\").disabled=false;\n" +
                        "document.getElementById(\"idX5\").disabled=false;\n" +
                    "}else{\n" +
                        "document.getElementById(\"idX1\").disabled=true;\n" +
                        "document.getElementById(\"idX2\").disabled=true;\n" +
                        "document.getElementById(\"idX3\").disabled=true;\n" +
                        "document.getElementById(\"idX4\").disabled=true;\n" +
                        "document.getElementById(\"idX5\").disabled=true;\n" +
                    "}\n" +
                "}\n" +
            "</script>\n");
            out.close();
        }
    }

