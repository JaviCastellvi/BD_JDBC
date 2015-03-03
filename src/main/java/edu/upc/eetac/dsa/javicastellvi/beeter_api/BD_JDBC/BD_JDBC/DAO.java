package edu.upc.eetac.dsa.javicastellvi.beeter_api.BD_JDBC.BD_JDBC;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;


public class DAO {
ArrayList<Provides> miProvides;
private static DbConnection conexion = new DbConnection();
private static ResultSet resultado;	
Provides pr= new Provides();
		public DAO(){
			miProvides= new ArrayList<Provides>();
		}
		public ArrayList< Provides> getAllProvides() {
			resultado = conexion.getQuery("SELECT * FROM Provides");
				try {
					while(resultado.next()){
						Provides e= new Provides();
						 pr.setPieza(Integer.parseInt(resultado.getString("Piece")));
						 pr.setProvider(resultado.getString("Provider"));
						 pr.setPrecio(Integer.parseInt(resultado.getString("Price")));
						 miProvides.add(e);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}	
			   
			  return miProvides;
			 }
	
		
	public void deleteProvides(int price) {
		
		conexion.setQuery("DELETE FROM Provides WHERE Price='" +price+ "'");
	}
		
	
	 public Provides getProvides(int price) {
				
		  Provides p= new Provides();
			resultado = conexion.getQuery("SELECT * FROM Provides WHERE Price='"+price+"'");
			try {
				while(resultado.next()){
					
				    p.setPieza(Integer.parseInt(resultado.getString("Piece")));
				    p.setProvider(resultado.getString("Provider"));
				    p.setPrecio(Integer.parseInt(resultado.getString("Price")));
				    
				   
				   
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}	
			
	return p;
}
	
	public static void updateProvides (Provides p){
		  int pieza, precio;
		  String provedor;
		  
			pieza= p.getPieza();
			provedor= p.getProvider();
			precio= p.getPrecio();
			
		
			String nombre= "UPDATE Provides SET Price="+precio+ "WHERE Provider='"+provedor+"' AND Piece="+pieza;
			System.out.println("Name: "+nombre);
			conexion.setQuery("UPDATE Provides SET Price="+precio+ " WHERE Provider='"+provedor+"' AND Piece="+pieza); 
				
		   
	}

	   
	
}
	
	

