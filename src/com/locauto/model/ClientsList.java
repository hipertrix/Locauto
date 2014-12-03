package com.locauto.model;

import java.util.ArrayList; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 

import com.locauto.dao.DAO; 
public class ClientsList  extends DAO { 
	
	public ClientsList(){
		super.conectar();		
	}
	 	
	public ArrayList<String[]> getClients() throws SQLException {
        ArrayList<String[]> uniList = new ArrayList<String[]>();
        String tryquery = "select cpf, nome from usuario order by nome asc ";		
        Statement stmt2 = conexao.createStatement();
        ResultSet rs1 = stmt2.executeQuery(tryquery);

        while (rs1.next()) {

            uniList.add(new String[]{rs1.getString("cpf"), rs1.getString("nome")});

        }

        return uniList;
    } 
}
 