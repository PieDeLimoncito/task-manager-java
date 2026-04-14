package service;
import java.util.ArrayList;
import java.util.List;

import model.entity.Usuario;

public class UsuarioService {

    private List<Usuario> usuarios;

    public UsuarioService(){
        this.usuarios = new ArrayList<>();
    }

    public Usuario crearUsuario(String nombre, int edad, String profesion){
        if(nombre.isBlank()){
            throw new IllegalArgumentException("No puede crear un usuario sin nombre");
        }

        if(edad <=0){
            throw new IllegalArgumentException("No puede crear un usuario con esa edad.");
        }

        var u = new Usuario(nombre, edad, profesion);
        usuarios.add(u);
        return u;
    }

    public List<Usuario> listarUsuarios(){
        return List.copyOf(usuarios);
    }

    public Usuario buscarUsuarioPorId(int id){
        return usuarios.stream()
        .filter(u -> u.getId()==id)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("El ID ingresado no esta asociado a un usuario registrado"));
    }

    public Object buscarUsuarioEntityPorId(int usuarioId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUsuarioEntityPorId'");
    }
}
