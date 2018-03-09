/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Francisco
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here

        int opcion = 0;
        Scanner leer = new Scanner(System.in);
        Menu menu = new Menu();
        Menu menu2 = new Menu();

        String ckmail = "";
        String correo = "";
        String nombre = "";
        String datos = "";
        System.out.println("B I E N V E N I D O   A   T U   A G E N D A   E L E C T R O N I C A");
        System.out.println("********************************************************************");
        Conector ck = new Conector();
        System.out.print("Ingrese su correo: ");
        ckmail = leer.next();
        menu.getMailuser(ckmail);
        
        
        
        do {
            menu.imprimirMenu();
            System.out.print("Ingrese codigo>> ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    
                    Conector cn = new Conector();
                    leer.nextLine();
                    int id = '0';
                    System.out.println("Ingrese Email :");
                    String email = leer.nextLine();
                    System.out.print("Ingrese su Nombre :");
                    String name = leer.nextLine();
                    cn.insertarUsuarios(email, name);
                    
                    break;
                    
                case 2:
                    System.out.println(menu.getAllEmails());
                    break;
                case 3:

                    break;

            }

        } while (opcion != 4);
        

    }
}
