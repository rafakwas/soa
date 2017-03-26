package lab3.zadanie1.com.example.model;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@WebFilter(servletNames = {"WyborPiwa"})
public class Filtr implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        int birthYear = Integer.parseInt(servletRequest.getParameter("year"));
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        if (year - birthYear <= 18) {
            servletResponse.getWriter().print("Nieletnim nie wolno pic piwa");
        }
        else {
            servletRequest.getRequestDispatcher("/lab3/zadanie1").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
