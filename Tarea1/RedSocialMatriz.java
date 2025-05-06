package ED.Tareas.Tarea1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que implementa una red social usando una matriz de adyacencia
 */
public class RedSocialMatriz {
    
    private List<String> usuarios;  // Lista de nombres de usuarios
    private int[][] matrizAdyacencia;  // Matriz de adyacencia
    private int numUsuarios;  // Número de usuarios en la red
    
    /**
     * Constructor para crear una red social vacía
     */
    public RedSocialMatriz() {
        usuarios = new ArrayList<>();
        numUsuarios = 0;
        matrizAdyacencia = new int[10][10];  // Tamaño inicial para 10 usuarios
    }
    
    /**
     * Constructor para crear una red social con usuarios predefinidos
     * @param nombresUsuarios Lista de nombres de usuarios
     */
    public RedSocialMatriz(String[] nombresUsuarios) {
        this();
        for (String nombre : nombresUsuarios) {
            agregarUsuario(nombre);
        }
    }
    
    /**
     * Agrega un nuevo usuario a la red social
     * @param nombre Nombre del usuario
     * @return true si se agregó correctamente, false si ya existía
     */
    public boolean agregarUsuario(String nombre) {
        // Verificar si el usuario ya existe
        if (usuarios.contains(nombre)) {
            return false;
        }
        
        // Redimensionar la matriz si es necesario
        if (numUsuarios >= matrizAdyacencia.length) {
            expandirMatriz();
        }
        
        usuarios.add(nombre);
        numUsuarios++;
        return true;
    }
    
    /**
     * Expande el tamaño de la matriz cuando se llena
     */
    private void expandirMatriz() {
        int nuevoTamaño = matrizAdyacencia.length * 2;
        int[][] nuevaMatriz = new int[nuevoTamaño][nuevoTamaño];
        
        // Copiar datos existentes
        for (int i = 0; i < numUsuarios; i++) {
            for (int j = 0; j < numUsuarios; j++) {
                nuevaMatriz[i][j] = matrizAdyacencia[i][j];
            }
        }
        
        matrizAdyacencia = nuevaMatriz;
    }
    
    /**
     * Añade una relación de amistad entre dos usuarios
     * @param usuario1 Primer usuario
     * @param usuario2 Segundo usuario
     * @return true si se creó la relación, false si no se pudo
     */
    public boolean agregarAmistad(String usuario1, String usuario2) {
        // Obtener índices de los usuarios
        int indice1 = usuarios.indexOf(usuario1);
        int indice2 = usuarios.indexOf(usuario2);
        
        // Verificar que ambos usuarios existan
        if (indice1 == -1 || indice2 == -1) {
            return false;
        }
        
        // Establecer relación bidireccional (no dirigida)
        matrizAdyacencia[indice1][indice2] = 1;
        matrizAdyacencia[indice2][indice1] = 1;
        
        return true;
    }
    
    /**
     * Elimina la relación de amistad entre dos usuarios
     * @param usuario1 Primer usuario
     * @param usuario2 Segundo usuario
     * @return true si se eliminó la relación, false si no se pudo
     */
    public boolean eliminarAmistad(String usuario1, String usuario2) {
        // Obtener índices de los usuarios
        int indice1 = usuarios.indexOf(usuario1);
        int indice2 = usuarios.indexOf(usuario2);
        
        // Verificar que ambos usuarios existan
        if (indice1 == -1 || indice2 == -1) {
            return false;
        }
        
        // Eliminar relación bidireccional
        matrizAdyacencia[indice1][indice2] = 0;
        matrizAdyacencia[indice2][indice1] = 0;
        
        return true;
    }
    
    /**
     * Verifica si dos usuarios son amigos
     * @param usuario1 Primer usuario
     * @param usuario2 Segundo usuario
     * @return true si son amigos, false si no lo son o no existen
     */
    public boolean sonAmigos(String usuario1, String usuario2) {
        // Obtener índices de los usuarios
        int indice1 = usuarios.indexOf(usuario1);
        int indice2 = usuarios.indexOf(usuario2);
        
        // Verificar que ambos usuarios existan
        if (indice1 == -1 || indice2 == -1) {
            return false;
        }
        
        return matrizAdyacencia[indice1][indice2] == 1;
    }
    
    /**
     * Obtiene la lista de amigos de un usuario
     * @param usuario Nombre del usuario
     * @return Lista de nombres de los amigos
     */
    public List<String> obtenerAmigos(String usuario) {
        List<String> amigos = new ArrayList<>();
        int indice = usuarios.indexOf(usuario);
        
        if (indice == -1) {
            return amigos; // Retorna lista vacía si el usuario no existe
        }
        
        // Buscar en la matriz de adyacencia
        for (int i = 0; i < numUsuarios; i++) {
            if (matrizAdyacencia[indice][i] == 1) {
                amigos.add(usuarios.get(i));
            }
        }
        
        return amigos;
    }
    
    /**
     * Calcula el número de amigos (grado) de un usuario
     * @param usuario Nombre del usuario
     * @return Número de amigos o -1 si el usuario no existe
     */
    public int contarAmigos(String usuario) {
        int indice = usuarios.indexOf(usuario);
        
        if (indice == -1) {
            return -1; // Usuario no existe
        }
        
        int contador = 0;
        for (int i = 0; i < numUsuarios; i++) {
            contador += matrizAdyacencia[indice][i];
        }
        
        return contador;
    }
    
    /**
     * Encuentra al usuario más popular (con más amigos)
     * @return Nombre del usuario más popular
     */
    public String usuarioMasPopular() {
        if (numUsuarios == 0) {
            return null;
        }
        
        int maxAmigos = -1;
        int indicePopular = -1;
        
        for (int i = 0; i < numUsuarios; i++) {
            int amigos = 0;
            for (int j = 0; j < numUsuarios; j++) {
                amigos += matrizAdyacencia[i][j];
            }
            
            if (amigos > maxAmigos) {
                maxAmigos = amigos;
                indicePopular = i;
            }
        }
        
        return usuarios.get(indicePopular);
    }
    
    /**
     * Imprime la matriz de adyacencia en formato legible
     */
    public void imprimirMatrizAdyacencia() {
        if (numUsuarios == 0) {
            System.out.println("La red social está vacía");
            return;
        }
        
        // Imprimir encabezado de columnas
        System.out.print("     ");
        for (int i = 0; i < numUsuarios; i++) {
            System.out.printf("%-8s", usuarios.get(i));
        }
        System.out.println();
        
        // Imprimir filas con nombres y valores
        for (int i = 0; i < numUsuarios; i++) {
            System.out.printf("%-5s", usuarios.get(i));
            for (int j = 0; j < numUsuarios; j++) {
                System.out.printf("%-8d", matrizAdyacencia[i][j]);
            }
            System.out.println();
        }
    }}
