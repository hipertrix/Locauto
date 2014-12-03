package com.locauto.model;

public class StatusVeiculo {
 
	private static String[] status = new String[]{"Disponível","Alugado","Manutenção","Inativo","Detido"};
	
	public static String[] getStatusVeiculo() {
		return status;		
	}
	
	public static String getStatusVeiculoByIndex(int index) {
		return status[index];		
	}
	

}
