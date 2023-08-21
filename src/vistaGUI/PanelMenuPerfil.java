package vistaGUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import bean.ParametroTipo;
import bean.Usuario;
import logica.LActividadFisica;
import logica.LDieta;
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

public class PanelMenuPerfil extends JPanel implements ActionListener {

	private JButton btnMostarDatos;
	private JButton btnCambiarDatos;
	private JButton btnCambiarPlanSeguimiento;
	private JButton btnEliminarCuenta;
	private int id;
	private JPanel panelCentro;
	
	/**
	 * Create the panel.
	 */
	public PanelMenuPerfil(int id) {
		
		this.id = id;
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
		panelOpciones.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnMostarDatos = new JButton("Mostrar datos personales");
		btnMostarDatos.setBackground(new Color(224, 193, 255));
		btnMostarDatos.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		Color backgroundColor = btnMostarDatos.getBackground();
		Border border = BorderFactory.createLineBorder(backgroundColor);
		btnMostarDatos.setBorder(border);
		btnMostarDatos.addActionListener(this);
		panelOpciones.add(btnMostarDatos);
		
		btnCambiarDatos = new JButton("Cambiar datos personales");
		btnCambiarDatos.setBackground(new Color(224, 193, 255));
		btnCambiarDatos.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnCambiarDatos.setBorder(border);
		btnCambiarDatos.addActionListener(this);
		panelOpciones.add(btnCambiarDatos);
		
		btnCambiarPlanSeguimiento = new JButton("Cambiar plan de seguimiento");
		btnCambiarPlanSeguimiento.setBackground(new Color(224, 193, 255));
		btnCambiarPlanSeguimiento.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnCambiarPlanSeguimiento.setBorder(border);
		btnCambiarPlanSeguimiento.addActionListener(this);
		panelOpciones.add(btnCambiarPlanSeguimiento);
		
		btnEliminarCuenta = new JButton("Eliminar cuenta");
		btnEliminarCuenta.setBackground(new Color(224, 193, 255));
		btnEliminarCuenta.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnEliminarCuenta.setBorder(border);
		btnEliminarCuenta.addActionListener(this);
		panelOpciones.add(btnEliminarCuenta);
		
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

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Usuario usuario = new Usuario();
        LUsuario lUsuario = new LUsuario();
        ParametroTipo<Boolean, Usuario> parametroT = lUsuario.buscar(id);
        boolean usuarioEliminado = false;
		
		if (e.getSource() == btnMostarDatos && usuarioEliminado==false) {
			lUsuario.MostrarUsuario(id, panelCentro);
		}
		
		if(e.getSource() == btnCambiarDatos && usuarioEliminado==false) {			
			 usuario = parametroT.getObjeto2();
	         lUsuario.modificar(usuario);
	         JOptionPane.showMessageDialog(null, "Usuario modificado: ");
	         lUsuario.MostrarUsuario(id, panelCentro);
		}
		
		if(e.getSource() == btnCambiarPlanSeguimiento && usuarioEliminado==false) {
			usuario = parametroT.getObjeto2();
			lUsuario.cambiarPlanSeguimiento(usuario);
			JOptionPane.showMessageDialog(null, "Plan de seguimiento cambiado con éxito");
		}	
		
		if(e.getSource() == btnEliminarCuenta) {
			
			panelCentro.removeAll();
			usuario = parametroT.getObjeto2();
            lUsuario.eliminar(usuario);
            JOptionPane.showMessageDialog(null, "El usuario ha sido eliminado con éxito", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
            panelCentro.repaint();
            usuarioEliminado=true;
		}
	
	}//CIERRE DEL METODO

}//CIERRE DE LA CLASE
