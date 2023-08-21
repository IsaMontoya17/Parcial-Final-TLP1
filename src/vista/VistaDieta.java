
package vista;

import Interface.CapturaDatos;
import bean.Dieta;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import logica.LDieta;

public class VistaDieta extends LDieta implements CapturaDatos<Dieta>{
    
    public VistaDieta(){}

    public Dieta ingresoDatos() {

        Dieta dieta = new Dieta();
        byte alimento;

        super.listar2("./datos/Dieta/ListaAlimentos.txt");
        
        String input = JOptionPane.showInputDialog("Seleccione un alimento:");
        alimento = Byte.parseByte(input);
        
        while (alimento < 1 || alimento > 100) {
            input = JOptionPane.showInputDialog("Por favor ingrese una opción válida:");
            alimento = Byte.parseByte(input);
        }

        dieta.getAlimentosConsumidos().add(alimento);
        short calorias = super.buscarNumeroEnArchivo(alimento);
        dieta.getCaloriasAlimentos().add(calorias);
        
        dieta = metodoIngresoDatos(dieta);

        return dieta;
        
    }// CIERRE DEL METODO
    
    private Dieta metodoIngresoDatos(Dieta dieta) {

        int opcion = JOptionPane.showOptionDialog(null, "¿Desea agregar otro alimento?", "Agregar alimento",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sí", "No"}, "Sí");

        if (opcion == JOptionPane.NO_OPTION) {
            return dieta;
        }

        while (opcion == JOptionPane.YES_OPTION) {
            super.listar2("./datos/Dieta/ListaAlimentos.txt");

            String input = JOptionPane.showInputDialog(null, "Seleccione un alimento:", "Agregar alimento",
                    JOptionPane.QUESTION_MESSAGE);
            byte alimento;
            try {
                alimento = Byte.parseByte(input);
            } catch (NumberFormatException e) {
                alimento = 0;
            }

            while (alimento < 1 || alimento > 100) {
                input = JOptionPane.showInputDialog(null, "Por favor ingrese una opción válida:", "Agregar alimento",
                        JOptionPane.WARNING_MESSAGE);
                try {
                    alimento = Byte.parseByte(input);
                } catch (NumberFormatException e) {
                    alimento = 0;
                }
            }

            short calorias = super.buscarNumeroEnArchivo(alimento);
            dieta.getCaloriasAlimentos().add(calorias);
            dieta.getAlimentosConsumidos().add(alimento);

            opcion = JOptionPane.showOptionDialog(null, "¿Desea agregar otro alimento?", "Agregar alimento",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sí", "No"}, "Sí");
        }

        short caloriasTotales = super.calcularCalorias(dieta);
        dieta.setCaloriasTotales(caloriasTotales);
        dieta.setFecha(LocalDate.now());

        return dieta;
        
    }// CIERRE DEL METODO

    @Override
    public String opcionesModificar() {

        Dieta dieta = new Dieta();  
        String nuevoD = "";   

        dieta = ingresoDatos();
        nuevoD = dieta.getAlimentosConsumidos().toString();
        nuevoD = nuevoD.substring(1, nuevoD.length() - 1);
        nuevoD = nuevoD.replaceAll("\\s*,\\s*", ",");
                

        return nuevoD;
        
    }//CIERRE DEL METODO

    
}//CIERRE DE LA CLASE
