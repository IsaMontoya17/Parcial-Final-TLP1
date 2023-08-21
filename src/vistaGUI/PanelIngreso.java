package vistaGUI;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import logica.LIngreso;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelIngreso extends JPanel implements ActionListener {
	private JTextField textUsuario;
	private JTextField textClave;
	private JPanel panelC;

	/**
	 * Create the panel.
	 */
	public PanelIngreso(JPanel panelC){
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
		panelCentro.setLayout(new GridLayout(8, 3, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("");
		panelCentro.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panelCentro.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("");
		panelCentro.add(lblNewLabel_7);
		
		JLabel lblNewLabel_4 = new JLabel("");
		panelCentro.add(lblNewLabel_4);
		
		JLabel lblUsuario = new JLabel("  Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		lblUsuario.setBackground(new Color(255, 234, 244));
		panelCentro.add(lblUsuario);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panelCentro.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		panelCentro.add(lblNewLabel_6);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		panelCentro.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panelCentro.add(lblNewLabel_1);
		
		JLabel lblContraseña = new JLabel("  Contraseña");
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseña.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(lblContraseña);
		
		JLabel lblNewLabel_10 = new JLabel("");
		panelCentro.add(lblNewLabel_10);
		
		JLabel lblNewLabel_8 = new JLabel("");
		panelCentro.add(lblNewLabel_8);
		
		textClave = new JPasswordField();
		textClave.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		panelCentro.add(textClave);
		textClave.setColumns(10);
		
		JLabel label = new JLabel("");
		panelCentro.add(label);
		
		JLabel lblNewLabel_11 = new JLabel("");
		panelCentro.add(lblNewLabel_11);
		
		JLabel lblNewLabel_15 = new JLabel("");
		panelCentro.add(lblNewLabel_15);
		
		JLabel lblNewLabel_9 = new JLabel("");
		panelCentro.add(lblNewLabel_9);
		
		JLabel lblNewLabel_12 = new JLabel("");
		panelCentro.add(lblNewLabel_12);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(new Color(255, 166, 210));
		btnIngresar.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		Color backgroundColor = btnIngresar.getBackground();
		Border border = BorderFactory.createLineBorder(backgroundColor);
		btnIngresar.setBorder(border);
		btnIngresar.addActionListener(this);
		panelCentro.add(btnIngresar);
		
		JLabel lblNewLabel_13 = new JLabel("");
		panelCentro.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		panelCentro.add(lblNewLabel_14);
		
		JLabel lblNewLabel_16 = new JLabel("");
		panelCentro.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("");
		panelCentro.add(lblNewLabel_17);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 234, 244));
		add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 234, 244));
		add(panel_1, BorderLayout.EAST);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		LIngreso lIngreso = new LIngreso();
		
		if (e.getActionCommand().equals("Ingresar")) {
			int id = Integer.parseInt(textUsuario.getText());
			String contraseña = textClave.getText();
			
			lIngreso.Ingreso(id, contraseña, panelC);
			
        }
		
	}//CIERRE DEL METODO

}//CIERRE DE LA CLASE
