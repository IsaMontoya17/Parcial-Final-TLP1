
package vista;

import bean.Usuario;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Interface.CapturaDatos;

public class VistaUsuario extends Usuario implements CapturaDatos<Usuario>{

	public VistaUsuario() {
	}
	
	@Override
	public String opcionesModificar() {
	    String[] opciones = { "Identificación", "Nombre", "Edad", "Altura", "Peso", "Sexo", "Fecha de Nacimiento",
	            "Correo Electrónico", "Teléfono Celular" };
	    Font font = new Font("Nirmala UI", Font.PLAIN, 11);
	    UIManager.put("OptionPane.messageFont", font);
	    UIManager.put("OptionPane.buttonFont", font);
	    
	    int opcion = JOptionPane.showOptionDialog(null, "Seleccione el dato que desea modificar:", "Modificar usuario",
	            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
	    String nuevoDato = "";

	    switch (opcion) {
	        case 0:
	            String nuevaIdentificacion = JOptionPane.showInputDialog(null, "Ingrese la nueva identificación:");
	            nuevoDato = "1:" + nuevaIdentificacion;
	            break;
	        case 1:
	            String nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre:");
	            nuevoDato = "2:" + nuevoNombre;
	            break;
	        case 2:
	            String nuevaEdad = JOptionPane.showInputDialog(null, "Ingrese la nueva edad:");
	            nuevoDato = "3:" + nuevaEdad;
	            break;
	        case 3:
	            String nuevaAltura = JOptionPane.showInputDialog(null, "Ingrese la nueva altura:");
	            nuevoDato = "4:" + nuevaAltura;
	            break;
	        case 4:
	            String nuevoPeso = JOptionPane.showInputDialog(null, "Ingrese el nuevo peso:");
	            nuevoDato = "5:" + nuevoPeso;
	            break;
	        case 5:
	            String[] opcionesSexo = { "Masculino", "Femenino" };
	            int opcionSexo = JOptionPane.showOptionDialog(null, "Seleccione el nuevo sexo:", "Modificar sexo",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionesSexo, opcionesSexo[0]);
	            nuevoDato = "6:" + opcionSexo;
	            break;
	        case 6:
	            String nuevaFechaNacimiento = JOptionPane.showInputDialog(null,
	                    "Ingrese la nueva fecha de nacimiento (YYYY-MM-DD):");
	            nuevoDato = "7:" + nuevaFechaNacimiento;
	            break;
	        case 7:
	            String nuevoCorreoElectronico = JOptionPane.showInputDialog(null, "Ingrese el nuevo correo electrónico:");
	            nuevoDato = "8:" + nuevoCorreoElectronico;
	            break;
	        case 8:
	            String nuevoTelefonoCelular = JOptionPane.showInputDialog(null, "Ingrese el nuevo teléfono celular:");
	            nuevoDato = "9:" + nuevoTelefonoCelular;
	            break;
	        default:
	            JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
	            break;
	    }

	    UIManager.put("OptionPane.messageFont", new Font(Font.DIALOG, Font.PLAIN, 11));
	    UIManager.put("OptionPane.buttonFont", new Font(Font.DIALOG, Font.PLAIN, 11));

	    return nuevoDato;
	    
	}// CIERRE DEL METODO
	
	public String cambiarPlanSeguimiento() {
	    String[] opciones = { "Actividad física", "Alimentación", "Sueño" };
	    Font font = new Font("Nirmala UI", Font.PLAIN, 11);
	    UIManager.put("OptionPane.messageFont", font);
	    UIManager.put("OptionPane.buttonFont", font);
	    
	    int opcion = JOptionPane.showOptionDialog(null, "Seleccione el plan de seguimiento que desea modificar:",
	            "Modificar usuario", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones,
	            opciones[0]);
	    String nuevoDato = "";

	    switch (opcion) {
	        case 0:
	            nuevoDato = "1:Actividad física";
	            break;
	        case 1:
	            nuevoDato = "2:Alimentación";
	            break;
	        case 2:
	            nuevoDato = "3:Sueño";
	            break;
	        default:
	            JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
	            break;
	    }

	    UIManager.put("OptionPane.messageFont", new Font(Font.DIALOG, Font.PLAIN, 11));
	    UIManager.put("OptionPane.buttonFont", new Font(Font.DIALOG, Font.PLAIN, 11));

	    return nuevoDato;
	    
	}// CIERRE DEL METODO

	public void asignarUsuarioYContraseña(int id) {
		String usuario = String.valueOf(id);
		String contraseña = usuario + "*";

		String mensaje = "Su usuario es: " + usuario + "\n" + "Su contraseña es: " + contraseña;
		JOptionPane.showMessageDialog(null, mensaje, "Información de Cuenta", JOptionPane.INFORMATION_MESSAGE);
		
	}// CIERRE DEL METODO

}// CIERRE DE LA CLASE
