import java.util.*;

// Clase Persona con Comparable para ordenar por edad
class Persona implements Comparable<Persona> {
    String nombre;
    int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método para mostrar la información de la persona
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
    }

    // Implementación de compareTo para ordenar por edad (de menor a mayor)
    @Override
    public int compareTo(Persona otra) {
        return Integer.compare(this.edad, otra.edad); 
    }
}

// Comparator para ordenar por nombre en orden alfabético
class ComparadorPorNombre implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.nombre.compareTo(p2.nombre);
    }
}

// Clase principal
public class OrdenarPersona {
    public static void main(String[] args) {
        // Lista de 10 personas con nombres y edades
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Carlos", 30));
        personas.add(new Persona("Ana", 25));
        personas.add(new Persona("Luis", 22));
        personas.add(new Persona("María", 27));
        personas.add(new Persona("Pedro", 35));
        personas.add(new Persona("Sofía", 20));
        personas.add(new Persona("Jorge", 28));
        personas.add(new Persona("Elena", 24));
        personas.add(new Persona("Daniel", 32));
        personas.add(new Persona("Gabriela", 29));

        // 🔹 Ordenar por edad (usando Comparable)
        Collections.sort(personas);
        System.out.println("🔹 Lista ordenada por edad:");
        for (Persona p : personas) {
            p.mostrarInfo();
        }

        // 🔹 Ordenar por nombre (usando Comparator)
        Collections.sort(personas, new ComparadorPorNombre());
        System.out.println("\n🔹 Lista ordenada por nombre:");
        for (Persona p : personas) {
            p.mostrarInfo();
        }
    }
}
