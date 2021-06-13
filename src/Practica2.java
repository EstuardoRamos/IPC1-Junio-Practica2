package src;

import java.util.*;


public class Practica2 {

  
    public static void main(String[] args) {
        Practica2 ipc = new Practica2();
        
    }
    boolean disponible=true;
    //boolean[] tienPelicula=new true[10];
    int numPelis=5;
    String[] clientes = new String[30];
    String[] nomPeliculas = {"Karatee kid", "karate kid 2", "Los vengadores", "Shrek", "Rambo"};
    int[] idClientes = new int[30];
    int[] idPeliculas = new int[30];
    Scanner scanner= new Scanner(System.in );
    /*"Karatee kid", "karate kid 2", "Los vengadores", "Shrek", "Rambo" */
    public Practica2 (){
        
        //llenrMatriz();
        Menu();
    }
    public void llenrMatriz(){
        /*nomPeliculas[0]="Karate kid";
        nomPeliculas[1]="Karate Kid 2";
        nomPeliculas[2]="Karate Kid ";
        nomPeliculas[3]="Los vengadores";
        nomPeliculas[4]="Shrek";
        nomPeliculas[5]="Rambo";*/
        
    }
    
    public void Menu(){
        System.out.println("\nBienvenido a la tienda Memorabilia.\n ");
        System.out.println("1. Prestamo de peliculas.");
        System.out.println("2. Devolucion de peliculas.");
        System.out.println("3. Mostrasr las peliculas");
        System.out.println("4. Ingreso de peliculas. ");
        System.out.println("5. Ordenar las peliculas. ");
        System.out.println("6. Ingresar los clientes nuevos.");
        System.out.println("7. Mostrar clientes ");
        System.out.println("8. Reportes.");
        int opc = scanner.nextInt();
        
        switch (opc) {
            case 1:
                prestarPeliculas();
               regresar();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                //agregarPeliculas();
                regresar();
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
        }
        
    }
    
    public void prestarPeliculas(){
       mostrarPeliculas();
       
        System.out.println("Seleccione la pelicula que desea rentar");
        int nP = scanner.nextInt();
        System.out.println("Ingrese el tiempo que la va a prestar");
        int tiempo= scanner.nextInt();
        System.out.println("Ingrese su id de usuario");
        int id = scanner.nextInt();
        System.out.println("Ingrse uno para aceptar alquilar la pelicula.");
        int acept= scanner.nextInt();
        if (acept==1) {
            disponible=false;
            nomPeliculas[nP]="no diponible";   
        }
        
    }
    public void peliculas(){
       
    }
    public void mostrarPeliculas(){
        for (int i = 0; i < nomPeliculas.length; i++) {
            System.out.println(nomPeliculas[i]);
            
            //System.out.println(nomPeliculas.length);
        }
    }
    public void agregarPeliculas(String[] nomPeliculas){
        //int numNue=(nomPeliculas.length+1);
        //numPelis=numNue;
        //peliculas(int numPelis);
        //System.out.println(numNue);
        System.out.println("Ingrese el nombre de la pelicula: ");
        nomPeliculas[numPelis]=scanner.next();
    }
    public void regresar(){
        System.out.print("Ingrese 5 si desea regresar:");
        int salir = scanner.nextInt();
        if (salir==5) {
            Menu();
            
        }
    }
}

