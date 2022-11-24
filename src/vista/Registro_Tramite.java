package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.Toolkit;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionExpediente;
import mantenimientos.GestionTramite;
import model.Expediente;
import model.Tramite;

import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class Registro_Tramite extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton button;
	private JLabel lblNuevoTrmite;
	private JLabel lblCodigoTramite;
	private JTextField txtCodigoEx;
	private JLabel lblCodigo;
	private JTextField txtCodigoTramite;
	private JLabel lblOficina;
	private JLabel lblDocumento;
	private JComboBox cboDocumento;
	private JButton btnDerivar;
	private JButton btnCancelar;
	private JComboBox cboOficina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro_Tramite frame = new Registro_Tramite();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registro_Tramite() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registro_Tramite.class.getResource("/Imagenes/reporte.png")));
		setResizable(false);
		setTitle("Registro de Tr\u00E1mite");
		setBounds(100, 100, 610, 538);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button = new JButton("Volver");
		button.setFont(new Font("Candara", Font.BOLD, 16));
		button.setBounds(-53, -50, 109, 23);
		contentPane.add(button);
		
		lblNuevoTrmite = new JLabel("NUEVO TR\u00C1MITE\r\n");
		lblNuevoTrmite.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoTrmite.setFont(new Font("Candara", Font.BOLD, 26));
		lblNuevoTrmite.setBounds(23, 23, 542, 33);
		contentPane.add(lblNuevoTrmite);
		
		lblCodigoTramite = new JLabel("C\u00F3digo Tramite");
		lblCodigoTramite.setFont(new Font("Candara", Font.BOLD, 21));
		lblCodigoTramite.setBounds(77, 124, 214, 23);
		contentPane.add(lblCodigoTramite);
		
		txtCodigoEx = new JTextField();
		txtCodigoEx.setColumns(10);
		txtCodigoEx.setBounds(308, 92, 141, 20);
		contentPane.add(txtCodigoEx);
		
		lblCodigo = new JLabel("C\u00F3digo de Expediente\r\n");
		lblCodigo.setFont(new Font("Candara", Font.BOLD, 21));
		lblCodigo.setBounds(77, 90, 256, 23);
		contentPane.add(lblCodigo);
		
		txtCodigoTramite = new JTextField();
		txtCodigoTramite.setColumns(10);
		txtCodigoTramite.setBounds(308, 126, 141, 20);
		contentPane.add(txtCodigoTramite);
		
		lblOficina = new JLabel("Oficina Remitente");
		lblOficina.setFont(new Font("Candara", Font.BOLD, 21));
		lblOficina.setBounds(77, 158, 214, 23);
		contentPane.add(lblOficina);
		
		lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Candara", Font.BOLD, 22));
		lblDocumento.setBounds(77, 200, 119, 20);
		contentPane.add(lblDocumento);
		
		cboDocumento = new JComboBox();
		cboDocumento.setModel(new DefaultComboBoxModel(new String[] {"Oficio", "Solicitud", "Modelos", "Instrucciones", "Reglamentos", "Revision", "Informe", "Carta", "Plan de Prevencion"}));
		cboDocumento.setToolTipText("");
		cboDocumento.setBounds(308, 197, 141, 23);
		contentPane.add(cboDocumento);
		
		btnDerivar = new JButton("Guardar");
		btnDerivar.setIcon(new ImageIcon(FrmAcceso.class.getResource("/Imagenes/ingresar.png")));

		btnDerivar.addActionListener(this);
		btnDerivar.setFont(new Font("Candara", Font.BOLD, 22));
		btnDerivar.setBounds(90, 428, 156, 46);
		contentPane.add(btnDerivar);
		
		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(FrmAcceso.class.getResource("/Imagenes/errorguardar.png")));

		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Candara", Font.BOLD, 22));
		btnCancelar.setBounds(264, 428, 174, 46);
		contentPane.add(btnCancelar);
		
		cboOficina = new JComboBox();
		cboOficina.setModel(new DefaultComboBoxModel(new String[] {"DGA", "DEIA"}));
		cboOficina.setBounds(308, 159, 141, 23);
		contentPane.add(cboOficina);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDerivar) {
			actionPerformedBtnDerivar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedButton_2(e);
		}
	}
	protected void actionPerformedButton_2(ActionEvent e) {
		dispose();
	}
	
	
	protected void actionPerformedBtnDerivar(ActionEvent e) {
		registrarExpediente();
	}

	 void registrarExpediente() {
			// variables
			int cod_exp;
			 String cod_tram,abrev_ofic,tipo_doc;
			
		
			
			//Entradas
			 cod_exp=leerCodigo();
			 cod_tram=leerCodigoTramite();
			 abrev_ofic=leerAbreviatura();
			 tipo_doc=leerDocumento();
	
			
		
			// procesos
			Tramite tr = new Tramite();
			tr.setCod_exp(cod_exp);
			tr.setCod_tram(cod_tram);
			tr.setAbrev_ofic(abrev_ofic);
			tr.setTipo_doc(tipo_doc);
			
			
			GestionTramite ge = new GestionTramite();
			
			int ok = ge.registrar(tr);
			// salidas
			if (ok==0)
			{
				Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/errorguardar.png")); 
				JOptionPane.showMessageDialog(null,"Error al ingresar","Registro de Expediente",JOptionPane.INFORMATION_MESSAGE,ico);

			}

			
			else
			{
				Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/ingresar.png")); 
				JOptionPane.showMessageDialog(null,"Ingreso OK ","Registro de Expediente",JOptionPane.INFORMATION_MESSAGE,ico);

			}
			

		}

	private String leerDocumento() {
		String doc;
		doc = cboDocumento.getSelectedItem().toString();		
		return doc;
	}

	private String leerAbreviatura() {
		String oficina;
		oficina = cboOficina.getSelectedItem().toString();		
		return oficina;
	}

	private String leerCodigoTramite() {
		return 	txtCodigoTramite.getText();
	}

	private int leerCodigo() {
		return Integer.parseInt(txtCodigoEx.getText());

	}

		  
	
	
	
	
	
	
}


