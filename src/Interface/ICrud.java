package Interface;

import java.util.ArrayList;

import javax.swing.JPanel;

import bean.ParametroTipo;

public interface ICrud<T, T1, T3> {
    
    public void registrar(T objeto);
    
    public void listar(String objeto, JPanel jPanel);
    
    public ParametroTipo<T1, T> buscar(T3 variable);

    public void modificar(T objeto);
    
    public void eliminar(T objeto);
    
    public ArrayList<String> listarArchivo(JPanel panelCentro);
    
    public void serializacion(ArrayList<String> x);
    
    public void deserializacion(JPanel panelCentro) ;

}//CIERRE DE LA CLASE
