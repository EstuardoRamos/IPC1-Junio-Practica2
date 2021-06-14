
package src;

import java.util.*;

public class Practica2 {

    public static void main(String[] args) {
        Practica2 ipc2 = new Practica2();

    }
    //clientes
    String[] clientes = new String[30];
    int[] idClientes = new int[30];
    Boolean[] tienePelicula = new Boolean[30];
    int[] celClientes = new int[30];
    //peliculas
    String[] nomPeliculas = new String[30];
    String[] categoriaPeliculas = new String[30];
    int[] idPeliculas = new int[30];
    int[] anioPeliculas = new int[30];
    Boolean disponible[] = new Boolean[30];
    //prestamos
    int[] noDeClientesConPeli = new int[30];
    int[] peliculaRentada = new int[30];
    int[] diasRentados = new int[30];
    int noPelisRent = 0;
    int numPelis = 5;
    int numClientes = 4;

    Scanner scanner = new Scanner(System.in);

    /*"Karatee kid", "karate kid 2", "Los vengadores", "Shrek", "Rambo" */
    public Practica2() {
        llenarPeliculas(numPelis);
        llenarUsuarios();
        //llenrMatriz();
        Menu();
    }

    public void llenarPeliculas(int numPelis) {
        nomPeliculas[0] = "Karate kid    ";
        nomPeliculas[1] = "Karate Kid 2  ";
        nomPeliculas[2] = "Amaerican pie ";
        nomPeliculas[3] = "Los vengadores";
        nomPeliculas[4] = "Shrek         ";
        nomPeliculas[5] = "Rambo         ";
        anioPeliculas[0] = 1984;
        anioPeliculas[1] = 1986;
        anioPeliculas[2] = 1999;
        anioPeliculas[3] = 2012;
        anioPeliculas[4] = 2001;
        anioPeliculas[5] = 1982;
        for (int i = 0; i <= numPelis; i++) {
            idPeliculas[i] = (int) (Math.random() * 9000 + 1000);
            disponible[i] = true;
        }
        //Menu();
    }

