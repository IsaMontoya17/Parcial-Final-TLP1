package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import bean.Usuario;

public class VistaSexo {
	
	public void imprimirvector(Usuario vec[], JPanel panelCentro) {
		
        JPanel panel = new JPanel(new FlowLayout()); 

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300)); 
        panelCentro.setLayout(new BorderLayout());
        
        for (int i = 0; i < vec.length; i++) {
            if (vec[i] != null) {
                textArea.append("Identificación: " + vec[i].getIdentificacion() + "\n");
                textArea.append("Nombre: " + vec[i].getNombre() + "\n");
                textArea.append("Sexo: " + vec[i].getSexo() + "\n");
                textArea.append("Plan de seguimiento: " + vec[i].getPlanSeguimiento() + "\n");
                textArea.append("Edad: " + vec[i].getEdad() + "\n");
                textArea.append("Peso: " + vec[i].getPeso() + "\n");
                textArea.append("Altura: " + vec[i].getAltura() + "\n");
                textArea.append("Correo electrónico: " + vec[i].getCorreoElectronico() + "\n");
                textArea.append("Teléfono celular: " + vec[i].getTelefonoCelular() + "\n");
                textArea.append("Fecha de nacimiento: " + vec[i].getFechaNacimiento() + "\n");
                textArea.append("---------------------------\n");
            }
        }

        panelCentro.add(scrollPane,BorderLayout.CENTER);  
        
    }//CIERRE DEL METODO
	
}//CIERRE DE LA CLASE
