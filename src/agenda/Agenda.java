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
        //String nomevent = "";
        //String fechain = "";
        //String fechaen = "";
        System.out.println("B I E N V E N I D O   A   T U   A G E N D A   E L E C T R O N I C A");
        System.out.println("********************************************************************");
        Conector ck = new Conector();
        System.out.print("Ingrese su correo: ");
        ckmail = leer.next();
        menu.getMailuser(ckmail);
        if (menu.getMailuser(ckmail) == true) {
            menu.imprimirMenuPrincipal();

        } else {
            menu.imprimirMenu();
            Conector cn = new Conector();
            leer.nextLine();
            
            System.out.println("Ingrese Email :");
            String email = leer.nextLine();
            System.out.print("Ingrese su Nombre :");
            String name = leer.nextLine();
            cn.insertarUsuarios(email, name);

        }

        do {
            menu.imprimirMenuPrincipal();
            //menu.imprimirMenu();
            System.out.print("Ingrese codigo>> ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:

                    System.out.println(menu.getAllEmails());
                    break;

                case 2:
                    do {

                        menu.imprimirMenuEventos();
                        System.out.print("Ingrese codigo>> ");
                        opcion = leer.nextInt();
                        switch (opcion) {
                            case 1:

                                Conector cn = new Conector();
                                leer.nextLine();
                                System.out.println("Ingresar asunto del evento :");
                                String nomevent = leer.nextLine();
                                System.out.print("Ingresa fecha de Inicio :");
                                String fechain = leer.nextLine();
                                System.out.print("Ingresa fecha final :");
                                String fechafin = leer.nextLine();
                                cn.insertarEventos(nomevent, fechain, fechafin);
                                break;

                            case 2:
                                Conector cn = new Conector();
                                

                                break;
                        }
                    } while (opcion != 4);

                    break;

                case 3:

                    break;

            }

        } while (opcion != 4);

    }
}

/*case 2:
                    
                     Conector cn = new Conector();
                            leer.nextLine();
                            System.out.println("Ingresar asunto del evento :");
                            String nomevent = leer.nextLine();
                            System.out.print("Ingresa fecha de Inicio :");
                            String fechain = leer.nextLine();
                            System.out.print("Ingresa fecha final :");
                            String fechafin = leer.nextLine();
                            cn.insertarEventos(nomevent, fechain,fechafin);
                            break;
                                        
                            break;
                    


 case 3:
                    
                   /* Conector cn = new Conector();
                    leer.nextLine();
                    int id = '0';
                    System.out.println("Ingrese Email :");
                    String email = leer.nextLine();
                    System.out.print("Ingrese su Nombre :");
                    String name = leer.nextLine();
                    cn.insertarUsuarios(email, name);
 */
