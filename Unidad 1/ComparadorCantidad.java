package Tarea; 
import java.util.Comparator;

public class ComparadorCantidad implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2) {
        return Integer.compare(p1.getCantidad(), p2.getCantidad());
    }
}
