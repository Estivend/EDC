package Tarea; 
import java.util.Objects;

public class Producto implements Comparable<Producto> {
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    // Constructor
    public Producto(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }

    public void setPrecio(double precio) { this.precio = precio; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    // Implementación de Comparable (comparar por precio)
    @Override
    public int compareTo(Producto otro) {
        return Double.compare(this.precio, otro.precio);
    }

    // Para imprimir el producto de manera legible
    @Override
    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre +
               " | Precio: $" + precio + " | Cantidad: " + cantidad;
    }

    // Equals y hashCode para comparar por código (evitar duplicados)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return Objects.equals(codigo, producto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}


