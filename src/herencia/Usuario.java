package herencia;

/**
 * Created by Arnau on 10/11/16.
 */
public class Usuario {

    private String nombre;
    private String apellidos;
    private int alura;
    private int peso;

    public Usuario(String nombre, String apellidos, int alura, int peso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.alura = alura;
        this.peso = peso;
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

    public int getAlura() {
        return alura;
    }

    public void setAlura(int alura) {
        this.alura = alura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
