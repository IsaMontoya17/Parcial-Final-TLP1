package bean;

public class Cronometro {
    
    public long inicio = 0;
    public long fin = 0;
    public double tiempoTranscurrido=0;

    public Cronometro(){}   

	public double getTiempoTranscurrido() {
		return tiempoTranscurrido;
	}

	public void setTiempoTranscurrido(double tiempoTranscurrido) {
		this.tiempoTranscurrido = tiempoTranscurrido;
	}

	public long getInicio() {
        return inicio;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public long getFin() {
        return fin;
    }

    public void setFin(long fin) {
        this.fin = fin;
    }
    
}//CIERRE DE LA CLASE

