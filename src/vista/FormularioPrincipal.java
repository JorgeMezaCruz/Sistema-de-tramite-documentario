package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionUsuario;
import model.Usuario;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Insets;

public class FormularioPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnConfiguracin;
	private JMenuItem mntmExpediente;
	private JMenu mnRegistros;
	private JMenuItem mntmNuevoExpediente;
	private JMenuItem mntmExpedientesRevisados;
	private JMenu mnTrmites;
	private JMenuItem mntmTramites;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioPrincipal frame = new FormularioPrincipal();
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
	public FormularioPrincipal() {
		setForeground(SystemColor.activeCaption);
		setTitle("SISTEMA DE TRAMITE DOCUMENTARIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 355);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setHorizontalAlignment(SwingConstants.CENTER);
		mnArchivo.setBackground(SystemColor.activeCaption);
		mnArchivo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnArchivo.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/archivo.png")));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setHorizontalAlignment(SwingConstants.CENTER);
		mntmSalir.setBackground(SystemColor.window);
		mntmSalir.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/salir.png")));
		mntmSalir.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnRegistros = new JMenu("Registros");
		mnRegistros.setHorizontalAlignment(SwingConstants.CENTER);
		mnRegistros.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/lista.png")));
		mnRegistros.setBackground(SystemColor.activeCaption);
		mnRegistros.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnRegistros);
		
		mntmNuevoExpediente = new JMenuItem("Nuevo Expediente");
		mntmNuevoExpediente.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/reporte.png")));
		mntmNuevoExpediente.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmNuevoExpediente.addActionListener(this);
		mnRegistros.add(mntmNuevoExpediente);
		
		mnTrmites = new JMenu("Tr\u00E1mites");
		mnTrmites.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/boleta.png")));
		mnTrmites.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnTrmites.setBackground(SystemColor.activeCaption);
		menuBar.add(mnTrmites);
		
		mntmTramites = new JMenuItem("Nuevo Tramite");
		mntmTramites.addActionListener(this);
		mntmTramites.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/stock.png")));
		mntmTramites.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmTramites.setBackground(Color.WHITE);
		mnTrmites.add(mntmTramites);

		
		
		
		mnConfiguracin = new JMenu("Consulta");
		mnConfiguracin.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/ayuda.png")));
		mnConfiguracin.setBackground(SystemColor.activeCaption);
		mnConfiguracin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnConfiguracin);
		
		mntmExpediente = new JMenuItem("Expedientes");
		mntmExpediente.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/consulta.png")));
		mntmExpediente.setBackground(SystemColor.window);
		mntmExpediente.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmExpediente.addActionListener(this);
		mnConfiguracin.add(mntmExpediente);
		
		mntmExpedientesRevisados = new JMenuItem("Expedientes Revisados");
		mntmExpedientesRevisados.addActionListener(this);
		mntmExpedientesRevisados.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/resetCli.png")));
		mntmExpedientesRevisados.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmExpedientesRevisados.setBackground(Color.WHITE);
		mnConfiguracin.add(mntmExpedientesRevisados);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null); 
		this.setUndecorated(true);
		


		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmTramites) {
			actionPerformedMntmTramites(arg0);
		}
		if (arg0.getSource() == mntmExpedientesRevisados) {
			actionPerformedMntmExpedientesRevisados(arg0);
		}

		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
		if (arg0.getSource() == mntmExpediente) {
			actionPerformedMntmExpediente(arg0);
		}
		if (arg0.getSource() == mntmNuevoExpediente) {
			actionPerformedmntmNuevoExpediente(arg0);
		}
		
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		DialogoSalir DS = new DialogoSalir();
		DS.setLocationRelativeTo(this);
		DS.setVisible(true);
		}

	
	protected void actionPerformedmntmNuevoExpediente(ActionEvent arg0) {
	Registro_Expediente nuevoreg = new Registro_Expediente();
	nuevoreg.setVisible(true);
	}
	
	protected void actionPerformedMntmExpediente(ActionEvent arg0) {
	VerExpedientes nuevoreg = new VerExpedientes();
	nuevoreg.setVisible(true);
	}


	protected void actionPerformedMntmExpedientesRevisados(ActionEvent arg0) {
		VerExpedientesRevisados expeRevi = new VerExpedientesRevisados();
		expeRevi.setVisible(true);
		
	}
	protected void actionPerformedMntmTramites(ActionEvent arg0) {
		Registro_Tramite regT = new Registro_Tramite();
		regT.setVisible(true);
	}
}
