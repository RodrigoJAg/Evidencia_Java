import java.util.*;
import java.io.*;
public class Paciente {

    File csvPacientes = new File("./db/Pacientes.csv");

    public void crear(){
        Scanner scan = new Scanner(System.in);
        String ID;
        try {
            FileWriter writer = new FileWriter("./db/Pacientes.csv", true);
            Scanner scanP = new Scanner(csvPacientes);

            System.out.println("ID Paciente");
            ID = scan.nextLine();
            while (scanP.hasNextLine()){
                String Data = scanP.nextLine();
                if(Data.contains(ID)){
                    System.out.println("ID ya existente, escriba otro");
                    ID = scan.nextLine();
                }
            }

            writer.write(ID);
            System.out.println("Nombre Paciente");
            writer.write("," + scan.nextLine() + "\n");
            writer.close();

        }catch (IOException e){
            System.out.println("Error");
        }

    }
}
