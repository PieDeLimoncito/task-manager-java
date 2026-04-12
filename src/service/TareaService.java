package service;
import java.util.ArrayList;
import java.util.List;

import model.entity.Tarea;

public class TareaService {

    private List<Tarea> tareas;
    private UsuarioService servicioDeUsuarios;

    public TareaService(UsuarioService servicioDeUsuarios) {
        this.tareas = new ArrayList<>();
        this.servicioDeUsuarios = servicioDeUsuarios;
    }

    public Tarea crearTarea(String titulo, String descripcion){
        if(titulo == null){
            throw new IllegalArgumentException("La tarea no puede ser creada sin un nombre");
        }
        var t = new Tarea(titulo, descripcion);
        tareas.add(t);
        return t;
    }

    public List<Tarea> listarTareas(){
        return List.copyOf(tareas);
    }

    public Tarea marcarTareaComoCompletadaPorId(int id){
        var tarea = buscarTareaPorId(id);
        tarea.completarTarea();
        return tarea;
    }

    public Tarea asignarTareaAUnUsuario(int usuarioId, int tareaId){
        var usuario = servicioDeUsuarios.buscarUsuarioPorId(usuarioId);
        if(usuario == null){
            throw new IllegalArgumentException("No se puede asignar la tarea al usuario. Usuario no registrado con ese id");
        }

        var tarea =  buscarTareaPorId(tareaId);

        if(tarea == null){
            throw new IllegalArgumentException("No se puede asignar la tarea al usuario. Tarea no encontrada");
        }

        tarea.asignarUsuarioPorId(usuarioId);

        return tarea;
    }

    public Tarea buscarTareaPorId(int id){
        Tarea tareaEncontrada = null;
        for (int i = 0; i < tareas.size(); i++) {
            if(tareas.get(i).getId()==id){
                tareaEncontrada = tareas.get(i);
                break;
            }
        }

        if(tareaEncontrada==null){
                throw new IllegalArgumentException("Tarea no encontrada con el ID suministrado");
            }

            return tareaEncontrada;
    }

    public List<Tarea> listarTareasPorUsuario(int usuarioId){
        return tareas.stream()
        .filter(t -> t.getUsuarioId()==usuarioId)
        .toList();
    }

    public UsuarioService getServicioDeUsuarios() {
        return servicioDeUsuarios;
    }
}
