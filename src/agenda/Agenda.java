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
        
         int opcion =0;
        Scanner leer = new Scanner (System.in);
        Menu menu = new Menu();
        Menu menu2 = new Menu();
        String ckmail = "";
        String correo = "";
        String nombre = "";
        System.out.println("B I E N V E N I D O   A   T U   A G E N D A   E L E C T R O N I C A");
        System.out.println("********************************************************************");
        System.out.print("Ingrese su correo: ");
        ckmail = leer.next();
        
        do {
            menu.imprimirMenu();
            System.out.print("Ingrese codigo>> ");
            opcion = leer.nextInt();
            switch (opcion){
                case 1:
                   
                    
                    do{
                    menu2.imprimircorreo();
                    correo = leer.nextLine();
                    System.out.println("Ingrese sus datos");
                    System.out.print("Nombre correo : ");
                    correo = leer.nextLine();
                    System.out.print("Nombre : ");
                    nombre = leer.nextLine();
                    break;
                    }while(opcion !=4);
                    
                    
                case 2:
                    System.out.println(menu.getAllEmails());
                    break;
                case 3:
                    /*System.out.print("Ingrese Correo ");
                    String email = leer.nextLine();
                    System.out.println(email);
                    //stem.out.println(menu.getUseremails(Useremails);*/
                     Usuarios p1 = new Usuarios(2,"c.williams@hotmail.com","Carlos Williams");
                     Conector cn = new Conector();
                     cn.insertar(p1);
                    
                    break;
                //default:
            }
            
        }while(opcion!=4);
        
        
       
        
       
        
    }
}
