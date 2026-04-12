package model.dto;

public class CrearUsuarioDTO {
    
    private String nombre;
    private int edad;
    private String profesion;
    
    public CrearUsuarioDTO(String nombre, int edad, String profesion) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
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
