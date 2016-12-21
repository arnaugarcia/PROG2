package presupuesto;

import java.util.ArrayList;

/**
 * Created by Arnau on 19/10/16.
 */
public class ListaClientes {

    private ArrayList<Cliente> lista;

    public ListaClientes(){
        lista = new ArrayList<>();
    }

    public void altaCliente(Cliente c){
        lista.add(c);
    }

    public ArrayList<Cliente> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Cliente> lista) {
        this.lista = lista;
    }

    public Cliente getClienteByNumeroTelefono(int telefono){
        for (Cliente c : lista) {
            if (c.getTelefono() == telefono){
                return c;
            }
        }
        return null;
    }
}
