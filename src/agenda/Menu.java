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
        System.out.println("1.- Ingresa Nuevo Usuario.");
        System.out.println("-----------------------------");
                
        int codigo = s.nextInt();
              
       
    }
    public void imprimirMenuPrincipal(){
        System.out.println("-----------------------------");
        System.out.println("M E N U  P R I N C I P A L");
        System.out.println("1.) Ver Correos de Usuarios");
        System.out.println("2.) Ir a menu de eventos");
        System.out.println("4.) Salir");
        System.out.println("-----------------------------");
        int codigo = s.nextInt();
              
     
    }
    public void imprimirMenuEventos(){
        System.out.println("-----------------------------");
        System.out.println("I N G R E S O  D E   E V E N T O S");
        System.out.println("1.) Ingresar Eventos");
        System.out.println("2.) Ver los Primeros Eventos");
        System.out.println("3.) Ver todos los Eventos");
        System.out.println("4.) Salir");
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
    public boolean getMailuser(String ckmail){
        Conector emp = new Conector();
        boolean resultado = emp.getCorreoTablauser(ckmail);
        return resultado;
        
    
    }
   
    
    
}
