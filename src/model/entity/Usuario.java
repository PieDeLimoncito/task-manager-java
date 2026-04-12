package model.entity;
public class Usuario{

    private static int contador;

    private int id;
    private String nombre;
    private int edad;
    private String profesion;

    public Usuario(String nombre, int edad, String profesion){
        this.id = contador++;
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
    }

    public int getId(){
        return this.id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    
}