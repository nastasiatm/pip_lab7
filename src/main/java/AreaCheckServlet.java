/**
 * Created by nasta_000 on 03.04.2016.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String X_s = req.getParameter("X").replace(',', '.');
        String Y_s = req.getParameter("Y").replace(',', '.');
        String R_s = req.getParameter("R").replace(',', '.');
        float X = Float.NaN;
        float Y = Float.NaN;
        float R = Float.NaN;
        try {
            X = Float.parseFloat(X_s);
            Y = Float.parseFloat(Y_s);
            R = Float.parseFloat(R_s);
        }
        catch (NumberFormatException e) {}

        PrintWriter out = resp.getWriter();
        if (!validate(X, Y, R)) {
            out.print("<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                            "<head>\n" +
                                "<meta charset=\"UTF-8\">\n" +
                                "<title>Result</title>\n" +
                            "</head>\n" +
                            "<body align=\"center\">\n" +
                                "<p>Input error!</p>\n" +
                                "<p>\"Y\" must be [-5;5]. Your \"Y\" = " + Y_s + "</p>\n" +
                                "<p  align=\"center\"><a href=\"/Lab7/main\">Go back</a></p>" +
                            "</body>\n" +
                        "</html>");
            out.close();
            return;
        }
        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                    "<head>\n" +
                        "<meta charset=\"UTF-8\">\n" +
                        "<title>Result</title>\n" +
                        "<style>\n" +
                            ".tbl1 tr td {\n" +
                                "border: 1px solid black;\n" +
                                "padding: 10px;\n" +
                                "text-align: center;\n" +
                                "border-collapse: separate;\n" +
                            "}\n" +
                        "</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                        "<table class=\"tbl1\" align= \"center\">\n" +
                            "<tr>\n" +
                                "<td>X: </td>\n" +
                                "<td>" + X + "</td>\n" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<td>Y: </td>\n" +
                                "<td>" + Y + "</td>\n" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<td>R: </td>\n" +
                                "<td>" + R + "</td>\n" +
                                "<tr>\n" +
                                "<td>In area: </td>\n" +
                                "<td>" + (inArea(X, Y, R) ? "Yes" : "No") + "</td>\n" +
                            "</tr>\n" +
                        "</table>\n" +
                "<p  align=\"center\"><a href=\"/Lab7/main\">Go back</a></p>" +
                "</body>\n" +
                "</html>");
        out.close();
    }

    boolean inArea(float X, float Y, float R) {
        return (((X <= 0) && (X >= -R) && (Y <= 0) && (Y >= -R / 2)) ||
                ((X >= 0) && (X <= R) && (Y >= -R) && (Y <= 0) && (X * X + Y * Y) <= R * R / 4) ||
                ((X >= 0) && (X <= R) && (Y >= 0) && X <= R && (Y <= -X + R)));
    }

    boolean validate(float X, float Y, float R) {
        return (Y >= -5.0 && Y <= 5.0) && (!Float.isNaN(X) && !Float.isNaN(Y) && !Float.isNaN(R) && Y <= 5 && Y >= -5);
    }
}
