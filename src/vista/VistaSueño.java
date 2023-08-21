
package vista;

import Interface.CapturaDatos;
import bean.Sueño;

import javax.swing.JOptionPane;

import logica.LSueño;

public class VistaSueño implements CapturaDatos<Sueño>{
    
    @Override
    public String opcionesModificar() {
        LSueño lSueño = new LSueño();

        String[] opciones = { "Duración del sueño", "Calidad del sueño", "Ambiente", "Latencia" };
        int opcion = JOptionPane.showOptionDialog(null, "Seleccione el dato que desea modificar:", "Modificar sueño",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        String nuevoDato = "";

        switch (opcion) {
            case 0:
                float nuevaDuracion = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la nueva duración:"));
                nuevoDato = "1:" + nuevaDuracion;
                break;
            case 1:
                lSueño.listar2("./datos/Sueño/CalidadSueñoSubjetiva.txt");
                byte nuevaCalidad = Byte.parseByte(JOptionPane.showInputDialog(null, "Ingrese la nueva calidad del sueño:"));
                nuevoDato = "2:" + nuevaCalidad;
                break;
            case 2:
                String[] opcionesAmbiente = { "1. Buen ambiente", "2. Mal ambiente" };
                int opcionAmbiente = JOptionPane.showOptionDialog(null, "Seleccione el nuevo ambiente:", "Modificar sueño",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionesAmbiente, opcionesAmbiente[0]);

                byte nuevoAmbiente = (byte) (opcionAmbiente + 1);
                nuevoDato = "3:" + nuevoAmbiente;
                break;
            case 3:
                float nuevaLatencia = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la nueva latencia:"));
                nuevoDato = "4:" + nuevaLatencia;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
                break;
        }

        return nuevoDato;
        
    }// CIERRE DEL METODO

    public void consejosDuracion(float porcentaje) {
    	
        if (porcentaje > 50) {
            JOptionPane.showMessageDialog(null, "Necesitas acostarte más temprano, no estás durmiendo lo suficiente");
        } else {
            JOptionPane.showMessageDialog(null, "Lo estás haciendo muy bien, sigue así");
        }
        
    }// CIERRE DEL METODO

    public void consejosLatencia(float porcentaje) {
    	
        if (porcentaje > 50) {
            String mensaje = "Puedes tomarte una aromática o un té caliente que te ayude a conciliar el sueño\n";
            mensaje += "No uses aparatos electrónicos ya que el uso excesivo de dispositivos electrónicos, como teléfonos o computadoras,\n";
            mensaje += "puede interferir con el ritmo circadiano y dificultar conciliar el sueño. Prueba leer un libro o simplemente relajarte un rato antes de irte a dormir";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "Estás muy bien");
        }
        
    }// CIERRE DEL METODO

    public void consejosAmbiente(float porcentaje) {
    	
        if (porcentaje > 50) {
            JOptionPane.showMessageDialog(null, "Trata de buscar un ambiente apto para dormir, en caso de que no puedas,\n"
                    + "lo mejor que puedes hacer es conseguir una almohada y colchón cómodos que te ayuden a estar cómodo y por ende dormir mejor");
        } else {
            JOptionPane.showMessageDialog(null, "El ambiente en el que duermes está bien");
        }
        
    }// CIERRE DEL METODO
    
}//CIERRE DE LA CLASE
