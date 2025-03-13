package ED.Guia2;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Inventario {
    private ListaEnlazada productos = new ListaEnlazada();
    private Stack<Producto> devoluciones = new Stack<>();
    private Queue<Producto> reposiciones = new LinkedList<>();

    // Agregar producto al inventario
    public void agregarProducto(Producto p) {
        productos.agregarProducto(p);
    }

    // Buscar producto en el inventario
    public Producto buscarProducto(String codigo) {
        return productos.buscarProducto(codigo);
    }

    // Eliminar un producto del inventario
    public boolean eliminarProducto(String codigo) {
        return productos.eliminarProducto(codigo);
    }

    // Agregar devolución
    public void agregarDevolucion(Producto p) {
        devoluciones.push(p);
    }

    // Agregar reposición
    public void agregarReposicion(Producto p) {
        reposiciones.offer(p);
    }

    // Procesar reposición
    public void procesarReposicion() {
        if (!reposiciones.isEmpty()) {
            System.out.println("Procesando reposición: " + reposiciones.poll());
        } else {
            System.out.println("No hay reposiciones pendientes.");
        }
    }

    // Mostrar inventario
    public void mostrarInventario() {
        productos.mostrarInventario();
    }
}
