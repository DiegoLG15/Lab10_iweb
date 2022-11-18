package com.example.lab10_iweb.Controllers;

import com.example.lab10_iweb.Beans.Credentianls;
import com.example.lab10_iweb.Daos.DaoCliente;
import com.example.lab10_iweb.Daos.DaoLogin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletAdmin", value = "/ServletAdmin")
public class ServletAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;
        Credentianls credentianls;
        DaoCliente daoCliente = new DaoCliente();

        switch (action){
            case "crear":
                request.setAttribute("clientes", daoCliente.listarClientes());
                view = request.getRequestDispatcher("/newCredencial.jsp");
                view.forward(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;
        ArrayList<String> clientes = new ArrayList<>();
        DaoLogin daoLogin = new DaoLogin();

        switch (action){
            case "guardar":
                String  nroDocumento= request.getParameter("clientes");
                String password = request.getParameter("password");
                String tipoUsuario = request.getParameter("tipoUsuario");

                Credentianls credentianls=new Credentianls();
                credentianls.setNumeroDocumento(nroDocumento);
                credentianls.setTipoUsuario(Integer.parseInt(tipoUsuario));
                daoLogin.createCredentialCliente(credentianls,password);

                response.sendRedirect(request.getContextPath() + "/JobServlet");
                break;
        }

    }
}
