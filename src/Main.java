import java.io.IOException;
import java.util.*;
import java.nio.file.*;
public class Main {
    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        Paciente paciente = new Paciente();
        Cita cita = new Cita();


        Scanner scan = new Scanner(System.in);
        int opcion = 1;
        int option = 0;
        int valido = 0;
        boolean inicio;

        for(int i = 0; i < 2; i++){
            System.out.println("*-----------------------------------*");
        }
        System.out.println("*-----Programa de agendar citas-----*");
        for(int i = 0; i < 2; i++){
            System.out.println("*-----------------------------------*");
        }

        do {
            if (login.Verify()) {
                do{
                    valido = 1;
                    System.out.println("\nSeleccione el numero de la opcion a seleccionar");
                    System.out.println("1. Registrar doctor\n2. Registrar paciente\n3. Agendar cita\n4. Lista de citas\n5. Cancelar cita\n6. Salir");
                    option = Integer.parseInt(scan.nextLine());
                    switch (option){
                        case 1:
                            doctor.crear();
                            break;
                        case 2:
                            paciente.crear();
                            break;
                        case 3:
                            cita.AgendarCita();
                            break;
                        case 4:
                            cita.lista();
                            break;
                        case 5:
                            cita.delete();
                            break;
                        case 6:
                            opcion = 0;
                            valido = 0;
                            break;
                    }

                }while (opcion != 0);

            } else {
                System.out.println("Usario y/o contrsaeña incorrectos");
                valido = 0;
            }

        }while (valido != 0);


    }
}