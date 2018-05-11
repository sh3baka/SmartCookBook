package lv.shebaka.smartcookbook.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/hw")
public class HelloWorldServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String param1 = req.getParameter("param1");

        HttpSession session = req.getSession();
        session.setAttribute("AttrName", 1L);

        //set response content type
        resp.setContentType("text/html");



        //Prepare output html
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + "Helloworld Java Servlet" + "</h1>");
        out.println("<h1>" + "Param1 = "+ param1 + "</h1>");
    }
}
