package application.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Model.ConexionBDD;
import application.Model.Genio;
import javafx.collections.FXCollections;

public class AppModel {

	
	public void listarGenios () {
		Connection conn = null;
		ArrayList<Genio> genios = new ArrayList<Genio>();
		try {
			 conn = new ConexionBDD().getConnection();
			 String sql = "Select * from Genio";
 			 System.out.println(sql);

			  ResultSet rs = conn.createStatement().executeQuery(sql);
	            while (rs.next()) {       
	                Genio a = new Genio();
	                a.setIdGenio(rs.getInt("idGenio"));
	                a.setNombre(rs.getString("nombre"));
	                a.setNacimiento(rs.getInt("nacimiento"));

	                genios.add(a);
	            }
	            

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	
	public void insert (Genio genioAInsertar) {
	//ODELO
	//Genio genioAInsertar = new Genio(0,nombre,nacimiento);
	 Connection conn = null;
		try {
			conn = new ConexionBDD().getConnection();
			String insert = "INSERT INTO Genio (nombre,nacimiento) "
					+ " values (?,?)";
		    
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setString(1, genioAInsertar.getNombre());
			ps.setInt(2, genioAInsertar.getNacimiento());
			
			System.out.println(insert);
			System.out.println("1) "+genioAInsertar.getNombre());
			System.out.println("2) "+genioAInsertar.getNacimiento());
			
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		this.listarGenios();
	}
	
	
	public void update (Genio genioAInsertar) {
		
		Connection conn = null;
		try {
			conn = new ConexionBDD().getConnection();
			String update = "UPDATE genio SET idGenio=?, nombre=?,nacimiento=?,profesion=? WHERE idGenio=¡?";
			PreparedStatement ps = conn.prepareStatement(update);
			ps.setString(1, genioAInsertar.getNombre());
			ps.setInt(2, genioAInsertar.getNacimiento());
			ps.setString(3, genioAInsertar.getProfesion());
			
			System.out.println(update);
			System.out.println("1) "+genioAInsertar.getNombre());
			System.out.println("2) "+genioAInsertar.getNacimiento());
			System.out.println("3) "+genioAInsertar.getProfesion());
			
			
			ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void delete(Genio genioAInsertar) {
		
		Connection conn = null;
		try {
			conn = new ConexionBDD().getConnection();
			String delete = "DELETE FROM genio WHERE idGenio = ?";
			
			PreparedStatement ps = conn.prepareStatement(delete);
			ps.setInt(1, genioAInsertar.getIdGenio());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
}
