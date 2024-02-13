import java.io.*;
import java.nio.file.*;
import java.util.*;
public class Cita {
    File csvC = new File("./db/Citas.csv");
    File csvP = new File("./db/Pacientes.csv");
    File csvD = new File("./db/Doctores.csv");
    Scanner scan = new Scanner(System.in);
    public void AgendarCita(){
        String IDC;
        String IDP;
        String IDD;

        try {
            if(csvC.createNewFile()){
                System.out.println("Archivo creado!");
                FileWriter writer = new FileWriter("./db/Citas.csv", true);
                writer.write("*" + "," + "---"+ "," + "---"+ "," + "---"+ "," + "---"+ "," + "---"+ "," + "*" + "\n");
                writer.close();
            }else{
                FileWriter writer = new FileWriter("./db/Citas.csv", true);
                Scanner scanP = new Scanner(csvP);
                Scanner scanD = new Scanner(csvD);
                Scanner scanC = new Scanner(csvC);


                System.out.println("crea el ID de la cita");
                IDC = scan.nextLine();

                while (scanC.hasNextLine()){
                    String data = scanC.nextLine();
                    String[] string = data.split(",");
                    String ID = string[0];

                    if(Objects.equals(IDC, ID)){
                        System.out.println("ID ya existente, escriba otro");
                        IDC = scan.nextLine();
                        break;
                    }
                }
                writer.write(IDC + ",");

                scanC.close();

                System.out.println("Escriba el ID del doctor: ");
                IDD = scan.nextLine();


                while (scanD.hasNextLine()){
                    String data = scanD.nextLine();

                    String[] string = data.split(",");

                    String id = string[0];
                    String name = string[1];
                    String special = string[2];


                    if(Objects.equals(IDD, id)){
                        writer.write("Doctor: " + name + ",");
                        writer.write("Especialidad: " + special + ",");
                    }

                }
                scanD.close();

                System.out.println("Escriba el ID del paciente: ");
                IDP = scan.nextLine();

                while (scanP.hasNextLine()){
                    String data = scanP.nextLine();
                    String[] string = data.split(",");
                    String id = string[0];
                    String name = string[1];
                    if(Objects.equals(IDP,id)){
                        writer.write("Paciente: " + name + ",");
                    }

                }
                scanP.close();

                System.out.println("Escriba la fecha:");
                writer.write(scan.nextLine() + ",");

                System.out.println("Escriba la hora:");
                writer.write(scan.nextLine() + ",");

                System.out.println("Escriba el motivo:");
                writer.write("Motivo: " + scan.nextLine() + "\n");

                writer.close();
            }

        }catch (IOException e){
            System.out.println("Error");
        }




    }
    public void lista(){
        try {
            Scanner scan = new Scanner(csvC);

            while (scan.hasNextLine()){
                String data = scan.nextLine();
                System.out.println(data);
            }
        }catch (IOException e){
            System.out.println("Error");
        }

    }

    public void delete(){
        File CitaNew = new File("./db/CitaTemp.csv");
        String IDC;

        try {
            if(!csvC.exists()){
                System.out.println("Sin citas");

            }else{

                Scanner scanC = new Scanner(csvC);

                FileWriter writer = new FileWriter("./db/CitaTemp.csv");

                System.out.println("Escribe el ID de la cita a eliminar:");
                IDC = scan.nextLine();

                while (scanC.hasNextLine()){

                    String data = scanC.nextLine();
                    String[] string = data.split(",");
                    String id = string[0];

                    if(!Objects.equals(IDC, id)){
                        writer.write(data + "\n");
                    }

                }
                writer.close();
                scanC.close();
            }

        }catch (IOException e){
            System.out.println("Error");
        }

        try{
            Path citaN = Path.of(CitaNew.getPath());
            Path citaC = Path.of(csvC.getPath());


            Files.move(citaN,citaC,StandardCopyOption.REPLACE_EXISTING);

        }catch (IOException e){
            System.out.println("Error fatal");
        }



    }





}
