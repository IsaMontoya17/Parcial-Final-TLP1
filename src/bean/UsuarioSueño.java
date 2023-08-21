
package bean;

import java.io.Serializable;

public class UsuarioSueño implements Serializable{
    
    private Usuario usuario;
    private Sueño sueño;

    public UsuarioSueño(Usuario usuario, Sueño sueño) {
        this.usuario = usuario;
        this.sueño = sueño;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sueño getSueño() {
        return sueño;
    }

    public void setSueño(Sueño sueño) {
        this.sueño = sueño;
    }
    
}//CIERRE DE LA CLASE
