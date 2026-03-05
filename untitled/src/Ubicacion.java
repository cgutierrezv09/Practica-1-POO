public class Ubicacion {

    //Atributos
    private int identificador;
    private String fecha;
    private String hora;
    private String infoUbicacion;


    //constructor

    public Ubicacion(int identificador, String fecha, String hora, String infoUbicacion) {
        this.identificador = identificador;
        this.fecha = fecha;
        this.hora = hora;
        this.infoUbicacion = infoUbicacion;

    }


    //getters

    public int getIdentificador() {
        return identificador;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getInfoUbicacion() {
        return infoUbicacion;
    }

    //Setters


    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setInfoUbicacion(String infoUbicacion) {
        this.infoUbicacion = infoUbicacion;
    }
}
