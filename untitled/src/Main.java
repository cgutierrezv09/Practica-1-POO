import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList  <Mascota> mascotas;

    //este metodo busca la mascota en base al identificador
    public static Mascota buscarMascota(int identificadorBuscar){

        for (Mascota m : mascotas){
            if (m.getIdentificadorUnico() == identificadorBuscar){
                return m;
            }
        }

        return null;
    }

    //este metodo agrega una mascota verificando que el identificador no sea igual que otro

    public static void agregarMascota(Mascota mascota){

        if (buscarMascota(mascota.getIdentificadorUnico()) != null){
            System.out.println("Ya existe una mascota con ese identificador");
            return;
        }

        mascotas.add(mascota);
        System.out.println("Mascota agregada correctamente");
    }

    //este metodo busca el codigo del dispositivo para crear una ubicacion
    public static DispositivoLocalizacion buscarCodigo(int codigoBuscar){

        for (Mascota m : mascotas){

            if (m.getDispositivo() != null &&
                    m.getDispositivo().getCodigo() == codigoBuscar){

                return m.getDispositivo();
            }
        }

        return null;
    }

    //Metodos para registrar una mascota
    public static void registrarMascota() throws IOException{

        System.out.println("Ingrese un identificador para su mascota ");
        int identificador=Integer.parseInt(entrada.readLine());

        System.out.println("Ingrese el nombre de la mascota a registrar");
        String nombre=entrada.readLine();

        System.out.println("Ingrese la raza de mascota");
        String especie=entrada.readLine();

        System.out.println("Ingrese el estado de su mascota");
        String estado=entrada.readLine();


        Mascota mascota=new Mascota(identificador,nombre,especie,estado);
        agregarMascota(mascota);



    }


    public static void asociacionDispositivo() throws IOException {

        System.out.println("Ingrese el identificador de su mascota ");
        int identificador = Integer.parseInt(entrada.readLine());

        Mascota mascota = buscarMascota(identificador);

        if (mascota == null) {
            System.out.println("No se encontro ninguna mascota con ese identificador");
            return;
        }

        if (mascota.getDispositivo() != null) {
            System.out.println("Esta mascota ya tiene un dispositivo asociado");
            return;
        }

        System.out.println("Ingrese un codigo para su dispositivo");
        int codigo = Integer.parseInt(entrada.readLine());

        if (buscarCodigo(codigo) != null) {
            System.out.println("Ya existe un dispositivo con ese codigo");
            return;
        }

        System.out.println("Ingrese el estado del dispositivo");
        String estado = entrada.readLine();

        DispositivoLocalizacion dispositivo = new DispositivoLocalizacion(codigo, estado);
        mascota.setDispositivo(dispositivo);

        System.out.println("Dispositivo asociado correctamente");
    }

    public static void registroUbicacion()throws IOException{

        System.out.println("Ingrese el codigo de su dispositivo");
        int codigo=Integer.parseInt(entrada.readLine());

        DispositivoLocalizacion dispositivoLocalizacion=buscarCodigo(codigo);
        if (dispositivoLocalizacion==null){
            System.out.println("No se encontro ningun dispositivo con ese codigo");
        }else {

            System.out.println("Ingrese un identificador");
            int identificador=Integer.parseInt(entrada.readLine());

            System.out.println("Ingrese la fecha AAAA-MM-DD");
            LocalDate fecha=LocalDate.parse(entrada.readLine());

            System.out.println("Ingrese la hora HH:mm ");
            LocalTime hora=LocalTime.parse(entrada.readLine());

            System.out.println("Ingrese la ubicacion");
            String ubi=entrada.readLine();

            Ubicacion ubicacion=new Ubicacion(identificador,fecha,hora,ubi);
            dispositivoLocalizacion.agregarUbicacion(ubicacion);
        }

    }

    public static void consultarInfo()throws IOException{

        System.out.println("Ingrese el idenficador de su mascota ");
        int identficador=Integer.parseInt(entrada.readLine());


        Mascota mascota=buscarMascota(identficador);
        if (mascota==null){
            System.out.println("No se encontro ninguna mascota con el identificador");
            return;

        }else {
            System.out.println("====Datos de la mascota====");
            System.out.println("ID: " +mascota.getIdentificadorUnico());
            System.out.println("Nombre: "+mascota.getNombre()+ "\nEspecie: "+mascota.getEspecie()+"\nEstado: "+mascota.getEstado());


            if (mascota.getDispositivo()==null){
                System.out.println("La mascota no tiene un dispositivo asociado");
            }else {
                DispositivoLocalizacion dispositivo= mascota.getDispositivo();

                System.out.println("====Dispositivo====");
                System.out.println("Codigo: "+dispositivo.getCodigo()+  "\nEstado: "+dispositivo.getEstado());

                if (dispositivo.getCantidadUbicaciones()==0){
                    System.out.println("No hay ubicaciones registradas ");
                }else {
                    System.out.println("====Ubicaciones====");

                    for (int i=0; i< dispositivo.getCantidadUbicaciones(); i++){
                        Ubicacion ubi=dispositivo.getUbicaciones()[i];

                        System.out.println("Identificador: "+ubi.getIdentificador()+ " \nFecha: "+ubi.getFecha()+ "\nHora: "+ubi.getHora()+ "" +
                                "\nInformacion de la ubicacion: "+ubi.getInfoUbicacion());
                    }
                }
            }
        }




    }
    public static void main(String[] args)throws IOException {

        mascotas = new ArrayList<>();
        int opcion;

        do {
            System.out.println("======Sistema de mascotas======");
            System.out.println("1. Registrar una mascota");
            System.out.println("2. Asociar un dispositivo con la mascota ");
            System.out.println("3. Registrar la ubicacion");
            System.out.println("4. Consultar infomracion");


            opcion=Integer.parseInt(entrada.readLine());


            switch (opcion){
                case 1:
                    registrarMascota();
                    break;

                case 2:
                    asociacionDispositivo();
                    break;

                case 3:
                    registroUbicacion();
                    break;
                case 4:
                    consultarInfo();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema ");
                    break;

                default:
                    System.out.println("Opcion invalida");
                    return;

            }

        }while (opcion!=5);

    }
}
