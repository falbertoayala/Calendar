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
        System.out.println("I N G R E S O   D E   N U E V O   U S U A R I O");
        System.out.println("-----------------------------");
        System.out.println("1.- Ingresa Correo.");
        System.out.println("2.- Ver Correos.");
        System.out.println("3.- INgresar");
        System.out.println("4.- Salir.");
        System.out.println("-----------------------------");
        int codigo = s.nextInt();
              
       
    }
    public void imprimircorreo(){
        System.out.println("-----------------------------");
        System.out.println("Ingresar Usuario.");
        System.out.println("4.- Salir.");
        System.out.println("-----------------------------");
        //int codigo = s.nextInt();
              
     
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
    public boolean getMailuser(String ckmail){
        Conector emp = new Conector();
        boolean resultado = emp.getCorreoTablauser(ckmail);
        return resultado;
        
    
    }
   
    
    
}
