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
import java.util.ArrayList;
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
import model.Usuario;

import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class VerExpedientes extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JButton button;
	private JLabel lblListadoDeExpedientes;
	private JButton btnDerivar;
	private JButton btnCancelar;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerExpedientes frame = new VerExpedientes();
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
	public VerExpedientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerExpedientes.class.getResource("/Imagenes/reporte.png")));
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
		
		lblListadoDeExpedientes = new JLabel("Listado de Expedientes");
		lblListadoDeExpedientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeExpedientes.setFont(new Font("Candara", Font.BOLD, 26));
		lblListadoDeExpedientes.setBounds(51, 28, 514, 33);
		contentPane.add(lblListadoDeExpedientes);
		
		btnDerivar = new JButton("Visualizar");
		btnDerivar.setIcon(new ImageIcon(FrmAcceso.class.getResource("/Imagenes/ingresar.png")));

		btnDerivar.addActionListener(this);
		btnDerivar.setFont(new Font("Candara", Font.BOLD, 22));
		btnDerivar.setBounds(126, 428, 156, 46);
		contentPane.add(btnDerivar);
		
		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(FrmAcceso.class.getResource("/Imagenes/errorguardar.png")));

		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Candara", Font.BOLD, 22));
		btnCancelar.setBounds(325, 428, 174, 46);
		contentPane.add(btnCancelar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 80, 514, 307);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
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
		mostrar();
	}

			



		  
	//VALIDACIONES

	 void mostrar() {
		GestionExpediente gu = new GestionExpediente();
		ArrayList<Expediente> resultado = gu.listado();
		
		if(resultado == null)
			txtS.setText("Lista Vacia......");
		else
		{
	
			
			txtS.setText("Codigo\tFecha de Registro\tFecha de Emision\tOrganismo\t\tApoderado\t\tTelefono\tEmail\t\tDescripcion\t\t\tSituacion\n");
			for (Expediente u: resultado) {
				txtS.append(u.getCod_exp()+ "\t"
													+u.getFecha_registro()+"\t"+"\t"
													+u.getFecha_emision()+"\t"+"\t"
													+u.getNom_organismo()+"\t"+"\t"
													+u.getApoderado_organismo()+"\t"+"\t"
													+u.getContacto_tlf()+"\t"
													+u.getContacto_email()+"\t"
													+u.getDescripcion_exp()+"\t"
													+u.getSituacion_exp()+"\n");
				
			}
		}
	}

	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
	}
}


