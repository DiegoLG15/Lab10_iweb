package com.example.lab10_iweb.Controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.lab10_iweb.Daos.*;
import com.example.lab10_iweb.Beans.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ClienteServlet", value = "/ClienteServlet")
public class ClienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "datos" : request.getParameter("action");
        RequestDispatcher view;
        HttpSession session = request.getSession();
        Credentianls credentials = (Credentianls) session.getAttribute("usuarioLogueado");

        DaoCliente daoCliente = new DaoCliente();
        DaoContrato daoContrato = new DaoContrato();


        //ArrayList<Partido> listaPartidosUnicos;
        //ArrayList<Integer> JornadasID = new ArrayList<>();

        bandera: switch (action) {

            case "datos":

                //request.setAttribute("error1", "El campo Jornada debe ser un entero mayor que cero ");
               // int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                request.setAttribute("cliente", daoCliente.buscarCliente(Integer.parseInt(credentials.getNumeroDocumento())));
                view = request.getRequestDispatcher("cliente/misdatos.jsp");
                view.forward(request, response);
                break bandera;
            case "contratos":

                request.setAttribute("listaContratos", daoContrato.listarContratos(Integer.parseInt(credentials.getNumeroDocumento())));
                view = request.getRequestDispatcher("cliente/miscontratos.jsp");
                view.forward(request, response);

                break bandera;
            case "estado":
                request.setAttribute("listaCantContratos", daoContrato.contratosCantidad(Integer.parseInt(credentials.getNumeroDocumento())));
                view = request.getRequestDispatcher("cliente/cantcontratos.jsp");
                view.forward(request, response);

                break bandera;
            case "loss":
                request.setAttribute("expectedLoss", daoContrato.getMaxExpectedLoss(Integer.parseInt(credentials.getNumeroDocumento())));
                view = request.getRequestDispatcher("cliente/expectedloss.jsp");
                view.forward(request, response);
                break bandera;
            default:
                response.sendRedirect(request.getContextPath() + "/ClienteServlet?action=datos");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }
}
