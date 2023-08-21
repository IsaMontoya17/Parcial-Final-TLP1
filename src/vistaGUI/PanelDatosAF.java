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

import bean.ActividadFisica;
import bean.ParametroTipo;
import bean.Usuario;
import bean.UsuarioActFisica;
import logica.LActividadFisica;
import logica.LCronometro;
import logica.LUsuario;
import logica.LUsuarioActFisica;
import java.awt.Font;

public class PanelDatosAF extends JPanel implements ActionListener {
	private JTextField textOpcion;
	private JComboBox<String> comboBoxRespuesta;
	private JTextField textDesplazamiento;
	private JPanel panelC;
	private int id;
	private JButton btnGuardar;
	private JButton btnInicio;
	private JButton btnFin;
	
	public PanelDatosAF(JPanel panelC, int id) {
		
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
		
		JLabel lblOpcion = new JLabel("Escriba una opción: ");
		lblOpcion.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		lblOpcion.setBackground(new Color(255, 234, 244));
		panelCentro.add(lblOpcion);
		
		JLabel lblVacio = new JLabel("");
		panelCentro.add(lblVacio);
		
		textOpcion = new JTextField();
		textOpcion.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(textOpcion);
		textOpcion.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Cronometro");
		lblDuracion.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblDuracion);
		
		btnInicio = new JButton("Iniciar");
		btnInicio.setBackground(new Color(255, 255, 189));
		btnInicio.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		btnInicio.addActionListener(this);
		panelCentro.add(btnInicio);
		
		btnFin = new JButton("Finalizar");
		btnFin.setBackground(new Color(255, 255, 189));
		btnFin.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		btnFin.addActionListener(this);
		panelCentro.add(btnFin);
		
		JLabel lblRespuesta = new JLabel("¿Se ha desplazado al hacer la actividad física?");
		lblRespuesta.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblRespuesta);
		
		JLabel lblVacio1 = new JLabel("");
		panelCentro.add(lblVacio1);
		comboBoxRespuesta = new JComboBox<>();
		comboBoxRespuesta.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		comboBoxRespuesta.setModel(new DefaultComboBoxModel(new String[] {"1. Si", "2. No"}));
		panelCentro.add(comboBoxRespuesta);
		
		JLabel lblRecorrido = new JLabel("En caso de haberse desplazado, ingrese la distancia recorrida aproximadamente en km:");
		lblRecorrido.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblRecorrido);
		
		JLabel lblVacio2 = new JLabel("");
		panelCentro.add(lblVacio2);
		
		textDesplazamiento = new JTextField();
		textDesplazamiento.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(textDesplazamiento);
		textDesplazamiento.setColumns(10);
		
		JLabel lblVacio3 = new JLabel("");
		panelCentro.add(lblVacio3);
		
		JLabel lblVacio5 = new JLabel("");
		panelCentro.add(lblVacio5);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(255, 255, 189));
		btnGuardar.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnGuardar.addActionListener(this);
		panelCentro.add(btnGuardar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 234, 244));
		add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 234, 244));
		add(panel_1, BorderLayout.EAST);
	}
	
	LCronometro lCronometro = new LCronometro();

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnGuardar) {

			ActividadFisica actividadFisica = new ActividadFisica();
			LActividadFisica lActividadFisica = new LActividadFisica();	
			LUsuario lUsuario = new LUsuario();
			LUsuarioActFisica lUsuarioActFisica = new LUsuarioActFisica();
			actividadFisica = capturaDatos();
			String clasificacion="";
			clasificacion = lActividadFisica.clasificacionActFisica(Short.parseShort(actividadFisica.getTipoActividad()));
			actividadFisica.setTipoActividad(clasificacion);
			lActividadFisica.registrar(actividadFisica);
			ParametroTipo<Boolean, Usuario> parametroT = lUsuario.buscar(id);
			UsuarioActFisica usuarioActFisica = new UsuarioActFisica(parametroT.getObjeto2(), actividadFisica);
			try {
				lUsuarioActFisica.hacerComposicion(usuarioActFisica);
			} catch (IOException e1) {
				e1.printStackTrace();
			}			
        }
		
		if (e.getSource() == btnInicio) {
			lCronometro.iniciarCronometro();
        }
		
		if (e.getSource() == btnFin) {
			lCronometro.detenerCronometro();
            double tiempo = (double) lCronometro.getTiempoTranscurrido() / 1000.0;
            lCronometro.setTiempoTranscurrido(tiempo);
        }
		
	}//CIERRE DEL METODO
	
	public ActividadFisica capturaDatos() {
		
	    ActividadFisica actividadFisica = new ActividadFisica();
	    actividadFisica.setTipoActividad(textOpcion.getText());

	    String desplazamientoText = textDesplazamiento.getText();
	    float desplazamiento = (desplazamientoText.isEmpty()) ? 0 : Float.parseFloat(desplazamientoText);
	    actividadFisica.setDistanciaRecorrida(desplazamiento);

	    actividadFisica.setDuracion(lCronometro.getTiempoTranscurrido());
	    actividadFisica.setId(id);
	    actividadFisica.setFecha(LocalDate.now());

	    return actividadFisica;
	    
	}//CIERRE DEL METODO
	
}//CIERRE DE LA CLASE
