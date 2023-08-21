
package bean;

public class ParametroTipo <T1, T2>{
    
    private T1 objeto1;
    private T2 objeto2;

    public ParametroTipo(T1 objeto1, T2 objeto2) {
        this.objeto1 = objeto1;
        this.objeto2 = objeto2;
    }

    public T1 getObjeto1() {
        return objeto1;
    }

    public void setObjeto1(T1 objeto1) {
        this.objeto1 = objeto1;
    }

    public T2 getObjeto2() {
        return objeto2;
    }

    public void setObjeto2(T2 objeto2) {
        this.objeto2 = objeto2;
    }

    
}//CIERRE DE LA CLASE
