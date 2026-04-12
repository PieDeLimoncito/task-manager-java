package model.dto;

public class CrearTareaDTO {

    private String titulo;
    private String descripcion;

    public CrearTareaDTO(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
