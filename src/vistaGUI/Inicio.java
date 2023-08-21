package vistaGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Inicio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(255, 234, 244));
		panel.add(panelTitulo, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Habit Tracker");
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 17));
		panelTitulo.add(lblNewLabel);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(new Color(255, 234, 244));
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		PanelMenuPrincipal panelMenuPrincipal = new PanelMenuPrincipal(panelCentro);
		panelMenuPrincipal.setBackground(new Color(255, 234, 244));
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(255, 234, 244));
		panel.add(panelMenu, BorderLayout.SOUTH);
		panelMenu.setLayout(new BorderLayout(0, 0));
		panelMenu.add(panelMenuPrincipal);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 234, 244));
		panelMenu.add(panel_4, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 234, 244));
		panelMenu.add(panel_5, BorderLayout.EAST);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 234, 244));
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 234, 244));
		frame.getContentPane().add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 234, 244));
		frame.getContentPane().add(panel_3, BorderLayout.EAST);
		
	}

}//CIERRE DE LA CLASE
