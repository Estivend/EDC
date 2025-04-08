package ED.BusquedaBinaria.Ejercicio1;

public class estudiantes implements Comparable <estudiantes> {
    int id; 
    String Nombre;
    float Prom_acum;
    

    public estudiantes(int id, String nombre, float prom_acum) {
        this.id = id;
        Nombre = nombre;
        Prom_acum = prom_acum;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public float getProm_acum() {
        return Prom_acum;
    }
    public void setProm_acum(float prom_acum) {
        Prom_acum = prom_acum;
    }
    @Override
    public int compareTo(estudiantes o) {
        return Float.compare(this.Prom_acum,o.Prom_acum); 
    }

    @Override
    public String toString() {
        return id + "- Nombre: " + Nombre + "- Promedio Acumulado: " + Prom_acum; 
    }

    
}

