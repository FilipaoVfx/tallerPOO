public class Revista extends MaterialBibliografico {
    private String periodicidad;
    private int numEdicion;

    public Revista(String titulo, String periodicidad, int numEdicion) {
        super(titulo);
        setPeriodicidad(periodicidad);
        setNumEdicion(numEdicion);
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        if (periodicidad == null || periodicidad.trim().isEmpty()) {
            System.out.println("Error: La periodicidad no puede estar vacía.");
            this.periodicidad = "Mensual";
        } else {
            this.periodicidad = periodicidad;
        }
    }

    public int getNumEdicion() {
        return numEdicion;
    }

    public void setNumEdicion(int numEdicion) {
        if (numEdicion <= 0) {
            System.out.println("Error: El número de edición debe ser positivo.");
            this.numEdicion = 1;
        } else {
            this.numEdicion = numEdicion;
        }
    }

    @Override
    public double calcularMulta(int diasRetraso) {
        if (diasRetraso <= 0) {
            return 0;
        }
        return diasRetraso * 3000.0;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo: Revista");
        System.out.println("Periodicidad: " + periodicidad);
        System.out.println("Número de Edición: " + numEdicion);
        System.out.println("Días de préstamo permitidos: 7");
    }
}
