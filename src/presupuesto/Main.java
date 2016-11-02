package presupuesto;

import stucom.tools.Fichero;
import stucom.tools.InputData;

import java.util.ArrayList;

import static stucom.tools.InputData.*;

/**
 * Created by Arnau on 18/10/16.
 */
public class Main {

    private static ListaClientes listaClientes;
    private static Fichero miFichero;

    public static void main(String[] args) {
        miFichero = new Fichero("clientes.xml");
        listaClientes = (ListaClientes) miFichero.leer();

        if (listaClientes == null){
            listaClientes = new ListaClientes();
        }
        int menu = 0;
        do {
            showMenu();
            menu = pedirEntero("Introduce una opción");
            switch (menu){
                case 1:
                    altaCliente();
                    break;
                case 2:
                    altaPresupuesto();
                    break;
                case 3:
                    showPresupuestosPendientes();
                    break;
                case 4:
                    showPresupuestosFromCliente();
            }
        }while(menu != 8);

    }
    public static void showMenu(){
        System.out.println("** Menú principal **");
        System.out.println("1. Alta cliente");
        System.out.println("2. Nuevo presupuesto");
        System.out.println("3. Presupuesto pendientes (de aceptar o rechazar)");
        System.out.println("4. Listado de presupuestos de un cliente determinado");
        System.out.println("5. Listado de presupuestos rechazados");
        System.out.println("6. Listado de clientes, donde aparezca también el total de presupuestos que tiene cada uno");
        System.out.println("7. Cambiar estado de un presupuesto");
        System.out.println("8. Salir");
    }
    public static Cliente altaCliente(){
        System.out.println("** Alta de un cliente **");
        String nombre = InputData.pedirCadena("Introduce el nombre del cliente");
        String apellido = InputData.pedirCadena("Introduce el apellido del cliente");
        int telefono = pedirEntero("Introduce el telefono del cliente");
        boolean vip = InputData.pedirBoolean("Introduce si el cliente es VIP");
        Cliente cliente = new Cliente(nombre, apellido, telefono, vip);
        if (listaClientes.getClienteByNumeroTelefono(telefono) == null){
            listaClientes.altaCliente(cliente);
            miFichero.grabar(listaClientes);
            return cliente;
        }else{
            System.out.println("Existe un cliente con este número de telefono: " + telefono);
            return listaClientes.getClienteByNumeroTelefono(telefono);
        }
    }
    public static void altaPresupuesto(){
        int tempTelefono = pedirEntero("Introduce su número de teléfono");
        if (listaClientes.getClienteByNumeroTelefono(tempTelefono) == null){
            System.out.println("Cliente no registrado");
            Cliente cliente = altaCliente();
            System.out.println("** Nuevo presupuesto **");
            int id = pedirEntero("Introduce numero de presupuesto");
            String concepto = pedirCadena("Introduce un concepto");
            Double precio = pedirDouble("Introduce un precio");
            Presupuesto presupuesto = new Presupuesto(id,concepto,precio,"pendiente");
            cliente.getListaPresupuestos().newPresupuesto(presupuesto);
            miFichero.grabar(listaClientes);
        }else{
            System.out.println("Cliente registrado");
            Cliente cliente = listaClientes.getClienteByNumeroTelefono(tempTelefono);
            System.out.println("** Nuevo presupuesto **");
            int id = pedirEntero("Introduce numero de presupuesto");
            String concepto = pedirCadena("Introduce un concepto");
            Double precio = pedirDouble("Introduce un precio");
            Presupuesto presupuesto = new Presupuesto(id,concepto,precio,"pendiente");
            cliente.getListaPresupuestos().newPresupuesto(presupuesto);
            miFichero.grabar(listaClientes);
        }
    }

    public static ArrayList<Presupuesto> getPresupuestosFromEstado(String estado){
        ArrayList<Presupuesto> presupuestosPendientes = new ArrayList<>();
        for (Cliente client : listaClientes.getLista()) {
            for (Presupuesto presupuesto : client.getListaPresupuestos().getLista()){
                if (presupuesto.getEstado() == estado){
                   presupuestosPendientes.add(presupuesto);
                }
            }
        }
        return presupuestosPendientes;
    }

    public static void showPresupuestosPendientes(){
        for (Presupuesto presupuestos : getPresupuestosFromEstado("pendiente")) {
            System.out.println(presupuestos.getConcepto());
        }
    }

    public static void showPresupuestosFromCliente(){
        for (Presupuesto presupuestos : getPresupuestosFromCliente()) {
            System.out.println(presupuestos.getConcepto());
        }
    }

    public static ArrayList<Presupuesto> getPresupuestosFromCliente(){
        ArrayList<Presupuesto> presupuestosCliente = new ArrayList<>();
        int numeroCliente = pedirEntero("Introduce el número de telefono");
        for (Cliente client : listaClientes.getLista()) {
            for (Presupuesto presupuesto : client.getListaPresupuestos().getLista()){
                if (client.getTelefono() == numeroCliente){
                    presupuestosCliente.add(presupuesto);
                }
            }
        }
        return presupuestosCliente;
    }

}
