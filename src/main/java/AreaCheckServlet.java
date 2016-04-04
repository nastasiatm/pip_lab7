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
        String XBuf = req.getParameter("X").replace(',', '.');
        String YBuf = req.getParameter("Y").replace(',', '.');
        String RBuf = req.getParameter("R").replace(',', '.');
        float X = Float.NaN;
        float Y = Float.NaN;
        float R = Float.NaN;
        try {
            X = Float.parseFloat(XBuf);
            Y = Float.parseFloat(YBuf);
            R = Float.parseFloat(RBuf);
        } catch (NumberFormatException e) {
        }
        PrintWriter out = resp.getWriter();
        if (!validate(X, Y, R)) {
            out.print("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "<meta charset=\"UTF-8\">\n" +
                    "<title>Labwork №7</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<p>Input error!</p>\n" +
                    "<p>Y must be [-5;5]" + "</p>\n" +
                    "<p  align=\"center\"><a href=\"/Lab7/main\">Go back</a></p>" +
                    "</body>\n" +
                    "</html>");
            out.close();
            return;
        }
        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Labwork №7</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table align='center'>\n" +
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
                " <tr>\n" +
                "<td>In area: </td>\n" +
                "<td>" + (inFigure(X, Y, R) ? "Yes" : "No") + "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<p  align=\"center\"><a href=\"/Lab7/main\">Go back</a></p>" +
                "</body>\n" +
                "</html>");
        out.close();
    }

    boolean inFigure(float X, float Y, float R) {
        return (Y >= 0 && Y <= R && X <= 0 && X >= R / 2) &&
                (Y >= -R / 2 && Y <= 0 && X >= -R / 2 && X <= 0 && (X * X + Y * Y) >= R * R) &&
                (Y >= -R / 2 && Y <= 0 && X >= 0 / 2 && X <= R && Y >= X / 2 - R / 2);
    }

    boolean validate(float X, float Y, float R) {
        return (Y >= -5.0 && Y <= 5.0) && (!Float.isNaN(X) && !Float.isNaN(Y) && !Float.isNaN(R) && Y <= 5 && Y >= -5);
    }
}
