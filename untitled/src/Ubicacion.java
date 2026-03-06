import java.time.LocalDate;
import java.time.LocalTime;

public class Ubicacion {

    //Atributos
    private int identificador;
    private LocalDate fecha;
    private LocalTime hora;
    private String infoUbicacion;


    //constructor

    public Ubicacion(int identificador, LocalDate fecha,LocalTime hora, String infoUbicacion) {
        this.identificador = identificador;
        this.fecha = fecha;
        this.hora = hora;
        this.infoUbicacion = infoUbicacion;

    }


    //getters

    public int getIdentificador() {
        return identificador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getInfoUbicacion() {
        return infoUbicacion;
    }

    //Setters


    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setInfoUbicacion(String infoUbicacion) {
        this.infoUbicacion = infoUbicacion;
    }
}
