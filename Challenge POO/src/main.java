import java.util.Scanner;

public class main {

    public static void  main(String args[]){

        System.out.println("Ingrese una password");
        Scanner input = new Scanner(System.in);
        Password password = new Password(input.nextLine());

        System.out.print("La password: "+password.getPassword());
        if (password.isStrong()){
            System.out.print(" es fuerte");
        }else {
            System.out.println(" no es fuerte");
        }

    }

}
