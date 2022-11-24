package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import interfaces.UsuarioInterface;
import model.Usuario;
import utils.MySQLConexion;

public class GestionUsuario implements UsuarioInterface {

	
	public Usuario validaAcceso(String usuario, String clave) {
		Usuario u = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
			
			try {
				con= MySQLConexion.getConexion();
				String sql= "call usp_validaAcceso(?,?);";

				pst = con.prepareStatement(sql);
				pst.setString(1, usuario);
				pst.setString(2, clave);
				
				rs=pst.executeQuery();
				
				
				while(rs.next())
				{
				u = new Usuario();
				u.setCodigo(rs.getInt(1));
				u.setNombre(rs.getString(2));
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error en la sentencia:" +e.getMessage());
			}	
			finally {
				try {
					if(pst!=null) pst.close();
					if(con!=null) con.close();
				}catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Error al CERRAR:" +e2.getMessage());
				}	 
				
			}
			return u;
		}

	

}
