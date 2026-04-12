import java.util.Scanner;

import model.entity.Tarea;
import model.entity.Usuario;
import service.TareaService;
import service.UsuarioService;

import java.util.List;

public class Main {
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final TareaService tareaService = new TareaService(usuarioService);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE TAREAS ---");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Crear Tarea");
            System.out.println("3. Listar Usuarios");
            System.out.println("4. Listar Todas las Tareas");
            System.out.println("5. Asignar Tarea a Usuario");
            System.out.println("6. Marcar Tarea como completada");
            System.out.println("7. Listar Tareas de un Usuario (por ID)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1 -> menuCrearUsuario();
                    case 2 -> menuCrearTarea();
                    case 3 -> listarUsuarios();
                    case 4 -> listarTareas();
                    case 5 -> asignarTarea();
                    case 6 -> completarTarea();
                    case 7 -> listarTareasUsuario();
                    case 0 -> salir = true;
                    default -> System.out.println("Opcion invalida");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Programa finalizado.");
    }

    private static void menuCrearUsuario() {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad del usuario: ");
        int edad = Integer.parseInt(scanner.nextLine());
        System.out.print("Profesión: ");
        String profesion = scanner.nextLine();
        Usuario u = usuarioService.crearUsuario(nombre, edad, profesion);
        System.out.println("Usuario creado:\n " + u );
    }

    private static void menuCrearTarea() {
        System.out.print("Título de la tarea: ");
        String titulo = scanner.nextLine();
        System.out.print("Descripción: ");
        String desc = scanner.nextLine();
        Tarea t = tareaService.crearTarea(titulo, desc);
        System.out.println("Tarea creada: :\n " + t );
    }

    private static void listarUsuarios() {
        var usuarios = usuarioService.listarUsuarios();

        if(usuarios==null){
            System.out.println("No hay usuarios registrados");
        } else {
            usuarios.forEach(u -> System.out.println(u.toString()));
        }
    }

    private static void listarTareas() {
        System.out.println("\n--- LISTA DE TAREAS ---");
        tareaService.listarTareas().forEach(t -> 
            System.out.println(t.toString()));
    }

    private static void asignarTarea() {
        System.out.print("ID del Usuario al que se le asignara la tarea: ");
        int uId = Integer.parseInt(scanner.nextLine());
        System.out.print("ID de la Tarea: ");
        int tId = Integer.parseInt(scanner.nextLine());
        
        tareaService.asignarTareaAUnUsuario(uId, tId);
        System.out.println("Tarea asignada correctamente.");
    }

    private static void completarTarea() {
        System.out.print("ID de la Tarea a completar: ");
        int id = Integer.parseInt(scanner.nextLine());
        var tarea = tareaService.marcarTareaComoCompletadaPorId(id);
        System.out.println("Tarea completada:\n" + tarea);
    }

    private static void listarTareasUsuario() {
        System.out.print("ID del Usuario: ");
        int id = Integer.parseInt(scanner.nextLine());
        List<Tarea> tareasc = tareaService.listarTareasPorUsuario(id);
        
        if (tareasc.isEmpty()) {
            System.out.println("El usuario no tiene tareas asignadas.");
        } else {
            tareasc.forEach(t -> System.out.println(t));
        }
    }
}
