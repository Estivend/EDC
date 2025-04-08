package ED.BusquedaBinaria.Ejercicio1;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        estudiantes[] est = new estudiantes[10];
        est[0] = new estudiantes(171515, "Paolo", 4.7f);
        est[1] = new estudiantes(171515, "Steven", 2.3f);
        est[2] = new estudiantes(171515, "Esperanza Gomez", 2.7f);
        est[3] = new estudiantes(171515, "Bob Patiño", 3.7f);
        est[4] = new estudiantes(171515, "Paula", 3.9f);
        est[5] = new estudiantes(171515, "Pablo", 3.5f);
        est[6] = new estudiantes(171515, "Messi", 4.9f);
        est[7] = new estudiantes(171515, "Cristiano", 4.8f);
        est[8] = new estudiantes(171515, "Kaka", 4.1f);
        est[9] = new estudiantes(12323, "Jhonny Sins", 4.2f);

        // Ordenar de forma ascendente por promedio (requerido para búsqueda binaria)
        Arrays.sort(est);

        float limite = 4.5f;
        int posicion = busquedaBinariaIterativa(est, limite);

        System.out.println("Estudiantes con promedio >= 4.5:");
        if (posicion == -1) {
            System.out.println("Ningún estudiante tiene promedio mayor o igual a " + limite);
        } else {
            // Imprimir desde la posición encontrada hasta el final (mayores o iguales)
            for (int i = est.length - 1; i >= posicion; i--) {
                if (est[i].getProm_acum() >= limite) {
                    System.out.println(est[i]);
                }
            }
        }
    }

    public static int busquedaBinariaIterativa(estudiantes[] arr, float objetivo) {
        int izquierda = 0;
        int derecha = arr.length - 1;
        int resultado = -1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            float promedioMedio = arr[medio].getProm_acum();

            if (promedioMedio == objetivo) {
                resultado = medio;
                derecha = medio - 1; // Buscar posibles iguales más a la izquierda
            } else if (promedioMedio < objetivo) {
                izquierda = medio + 1;
            } else {
                resultado = medio;
                derecha = medio - 1;
            }
        }

        return resultado;
    }
}
