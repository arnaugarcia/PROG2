package presupuesto;

import stucom.tools.Fichero;
import stucom.tools.InputData;

import static stucom.tools.InputData.pedirCadena;
import static stucom.tools.InputData.pedirDouble;
import static stucom.tools.InputData.pedirEntero;

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
    public static void altaCliente(){
        System.out.println("** Alta de un cliente **");
        String nombre = InputData.pedirCadena("Introduce el nombre del cliente");
        String apellido = InputData.pedirCadena("Introduce el apellido del cliente");
        int telefono = pedirEntero("Introduce el telefono del cliente");
        boolean vip = InputData.pedirBoolean("Introduce si el cliente es VIP");
        Cliente cliente = new Cliente(nombre, apellido, telefono, vip);
        if (listaClientes.getClienteByNumeroTelefono(telefono) == null){
            listaClientes.altaCliente(cliente);
            miFichero.grabar(listaClientes);
        }else{
            System.out.println("Existe un cliente con este número de telefono: " + telefono);
        }
    }
    public static void checkIfTelefonoExists(){
        int tempTelefono = pedirEntero("Introduce su número de teléfono");
        if (listaClientes.getClienteByNumeroTelefono(tempTelefono) == null){
            System.out.println("Cliente no registrado");
            altaCliente();
        }else{
            System.out.println("Cliente registrado");
        }
    }
    public static void altaPresupuesto(){
        checkIfTelefonoExists();
        System.out.println("** Nuevo presupuesto **");
        int id = pedirEntero("Introduce numero de presupuesto");
        String concepto = pedirCadena("Introduce un concepto");
        Double precio = pedirDouble("Introduce un precio");
        Presupuesto presupuesto = new Presupuesto(id,concepto,precio,"pendiente");
        //listaClientes.getClienteByNumeroTelefono();
    }
}
