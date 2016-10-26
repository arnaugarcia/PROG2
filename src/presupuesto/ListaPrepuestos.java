package presupuesto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arnau on 19/10/16.
 */
public class ListaPrepuestos {

    private List<Presupuesto> lista;

    public ListaPrepuestos(){
        lista = new ArrayList<>();
    }

    public List<Presupuesto> getLista() {
        return lista;
    }

    public void setLista(List<Presupuesto> lista) {
        this.lista = lista;
    }

}
