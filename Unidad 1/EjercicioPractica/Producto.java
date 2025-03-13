package ED.Guia2;

import java.util.Comparator;

public class Producto implements Comparable<Producto> {
    private String codigo;
    private String descripcion;
    private int cantidad;
    private double precio;

    public Producto(String codigo, String descripcion, int cantidad, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Implementación de Comparable (Ordenar por código)
    @Override
    public int compareTo(Producto otro) {
        return this.codigo.compareTo(otro.codigo);
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return codigo + " - " + descripcion + " | Stock: " + cantidad + " | Precio: $" + precio;
    }
}

// Comparator para ordenar por precio
class ComparadorPorPrecio implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2) {
        return Double.compare(p1.getPrecio(), p2.getPrecio());
    }
}
