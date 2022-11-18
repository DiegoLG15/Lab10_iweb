package com.example.lab10_iweb.Daos;

import com.example.lab10_iweb.Beans.Clientes;
import java.sql.*;
import java.util.ArrayList;




public class DaoCliente extends DaoBase{

    public ArrayList<Clientes> listarClientes(){

        /*  QUERY PARA listarClientes
        SELECT concat(clientes.g4093_name, ' ',coalesce(clientes.g4093_last_name," ")) AS `nombreCliente`, clientes.g4093_age AS 'edad', clientes.g4093_type AS 'tipoCliente', clientes.g4093_documentType AS 'tipoDocumento', count(contratos.g6789_cod_nup) AS 'cantidadContr'
        FROM jm_client_bii clientes LEFT JOIN jm_cotr_bis contratos ON  (contratos.client_nro_id = clientes.g4093_nro_id)
        GROUP BY `nombreCliente`*/

        ArrayList<Clientes> listaClientes = new ArrayList<>();

        try(Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM bi_corp_business.jm_client_bii where g4093_nro_id not in (select nro_documento from credentials);")) {

            while(rs.next()){
                Clientes cliente = new Clientes();

                cliente.setNumeroDocumento(rs.getString(1));
                cliente.setNombreCliente(rs.getString(2));
                cliente.setEdad(rs.getString(3));
                if (rs.getString(4).equalsIgnoreCase("N")) {
                    cliente.setTipoCliente("Natural");
                } else if (rs.getString(4).equalsIgnoreCase("J")) {
                    cliente.setTipoCliente("Jurídica");
                }
                cliente.setTipoDocumento(rs.getString(5));

                listaClientes.add(cliente);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return listaClientes;
    }



    public Clientes buscarCliente(int idCliente) {

        Clientes cliente = new Clientes();


        try(Connection conn = getConnection();
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM jm_client_bii WHERE g4093_nro_id=?;")){

            pstm.setInt(1,idCliente);
            try (ResultSet rs = pstm.executeQuery();){
                if(rs.next()){
                    cliente.setNumeroDocumento(rs.getString(1));
                    cliente.setNombreCliente(rs.getString(2));
                    cliente.setEdad(rs.getString(3));
                    if (rs.getString(4).equalsIgnoreCase("N")) {
                        cliente.setTipoCliente("Natural");
                    } else if (rs.getString(4).equalsIgnoreCase("J")) {
                        cliente.setTipoCliente("Jurídica");
                    }
                    cliente.setTipoDocumento(rs.getString(5));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }




}