    public void Menu() {
        int opc = 0;
        do {
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
            opc = scanner.nextInt();
        } while (opc < 1 || opc > 9);

        switch (opc) {
            case 1:
                prestarPeliculas();
                regresar();
                break;
            case 2:
                mostrarPeliculaRentadas();
                regresar();
                break;
            case 3:
                peliculasADetalle();
                regresar();
                break;
            case 4:
                crearPelicula();
                regresar();
                break;
            case 5:
                break;
            case 6:
                crearUsuario();
                regresar();
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

    public void prestarPeliculas() {
        mostrarPeliculas();
        System.out.println("");
        System.out.print("Seleccione la pelicula que desea rentar: ");
        int nP = scanner.nextInt();
        System.out.print("Ingrese el tiempo que la va a prestar: ");
        int tiempo = scanner.nextInt();
        System.out.print("Ingrese su id de usuario: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese 1 para aceptar alquilar la pelicula, o 2 para regresar al menu: ");
        int acept = scanner.nextInt();
        if (acept == 1) {
            if (disponible[nP - 1] == true) {
                agregarPeliculaAlUsuario(id, (nP - 1));
            } else {
                if (disponible[nP - 1] == false) {
                    System.out.println("\nLo sentimos!. La pelicula esta rentada");
                    System.out.println("1. volver al menu.");
                    System.out.println("2. Seleccionar otra pelicula");
                    int opcion = scanner.nextInt();
                    if (opcion == 1) {
                        Menu();
                    } else {
                        if (opcion == 2) {
                            prestarPeliculas();
                        }
                    }
                }
            }
        } else {
            if (acept == 2) {
                Menu();
            }

        }

    }

    public void llenarUsuarios() {
        clientes[0] = "Diana";
        clientes[1] = "Juan";
        clientes[2] = "Maria";
        clientes[3] = "Luz";
        clientes[4] = "Luis";
        celClientes[0] = 44571278;
        celClientes[1] = 42115691;
        celClientes[2] = 32154789;
        celClientes[3] = 47859625;
        celClientes[4] = 54156387;
        for (int i = 0; i < numClientes + 1; i++) {
            idClientes[i] = (int) (Math.random() * 900 + 100);
            tienePelicula[i] = false;

        }

    }

    public void mostrarPeliculas() {
        System.out.println("");
        System.out.println("PELICULAS");
        System.out.println("Estas son nuestras peliculas diponibles:  \n");
        for (int i = 0; i <= numPelis; i++) {

            System.out.println((i + 1) + ". " + idPeliculas[i] + " " + nomPeliculas[i] + "    Disponible: " + disponible[i]);
        }
    }

    public void peliculasADetalle() {
        System.out.println("");
        System.out.println("PELICULAS");
        System.out.println("Informacion de las peliculas\n");
        for (int i = 0; i <= numPelis; i++) {

            System.out.println((i + 1) + ". " + idPeliculas[i] + " " + nomPeliculas[i] + "    Año: " + anioPeliculas[i] + "   Categoria: " + categoriaPeliculas[i]);
        }
    }

    public void agregarPeliculaAlUsuario(int id, int noPelicula) {
        int contador = 0;
        while (contador < numClientes && idClientes[contador] != id) {
            contador++;
        }
        if (contador != numClientes) {
            System.out.println("Numero encontrado en el espacio numero " + contador);
            if (tienePelicula[contador] == true) {
                System.out.println("Ya tiene una Pelicula rentada, hasta que se devuelva puede alquilar otra. Lo sentimos...");
                //disponi[buscar]=true;
                Menu();
            } else {
                int noCliente = contador;
                tienePelicula[noCliente] = true;
                disponible[noPelicula] = false;
                peliculasRentadas(noPelicula, noCliente, id);

            }

        } else {
            System.out.println("Id no encontrado, debe de registrase. O introduzca bien los datos");
        }
    }

    public void regresar() {
        System.out.print("Ingrese S si desea regresar:  ");
        String salir = scanner.next();
        if (salir.equalsIgnoreCase("s")) {
            Menu();
        }
    }

    public void definirId(int i) {
        int numAl = (int) (Math.random() * 9000 + 1000);
        for (int j = 0; j < numClientes; j++) {
            if (idClientes[j] != numAl) {
                idPeliculas[i] = numAl;
                disponible[i] = true;
            } else {
                definirId(i);
            }
        }
        System.out.println("El Id de la pelicula es " + idClientes[i]);

    }

    public void definirIdClientes(int i) {
        int numAl = (int) (Math.random() * 900 + 100);
        for (int j = 0; j < numClientes; j++) {
            if (idClientes[j] != numAl) {
                idClientes[i] = numAl;
                tienePelicula[i] = false;
            } else {
                definirIdClientes(i);
            }

        }
        System.out.println("Su ID es " + idClientes[i]);
    }

    public void peliculasRentadas(int noPelicula, int noCliente, int dias) {

        peliculaRentada[noPelisRent] = noPelicula;
        noDeClientesConPeli[noPelisRent] = noCliente;
        diasRentados[noPelisRent] = dias;
        noPelisRent += 1;
    }

    public void mostrarPeliculaRentadas() {
        System.out.println("");
        System.out.println("Peliculas rentadas\n");
        for (int i = 0; i < noPelisRent; i++) {
            System.out.println((i + 1) + ". Pelicula: " + nomPeliculas[peliculaRentada[i]] + "  Cliente: " + clientes[noDeClientesConPeli[i]]);
        }
        System.out.println("\nIngrese El numero de la pelicula que desea devolver: ");
        int numRentada = scanner.nextInt();
        quitarPelicula((numRentada - 1));

    }

    public void quitarPelicula(int n) {
        int numero = peliculaRentada[n];
        int numeroCliente = noDeClientesConPeli[n];
        tienePelicula[numeroCliente] = false;
        disponible[numero] = true;
        for (int i = n; i < noPelisRent; i++) {
            peliculaRentada[i] = peliculaRentada[i + 1];
        }
        noPelisRent -= 1;
    }

    public void mostrarClientes() {
        System.out.println("");
        System.out.println("Informacion de los clientes\n");
        System.out.println("Estos son nuestros clientes registrados: \n");
        for (int i = 0; i < numClientes + 1; i++) {
            System.out.println((i + 1) + " Id: " + idClientes[i] + ".   Nombre cliente: " + clientes[i] + "         Telefono: " + celClientes[i] + "      Tiene rentada pelicula: " + tienePelicula[i]);

        }
    }

    public void crearPelicula() {
        System.out.println("");
        System.out.println("Ingrese los datos de la pelicula que sea ingresar.\n");
        System.out.print("Ingrese nombre de la pelicula. ");
        String nombrePeli = scanner.next();

        System.out.print("Ingrese la fecha de estreno de la pelicula: ");
        int fecha = scanner.nextInt();
        System.out.print("Ingrse la categoria a la que pertenece: ");
        String categoria = scanner.next();
        int selec = 0;
        do {
            System.out.println("Desea agregar estos datos a las peliculas.");
            System.out.println("1. Aceptar.");
            System.out.println("2. Cancelar.");
            selec = scanner.nextInt();
        } while (selec != 1 && selec != 2);
        if (selec == 1) {
            numPelis = numPelis + 1;
            nomPeliculas[numPelis] = nombrePeli;
            anioPeliculas[numPelis] = fecha;
            categoriaPeliculas[numPelis] = categoria;
            definirId(numPelis);
            //llenarPeliculas(numPelis);
            System.out.println("\nSe agregar la pelicula " + nomPeliculas[numPelis] + " ha la posision " + numPelis);
        } else {
            if (selec == 2) {
                Menu();
            }
        }
    }

    public void crearUsuario() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.next();

        System.out.print("Ingrese su numero de telefono (8 digitos): ");
        int cel = scanner.nextInt();
        int selec = 0;
        do {
            System.out.println("¿Desea agregar estos datos a los clientes ingresados?.");
            System.out.println("1. Aceptar.");
            System.out.println("2. Cancelar.");
            selec = scanner.nextInt();
        } while (selec != 1 && selec != 2);
        if (selec == 1) {
            numClientes += 1;
            clientes[numClientes] = nombre;
            celClientes[numClientes] = cel;
            definirIdClientes(numClientes);
            System.out.println("Nuevo usuario " + clientes[numClientes] + "id: " + idClientes[numClientes] + ". Se ha agregado a la lista.");
        } else {
            if (selec == 2) {
                Menu();
            }
        }
    }

    public void reportes() {

    }

}

