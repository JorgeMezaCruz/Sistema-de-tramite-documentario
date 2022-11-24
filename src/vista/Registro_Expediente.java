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
import model.Expediente;

import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class Registro_Expediente extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JButton button;
	private JLabel label;
	private JLabel lblFechaDeEmisin;
	private JTextField txtNombreOrganiz;
	private JLabel lblRaznSocial;
	private JTextField txtRepresentante;
	private JLabel label_3;
	private JTextField txtTelefono;
	private JLabel lblTelfono;
	private JTextField txtEmail;
	private JLabel label_5;
	private JTextField txtDescripcion;
	private JLabel label_6;
	private JLabel label_7;
	private JComboBox cboSituacion;
	private JButton btnDerivar;
	private JButton btnCancelar;
	private JDateChooser txtFechaEmision;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro_Expediente frame = new Registro_Expediente();
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
	public Registro_Expediente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registro_Expediente.class.getResource("/Imagenes/reporte.png")));
		setResizable(false);
		setTitle("Registro de Nuevo Expediente");
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
		
		label = new JLabel("NUEVO EXPEDIENTE EN MESA DE PARTES");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Candara", Font.BOLD, 26));
		label.setBounds(23, 23, 542, 33);
		contentPane.add(label);
		
		lblFechaDeEmisin = new JLabel(" Fecha de Emisi\u00F3n");
		lblFechaDeEmisin.setFont(new Font("Candara", Font.BOLD, 21));
		lblFechaDeEmisin.setBounds(29, 77, 214, 23);
		contentPane.add(lblFechaDeEmisin);
		
		txtNombreOrganiz = new JTextField();
		txtNombreOrganiz.addKeyListener(this);
		txtNombreOrganiz.setColumns(10);
		txtNombreOrganiz.setBounds(264, 105, 141, 20);
		contentPane.add(txtNombreOrganiz);
		
		lblRaznSocial = new JLabel("Raz\u00F3n Social");
		lblRaznSocial.setFont(new Font("Candara", Font.BOLD, 21));
		lblRaznSocial.setBounds(33, 103, 256, 23);
		contentPane.add(lblRaznSocial);
		
		txtRepresentante = new JTextField();
		txtRepresentante.addKeyListener(this);
		txtRepresentante.setColumns(10);
		txtRepresentante.setBounds(264, 136, 141, 20);
		contentPane.add(txtRepresentante);
		
		label_3 = new JLabel("Representante");
		label_3.setFont(new Font("Candara", Font.BOLD, 21));
		label_3.setBounds(33, 137, 214, 23);
		contentPane.add(label_3);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(this);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(264, 172, 141, 20);
		contentPane.add(txtTelefono);
		
		lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Candara", Font.BOLD, 21));
		lblTelfono.setBounds(33, 171, 164, 20);
		contentPane.add(lblTelfono);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(264, 204, 141, 20);
		contentPane.add(txtEmail);
		
		label_5 = new JLabel("Email");
		label_5.setFont(new Font("Candara", Font.BOLD, 21));
		label_5.setBounds(33, 203, 164, 20);
		contentPane.add(label_5);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 9));
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(264, 239, 301, 105);
		contentPane.add(txtDescripcion);
		
		label_6 = new JLabel("Descripci\u00F3n");
		label_6.setFont(new Font("Candara", Font.BOLD, 22));
		label_6.setBounds(33, 239, 119, 20);
		contentPane.add(label_6);
		
		label_7 = new JLabel("Situaci\u00F3n");
		label_7.setFont(new Font("Candara", Font.BOLD, 22));
		label_7.setBounds(33, 355, 119, 20);
		contentPane.add(label_7);
		
		cboSituacion = new JComboBox();
		cboSituacion.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Revisado"}));
		cboSituacion.setToolTipText("");
		cboSituacion.setBounds(264, 355, 141, 23);
		contentPane.add(cboSituacion);
		
		btnDerivar = new JButton(" Derivar");
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
		
		txtFechaEmision = new JDateChooser();
		txtFechaEmision.setBounds(266, 80, 139, 20);
		contentPane.add(txtFechaEmision);
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
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        // El email a validar
        String email = leerEmail();
        Matcher mather = pattern.matcher(email);
        if (mather.find() == true) {
    		registrarExpediente();
        } else {
			JOptionPane.showMessageDialog(null,"EMAIL INVÁLIDO","Registro de Expediente",JOptionPane.ERROR_MESSAGE);
        }
	}

	 void registrarExpediente() {
			// variables
			String fecha_emision,nom_organismo,apoderado_organismo,
			contacto_tlf,contacto_email,descripcion_exp,situacion_exp;
			
			
			//Entradas
			fecha_emision=leerFechaEmision();
			nom_organismo=leerNombreOrganismo();
			apoderado_organismo=leerNombreApoderado();
			contacto_tlf=leerTelefono();
			contacto_email=leerEmail();
			descripcion_exp=leerDescripcion();
			situacion_exp=leerSituacion();

			
		
			// procesos
			Expediente exp = new Expediente();
			exp.setFecha_emision(fecha_emision);
			exp.setNom_organismo(nom_organismo);
			exp.setApoderado_organismo(apoderado_organismo);
			exp.setContacto_tlf(contacto_tlf);
			exp.setContacto_email(contacto_email);
			exp.setDescripcion_exp(descripcion_exp);
			exp.setSituacion_exp(situacion_exp);
			

			GestionExpediente ge = new GestionExpediente();
			
			int ok = ge.registrar(exp);
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

	private String leerSituacion() {
		String documentos_cb;
		documentos_cb = cboSituacion.getSelectedItem().toString();		
		return documentos_cb;

	}

	private String leerDescripcion() {
		return txtDescripcion.getText();
	}

	private String leerEmail() {
		return txtEmail.getText();
	}

	private String leerTelefono() {
		return txtTelefono.getText();

	}

	private String leerNombreApoderado() {
		return txtRepresentante.getText();

	}

	private String leerNombreOrganismo() {
		return txtNombreOrganiz.getText();

	}

	private String leerFechaEmision() {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String fechavta= formato.format(txtFechaEmision.getDate());
		  return fechavta;
		  
		  
	//VALIDACIONES
		  
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtRepresentante) {
			keyTypedTxtRepresentante(arg0);
		}
		if (arg0.getSource() == txtTelefono) {
			keyTypedTxtTelefono(arg0);
		}
	}
	protected void keyTypedTxtTelefono(KeyEvent arg0) {
		char validacion = arg0.getKeyChar();
		
		if(Character.isLetter(validacion)){
			getToolkit().beep();
			arg0.consume();
			JOptionPane.showMessageDialog(rootPane, "INGRESAR SOLO NUMEROS");
	
		}
	}

	protected void keyTypedTxtRepresentante(KeyEvent arg0) {

		char validacion = arg0.getKeyChar();
		
		if(Character.isDigit(validacion)){
			getToolkit().beep();
			arg0.consume();
			JOptionPane.showMessageDialog(rootPane, "INGRESAR SOLO LETRAS");
		}
	}
	

	
	
	
	
	
	
}


