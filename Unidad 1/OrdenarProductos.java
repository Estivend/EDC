package ED; 
import java.util.Scanner; 
public class OrdenarProductos {

    public static void bubbleSort(Producto[] productos) {
        int n = productos.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (productos[j].precio > productos[j + 1].precio) {
                    // Intercambio
                    Producto temp = productos[j];
                    productos[j] = productos[j + 1];
                    productos[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void insertionSort(Producto[] productos) {
        int n = productos.length;
        for (int i = 1; i < n; i++) {
            Producto key = productos[i];
            int j = i - 1;
            while (j >= 0 && productos[j].precio > key.precio) {
                productos[j + 1] = productos[j];
                j--;
            }
            productos[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de productos: ");
        int cantidad = teclado.nextInt();
        teclado.nextLine(); 

        Producto[] productos = new Producto[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el nombre del producto " + (i + 1) + ": ");
            String nombre = teclado.nextLine();
            System.out.print("Ingrese el precio del producto " + (i + 1) + ": ");
            double precio = teclado.nextDouble();
            teclado.nextLine(); 
            productos[i] = new Producto(nombre, precio);
        }

        System.out.println("Seleccione el método de ordenación:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        int opcion = teclado.nextInt();

        if (opcion == 1) {
            bubbleSort(productos);
        } else if (opcion == 2) {
            insertionSort(productos);
        } else {
            System.out.println("Opción inválida.");
            return;
        }

        System.out.println("\nProductos ordenados por precio:");
        for (Producto p : productos) {
            System.out.println(p);
        }

        teclado.close();
    }
}
