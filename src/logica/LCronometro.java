package logica;

import bean.Cronometro;

public class LCronometro extends Cronometro{
    
    public LCronometro(){}
    
    public void iniciarCronometro() {

        inicio = System.currentTimeMillis();
    }

    public void detenerCronometro() {

        fin = System.currentTimeMillis();
        tiempoTranscurrido = fin - inicio;
    }
    
}