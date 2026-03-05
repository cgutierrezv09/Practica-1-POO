public class DispositivoLocalizacion {

    //atributos
    private int codigo;
    private String estado;
    private Ubicacion[] ubicaciones;
    private int cantidadUbicaciones;


    //constructor

    public DispositivoLocalizacion(int codigo, String estado) {
        this.codigo = codigo;
        this.estado = estado;
        ubicaciones = new Ubicacion[50];
        cantidadUbicaciones = 0;
    }


    //getters


    public int getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado;
    }

    public Ubicacion[] getUbicaciones() {
        return ubicaciones;
    }

    public int getCantidadUbicaciones() {
        return cantidadUbicaciones;
    }
    //setters


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setUbicaciones(Ubicacion[] ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public void setCantidadUbicaciones(int cantidadUbicaciones) {
        this.cantidadUbicaciones = cantidadUbicaciones;
    }

    public void agregarUbicacion(Ubicacion u){
        if (cantidadUbicaciones < ubicaciones.length){
            ubicaciones[cantidadUbicaciones] = u;
            cantidadUbicaciones++;
        } else {
            System.out.println("No se pueden agregar más ubicaciones");
        }
    }
}
