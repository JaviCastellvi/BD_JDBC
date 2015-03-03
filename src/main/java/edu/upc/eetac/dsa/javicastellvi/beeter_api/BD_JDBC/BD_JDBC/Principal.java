package edu.upc.eetac.dsa.javicastellvi.beeter_api.BD_JDBC.BD_JDBC;

import java.util.ArrayList;


public class Principal {
	
	public static void main(String[] args) {
	
		Provides pr= new Provides();
		DAO d=new DAO();
		pr= d.getProvides (7);
		System.out.println("Pieza: "+pr.getPieza());
		System.out.println("Provider: "+pr.getProvider());
		System.out.println("Precio: "+pr.getPrecio());
		d.deleteProvides(7);
		pr.setPieza(1);
		pr.setProvider("HAL");
		pr.setPrecio(100);
		d.updateProvides(pr);
		
		 ArrayList<Provides> AllProvides = d.getAllProvides();
		 if (AllProvides.size()>0) {
		   int numeroPersona=0;
		   
		   for (int i = 0; i < AllProvides.size(); i++) {
		    numeroPersona++;
		    pr=AllProvides.get(i);
		    System.out.println("****************Provedor "+numeroPersona+"**********************");
		    System.out.println("Pieza: "+pr.getPieza());
		    System.out.println("Provedor: "+pr.getProvider());
		    System.out.println("Precio: "+pr.getPrecio());
		    System.out.println("*************************************************\n");
		   }
		  }else{
		   System.out.println ("Actualmente no existen registros");
		  }
		   
	}
}

