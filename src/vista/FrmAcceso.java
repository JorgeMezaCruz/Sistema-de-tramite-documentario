package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import mantenimientos.GestionUsuario;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

public class FrmAcceso extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JButton btnIngresar;
	private JButton btnSalir;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAcceso frame = new FrmAcceso();
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
	public FrmAcceso() {
		setTitle("CIBERFARMA - Acceso al Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, null, null, null));
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		
		
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setIcon(new ImageIcon(FrmAcceso.class.getResource("/Imagenes/user.png")));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(66, 33, 127, 39);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(248, 35, 142, 27);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setIcon(new ImageIcon(FrmAcceso.class.getResource("/Imagenes/password.png")));
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClave.setBounds(66, 108, 127, 39);
		contentPane.add(lblClave);
		
		txtClave = new JPasswordField();
		txtClave.addKeyListener(this);
		txtClave.setBounds(248, 116, 142, 27);
		contentPane.add(txtClave);

		
		btnIngresar = new JButton("  Ingresar");
		btnIngresar.addKeyListener(this);
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIngresar.setIcon(new ImageIcon(FrmAcceso.class.getResource("/Imagenes/ingresar.png")));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(57, 201, 162, 39);
		contentPane.add(btnIngresar);
		
		
		btnSalir = new JButton("  Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalir.setIcon(new ImageIcon(FrmAcceso.class.getResource("/Imagenes/salir.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(248, 201, 162, 39);
		contentPane.add(btnSalir);
		
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		valida();
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		System.exit(0);
	}

	
	//private void aviso(String msg) {
	//	JOptionPane.showMessageDialog(null, msg);		
	//}

	private String leerClave() {		
		return txtClave.getText();
	}

	private String leerUsuario() {
		return txtUsuario.getText();
	}
	
	void valida()
	{
	 String usuario,clave;
	 usuario= leerUsuario();
	 clave = leerClave();
	
	 GestionUsuario gu = new GestionUsuario();
	 Usuario u =gu.validaAcceso(usuario, clave);
	 if (u == null)
	 {
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/usererror.png")); 
		txtClave.setText(null);		 
		txtUsuario.setText(null);		 
		JOptionPane.showMessageDialog(null,"Contraseña Incorrecta","Error al Iniciar Sesión",JOptionPane.INFORMATION_MESSAGE,ico);
	 }		 
	 
	 else if (u.getPuesto()== "Tecnico Administrativo")
	 {
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/user.png")); 
		JOptionPane.showMessageDialog(null,"Bienvenido "+ u.getNombre(),"Inicio de Sesión",JOptionPane.INFORMATION_MESSAGE,ico);
		FormularioPrincipal p = new FormularioPrincipal();
		p.setVisible(true);
		dispose();
	 }
	 
	 else
	 {
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/user.png")); 
		JOptionPane.showMessageDialog(null,"Bienvenido "+ u.getNombre(),"Inicio de Sesión",JOptionPane.INFORMATION_MESSAGE,ico);
		FormularioPrincipal p = new FormularioPrincipal();
		p.setVisible(true);
		dispose();
	 }

	 
	}

	
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtClave) {
			keyPressedTxtClave(e);
		}
	}
	
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtClave) {
			keyTypedTxtClave(e);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtClave) {
			keyReleasedTxtClave(e);
		}
	}
	
	
	protected void keyPressedTxtClave(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			valida();
		}
	}

	protected void keyTypedTxtClave(KeyEvent e) {
		
		char key = e.getKeyChar();

		if(Character.isSpaceChar(key)) {
			e.consume();
			getToolkit().beep();
			Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/usererror.png")); 
			JOptionPane.showMessageDialog(null,"Valor no admitido","Error al iniciar sesión",JOptionPane.INFORMATION_MESSAGE,ico);
			txtClave.setText(null);		 
			txtUsuario.setText(null);		 
		}
	}

	protected void keyReleasedTxtClave(KeyEvent e) {
	}
}
