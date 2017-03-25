package lab3.zadanie1;

import lab3.zadanie1.com.example.model.EkspertPiwny;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "WyborPiwa", urlPatterns = {"lab3/zadanie1"})
public class WyborPiwa extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Porada piwna<br/>");
        String kolor = request.getParameter("kolor");

        EkspertPiwny ekspertPiwny = new EkspertPiwny();
        List<String> marki = ekspertPiwny.marki(kolor);
        request.setAttribute("marki",marki);

        RequestDispatcher view = request.getRequestDispatcher("/lab3/zadanie1/wyniki.jsp");
        view.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
