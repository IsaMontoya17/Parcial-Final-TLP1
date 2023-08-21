package vistaGUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import bean.Dieta;
import bean.ParametroTipo;
import bean.Usuario;
import bean.UsuarioDieta;
import logica.LDieta;
import logica.LUsuario;
import logica.LUsuarioDieta;
import java.awt.Font;

public class PanelDatosAlimentacion extends JPanel implements ActionListener {
	private JTextField textOpcion;
	private JPanel panelC;
	private int id;
	private JButton btnGuardar;
	private ArrayList<String> opciones;
	private JPanel panelCentro;

	public PanelDatosAlimentacion(JPanel panelC, int id) {

		this.panelC = panelC;
		this.id = id;
		this.opciones = new ArrayList<>();

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

		panelCentro = new JPanel();
		panelCentro.setBackground(new Color(255, 234, 244));
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel lblOpcion = new JLabel("Escriba una opción: ");
		lblOpcion.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		lblOpcion.setBackground(new Color(255, 234, 244));
		panelCentro.add(lblOpcion);

		textOpcion = new JTextField();
		textOpcion.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(textOpcion);
		textOpcion.setColumns(10);

		JLabel lblVacio5 = new JLabel("");
		panelCentro.add(lblVacio5);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(181, 255, 218));
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
	
	Dieta dieta = new Dieta();

	@Override
	public void actionPerformed(ActionEvent e) {
	    LDieta lDieta = new LDieta();
	    LUsuario lUsuario = new LUsuario();
	    LUsuarioDieta lUsuarioDieta = new LUsuarioDieta();
	    dieta.setId(id);

	    if (e.getSource() == btnGuardar) {
	        String alimento = textOpcion.getText().trim();
	        if (!alimento.isEmpty()) {
	            try {
	                byte opcion = Byte.parseByte(alimento);
	                if (opcion <= 100) {
	                    dieta.getAlimentosConsumidos().add(opcion);
	                    short calorias = lDieta.buscarNumeroEnArchivo(opcion);
	                    dieta.getCaloriasAlimentos().add(calorias);
	                    textOpcion.setText("");
	                    String pregunta = "¿Desea ingresar otra opción?";
	                    String[] opcionesRespuesta = { "Sí", "No" };
	                    int respuesta = JOptionPane.showOptionDialog(this, pregunta, "Ingresar otra opción",
	                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesRespuesta,
	                            opcionesRespuesta[0]);
	                    if (respuesta == JOptionPane.NO_OPTION) {
	                        Short caloriasTotales = lDieta.calcularCalorias(dieta);
	                        dieta.setCaloriasTotales(caloriasTotales);
	                        lDieta.registrar(dieta);
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(this, "El número ingresado debe ser dentro del rango válido", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            } catch (NumberFormatException ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(this, "Debe ingresar un número válido", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } else {
	            JOptionPane.showMessageDialog(this, "Debe ingresar un número", "Error", JOptionPane.ERROR_MESSAGE);
	        }

	        ParametroTipo<Boolean, Usuario> pT = lUsuario.buscar(id);
	        UsuarioDieta usuarioDieta = new UsuarioDieta(pT.getObjeto2(), dieta);
	        try {
	            lUsuarioDieta.hacerComposicion(usuarioDieta);
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	    }
	    
	}//CIERRE DEL METODO
	
}//CIERRE DE LA CLASE

