package vistaGUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import logica.LActividadFisica;
import logica.LDieta;
import logica.LSexo;
import logica.LSueño;
import logica.LUsuario;
import logica.LUsuarioActFisica;
import logica.LUsuarioDieta;
import logica.LUsuarioSueño;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;

public class PanelMenuProgramador extends JPanel implements ActionListener {

	private JButton btnListarUsuario;
	private JButton btnRegistroSueño;
	private JButton btnRegistroActFisica;
	private JButton btnRegistroDieta;
	private JButton btnCUsuarioActFisica;
	private JButton btnCUsuarioSueño;
	private JButton btnPolimorfismo;
	private JPanel panelCentro;

	/**
	 * Create the panel.
	 */
	public PanelMenuProgramador() {
		setBackground(new Color(255, 234, 244));
		setForeground(new Color(0, 0, 128));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 234, 244));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 234, 244));
		panel.add(panel_4, BorderLayout.NORTH);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 234, 244));
		panel_5.add(panel_7, BorderLayout.EAST);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 234, 244));
		panel_5.add(panel_6, BorderLayout.WEST);

		JPanel panelOpciones = new JPanel();
		panelOpciones.setBackground(new Color(255, 234, 244));
		panel_5.add(panelOpciones, BorderLayout.CENTER);
		panelOpciones.setLayout(new GridLayout(0, 7, 0, 0));

		btnListarUsuario = new JButton("Listar registros usuario");
		btnListarUsuario.setBackground(new Color(255, 255, 255));
		btnListarUsuario.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		Color backgroundColor = btnListarUsuario.getBackground();
		Border border = BorderFactory.createLineBorder(backgroundColor);
		btnListarUsuario.setBorder(border);
		btnListarUsuario.addActionListener(this);
		panelOpciones.add(btnListarUsuario);

		btnRegistroSueño = new JButton("Listar registros sueño");
		btnRegistroSueño.setBackground(new Color(255, 255, 255));
		btnRegistroSueño.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnRegistroSueño.setBorder(border);
		btnRegistroSueño.addActionListener(this);
		panelOpciones.add(btnRegistroSueño);

		btnRegistroActFisica = new JButton("Listar registros actividad fisica");
		btnRegistroActFisica.setBackground(new Color(255, 255, 255));
		btnRegistroActFisica.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnRegistroActFisica.setBorder(border);
		btnRegistroActFisica.addActionListener(this);
		panelOpciones.add(btnRegistroActFisica);

		btnRegistroDieta = new JButton("Listar registros dieta");
		btnRegistroDieta.setBackground(new Color(255, 255, 255));
		btnRegistroDieta.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnRegistroDieta.setBorder(border);
		btnRegistroDieta.addActionListener(this);
		panelOpciones.add(btnRegistroDieta);

		btnCUsuarioActFisica = new JButton("Listar composición registros UsuarioActFisica");
		btnCUsuarioActFisica.setBackground(new Color(255, 255, 255));
		btnCUsuarioActFisica.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnCUsuarioActFisica.setBorder(border);
		btnCUsuarioActFisica.addActionListener(this);
		panelOpciones.add(btnCUsuarioActFisica);

		btnCUsuarioSueño = new JButton("Listar composición registros UsuarioSueño");
		btnCUsuarioSueño.setBackground(new Color(255, 255, 255));
		btnCUsuarioSueño.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnCUsuarioSueño.setBorder(border);
		btnCUsuarioSueño.addActionListener(this);
		panelOpciones.add(btnCUsuarioSueño);

		btnPolimorfismo = new JButton("Listar ordenado por sexo");
		btnPolimorfismo.setBackground(new Color(255, 255, 255));
		btnPolimorfismo.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnPolimorfismo.setBorder(border);
		btnPolimorfismo.addActionListener(this);
		panelOpciones.add(btnPolimorfismo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 234, 244));
		add(panel_1, BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 234, 244));
		add(panel_2, BorderLayout.WEST);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 234, 244));
		add(panel_3, BorderLayout.EAST);

		panelCentro = new JPanel();
		panelCentro.setBackground(new Color(255, 234, 244));
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		LUsuarioSueño lUsuarioSueño = new LUsuarioSueño();
		LUsuarioDieta lUsuarioDieta = new LUsuarioDieta();
		LActividadFisica lActividadFisica = new LActividadFisica();
		LDieta lDieta = new LDieta();
		LSueño lSueño = new LSueño();
		LUsuario lUsuario = new LUsuario();
		LUsuarioActFisica lUsuarioActFisica = new LUsuarioActFisica();
		ArrayList<String> listaRegistrosUsuarioSueño = new ArrayList<>();
		ArrayList<String> listaRegistrosUsuarioDieta = new ArrayList<>();
		ArrayList<String> listaRegistrosUsuarioActFisica = new ArrayList<>();
		ArrayList<String> listaRegistrosUsuarioObjetivo = new ArrayList<>();
		ArrayList<String> listaRegistrosSueño = new ArrayList<>();
		ArrayList<String> listaRegistrosDieta = new ArrayList<>();
		ArrayList<String> listaRegistrosActFisica = new ArrayList<>();
		ArrayList<String> listaRegistrosUsuario = new ArrayList<>();

		if (e.getSource() == btnListarUsuario) {
			panelCentro.removeAll();
			listaRegistrosUsuario = lUsuario.listarArchivo(panelCentro);
			lUsuario.deserializacion(panelCentro);
			panelCentro.revalidate();
			panelCentro.repaint();
		}

		if (e.getSource() == btnRegistroSueño) {
			panelCentro.removeAll();
			listaRegistrosSueño = lSueño.listarArchivo(panelCentro);
			lSueño.deserializacion(panelCentro);
			panelCentro.revalidate();
			panelCentro.repaint();
		}

		if (e.getSource() == btnRegistroActFisica) {
			panelCentro.removeAll();
			listaRegistrosActFisica = lActividadFisica.listarArchivo(panelCentro);
			lActividadFisica.deserializacion(panelCentro);
			panelCentro.revalidate();
			panelCentro.repaint();
		}

		if (e.getSource() == btnRegistroDieta) {
			panelCentro.removeAll();
			listaRegistrosDieta = lDieta.listarArchivo(panelCentro);
			lDieta.deserializacion(panelCentro);
			panelCentro.revalidate();
			panelCentro.repaint();
		}

		if (e.getSource() == btnCUsuarioActFisica) {

			panelCentro.removeAll();

			try {
				listaRegistrosUsuarioActFisica = lUsuarioActFisica.listarArchivoPlanoAleatorio(panelCentro);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			lUsuarioActFisica.deserializacion(panelCentro);

			panelCentro.revalidate();
			panelCentro.repaint();

		}

		if (e.getSource() == btnCUsuarioSueño) {

			panelCentro.removeAll();
			try {
				listaRegistrosUsuarioSueño = lUsuarioSueño.listarArchivoPlanoAleatorio(panelCentro);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			lUsuarioSueño.deserializacion(panelCentro);

			panelCentro.revalidate();
			panelCentro.repaint();
		}

		if (e.getSource() == btnPolimorfismo){
			
			LSexo lSexo = new LSexo();

			panelCentro.removeAll();
			lSexo.ordenarSegunSexo(panelCentro);
			panelCentro.revalidate();
			panelCentro.repaint();

		}

	}//CIERRE DEL METODO

}// CIERRE DE LA CLASE
