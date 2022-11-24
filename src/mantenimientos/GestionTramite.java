package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import interfaces.TramiteInterface;
import model.Tramite;
import utils.MySQLConexion;
import vista.FormularioPrincipal;

public class GestionTramite implements TramiteInterface {

	@Override
	public int registrar(Tramite tr) {
		// conexion con la BD, las sentencias, etc
		int rs = 0; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into TB_EXPEDIENTE values (?,?,curdate(),?,?)";
			pst = con.prepareStatement(sql); 
			
			// parámetros según la sentencia
			pst.setInt(1, tr.getCod_exp()); 
			pst.setString(2, tr.getCod_tram());
			pst.setString(3, tr.getAbrev_ofic());
			pst.setString(4, tr.getTipo_doc());
					
			

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

}
