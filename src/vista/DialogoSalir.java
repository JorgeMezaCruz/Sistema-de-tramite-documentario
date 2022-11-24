package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class DialogoSalir extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lbldeseaSalirDe;
	private JRadioButton rdbtnSiDeseoSalir;
	private JRadioButton rdbtnNoDeseoQuedarme;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoSalir dialog = new DialogoSalir();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoSalir() {
		setModal(true);
		setResizable(false);
		setTitle("Confirmaci\u00F3n de Salida");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoSalir.class.getResource("/Imagenes/salir.png")));
		setBounds(100, 100, 389, 208);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lbldeseaSalirDe = new JLabel("\u00BFDesea salir de la aplicaci\u00F3n?");
		lbldeseaSalirDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbldeseaSalirDe.setBounds(59, 11, 265, 33);
		contentPanel.add(lbldeseaSalirDe);
		
		rdbtnSiDeseoSalir = new JRadioButton("Si, deseo salir.");
		rdbtnSiDeseoSalir.addActionListener(this);
		rdbtnSiDeseoSalir.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		rdbtnSiDeseoSalir.setBounds(29, 76, 109, 23);
		contentPanel.add(rdbtnSiDeseoSalir);
		
		rdbtnNoDeseoQuedarme = new JRadioButton("No, deseo quedarme.");
		rdbtnNoDeseoQuedarme.addActionListener(this);
		rdbtnNoDeseoQuedarme.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		rdbtnNoDeseoQuedarme.setBounds(29, 102, 150, 23);
		contentPanel.add(rdbtnNoDeseoQuedarme);
		
		btnAceptar = new JButton("  Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setIcon(new ImageIcon(DialogoSalir.class.getResource("/Imagenes/ingresar.png")));
		btnAceptar.setBounds(213, 77, 129, 40);
		contentPanel.add(btnAceptar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == rdbtnNoDeseoQuedarme) {
			actionPerformedRdbtnNoDeseoQuedarme(arg0);
		}
		if (arg0.getSource() == rdbtnSiDeseoSalir) {
			actionPerformedRdbtnSiDeseoSalir(arg0);
		}
	}
	protected void actionPerformedRdbtnSiDeseoSalir(ActionEvent arg0) {
		if(rdbtnSiDeseoSalir.isSelected())
			rdbtnNoDeseoQuedarme.setSelected(false);
		
	}
	protected void actionPerformedRdbtnNoDeseoQuedarme(ActionEvent arg0) {
		if(rdbtnNoDeseoQuedarme.isSelected())
			rdbtnSiDeseoSalir.setSelected(false);
		
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		
		if(rdbtnSiDeseoSalir.isSelected())
			System.exit(0);
		else
			dispose();
	}
}
