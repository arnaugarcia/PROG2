package presupuesto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Arnau on 19/10/16.
 */
public class ListaPresupuestos implements Serializable{

    private ArrayList<Presupuesto> lista;

    public ListaPresupuestos(){
        lista = new ArrayList<>();
    }

    public void setLista(ArrayList<Presupuesto> lista) {
        this.lista = lista;
    }

    public ArrayList<Presupuesto> getLista() {return this.lista;}

    public void newPresupuesto(Presupuesto presupuesto){
        lista.add(presupuesto);
    }


}
