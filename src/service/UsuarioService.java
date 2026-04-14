package service;
import java.util.ArrayList;
import java.util.List;

import model.dto.CrearUsuarioDTO;
import model.dto.UsuarioDTO;
import model.entity.Usuario;
import model.mapper.UsuarioMapper;

public class UsuarioService {

    private List<Usuario> usuarios;

    public UsuarioService(){
        this.usuarios = new ArrayList<>();
    }

    public UsuarioDTO crearUsuario(CrearUsuarioDTO cud){

        if (cud == null){
            throw new IllegalArgumentException("Solicitud de crear usuario vacia");
        }
        if(cud.getNombre().isBlank()){
            throw new IllegalArgumentException("No puede crear un usuario sin nombre");
        }

        if(cud.getEdad()<=0 || cud.getEdad()>150){
            throw new IllegalArgumentException("No se puede crear a un usuario con esta edad");
        }

        if(cud.getProfesion().isBlank()){
            throw new IllegalArgumentException("No es posible crear un usuario sin profesion");
        }

        var u = UsuarioMapper.toEntity(cud);
        usuarios.add(u);
        return UsuarioMapper.toDTO(u);
    }

    public List<UsuarioDTO> listarUsuarios(){
        return usuarios.stream()
        .map(UsuarioMapper::toDTO)
        .toList();
    }

    private Usuario buscarUsuarioEntityPorId(int id){
        for(Usuario u : usuarios){
            if(u.getId() == id){
                return u;
            }
        }

        throw new IllegalArgumentException("No se ha encontrado un usuario con este ID");
    }

    public UsuarioDTO buscarUsuarioPorId(int id){
        var u = buscarUsuarioEntityPorId(id);
        return UsuarioMapper.toDTO(u);
    }
}
