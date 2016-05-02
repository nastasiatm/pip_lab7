/**
 * Created by nasta_000 on 01.05.2016.
 */

import tools.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(true);
        List<Result> res = (ArrayList<Result>) session.getAttribute("results");

        String XBuf = req.getParameter("XSelector").replace(',', '.');
        String YBuf = req.getParameter("YSelector").replace(',', '.');
        String RBuf = req.getParameter("RSelector").replace(',', '.');
        double X = Double.NaN;
        double Y = Double.NaN;
        double R = Double.NaN;
        boolean ok = true;
        try {
            X = Double.parseDouble(XBuf);
            Y = Double.parseDouble(YBuf);
            R = Double.parseDouble(RBuf);
            if (!validate(X, Y, R)) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            session.setAttribute("success", "Something was wrong with your parameters! Please check them and try again! " +
                    "\nRemember that they must be numeric and r must be more than 0!");
            ok = false;
        }
        if (ok) {
            session.setAttribute("success", "Your request was successful! See table for results!");
            if (res == null) {
                res = new ArrayList<Result>();
                res.add(new Result(X, Y, R, inFigure(X, Y, R)));
                session.setAttribute("results", res);
            } else {
                res.add(new Result(X, Y, R, inFigure(X, Y, R)));
            }
        }
        resp.sendRedirect("/Lab8/view.jsp");
    }

    boolean inFigure(double X, double Y, double R) {
        return (((X <= 0) && (X >= -R) && (Y <= 0) && (Y >= -R / 2)) ||
                ((X >= 0) && (X <= R) && (Y >= -R) && (Y <= 0) && (X * X + Y * Y) <= R * R / 4) ||
                ((X >= 0) && (X <= R) && (Y >= 0) && X <= R && (Y <= -X + R)));
    }

    boolean validate(double X, double Y, double R) {
        return (Y >= -5.0 && Y <= 5.0) && (R > 0) && (!Double.isNaN(X) && !Double.isNaN(Y) && !Double.isNaN(R) && Y <= 5 && Y >= -5);
    }
}
