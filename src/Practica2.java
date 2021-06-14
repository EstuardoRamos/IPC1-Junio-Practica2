
package src;

import java.util.*;


public class Practica2 {

  
    public static void main(String[] args) {
        Practica2 ipc2 = new Practica2();
        
    }
    
    Boolean[] tienPelicula=new Boolean[30];
    String[] clientes = new String[30];
    String[] nomPeliculas = new String[30];
    int[] idClientes = new int[30];
    int[] idPeliculas = new int[30];
    Boolean disponi[] = new Boolean[30];
    int numPelis=5;
    int numClientes;
    
    Scanner scanner= new Scanner(System.in );
    /*"Karatee kid", "karate kid 2", "Los vengadores", "Shrek", "Rambo" */
    public Practica2 (){
        llenarPeliculas(numPelis);
        llenarUsuarios();
        //llenrMatriz();
        Menu();
    }
    public void llenarPeliculas(int numPelis){
        nomPeliculas[0]="Karate kid    ";
        nomPeliculas[1]="Karate Kid 2  ";
        nomPeliculas[2]="Amaerican pie    ";
        nomPeliculas[3]="Los vengadores";
        nomPeliculas[4]="Shrek         ";
        nomPeliculas[5]="Rambo         ";
        for (int i = 0; i <= numPelis; i++) {
            idPeliculas[i] = (int) (Math.random() * 9999 + 1000);
            disponi[i] = true; 
        }
        //Menu();
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
        System.out.println("9. Salir.");
        System.out.print("Ingrese la opcion que desea realizar: ");
        int opc = scanner.nextInt();
        
        switch (opc) {
            case 1:
               prestarPeliculas();
               regresar();
                break;
            case 2:
                devolverPelicula();
                regresar();
                break;
            case 3:
                break;
            case 4:
                crearPelicula();
                regresar();
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                mostrarClientes();
                regresar();
                break;
            case 8:
                break;
            case 9:
                System.out.println("Adios");
                break;
        }
        
    }
    
    public void prestarPeliculas(){
       mostrarPeliculas();
       
        System.out.println("Seleccione la pelicula que desea rentar: ");
        int nP = scanner.nextInt();
        System.out.print("Ingrese el tiempo que la va a prestar: ");
        int tiempo= scanner.nextInt();
        System.out.print("Ingrese su id de usuario: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese 1 para aceptar alquilar la pelicula, o 2 para regresar al menu: ");
        int acept= scanner.nextInt();
        if (acept==1) {
            if (disponi[nP-1]==true){
            agregarPeliculaAlUsuario(id,(nP-1));
            }
            else{
                if(disponi[nP-1]==false){
                    System.out.println("la pelicula esta rentada");
                    System.out.println("1. volver al menu.");
                    System.out.println("2. Seleccionar otra pelicula");
                    int opcion=scanner.nextInt();
                    if (opcion==1) {
                        Menu();
                    } 
                    else {
                        if (opcion==2) {
                            prestarPeliculas();
                        }
                    }
                }
            }
        }
        else{
            if (acept==2){
                Menu();
            }
            
        }
        
    }
    public void llenarUsuarios() {
        clientes[1] = "Juan";
        clientes[2] = "MAria";
        clientes[3] = "Luz";
        clientes[4] = "Luis";
        for (int i = 0; i < 4; i++) {
            idClientes[i] = (int) (Math.random() * 999 + 100);
            tienPelicula[i] = false;
            
        }

    }
    public void mostrarPeliculas(){
        for (int i = 0; i <=numPelis; i++) {
            
            System.out.println((i+1)+". "+idPeliculas[i]+" "+nomPeliculas[i]+ "    Disponible: "+disponi[i]);
        }
    }
    public void agregarPeliculaAlUsuario(int buscar,int pel){
        int contador = 0;
        while (contador < 4 && idClientes[contador] != buscar) {
            contador++;
        }
        if (contador != 4) {
            System.out.println("Numero encontrado en el espacio numero " + contador);
            if (tienPelicula[contador]==true) {
                System.out.println("Ya tiene una Pelicula rentada, hasta que se devuelva puede alquilar otra. Lo sentimos...");
                //disponi[buscar]=true;
                Menu();
            } else {
                tienPelicula[contador]=true;
                disponi[pel]=false;
            }
            

        } else {
            System.out.println("Numero no encontrado");
        }
    }
    public void regresar(){
        System.out.print("Ingrese 5 si desea regresar:");
        int salir = scanner.nextInt();
        if (salir==5) {
            Menu();
          
        }
    }
    public void definirId(){
        for (int i = 0; i < 5; i++) {
            idPeliculas[i]=(int) (Math.random()*999+100);
        }
    }
    
    public void definirIdClientes(){
        for (int i = 0; i < 10; i++) {
            idClientes[i]=(int) (Math.random()*9999+1000);     
        }
    }
    
    public void peliculasRentadas(String peliculaRen, int idCliente, int dias){
        int posicion = 0;
        String[] peliculasRentadas = new String[30];
        int[] idClientesConPeli=new int[30];
        int[] diasRentados=new int[30];
               posicion=posicion+1;
               peliculasRentadas[posicion]=peliculaRen;
               idClientesConPeli[posicion]=idCliente;
               diasRentados[posicion]=dias;
    }
    public void devolverPelicula(){
        System.out.println("Peliculas rentadas");
        for (int i = 0; i < 5; i++) {
            if (disponi[i] ==false) {
                System.out.println(+i + " " + nomPeliculas[i] + "Dias de alquiler");
            }
        }  
    }
    public void mostrarClientes(){
        for (int i = 0; i < 4; i++) {
            System.out.println((i+1)+" Id: "+idClientes[i]+".   Nombre cliente: "+clientes[i]+"      Tiene rentada pelicula: "+tienPelicula[i]);
            
        }
    }
    public void crearPelicula(){
        System.out.print("Ingrese nombre de la pelicula. ");
        String nombrePeli=scanner.next();
        System.out.println("Desea agregar estos datos a las peliculas.");
        System.out.println("1. Aceptar.");
        System.out.println("2. Cancelar.");
        int selec=scanner.nextInt();
        if (selec==1) {
            numPelis=numPelis+1;
            nomPeliculas[numPelis]=nombrePeli;
            llenarPeliculas(numPelis);
            System.out.println("Se agregar la pelicula "+nomPeliculas[numPelis]+" ha la posision "+numPelis);
        } else {
        }
    } 
    
}
