
package vista;

import bean.ActividadFisica;

import javax.swing.JOptionPane;

import logica.LActividadFisica;
import Interface.CapturaDatos;

public class VistaActividadFisica extends LActividadFisica implements CapturaDatos<ActividadFisica> {

	public void informeUsuario(ActividadFisica actividadFisica) {
	    String mensaje = "Se ha registrado una actividad física de tipo " + actividadFisica.getTipoActividad()
	            + " con una duración de " + actividadFisica.getDuracion() + " segundos y una distancia recorrida de "
	            + actividadFisica.getDistanciaRecorrida() + " km.";

	    JOptionPane.showMessageDialog(null, mensaje);
	    
	}// CIERRE DEL METODO
 
	@Override
	public String opcionesModificar() {
		String[] opciones = { "Tipo de actividad", "Duración", "Distancia recorrida" };
		int opcion = JOptionPane.showOptionDialog(null, "Seleccione el dato que desea modificar:",
				"Modificar actividad física", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones,
				opciones[0]);

		String nuevoDato = "";

		switch (opcion) {
		case 0:
			super.listar2("./datos/ActividadFisica/ListaAF.txt");
			String TipoAct = JOptionPane.showInputDialog(null, "Ingrese el nuevo tipo de actividad:");
			String nuevoTAct = super.clasificacionActFisica(Short.parseShort(TipoAct));
			nuevoDato = "1:" + nuevoTAct;
			break;
		case 1:
			String nuevaDuracion = JOptionPane.showInputDialog(null, "Ingrese la nueva duración en segundos:");
			nuevoDato = "2:" + nuevaDuracion;

			break;
		case 2:
			String nuevaDR = JOptionPane.showInputDialog(null, "Ingrese la nueva distancia recorrida:");
			nuevoDato = "3:" + nuevaDR;

			break;
		default:
			JOptionPane.showMessageDialog(null, "Opción inválida");
			break;
		}

		return nuevoDato;
		
	}// CIERRE DEL METODO

}// CIERRE DE LA CLASE
