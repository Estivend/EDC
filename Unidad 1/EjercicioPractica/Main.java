package ED.Guia2;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // Agregar productos al inventario
        inventario.agregarProducto(new Producto("A101", "Laptop Lenovo", 5, 2500.0));
        inventario.agregarProducto(new Producto("B202", "Mouse Logitech", 15, 30.0));
        inventario.agregarProducto(new Producto("C303", "Teclado Mecánico", 8, 80.0));
        inventario.agregarProducto(new Producto("C312", "Ipad", 32, 54.0));

        // Mostrar inventario
        System.out.println("Inventario Actual:");
        inventario.mostrarInventario();

        // Buscar un producto
        System.out.println("\nBuscando producto B202:");
        Producto buscado = inventario.buscarProducto("B202");
        System.out.println(buscado != null ? buscado : "No encontrado.");

        // Eliminar un producto
        System.out.println("\nEliminando producto C303...");
        boolean eliminado = inventario.eliminarProducto("C303");
        System.out.println(eliminado ? "Producto eliminado." : "Producto no encontrado.");

        // Mostrar inventario actualizado
        System.out.println("\nInventario después de eliminar:");
        inventario.mostrarInventario();

        // Agregar devoluciones y reposiciones
        inventario.agregarDevolucion(new Producto("B202", "Mouse Logitech", 1, 30.0));
        inventario.agregarReposicion(new Producto("A101", "Laptop Lenovo", 3, 2500.0));

        // Procesar reposición
        inventario.procesarReposicion();
    }
}

