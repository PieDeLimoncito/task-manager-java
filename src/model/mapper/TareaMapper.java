package model.mapper;

import model.dto.CrearTareaDTO;
import model.dto.TareaDTO;
import model.entity.Tarea;

public class TareaMapper {

    public static TareaDTO toDto(Tarea t){

        if(t== null){
            throw new IllegalArgumentException("Tarea no valida");
        }

        var id = t.getId();
        var usuarioId = t.getUsuarioId();
        var titulo = t.getTitulo();
        var descripcion = t.getDescripcion();
        var estado = t.getEstado();

        return new TareaDTO(id, usuarioId, titulo, descripcion, estado);
    }
    
    public static Tarea toEntity(CrearTareaDTO ctd){

        if(ctd == null){
            throw new IllegalArgumentException("Tarea no creada");
        }

        var titulo= ctd.getTitulo();
        var descripcion= ctd.getDescripcion();

        return new Tarea(titulo, descripcion);
        
    }
}
