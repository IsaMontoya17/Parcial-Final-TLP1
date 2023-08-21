package vistaGUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;

import bean.Usuario;
import logica.LUsuario;

public class PanelRegistro extends JPanel implements ActionListener {

	private JTextField textIdentificacion;
	private JTextField textNombre;
	private JComboBox<String> comboBoxSexo;
	private JComboBox<String> comboBoxPlan;
	private JTextField textPeso;
	private JTextField textAltura;
	private JTextField textFechaNacimiento;
	private JTextField textCelular;
	private JTextField textCorreo;
	private JPanel panelC;

	public PanelRegistro(JPanel panelC) {

		this.panelC = panelC;

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
		panelCentro.setLayout(new GridLayout(11, 2, 0, 0));

		JLabel lblIdentificacion = new JLabel("Identificación");
		lblIdentificacion.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		lblIdentificacion.setBackground(new Color(255, 234, 244));
		panelCentro.add(lblIdentificacion);

		textIdentificacion = new JTextField();
		textIdentificacion.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(textIdentificacion);
		textIdentificacion.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblSexo);

		String[] opcionesSexo = { "1. Femenino", "2. Masculino" };
		comboBoxSexo = new JComboBox<>();
		comboBoxSexo.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		comboBoxSexo.setModel(new DefaultComboBoxModel<>(opcionesSexo));
		panelCentro.add(comboBoxSexo);

		JLabel lblPeso = new JLabel("Peso (Kg)");
		lblPeso.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblPeso);

		textPeso = new JTextField();
		textPeso.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(textPeso);
		textPeso.setColumns(10);

		JLabel lblCorreo = new JLabel("Correo electrónico");
		lblCorreo.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblCorreo);

		textCorreo = new JTextField();
		textCorreo.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(textCorreo);
		textCorreo.setColumns(10);

		JLabel lblAltura = new JLabel("Altura (m)");
		lblAltura.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblAltura);

		textAltura = new JTextField();
		textAltura.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(textAltura);
		textAltura.setColumns(10);

		JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento (AAAA-MM-DD)");
		lblFechaNacimiento.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblFechaNacimiento);

		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(textFechaNacimiento);
		textFechaNacimiento.setColumns(10);

		JLabel lblTelefonoCelular = new JLabel("Telefono celular");
		lblTelefonoCelular.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblTelefonoCelular);

		textCelular = new JTextField();
		textCelular.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(textCelular);
		textCelular.setColumns(10);

		JLabel lblPlanSeguimiento = new JLabel("Plan de seguimiento");
		lblPlanSeguimiento.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblPlanSeguimiento);

		String[] opcionesSeguimiento = { "1. Actividad física", "2. Alimentación", "3. Sueño" };
		comboBoxPlan = new JComboBox<>();
		comboBoxPlan.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		comboBoxPlan.setModel(new DefaultComboBoxModel<>(opcionesSeguimiento));
		panelCentro.add(comboBoxPlan);

		JLabel lblNewLabel_4 = new JLabel();
		panelCentro.add(lblNewLabel_4);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(255, 128, 191));
		btnRegistrar.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		Color backgroundColor = btnRegistrar.getBackground();
		Border border = BorderFactory.createLineBorder(backgroundColor);
		btnRegistrar.setBorder(border);
		btnRegistrar.addActionListener(this);
		panelCentro.add(btnRegistrar);

		JLabel lblNewLabel_6 = new JLabel();
		panelCentro.add(lblNewLabel_6);

		JLabel lblNewLabel_8 = new JLabel();
		panelCentro.add(lblNewLabel_8);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 234, 244));
		add(panel, BorderLayout.WEST);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 234, 244));
		add(panel_1, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Registrar")) {
			if (validarCampos()) {
				Usuario usuario = capturaDatos();
				LUsuario lUsuario = new LUsuario();
				lUsuario.registrar(usuario);
				panelC.remove(this);
				panelC.revalidate();
				panelC.repaint();
			}
		}

	}//CIERRE DEL METODO

	public boolean validarCampos() {
		String identificacion = textIdentificacion.getText();
		String nombre = textNombre.getText();
		String peso = textPeso.getText();
		String correo = textCorreo.getText();
		String altura = textAltura.getText();
		String fechaNacimiento = textFechaNacimiento.getText();
		String celular = textCelular.getText();

		if (identificacion.isEmpty() || nombre.isEmpty() || peso.isEmpty() || correo.isEmpty() || altura.isEmpty()
				|| fechaNacimiento.isEmpty() || celular.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!identificacion.matches("[0-9]+")) {
			JOptionPane.showMessageDialog(this, "La identificación debe ser un número entero.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!peso.matches("[0-9]+(\\.[0-9]+)?")) {
			JOptionPane.showMessageDialog(this, "El peso debe ser un número válido.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!altura.matches("[0-9]+(\\.[0-9]+)?")) {
			JOptionPane.showMessageDialog(this, "La altura debe ser un número válido.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!fechaNacimiento.matches("\\d{4}-\\d{2}-\\d{2}")) {
			JOptionPane.showMessageDialog(this, "El formato de la fecha de nacimiento debe ser AAAA-MM-DD.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!celular.matches("[0-9]+")) {
			JOptionPane.showMessageDialog(this, "El número de celular debe ser un número entero.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
		
	}//CIERRE DEL METODO

	public Usuario capturaDatos() {

		Usuario usuario = new Usuario();
		usuario.setIdentificacion(Integer.parseInt(textIdentificacion.getText()));
		usuario.setNombre(textNombre.getText());
		char opcionSeleccionada = (char) Character.getNumericValue(((String) comboBoxSexo.getSelectedItem()).charAt(0));
		usuario.setSexo((byte) opcionSeleccionada);
		usuario.setPeso(Float.parseFloat(textPeso.getText()));
		char opcionSeleccionada1 = (char) Character.getNumericValue(((String) comboBoxPlan.getSelectedItem()).charAt(0));
		usuario.setPlanSeguimiento((byte) opcionSeleccionada1);
		usuario.setCorreoElectronico(textCorreo.getText());
		usuario.setAltura(Float.parseFloat(textAltura.getText()));
		usuario.setFechaNacimiento(LocalDate.parse(textFechaNacimiento.getText()));
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(usuario.getFechaNacimiento(), fechaActual);
		int edad = periodo.getYears();
		usuario.setEdad((byte) edad);
		usuario.setTelefonoCelular(textCelular.getText());

		return usuario;

	}//CIERRE DEL METODO
	
}//CIERRE DE LA CLASE
