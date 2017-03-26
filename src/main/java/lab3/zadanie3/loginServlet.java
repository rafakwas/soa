package lab3.zadanie3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", urlPatterns = {"lab3/zadanie3/login"})
public class loginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String login = request.getParameter("login");
        if (login.isEmpty()) {
            out.println("Login was not given");
            request.getRequestDispatcher("loginSite.jsp").include(request, response);
            out.close();
            return;
        }

        String password = request.getParameter("password");
        if (password.isEmpty()) {
            out.println("Password was not given");
            request.getRequestDispatcher("loginSite.jsp").include(request, response);
            out.close();
            return;
        }

        if (Validation.checkUser(login, password)) {
            Cookie cookie = new Cookie("guestCookie2",login);
            cookie.setMaxAge(60*2);
            response.addCookie(cookie);
            response.sendRedirect("bookSite.jsp");
        } else {
            out.println("Username or password incorrect");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginSite.jsp");
            requestDispatcher.include(request, response);

        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
