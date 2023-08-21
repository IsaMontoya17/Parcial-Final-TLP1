package Interface;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import bean.UsuarioActFisica;

public interface MetodosComposiciones <T>{
	
	public void hacerComposicion(T composicion)throws IOException; 

	public ArrayList<String> listarArchivoPlanoAleatorio(JPanel panelCentro)throws IOException;
	
	public void serializacion(ArrayList<String> x);
	
	public void deserializacion(JPanel panelCentro);
	
}
