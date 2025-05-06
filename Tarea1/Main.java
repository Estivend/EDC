package ED.Tareas.Tarea1;

import java.util.List;
import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
        // Crear una red social con el ejemplo del ejercicio
        String[] personas = {"Ana", "Beto", "Carlos", "Diana", "Elena"};
        RedSocialMatriz redSocial = new RedSocialMatriz(personas);
        
        // Agregar las amistades del ejemplo
        redSocial.agregarAmistad("Ana", "Beto");
        redSocial.agregarAmistad("Ana", "Diana");
        redSocial.agregarAmistad("Beto", "Carlos");
        redSocial.agregarAmistad("Beto", "Elena");
        redSocial.agregarAmistad("Carlos", "Diana");
        redSocial.agregarAmistad("Diana", "Elena");
        
        // Mostrar matriz de adyacencia
        System.out.println("Matriz de adyacencia de la red social:");
        redSocial.imprimirMatrizAdyacencia();
        
        // Mostrar amigos de cada persona
        System.out.println("\nLista de amigos:");
        for (String persona : personas) {
            System.out.println(persona + " tiene " + redSocial.contarAmigos(persona) + 
                    " amigos: " + redSocial.obtenerAmigos(persona));
        }
        
        // Mostrar usuario más popular
        System.out.println("\nEl usuario más popular es: " + redSocial.usuarioMasPopular());
        
        // Menú interactivo para probar la red social
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n--- MENÚ RED SOCIAL ---");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Crear amistad");
            System.out.println("3. Eliminar amistad");
            System.out.println("4. Verificar amistad");
            System.out.println("5. Ver amigos de un usuario");
            System.out.println("6. Ver matriz de adyacencia");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea
            
            switch (opcion) {
                case 1:
                    System.out.print("Nombre del nuevo usuario: ");
                    String nuevoUsuario = scanner.nextLine();
                    if (redSocial.agregarUsuario(nuevoUsuario)) {
                        System.out.println("Usuario agregado correctamente");
                    } else {
                        System.out.println("El usuario ya existe");
                    }
                    break;
                    
                case 2:
                    System.out.print("Nombre del primer usuario: ");
                    String u1 = scanner.nextLine();
                    System.out.print("Nombre del segundo usuario: ");
                    String u2 = scanner.nextLine();
                    
                    if (redSocial.agregarAmistad(u1, u2)) {
                        System.out.println("Amistad creada correctamente");
                    } else {
                        System.out.println("No se pudo crear la amistad (verifica los nombres)");
                    }
                    break;
                    
                case 3:
                    System.out.print("Nombre del primer usuario: ");
                    u1 = scanner.nextLine();
                    System.out.print("Nombre del segundo usuario: ");
                    u2 = scanner.nextLine();
                    
                    if (redSocial.eliminarAmistad(u1, u2)) {
                        System.out.println("Amistad eliminada correctamente");
                    } else {
                        System.out.println("No se pudo eliminar la amistad");
                    }
                    break;
                    
                case 4:
                    System.out.print("Nombre del primer usuario: ");
                    u1 = scanner.nextLine();
                    System.out.print("Nombre del segundo usuario: ");
                    u2 = scanner.nextLine();
                    
                    if (redSocial.sonAmigos(u1, u2)) {
                        System.out.println("Sí son amigos");
                    } else {
                        System.out.println("No son amigos");
                    }
                    break;
                    
                case 5:
                    System.out.print("Nombre del usuario: ");
                    String usuario = scanner.nextLine();
                    List<String> amigos = redSocial.obtenerAmigos(usuario);
                    
                    if (amigos.isEmpty()) {
                        System.out.println(usuario + " no tiene amigos o no existe");
                    } else {
                        System.out.println("Amigos de " + usuario + ": " + amigos);
                    }
                    break;
                    
                case 6:
                    redSocial.imprimirMatrizAdyacencia();
                    break;
                    
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;
                    
                default:
                    System.out.println("Opción no válida");
            }
            
        } while (opcion != 7);
        
        scanner.close();
    }
}

