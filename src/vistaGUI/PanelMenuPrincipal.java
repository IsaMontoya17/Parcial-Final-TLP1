package vistaGUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import bean.Usuario;
import logica.LIngreso;
import logica.LSexo;
import logica.LUsuario;
import vista.VistaUsuario;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;

public class PanelMenuPrincipal extends JPanel implements ActionListener {
	
	private JPanel panelCentro;
	private JButton btnRegreso;
	private JButton btnIngreso;
	private JButton btnMenuProgramador;
	private JButton btnSalir;
	private JButton btnRegistro;
	/**
	 * Create the panel.
	 */
	public PanelMenuPrincipal(JPanel panelCentro) {
		setBackground(new Color(255, 234, 244));
		this.panelCentro = panelCentro;
		
		setLayout(new BorderLayout(0, 0));

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(255, 234, 244));
		setLayout(new BorderLayout());
		add(panelMenu, BorderLayout.CENTER);
		panelMenu.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMenu_1 = new JPanel();
		panelMenu_1.setBackground(new Color(255, 234, 244));
		panelMenu.add(panelMenu_1, BorderLayout.CENTER);
		panelMenu_1.setLayout(new GridLayout(0, 5, 0, 0));
		
		btnRegistro = new JButton("Registrarse");
		btnRegistro.setBackground(new Color(250, 141, 199));
		btnRegistro.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		Color backgroundColor = btnRegistro.getBackground();
		Border border = BorderFactory.createLineBorder(backgroundColor);
		btnRegistro.setBorder(border);
		btnRegistro.addActionListener(this);
		
		btnRegreso = new JButton("Regresar");
		btnRegreso.setForeground(new Color(0, 0, 0));
		btnRegreso.setBackground(new Color(250, 141, 199));
		btnRegreso.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnRegreso.setBorder(border);
		btnRegreso.addActionListener(this);
		panelMenu_1.add(btnRegreso);
		panelMenu_1.add(btnRegistro);
		
		btnIngreso = new JButton("Ingresar");
		btnIngreso.setBackground(new Color(250, 141, 199));
		btnIngreso.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnIngreso.setBorder(border);
		btnIngreso.addActionListener(this);
		panelMenu_1.add(btnIngreso);
		
		btnMenuProgramador = new JButton("Menu programador");
		btnMenuProgramador.setBackground(new Color(250, 141, 199));
		btnMenuProgramador.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnMenuProgramador.setBorder(border);
		btnMenuProgramador.addActionListener(this);
		panelMenu_1.add(btnMenuProgramador);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(250, 141, 199));
		btnSalir.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnSalir.setBorder(border);
		btnSalir.addActionListener(this);
		panelMenu_1.add(btnSalir);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		LSexo lSexo = new LSexo();

		if (e.getSource() == btnIngreso) {
			
			panelCentro.removeAll();
			PanelIngreso panelIngreso = new PanelIngreso(panelCentro);
			panelCentro.setLayout(new BorderLayout());
            panelCentro.add(panelIngreso, BorderLayout.CENTER);
            panelCentro.revalidate();
            panelCentro.repaint();
		}
		
		if (e.getSource() == btnSalir) {
			System.exit(0);
		}
		
		if (e.getSource() == btnRegistro) {
			
			panelCentro.removeAll();
            PanelRegistro panelRegistro = new PanelRegistro(panelCentro);
            panelCentro.setLayout(new BorderLayout());
            panelCentro.add(panelRegistro, BorderLayout.CENTER);
            panelCentro.revalidate();
            panelCentro.repaint();

		}
		
		if (e.getSource() == btnMenuProgramador) {
			
			panelCentro.removeAll();
			PanelMenuProgramador panelMenuProgramador = new PanelMenuProgramador();
			panelCentro.setLayout(new BorderLayout());
            panelCentro.add(panelMenuProgramador, BorderLayout.CENTER);
            panelCentro.revalidate();
            panelCentro.repaint();
		}
		
		if(e.getSource() == btnRegreso) {
			
			panelCentro.removeAll();
			PanelRegreso panelInicio = new PanelRegreso();
			panelCentro.setLayout(new BorderLayout());
            panelCentro.add(panelInicio, BorderLayout.CENTER);
            panelCentro.revalidate();
            panelCentro.repaint();
		}

	}//CIERRE DEL METODO

}// CIERRE DE LA CLASE
