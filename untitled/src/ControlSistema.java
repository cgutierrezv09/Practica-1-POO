public class ControlSistema {
    private Mascota [] mascotas;
    private int cantidad;


    //esta clase fue creada para tener un mejor control del sistema creando varios metodos auxiliares utilizados en el main

    public ControlSistema(int capacidad){
        mascotas =new Mascota[capacidad];
        cantidad=0;


    }

    //este metodo busca la mascota en base al identificador
    public Mascota buscarMascota(int identificador){
        for (int i=0; i< cantidad; i++){
            if (mascotas[i].getIdentificadorUnico()==identificador){
                return mascotas[i];
            }
        }
        return null;
    }

    //este metodo agrega una mascota verificando que el identificador no sea igual que otro
    public void agregarMascota(Mascota mascota){
        if (buscarMascota(mascota.getIdentificadorUnico())!=null){

            System.out.println("Ya existe una mascota con ese identificador");
            return;

        }
        if (cantidad<mascotas.length){
            mascotas[cantidad]=mascota;
            cantidad++;
            System.out.println("Mascota agregada correctamente ");
        }else {
            System.out.println("No se pueden agregar mas mascotas ");
        }
    }

    //este metodo busca el codigo del dispositivo para crear una ubicacion
    public DispositivoLocalizacion buscarCodigo(int codigoBuscar){
        for (int i = 0; i < cantidad; i++){
            if (mascotas[i].getDispositivo() != null &&
                    mascotas[i].getDispositivo().getCodigo() == codigoBuscar){

                return mascotas[i].getDispositivo();
            }
        }
        return null;
    }
}
