package com.locauto.model;

 public class StatusUsuario {
	private static String[] status = new String[]{"Novo","Ativo","Inativo","Pendente","Cancelado"};
	
	public static String[] get_all_tipo_usuario() {
		return status;		
	}
	
	public static String get_tipo_usuario_by_index(int index) {
		return status[index];		
	}
	

}
