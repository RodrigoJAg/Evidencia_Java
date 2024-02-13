import java.util.*;
import java.io.*;
public class Doctor {
    File csvDoctor = new File("./db/Doctores.csv");
    public void crear(){
        Scanner scan = new Scanner(System.in);
        String ID;

        try {
            FileWriter writer = new FileWriter("./db/Doctores.csv", true);
            Scanner scanD = new Scanner(csvDoctor);

            System.out.println("ID Doctor");
            ID = scan.nextLine();


            while (scanD.hasNextLine()){
                String Data = scanD.nextLine();
                if(Data.contains(ID)){
                    System.out.println("ID ya existente, escriba otro");
                    ID = scan.nextLine();
                }
            }

            writer.write(ID);
            System.out.println("Nombre Doctor");
            writer.write("," + scan.nextLine());
            System.out.println("Especialidad Doctor");
            writer.write("," + scan.nextLine() + "\n");
            writer.close();
        }catch (IOException e){
            System.out.println("Error");
        }

    }
}
