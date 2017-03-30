package lab3.zadanie2;

import lab3.zadanie2.com.example.model.User;
import lab3.zadanie2.com.example.model.UserRepo;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "logoutSession", urlPatterns = {"lab3/zadanie2/logoutSession"})
public class logoutServlet extends HttpServlet {

    @EJB
    UserRepo userRepo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        String login = (String)session.getAttribute("login");

        User user = new User();
        user.setLogin(login);

        userRepo.remove(user);

        getServletContext().setAttribute("users",userRepo);

        session.invalidate();



        out.print("Zostales wylogowany.");


        response.sendRedirect("/lab3/zadanie2/form.jsp");

    }
}
