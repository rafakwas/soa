package lab3.zadanie2;

import lab3.zadanie2.com.example.model.User;
import lab3.zadanie2.com.example.model.UserRepo;
import lab3.zadanie2.com.example.model.UserRepoBean;
import lab3.zadanie2.com.example.model.Validator;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "loginManagment", urlPatterns = {"lab3/zadanie2/loginManagment"})
public class sessionManagement extends HttpServlet {

    @EJB
    UserRepo userRepo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (request.getSession().getAttribute("login") != null) {
            getServletContext().getRequestDispatcher("/lab3/zadanie2/form.jsp").forward(request,response);
        }
        else if(Validator.checkUser(login,password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("login",login);

            User user = new User();
            user.setLogin(login);
            user.setTime(System.currentTimeMillis());

            userRepo.add(user);

            getServletContext().setAttribute("userRepo",userRepo);

            UserRepo tempo = (UserRepo)getServletContext().getAttribute("userRepo");
            System.out.println(tempo.getList());

            getServletContext().getRequestDispatcher("/lab3/zadanie2/form.jsp").forward(request,response);
        }
        else {
            out.print("Bledny login/haslo");
            getServletContext().getRequestDispatcher("/lab3/zadanie2/form.jsp").include(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
//
//    public static Context getInitialContext() throws javax.naming.NamingException {
//
//        Properties p = new Properties();
//        p.put(Context.INITIAL_CONTEXT_FACTORY,        "org.jnp.interfaces.NamingContextFactory");
//        p.put(Context.URL_PKG_PREFIXES, " org.jboss.naming:org.jnp.interfaces");
//        p.put(Context.PROVIDER_URL, "jnp://127.0.0.1:1099");
//
//        return new javax.naming.InitialContext(p);
//    }
}
