package model;
public class Tarea {

    private static int contador;

    private int id;
    private int usuarioId;
    private String titulo;
    private String descripcion;
    private Estado estado;

    public Tarea(String titulo, String descripcion){
        this.id = contador++;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = Estado.PENDIENTE;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void completarTarea() {
        this.estado = Estado.COMPLETADA;
    }

    public void asignarUsuarioPorId(int id){
        this.usuarioId = id;
    }

    public int getUsuarioId(){
        return this.usuarioId;
    }
}
