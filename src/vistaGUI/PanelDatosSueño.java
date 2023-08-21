package vistaGUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.Color;

import bean.ParametroTipo;
import bean.Sueño;
import bean.Usuario;
import bean.UsuarioSueño;
import logica.LSueño;
import logica.LUsuario;
import logica.LUsuarioSueño;
import java.awt.Font;

public class PanelDatosSueño extends JPanel implements ActionListener {
	private JTextField textHorasSueño;
	private JComboBox<String> comboBoxCalidadSub;
	private JComboBox<String> comboBoxAmbiente;
	private JTextField textLatencia;
	private JPanel panelC;
	private int id;
	private JButton btnGuardar;
	
	public PanelDatosSueño(JPanel panelC, int id) {
		
		this.panelC = panelC;
		this.id = id;
		
		setBackground(new Color(255, 234, 244));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(255, 234, 244));
		panelTitulo.setToolTipText("");
		panelSuperior.add(panelTitulo, BorderLayout.CENTER);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(255, 234, 244));
		add(panelInferior, BorderLayout.SOUTH);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(new Color(255, 234, 244));
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblHorasSueño = new JLabel("Horas de sueño");
		lblHorasSueño.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		lblHorasSueño.setBackground(new Color(255, 234, 244));
		panelCentro.add(lblHorasSueño);
		
		JLabel lblVacio = new JLabel("");
		panelCentro.add(lblVacio);
		
		textHorasSueño = new JTextField();
		textHorasSueño.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(textHorasSueño);
		textHorasSueño.setColumns(10);
		
		JLabel lblCalidadSubjetiva = new JLabel("Como consideras que ha sido la calidad de tu sueño");
		lblCalidadSubjetiva.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblCalidadSubjetiva);
		
		JLabel lblVacio1 = new JLabel("");
		panelCentro.add(lblVacio1);
		comboBoxCalidadSub = new JComboBox<>();
		comboBoxCalidadSub.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		comboBoxCalidadSub.setModel(new DefaultComboBoxModel(new String[] {"1. Mala", "2. Regular", "3. Buena", "4. Muy buena"}));
		panelCentro.add(comboBoxCalidadSub);
		
		JLabel lblLatencia = new JLabel("Latencia del sueño(tiempo aproximado que demoró en dormirse)");
		lblLatencia.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblLatencia);
		
		JLabel lblVacio2 = new JLabel("");
		panelCentro.add(lblVacio2);
		
		textLatencia = new JTextField();
		textLatencia.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(textLatencia);
		textLatencia.setColumns(10);
		
		JLabel lblAmbiente = new JLabel("¿Tuvo un buen ambiente de sueño?(Esto implica tener un colchón y una almohada cómodos, una temperatura adecuada en la habitación y niveles de ruido mínimos.)");
		lblAmbiente.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblAmbiente);
		
		JLabel lblVacio3 = new JLabel("");
		panelCentro.add(lblVacio3);
		
		comboBoxAmbiente = new JComboBox<String>();
		comboBoxAmbiente.setModel(new DefaultComboBoxModel(new String[] {"1. Si", "2. No"}));
		comboBoxAmbiente.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(comboBoxAmbiente);
		
		JLabel lblNewLabel = new JLabel("");
		panelCentro.add(lblNewLabel);
		
		JLabel lblVacio5 = new JLabel("");
		panelCentro.add(lblVacio5);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(204, 255, 255));
		btnGuardar.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		Color backgroundColor = btnGuardar.getBackground();
		Border border = BorderFactory.createLineBorder(backgroundColor);
		btnGuardar.setBorder(border);
		btnGuardar.addActionListener(this);
		panelCentro.add(btnGuardar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 234, 244));
		add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 234, 244));
		add(panel_1, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnGuardar) {

			Sueño sueño = new Sueño();
			LSueño lSueño = new LSueño();
			LUsuario lUsuario = new LUsuario();
			LUsuarioSueño lUsuarioSueño = new LUsuarioSueño();
			sueño = capturaDatos();
			lSueño.registrar(sueño);
			ParametroTipo<Boolean, Usuario> parametroT = lUsuario.buscar(id);
			UsuarioSueño usuarioSueño = new UsuarioSueño(parametroT.getObjeto2(), sueño);
			try {
				lUsuarioSueño.hacerComposicion(usuarioSueño);
			} catch (IOException e1) {
				e1.printStackTrace();
			}			
        }
		
	}//CIERRE DEL METODO
	
	public Sueño capturaDatos() {
		
		Sueño sueño = new Sueño();
		LSueño lSueño = new LSueño();
	    
		sueño.setDuracion(Float.parseFloat(textHorasSueño.getText()));
		sueño.setLatencia(Float.parseFloat(textLatencia.getText()));
		char opcionSeleccionada1 = (char) Character.getNumericValue(((String) comboBoxCalidadSub.getSelectedItem()).charAt(0));
		sueño.setCalidadSubjetiva((byte) opcionSeleccionada1);
		char opcionSeleccionada2 = (char) Character.getNumericValue(((String) comboBoxAmbiente.getSelectedItem()).charAt(0));
		sueño.setAmbiente((byte) opcionSeleccionada2);
		
		sueño = lSueño.calcularCalidadSueño(sueño);

	    sueño.setId(id);
	    sueño.setFecha(LocalDate.now());

	    return sueño;
	    
	}//CIERRE DEL METODO
	
}//CIERRE DE LA CLASE