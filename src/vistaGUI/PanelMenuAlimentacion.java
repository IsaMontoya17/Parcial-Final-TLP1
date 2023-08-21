package vistaGUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import bean.ActividadFisica;
import bean.Dieta;
import bean.ParametroTipo;
import bean.Usuario;
import bean.UsuarioActFisica;
import bean.UsuarioDieta;
import logica.LDieta;
import logica.LUsuario;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class PanelMenuAlimentacion extends JPanel implements ActionListener {

	private JButton btnRegistroAlimentación;
	private JButton btnCalorias;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnPerfil;
	private JPanel panelCentroDer;
	private JPanel panelCentroIzq;
	private JPanel panelCentro;
	private JButton btnListar;
	private JButton btnRegreso;
	private int id;

	/**
	 * Create the panel.
	 */
	public PanelMenuAlimentacion(int id) {
		setBackground(new Color(255, 234, 244));
		
		this.id = id;
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

		btnRegistroAlimentación = new JButton("Registrar alimentación");
		btnRegistroAlimentación.setBackground(new Color(181, 255, 218));
		btnRegistroAlimentación.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		Color backgroundColor = btnRegistroAlimentación.getBackground();
		Border border = BorderFactory.createLineBorder(backgroundColor);
		btnRegistroAlimentación.setBorder(border);		
		btnRegistroAlimentación.addActionListener(this);
		
		btnRegreso = new JButton("Regresar");
		btnRegreso.setBackground(new Color(181, 255, 218));
		btnRegreso.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnRegreso.setBorder(border);
		btnRegreso.addActionListener(this);
		panelOpciones.add(btnRegreso);
		panelOpciones.add(btnRegistroAlimentación);

		btnCalorias = new JButton("Calcular calorias consumidas");
		btnCalorias.setBackground(new Color(181, 255, 218));
		btnCalorias.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnCalorias.setBorder(border);		
		btnCalorias.addActionListener(this);
		panelOpciones.add(btnCalorias);

		btnModificar = new JButton("Modificar registro de actividad fisica");
		btnModificar.setBackground(new Color(181, 255, 218));
		btnModificar.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnModificar.setBorder(border);		
		btnModificar.addActionListener(this);
		panelOpciones.add(btnModificar);

		btnEliminar = new JButton("Eliminar registro de actividad fisica");
		btnEliminar.setBackground(new Color(181, 255, 218));
		btnEliminar.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnEliminar.setBorder(border);		
		btnEliminar.addActionListener(this);
		panelOpciones.add(btnEliminar);

		btnPerfil = new JButton("Perfil");
		btnPerfil.setBackground(new Color(181, 255, 218));
		btnPerfil.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnPerfil.setBorder(border);		
		btnPerfil.addActionListener(this);
		
		btnListar = new JButton("Ver mi seguimiento");
		btnListar.setBackground(new Color(181, 255, 218));
		btnListar.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnListar.setBorder(border);		
		btnListar.addActionListener(this);
		panelOpciones.add(btnListar);
		panelOpciones.add(btnPerfil);

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
		
		panelCentroIzq = new JPanel();
		panelCentro.add(panelCentroIzq, BorderLayout.WEST);
		panelCentroIzq.setLayout(new BorderLayout(0, 0));
		
		panelCentroDer = new JPanel();
		panelCentro.add(panelCentroDer, BorderLayout.EAST);
		panelCentroDer.setLayout(new BorderLayout(0, 0));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		LDieta lDieta = new LDieta();
		Dieta dieta = new Dieta();
		boolean dietaEliminada = false;
		
		if (e.getSource() == btnRegistroAlimentación) {

			panelCentroDer.removeAll();			
			PanelDatosAlimentacion panelDatosALimentacion = new PanelDatosAlimentacion(panelCentroDer, id);

			lDieta.listar("./datos/Dieta/ListaAlimentos.txt", panelCentroIzq);
			panelCentroDer.add(panelDatosALimentacion);
			panelCentroIzq.setPreferredSize(new Dimension(150, 300));
			panelCentroDer.setPreferredSize(new Dimension(150, 300));
			panelCentro.removeAll();
			panelCentro.add(panelCentroIzq, BorderLayout.NORTH);
			panelCentro.add(panelCentroDer, BorderLayout.SOUTH);
			panelCentro.revalidate();
			panelCentro.repaint();

		}

		if (e.getSource() == btnCalorias && dietaEliminada==false) {

			panelCentro.removeAll();
			LocalDate fecha = LocalDate.now();
			ParametroTipo<Boolean, Dieta> parametroT = lDieta.buscar(fecha);
			String mensaje = "Calorías consumidas: " + parametroT.getObjeto2().getCaloriasTotales() + " calorías";
			JOptionPane.showMessageDialog(PanelMenuAlimentacion.this, mensaje, "Resultado",
					JOptionPane.INFORMATION_MESSAGE);
			panelCentro.repaint();

		}

		if (e.getSource() == btnModificar && dietaEliminada==false) {

			panelCentro.removeAll();
			String fechaRegistro = JOptionPane.showInputDialog(null, "Ingrese la fecha del registro que desea modificar (yyyy-MM-dd):");
			LocalDate fecha = LocalDate.parse(fechaRegistro);
			ParametroTipo<Boolean, Dieta> parametroT = lDieta.buscar(fecha);
			boolean existe = parametroT.getObjeto1();
			dieta = parametroT.getObjeto2();
			if (existe) {
				lDieta.modificar(dieta);
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró ninguna actividad física para la fecha especificada.");
			}
			panelCentro.repaint();

		}

		if (e.getSource() == btnEliminar) {

			panelCentro.removeAll();
			String fechaRegistro = JOptionPane.showInputDialog(null, "Ingrese la fecha del registro que desea eliminar (yyyy-MM-dd):");
			LocalDate fecha = LocalDate.parse(fechaRegistro);
			ParametroTipo<Boolean, Dieta> parametroT = lDieta.buscar(fecha);
			Dieta dietaEliminar = parametroT.getObjeto2();
			lDieta.eliminar(dietaEliminar);
			panelCentro.repaint();
			dietaEliminada=true;

		}

		if (e.getSource() == btnPerfil) {

			panelCentro.removeAll();
			PanelMenuPerfil panelMenuPerfil = new PanelMenuPerfil(id);
			panelCentro.setLayout(new BorderLayout());
			panelCentro.add(panelMenuPerfil, BorderLayout.CENTER);
			panelCentro.revalidate();
			panelCentro.repaint();

		}
		
		if(e.getSource() == btnListar && dietaEliminada==false) {
			
	    	panelCentro.removeAll();
	    	lDieta.buscarRegistrosPorID(id, "./datos/Dieta/IngresoDieta.txt", panelCentro);
	    	panelCentro.revalidate();
            panelCentro.repaint();
            
	    }
		
		if (e.getSource() == btnRegreso) {

			panelCentro.removeAll();
			PanelRegreso panelInicio = new PanelRegreso();
			panelCentro.setLayout(new BorderLayout());
			panelCentro.add(panelInicio, BorderLayout.CENTER);
			panelCentro.revalidate();
			panelCentro.repaint();
		}

	}//CIERRE DEL METODO

}//CIERRE DE LA CLASE
