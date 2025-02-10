package edu.cesur;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static GestorCliente gestorCliente;
    private static GestorPpal gestorPpal;

    public static void main(String[] args) {
        gestorPpal = new GestorPpal();
        gestorPpal.iniciar();
        gestorCliente = new GestorCliente();

        menuPpal();

        gestorPpal.salir();

    }

    private static void menuPpal() {

        String opcion = null;
        Scanner teclado = new Scanner(System.in);

        do {
            mostrarOpcionesPpal();
            opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    menuCrear(teclado);
                    break;

                case "2":
                    menuLeer(teclado);
                    break;

                case "3":
                    menuActualizar(teclado);
                    break;

                case "4":
                    menuBorrar(teclado);
                    break;

                case "5":
                    menuLeerTodos();
                    break;
                default:
                    break;
            }
        } while (!opcion.equals("6"));

    }

    private static void menuCrear(Scanner teclado) {
        System.out.println();
        System.out.println("***   MENU INSERTAR CLIENTE   ***");
        System.out.println("--------------------------------");

        System.out.print("Introduce nombre cliente: ");
        String nombre = teclado.nextLine();

        System.out.print("Introduce Apellido1 cliente: ");
        String apellido1 = teclado.nextLine();

        System.out.print("Introduce Apellido2 cliente: ");
        String apellido2 = teclado.nextLine();

        System.out.print("Introduce comercialPrincipal cliente: ");
        String comercialPrincipal = teclado.nextLine();

        System.out.print("Introduce id empresa cliente: ");
        int idEmpresa = teclado.nextInt();
        teclado.nextLine();

        gestorCliente.create(nombre, apellido1, apellido2, comercialPrincipal, idEmpresa);
        System.out.println();
    }

    private static void menuLeer(Scanner teclado) {
        System.out.println();
        System.out.println("***   MENU LEER CLIENTE   ***");
        System.out.println("--------------------------------");

        System.out.print("Introduce ID Cliente a leer: ");
        Long id = teclado.nextLong();
        teclado.nextLine();
        System.out.println(gestorCliente.read(id));
        System.out.println();
    }

    private static void menuActualizar(Scanner teclado) {
        System.out.println();
        System.out.println("***   MENU ACTUALIZAR CLIENTE   ***");
        System.out.println("--------------------------------");
        System.out.println("INTRODUCE ID DEL CLIENTE A ACTUALIZAR");
        Long id = teclado.nextLong();
        teclado.nextLine();
        Cliente mCliente = gestorCliente.read(id);
        System.out.println("Introduce elemento a actualizar o ENTER para no actualizarlo");

        System.out.print("Introduce nombre Cliente: ");
        String nombre = teclado.nextLine();
        if (!nombre.equals(""))
            mCliente.setNombre(nombre);

        System.out.print("Introduce Apellido1 Cliente: ");
        String apellido1 = teclado.nextLine();
        if (!apellido1.equals(""))
            mCliente.setApellido1(apellido1);

        System.out.print("Introduce Apellido2 Cliente: ");
        String apellido2 = teclado.nextLine();
        if (!apellido2.equals(""))
            mCliente.setApellido2(apellido2);

        System.out.print("Introduce Comercial principal cliente: ");
        String comercialPrincipal = teclado.nextLine();
        if (!comercialPrincipal.equals(""))
            mCliente.setComercialPrincipal(comercialPrincipal);

        System.out.print("Introduce id empresa Cliente: ");
        String idEmpresa = teclado.nextLine();
        if (!idEmpresa.equals(""))
            mCliente.setIdEmpresa(Integer.parseInt(idEmpresa));

        System.out.print("Introduce fecha nueva cita (formato aaaa/mm/dd): ");
        String nuevaCita = teclado.nextLine();

        if (!nuevaCita.equals("")) {
            gestorCliente.update(mCliente.getId(), mCliente.getNombre(), mCliente.getApellido1(),
                    mCliente.getApellido2(), mCliente.getComercialPrincipal(), mCliente.getIdEmpresa(),new Date(nuevaCita));
        } else {
            gestorCliente.update(mCliente.getId(), mCliente.getNombre(), mCliente.getApellido1(),
                    mCliente.getApellido2(), mCliente.getComercialPrincipal(), mCliente.getIdEmpresa(), null);
        }

        System.out.println();
    }

    private static void menuBorrar(Scanner teclado) {
        System.out.println();
        System.out.println("***   MENU BORRAR CLIENTE   ***");
        System.out.println("--------------------------------");

        System.out.print("Introduce ID Cliente a borrar: ");
        Long id = teclado.nextLong();
        teclado.nextLine();
        gestorCliente.delete(id);
        System.out.println();
    }

    public static void menuLeerTodos() {
        System.out.println();
        List<Cliente> listado = gestorCliente.readAll();
        for (Cliente cliente : listado) {
            System.out.println(cliente);
        }
        System.out.println();
    }

    private static void mostrarOpcionesPpal() {
        System.out.println();
        System.out.println("***   INTRODUCE OPCION:   ***");
        System.out.println("-----------------------------");
        System.out.println("1) Introducir Cliente");
        System.out.println("2) Mostrar Cliente");
        System.out.println("3) Modificar Cliente");
        System.out.println("4) Borrar Cliente");
        System.out.println("5) Mostrar todos los Clientes");
        System.out.println("6) SALIR");
        System.out.println();
    }
}