
package bean;

public class UsuarioDieta {
    
    private Usuario usuario;
    private Dieta dieta;

    public UsuarioDieta(Usuario usuario, Dieta dieta) {
        super();
        this.usuario = usuario;
        this.dieta = dieta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

}//CIERRE DE LA CLASE
