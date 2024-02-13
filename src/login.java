import java.util.*;
import java.io.*;

public class login {
    static File csvL = new File("./db/Login.csv");
    public static boolean CreateUser(){
        Scanner scan = new Scanner(System.in);
        try {
            FileWriter writer = new FileWriter("./db/Login.csv", true);
            System.out.println("Crear usario de Admin");
            System.out.println("Escriba nombre de usario: ");
            writer.write(scan.nextLine());
            System.out.println("Escriba contraseña");
            writer.write("," + scan.nextLine() + "\n");
            writer.close();
            return true;
        }catch (IOException e){
            System.out.println("Error");
            return false;
        }

    }

    public static boolean Verify() {
        Scanner scan = new Scanner(System.in);
        String username;
        String password;
        int valido = 0;


        try {
            if(csvL.createNewFile()){
                System.out.println("Archivo creado");
                CreateUser();
                return true;
            }else{
                Scanner scanL = new Scanner(csvL);

                if(scanL.hasNextLine()){
                    System.out.println("Nombre de usario:");
                    username = scan.nextLine();
                    System.out.println("Contraseña:");
                    password = scan.nextLine();

                    while (scanL.hasNextLine()){
                        String data = scanL.nextLine();
                        String[] string = data.split(",");
                        String user = string[0];
                        String pass = string[1];

                        if(Objects.equals(user, username) && Objects.equals(pass, password)){
                            valido = 1;
                        }else{
                            valido = 0;
                        }


                    }
                }else{
                    CreateUser();
                }

            }

        }catch (IOException e){
            System.out.println("Error");
        }

        if(valido == 1){
            return true;
        }else{
            return false;
        }

    }

}
