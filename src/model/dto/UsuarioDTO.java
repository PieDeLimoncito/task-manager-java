package model.dto;

public class UsuarioDTO {
    
    private int id;
    private String nombre;
    private int edad;
    private String profesion;

    public UsuarioDTO(int id, String nombre, int edad, String profesion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getProfesion() {
        return profesion;
    }
    

    
    
}
