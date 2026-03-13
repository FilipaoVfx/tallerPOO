public class Pelicula extends MaterialBibliografico {
    private int duracion;
    private String director;

    public Pelicula(String titulo, String director, int duracion) {
        super(titulo);
        setDirector(director);
        setDuracion(duracion);
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion <= 0) {
            System.out.println("Error: La duración debe ser positiva.");
            this.duracion = 1;
        } else {
            this.duracion = duracion;
        }
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        if (director == null || director.trim().isEmpty()) {
            System.out.println("Error: El director no puede estar vacío.");
            this.director = "Desconocido";
        } else {
            this.director = director;
        }
    }

    @Override
    public double calcularMulta(int diasRetraso) {
        if (diasRetraso <= 0) {
            return 0;
        }
        return diasRetraso * 10000.0;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo: Película");
        System.out.println("Director: " + director);
        System.out.println("Duración: " + duracion + " min");
        System.out.println("Días de préstamo permitidos: 3");
    }
}
