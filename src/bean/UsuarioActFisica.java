package bean;

import java.io.Serializable;

public class UsuarioActFisica implements Serializable{

    private Usuario usuario;
    private ActividadFisica actividadFisica;

    public UsuarioActFisica(Usuario usuario, ActividadFisica actividadFisica) {
        super();
        this.usuario = usuario;
        this.actividadFisica = actividadFisica;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ActividadFisica getActividadFisica() {
        return actividadFisica;
    }

    public void setActividadFisica(ActividadFisica actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

}//CIERRE DE LA CLASE
