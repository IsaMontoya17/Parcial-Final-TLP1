package vistaGUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import bean.ParametroTipo;
import bean.Sueño;
import bean.Usuario;
import bean.UsuarioSueño;
import logica.LSueño;
import logica.LUsuario;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.Color;
import java.awt.Font;

public class PanelMenuSueño extends JPanel implements ActionListener {
	private JPanel panelCentro;
	private JButton btnRegistroSueño;
	private JButton btnCalidad;
	private JButton btnConsejos;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnPerfil;
	private JButton btnListar;
	private JButton btnRegreso;
	private int id;
	
	/**
	 * Create the panel.
	 */
	public PanelMenuSueño(int id) {
		
		this.id=id;
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
		panelOpciones.setLayout(new GridLayout(0, 8, 0, 0));
		
		btnRegistroSueño = new JButton("Registrar sueño");
		btnRegistroSueño.setBackground(new Color(204, 255, 255));
		btnRegistroSueño.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		Color backgroundColor = btnRegistroSueño.getBackground();
		Border border = BorderFactory.createLineBorder(backgroundColor);
		btnRegistroSueño.setBorder(border);
		btnRegistroSueño.addActionListener(this);
		
		btnRegreso = new JButton("Regresar");
		btnRegreso.setBackground(new Color(204, 255, 255));
		btnRegreso.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnRegreso.setBorder(border);
		btnRegreso.addActionListener(this);
		panelOpciones.add(btnRegreso);
		panelOpciones.add(btnRegistroSueño);
		
		btnCalidad = new JButton("Calcular calidad del sueño ");
		btnCalidad.setBackground(new Color(204, 255, 255));
		btnCalidad.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnCalidad.setBorder(border);
		btnCalidad.addActionListener(this);
		panelOpciones.add(btnCalidad);
		
		btnConsejos = new JButton("Consejos para mejorar el sueño");
		btnConsejos.setBackground(new Color(204, 255, 255));
		btnConsejos.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnConsejos.setBorder(border);
		btnConsejos.addActionListener(this);
		panelOpciones.add(btnConsejos);
		
		btnModificar = new JButton("Modificar registro de sueño");
		btnModificar.setBackground(new Color(204, 255, 255));
		btnModificar.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnModificar.setBorder(border);
		btnModificar.addActionListener(this);
		panelOpciones.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar registro de sueño");
		btnEliminar.setBackground(new Color(204, 255, 255));
		btnEliminar.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnEliminar.setBorder(border);
		btnEliminar.addActionListener(this);
		panelOpciones.add(btnEliminar);
		
		btnPerfil = new JButton("Perfil");
		btnPerfil.setBackground(new Color(204, 255, 255));
		btnPerfil.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		btnPerfil.setBorder(border);
		btnPerfil.addActionListener(this);
		
		btnListar = new JButton("Ver mi seguimiento");
		btnListar.setBackground(new Color(204, 255, 255));
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

	}
	
	LSueño lSueño = new LSueño();
	Sueño sueño = new Sueño();

	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean sueñoEliminado=false;
		
		if (e.getSource() == btnRegistroSueño) {
			
			panelCentro.removeAll();
			PanelDatosSueño panelDatosSueño = new PanelDatosSueño(panelCentro, id);
			panelCentro.add(panelDatosSueño);
			panelCentro.revalidate();
			panelCentro.repaint();	    					        
		
		}
		
		if (e.getSource() == btnCalidad && sueñoEliminado==false) {
			
	        panelCentro.removeAll();

			LUsuario lUsuario = new LUsuario();
			LocalDate fecha = LocalDate.now();
			ParametroTipo<Boolean, Sueño> parametroT = lSueño.buscar(fecha);
			ParametroTipo<Boolean, Usuario> pT = lUsuario.buscar(id);
			UsuarioSueño usuarioSueño = new UsuarioSueño(pT.getObjeto2(), parametroT.getObjeto2());
			sueño = lSueño.calcularCalidadSueño(parametroT.getObjeto2());
			JOptionPane.showMessageDialog(null, "La calidad del sueño es " + sueño.getCalidadObjetiva());
			panelCentro.repaint();

	    }
		    
	    if(e.getSource() == btnModificar && sueñoEliminado==false) {
	    	
	    	panelCentro.removeAll();
	    	String fechaRegistro = JOptionPane.showInputDialog(null, "Ingrese la fecha del registro que desea modificar (yyyy-MM-dd):");
	    	LocalDate fecha = LocalDate.parse(fechaRegistro);
	    	ParametroTipo<Boolean, Sueño> parametroT = lSueño.buscar(fecha);
	    	boolean existe = parametroT.getObjeto1();
	    	sueño = parametroT.getObjeto2();
	    	if (existe) {
	    		lSueño.modificar(sueño);
	    	} else {
	    	    JOptionPane.showMessageDialog(null, "No se encontró ninguna actividad física para la fecha especificada.");
	    	}
	    	JOptionPane.showMessageDialog(null, "Registro modificado exitosamente ");
	    	panelCentro.repaint();
	    	
	    }
	    
	    if(e.getSource() == btnEliminar) {
	    	
	    	panelCentro.removeAll();
	    	String fechaRegistro = JOptionPane.showInputDialog(null, "Ingrese la fecha del registro que desea eliminar (yyyy-MM-dd):");
	    	LocalDate fecha = LocalDate.parse(fechaRegistro);
	    	ParametroTipo<Boolean, Sueño> parametroT = lSueño.buscar(fecha);
            Sueño SueñoEliminar = parametroT.getObjeto2();
            lSueño.eliminar(SueñoEliminar);
            JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente ");
            panelCentro.repaint();
            sueñoEliminado=true;
            	    	
	    }
	    
	    if(e.getSource() == btnPerfil) {
	    	
	    	panelCentro.removeAll();
			PanelMenuPerfil panelMenuPerfil = new PanelMenuPerfil(id);
			panelCentro.setLayout(new BorderLayout());
            panelCentro.add(panelMenuPerfil, BorderLayout.CENTER);
            panelCentro.revalidate();
            panelCentro.repaint();
            
	    }
	    
	    if(e.getSource() == btnListar) {
	    	panelCentro.removeAll();
	    	lSueño.buscarRegistrosPorID(id, "./datos/Sueño/IngresoSueño.txt", panelCentro);
	    	panelCentro.revalidate();
            panelCentro.repaint();
	    }
	    
	    if(e.getSource() == btnConsejos && sueñoEliminado==false) {
	    	
	    	lSueño.buscarYDarConsejos(id);
	    	
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