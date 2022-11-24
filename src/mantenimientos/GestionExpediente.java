package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import interfaces.ExpedienteInterface;
import model.Expediente;
import utils.MySQLConexion;
import vista.FormularioPrincipal;

public class GestionExpediente implements ExpedienteInterface {

	@Override
	public int registrar(Expediente ex) {
		// conexion con la BD, las sentencias, etc
		int rs = 0; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into TB_EXPEDIENTE values (null,curdate(),?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql); 
			
			// parámetros según la sentencia
			pst.setString(1, ex.getFecha_emision()); 
			pst.setString(2, ex.getNom_organismo());
			pst.setString(3, ex.getApoderado_organismo());
			pst.setString(4, ex.getContacto_tlf());
			pst.setString(5, ex.getContacto_email());
			pst.setString(6, ex.getDescripcion_exp());
			pst.setString(7, ex.getSituacion_exp());
					
			

			rs = pst.executeUpdate();

		} catch (Exception e) {
			Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/usererror.png")); 
			JOptionPane.showMessageDialog(null,"Error en la Sentencia" + e.getMessage(),"Error al Ingresar Expediente",JOptionPane.INFORMATION_MESSAGE,ico);
	
			
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/usererror.png")); 
				JOptionPane.showMessageDialog(null,"Error al Cerrar" + e.getMessage(),"Error al Ingresar Expediente",JOptionPane.INFORMATION_MESSAGE,ico);
			}
		}
		return rs;
	}

	@Override
	public ArrayList<Expediente> listado() {
		ArrayList<Expediente> lista = new ArrayList<Expediente>();
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "select * from TB_EXPEDIENTE"; // sentencia sql

		   pst = con.prepareStatement(sql);
		   // parámetros según la sentencia		   
		   
		   rs = pst.executeQuery(); // tipo de ejecución
		   
		   // Acciones adicionales en caso de consultas
		   while (rs.next()){
			
			   Expediente ex = new Expediente();
			   ex.setCod_exp(rs.getInt(1));
			   ex.setFecha_registro(rs.getString(2));
			   ex.setFecha_emision(rs.getString(3));
			   ex.setNom_organismo(rs.getString(4));
			   ex.setApoderado_organismo(rs.getString(5));
			   ex.setContacto_tlf(rs.getString(6));
			   ex.setContacto_email(rs.getString(7));
			   ex.setDescripcion_exp(rs.getString(8));
			   ex.setSituacion_exp(rs.getString(9));
			   
			   lista.add(ex);
		   }
		} catch (Exception e) {
		   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
		  try {
		      if (pst != null) pst.close();
		      if (con != null) con.close();
		   } catch (SQLException e) {
		      System.out.println("Error al cerrar ");
		   }
		}

		return lista;
	}

	@Override
	public ArrayList<Expediente> listado(String situacion) {
		ArrayList<Expediente> lista = new ArrayList<Expediente>();
		ResultSet rs = null;
		Connection con=null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from TB_EXPEDIENTE where situacion_exp=?";
			
		pst=con.prepareStatement(sql);
		pst.setString(1, situacion);
		rs= pst.executeQuery();
		
		while (rs.next())
		{
			Expediente ex = new Expediente();
			   ex.setCod_exp(rs.getInt(1));
			   ex.setFecha_registro(rs.getString(2));
			   ex.setFecha_emision(rs.getString(3));
			   ex.setNom_organismo(rs.getString(4));
			   ex.setApoderado_organismo(rs.getString(5));
			   ex.setContacto_tlf(rs.getString(6));
			   ex.setContacto_email(rs.getString(7));
			   ex.setDescripcion_exp(rs.getString(8));
			   ex.setSituacion_exp(rs.getString(9));
			lista.add(ex);
		}
		
		} catch (Exception e) {
			System.out.println("ERROR EN LA SENTENCIA :"+e.getMessage());
		} finally {
			try {
				if (pst!=null) 
					pst.close();
					if (con!=null) 
						con.close();
			}catch (SQLException e2) {
				System.out.println("ERROR AL CERRAR");
			}
		}
		return lista;
	}

}
