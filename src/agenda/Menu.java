/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Scanner;

/**
 *
 * @author Francisco
 */
public class Menu {
     Scanner s;
    public Menu() {
    s = new Scanner(System.in);
    }
    
    public void imprimirMenu(){
        System.out.println("A G E N D A   E L E C T R O N I C A");
        System.out.println("-----------------------------");
        System.out.println("1.- Ingresa Correo.");
        System.out.println("2.- Ver Correos.");
        System.out.println("3.- Prueba deIngreso ");
        System.out.println("4.- Salir.");
        System.out.println("-----------------------------");
        int codigo = s.nextInt();
              
       
    }
    public void imprimircorreo(){
        System.out.println("-----------------------------");
        System.out.println("1.- Ingresa Correo.");
        System.out.println("2.- Ingresa Nombre.");
        System.out.println("3.- Ingresa Agenda ");
        System.out.println("4.- Salir.");
        System.out.println("-----------------------------");
        int codigo = s.nextInt();
              
     
    }
    
      
    
    public String getAllEmails(){
        Conector emp = new Conector();
        String resultado = emp.getInformacionTablauser();
        return resultado;
    }
    
    public String getUseremails(String Useremails){
        Conector emp = new Conector();
        String resultado =emp.getInformacionTablauser(Useremails);
        return resultado;
        
      }
    
    /*public String Useremails(){
        Conector ing = new Conector();
        String ingreso = ing.insertarUsuarios(p);
        return ingreso;
         
       
    }*/
    
    
}
