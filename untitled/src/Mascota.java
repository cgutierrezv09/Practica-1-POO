public class Mascota {

    //atributos
    private  int identificadorUnico;
    private String nombre;
    private String especie;
    private String estado;
    private DispositivoLocalizacion dispositivo;


    //constructor

    public Mascota(int identificadorUnico, String nombre, String especie, String estado) {
        this.identificadorUnico = identificadorUnico;
        this.nombre = nombre;
        this.especie = especie;
        this.estado = estado;
        this.dispositivo = null;
    }


    //getters




    public int getIdentificadorUnico() {
        return identificadorUnico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getEstado() {
        return estado;
    }

    public DispositivoLocalizacion getDispositivo() {
        return dispositivo;
    }
    //setters


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDispositivo(DispositivoLocalizacion dispositivo) {
        this.dispositivo = dispositivo;
    }
}
