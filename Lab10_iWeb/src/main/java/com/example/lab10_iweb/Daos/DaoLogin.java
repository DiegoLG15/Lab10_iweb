package com.example.lab10_iweb.Daos;

import com.example.lab10_iweb.Beans.Credentianls;

import java.sql.*;

public class DaoLogin extends DaoBase{

    public Credentianls buscarUsuario(String nroDoc, String password) {

        Credentianls credencialUsuario = null;


        try(Connection conn = getConnection();
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM bi_corp_business.credentials WHERE nro_documento= ? and password= ?;")){

            pstm.setInt(1, Integer.parseInt(nroDoc));
            try (ResultSet rs = pstm.executeQuery();){
                if(rs.next()){
                    credencialUsuario = new Credentianls();
                    credencialUsuario.setNumeroDocumento(rs.getString(1));
                    credencialUsuario.setTipoUsuario(rs.getInt(2));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return credencialUsuario;
    }
    public void createCredentialCliente(){

    }
}
