package com.locauto.model;
import java.util.ArrayList; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 

import com.locauto.dao.DAO; 

public class VeiculosList extends DAO { 
	
	public VeiculosList(){
		super.conectar();		
	}
	 	
	public ArrayList<String[]> getVeiculos() throws SQLException {
        ArrayList<String[]> uniList = new ArrayList<String[]>();
        String tryquery = "select veiculos.placa, veiculos.modelo, veiculos.ano from veiculos"
		  		+ "  order by veiculos.modelo asc ";
		
        Statement stmt2 = conexao.createStatement();
        ResultSet rs1 = stmt2.executeQuery(tryquery);

        while (rs1.next()) {

            uniList.add(new String[]{rs1.getString("placa"), rs1.getString("modelo"), rs1.getString("ano") });

        }

        return uniList;
    } 
}
 