package model.mapper;

import model.dto.CrearUsuarioDTO;
import model.dto.UsuarioDTO;
import model.entity.Usuario;

public class UsuarioMapper {
    
    public static UsuarioDTO toDTO(Usuario u){

        if(u==null){
            throw new IllegalArgumentException("Usuario vacio");
        }

        var id = u.getId();
        var nombre = u.getNombre();
        var edad = u.getEdad();
        var profesion = u.getProfesion();

        return new UsuarioDTO(id, nombre, edad, profesion);
    }

    public static Usuario toEntity(CrearUsuarioDTO cud){

        if(cud == null){
            throw new IllegalArgumentException("Usuario invalido");
        }

        var nombre = cud.getNombre();
        var edad = cud.getEdad();
        var profesion = cud.getProfesion();

        return new Usuario(nombre, edad, profesion);

    }
}
