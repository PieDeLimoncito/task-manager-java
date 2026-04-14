package service;
import java.util.ArrayList;
import java.util.List;

import model.dto.CrearTareaDTO;
import model.dto.TareaDTO;
import model.entity.Tarea;
import model.mapper.TareaMapper;

public class TareaService {

    private List<Tarea> tareas;
    private UsuarioService servicioDeUsuarios;

    public TareaService(UsuarioService servicioDeUsuarios) {
        this.tareas = new ArrayList<>();
        this.servicioDeUsuarios = servicioDeUsuarios;

    }

    public TareaDTO crearTarea(CrearTareaDTO ctd){
        if(ctd == null){
            throw new IllegalArgumentException("Solicitud vacia");
        }

        var t = TareaMapper.toEntity(ctd);

        tareas.add(t);
        return TareaMapper.toDto(t);
    }

    public List<TareaDTO> listarTareas(){
        return tareas.stream()
        .map(TareaMapper::toDto)
        .toList();
    }

    public TareaDTO marcarTareaComoCompletadaPorId(int id){
        var tarea = buscarTareaEntityPorId(id);
        tarea.completarTarea();
        return TareaMapper.toDto(tarea);
    }

    public TareaDTO asignarTareaAUnUsuario(int usuarioId, int tareaId){
        var usuario = servicioDeUsuarios.buscarUsuarioEntityPorId(usuarioId);

        if(usuario == null){
            throw new IllegalArgumentException("No se puede asignar la tarea al usuario. Usuario no registrado con ese id");
        }

        var tarea =  buscarTareaEntityPorId(tareaId);

        if(tarea == null){
            throw new IllegalArgumentException("No se puede asignar la tarea al usuario. Tarea no encontrada");
        }

        tarea.asignarUsuarioPorId(usuarioId);

        return TareaMapper.toDto(tarea);
    }

    private Tarea buscarTareaEntityPorId(int id){
        for (Tarea t : tareas) {
            if(t.getId()== id){
                return t;
            }
        }
        throw new IllegalArgumentException("Tarea no encontrada con el ID suministrado");
    }
    

    public TareaDTO buscarTareaPorId(int id){
        var t = buscarTareaEntityPorId(id);
        return TareaMapper.toDto(t);

    }

    public List<TareaDTO> listarTareasPorUsuario(int usuarioId){
        return tareas.stream()
        .filter(t -> t.getUsuarioId()==usuarioId)
        .map(TareaMapper::toDto)
        .toList();
    }

    public UsuarioService getServicioDeUsuarios() {
        return servicioDeUsuarios;
    }
}
