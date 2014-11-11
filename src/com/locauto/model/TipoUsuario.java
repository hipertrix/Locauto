package com.locauto.model;
 

public class TipoUsuario {
	private static String[] tipo_usuario = new String[]{"Administrador","Funcionário","Cliente"};
	
	public static String[] get_all_tipo_usuario() {
		return tipo_usuario;		
	}
	
	public static String get_tipo_usuario_by_index(int index) {
		return tipo_usuario[index];		
	}
	

}
