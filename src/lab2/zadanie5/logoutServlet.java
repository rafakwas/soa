package lab2.zadanie5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "logoutServlet", urlPatterns = {"lab2/zadanie5/logout"})
public class logoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


//        HttpSession session = request.getSession();
//        session.invalidate();
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookies[i].setValue(null);
                cookies[i].setPath("/hello/zadanie5");
                cookies[i].setMaxAge(0);
                response.addCookie(cookies[i]);
            }
        }

        request.getRequestDispatcher("loginSite.jsp").include(request,response);
    }
}
