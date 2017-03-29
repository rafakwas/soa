package lab3.zadanie3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "bookServlet", urlPatterns = {"lab3/zadanie3/book"})
public class bookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if(getServletContext().getAttribute("vector") == null) {
            getServletContext().setAttribute("vector",new Vector<UserFeedback>());
        }

        UserFeedback userFeedback = new UserFeedback(request.getParameter("login"),request.getParameter("email"),request.getParameter("comment"),System.currentTimeMillis());

        Vector<UserFeedback> vector = (Vector<UserFeedback>) getServletContext().getAttribute("vector");

        vector.add(userFeedback);

        getServletContext().setAttribute("vector",vector);

        response.sendRedirect("/lab3/zadanie3/writeCommentsToFile.jsp");

    }
}
