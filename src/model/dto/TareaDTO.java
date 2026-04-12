package model.dto;

import model.entity.Estado;

public class TareaDTO {

    private int id;
    private int usuarioId;
    private String titulo;
    private String descripcion;
    private Estado estado;

    public TareaDTO(int id, int usuarioId, String titulo, String descripcion, Estado estado) {
        this.usuarioId = usuarioId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
    }


    public int getId(){
        return id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Estado getEstado() {
        return estado;
    }
}
