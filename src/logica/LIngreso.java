package logica;

import bean.ParametroTipo;
import bean.Usuario;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vistaGUI.PanelMenuActividadFisica;
import vistaGUI.PanelMenuAlimentacion;
import vistaGUI.PanelMenuSueño;

public class LIngreso {

	public byte BuscarObjetivo(int identificacion) {

		byte planSeguimiento = 0;

		try {
			File archivo = new File("./datos/IngresoUsuario.txt");
			Scanner scanner = new Scanner(archivo);
			while (scanner.hasNextLine()) {
				String[] datos = scanner.nextLine().split(",");
				if (Integer.parseInt(datos[0]) == identificacion) {
					planSeguimiento = Byte.parseByte(datos[1]);

					break;
				}
			}
			scanner.close();
		} catch (IOException e) {
			System.out.println("Ocurrio un error al leer el archivo");
		}

		return planSeguimiento;

	}// CIERRE DEL BUSCARUSUARIO

	public void Ingreso(int identificacion, String contraseña, JPanel panelCentro) {

		int objetivo;
		LUsuario lUsuario = new LUsuario();
		PanelMenuActividadFisica panelMenuActFisica = new PanelMenuActividadFisica(identificacion);
		PanelMenuAlimentacion panelMenuAlimentacion = new PanelMenuAlimentacion(identificacion);
		PanelMenuSueño panelMenuSueño = new PanelMenuSueño(identificacion);
		boolean existe = false;
		ParametroTipo<Boolean, Usuario> parametroT = lUsuario.buscar(identificacion);
		existe = parametroT.getObjeto1();
		String password = parametroT.getObjeto2().getIdentificacion() + "*";

		if (existe == true && contraseña.equals(password)) {
			objetivo = BuscarObjetivo(identificacion);
			switch (objetivo) {
			case 1:
				panelCentro.removeAll();
				panelCentro.setLayout(new BorderLayout());
				panelCentro.add(panelMenuActFisica, BorderLayout.CENTER);
				panelCentro.revalidate();
				panelCentro.repaint();

				break;
			case 2:
				panelCentro.removeAll();
				panelCentro.setLayout(new BorderLayout());
				panelCentro.add(panelMenuAlimentacion, BorderLayout.CENTER);
				panelCentro.revalidate();
				panelCentro.repaint();
				break;
			case 3:
				panelCentro.removeAll();
				panelCentro.setLayout(new BorderLayout());
				panelCentro.add(panelMenuSueño, BorderLayout.CENTER);
				panelCentro.revalidate();
				panelCentro.repaint();
				break;
			default:
				throw new AssertionError();
			}
		} else {
			if (identificacion == parametroT.getObjeto2().getIdentificacion() && contraseña != password) {
				JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
			}
			if (identificacion != parametroT.getObjeto2().getIdentificacion() && contraseña == password) {
				JOptionPane.showMessageDialog(null, "Usuario incorrecto");
			}
			if (identificacion != parametroT.getObjeto2().getIdentificacion() && contraseña != password) {
				JOptionPane.showMessageDialog(null, "Usuario y contraseña no existen");
			}

		}

	}// CIERRE DEL METODO

}// CIERRE DE LA CLASE
