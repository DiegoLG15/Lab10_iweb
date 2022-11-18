package com.example.lab10_iweb.Daos;


import java.sql.*;
import java.util.ArrayList;
import com.example.lab10_iweb.Beans.Contratos;
import com.example.lab10_iweb.Dtos.CantidadContratosDto;
import com.example.lab10_iweb.Dtos.MaxExpectedLossDto;


public class DaoContrato extends DaoBase {

    public ArrayList<Contratos> listarContratos(int idCliente) {

        ArrayList<Contratos> listaContratos = new ArrayList<>();

        try(Connection conn = getConnection();
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM bi_corp_business.jm_cotr_bis where client_nro_id = ?;")){

            pstm.setInt(1,idCliente);
            try (ResultSet rs = pstm.executeQuery();){
                while(rs.next()){
                    Contratos contrato = new Contratos();

                    contrato.setNroDeContrato(rs.getString(1));
                    contrato.setIdCliente(rs.getInt(2));
                    if (rs.getInt(4) == 0) {
                        contrato.setEstado("Normal");
                        contrato.setMesesEnEseEstado(rs.getInt(5));
                    } else if (rs.getInt(4) == 1) {
                        contrato.setEstado("Cura");
                        contrato.setMesesEnEseEstado(rs.getInt(5));
                    } else if (rs.getInt(4) == 2) {
                        contrato.setEstado("Mora");
                        contrato.setMesesEnEseEstado(rs.getInt(5));
                    }

                    contrato.setDivisa(rs.getString(3));
                    listaContratos.add(contrato);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return listaContratos;

    }




    public ArrayList<CantidadContratosDto> contratosCantidad(int idCliente) {

        ArrayList<CantidadContratosDto> listaContratos = new ArrayList<>();

        try(Connection conn = getConnection();
            PreparedStatement pstm = conn.prepareStatement("SELECT G6789_status, count(g6789_contract) FROM bi_corp_business.jm_cotr_bis  contratos\n" +
                    "left join bi_corp_business.jm_client_bii cliente on contratos.client_nro_id = cliente.g4093_nro_id\n" +
                    "where cliente.g4093_nro_id = ? group by G6789_status order by G6789_status ASC ;")){

            pstm.setInt(1,idCliente);
            try (ResultSet rs = pstm.executeQuery();){
                while(rs.next()){
                    CantidadContratosDto cantidadContratosDto = new CantidadContratosDto();

                    if (rs.getInt(1) == 0) {
                        cantidadContratosDto.setEstado("Normal");
                    } else if (rs.getInt(1) == 1) {
                        cantidadContratosDto.setEstado("Cura");
                    } else if (rs.getInt(1) == 2) {
                        cantidadContratosDto.setEstado("Mora");
                    }

                    cantidadContratosDto.setCantidadPorEstado(rs.getInt(2));

                    listaContratos.add(cantidadContratosDto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaContratos;
    }



    public MaxExpectedLossDto getMaxExpectedLoss(int idCliente ) {

        MaxExpectedLossDto maxExpectedLossDto = new MaxExpectedLossDto();

        try(Connection conn = getConnection();
            PreparedStatement pstm = conn.prepareStatement("SELECT idJM_VALUES, max(valores.pd_value*valores.lgd_value*(1-valores.recovery_rate)),contratos.g6789_contract,cliente.g4093_nro_id   FROM bi_corp_business.jm_values  valores\n" +
                    "left join bi_corp_business.jm_cotr_bis contratos on contratos.g6789_contract = valores.jm_cotr_bis_g6789_cod_nup\n" +
                    "left join jm_client_bii cliente on contratos.client_nro_id = cliente.g4093_nro_id\n" +
                    "where cliente.g4093_nro_id = ?;")){

            pstm.setInt(1,idCliente);

            try (ResultSet rs = pstm.executeQuery()){
                if(rs.next()){
                    maxExpectedLossDto.setMaxExpectedLoss(rs.getFloat(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       return maxExpectedLossDto;
    }


}
