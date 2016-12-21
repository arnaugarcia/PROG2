package presupuesto;

/**
 * Created by Arnau on 18/10/16.
 */
public class Cliente {
    private String nombre;
    private String apellidos;
    private int telefono;
    private boolean vip;
    private ListaPresupuestos lista;

    public Cliente(String nombre, String apellidos, int telefono, boolean vip) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.vip = vip;
        this.lista = new ListaPresupuestos();
    }

    public Cliente() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public void setLista(ListaPresupuestos lista) {
        this.lista = lista;
    }

    public ListaPresupuestos getListaPresupuestos() { return lista; }
}
