package Tarea; 
import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto por código");
            System.out.println("3. Ordenar productos por precio");
            System.out.println("4. Ordenar productos por cantidad");
            System.out.println("5. Mostrar productos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Salto de linea para consumir despues de declarar un Scanner con valor númerico 

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> buscarProducto();
                case 3 -> ordenarPorPrecio();
                case 4 -> ordenarPorCantidad();
                case 5 -> mostrarProductos();
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    // Método para agregar un producto a la lista
    private static void agregarProducto() {
        System.out.print("Ingrese código: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Salto de linea para consumir despues de declarar un Scanner con valor númerico 


        Producto nuevoProducto = new Producto(codigo, nombre, precio, cantidad);
        productos.add(nuevoProducto);
        System.out.println("Producto agregado con éxito.");
    }

    // Método para buscar un producto por código (Busqueda lineal)
    private static void buscarProducto() {
        System.out.print("Ingrese el código del producto a buscar: ");
        String codigo = scanner.nextLine();

        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                System.out.println("Producto encontrado: " + p);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    // Método para ordenar la lista por precio usando Insertion Sort
    private static void ordenarPorPrecio() {
        int n = productos.size();
        for (int i = 1; i < n; i++) {
            Producto clave = productos.get(i);
            int j = i - 1;

            while (j >= 0 && productos.get(j).compareTo(clave) > 0) {
                productos.set(j + 1, productos.get(j));
                j--;
            }
            productos.set(j + 1, clave);
        }
        System.out.println("Productos ordenados por precio.");
    }

    // Método para ordenar la lista por cantidad usando Comparator y Collections
    private static void ordenarPorCantidad() {
        productos.sort(new ComparadorCantidad());
        System.out.println("Productos ordenados por cantidad.");
    }

    // Método para mostrar todos los productos
    private static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            System.out.println("\n--- Lista de Productos ---");
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }
}
