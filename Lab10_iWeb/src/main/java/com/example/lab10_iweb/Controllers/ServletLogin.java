package com.example.lab10_iweb.Controllers;

import com.example.lab10_iweb.Beans.Credentianls;
import com.example.lab10_iweb.Daos.DaoLogin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ?
              "loginform" : request.getParameter("action");

        RequestDispatcher view;

        switch(action){
            case "loginform":
                view = request.getRequestDispatcher("login/loginForm.jsp");
                view.forward(request, response);
                break;
            case "logout":
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect(request.getContextPath());
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoLogin loginDao = new DaoLogin();
         String nroDocumento = request.getParameter("inputDocument");
         String password = request.getParameter("inputPassword");

        Credentianls crendencial = loginDao.buscarUsuario(nroDocumento,password);

        if(crendencial != null){
            HttpSession session = request.getSession();
            session.setAttribute("usuarioSession",crendencial);

            response.sendRedirect(request.getContextPath());
        } else {
            response.sendRedirect(request.getContextPath()+"/LoginServlet?error");
        }


    }
}
