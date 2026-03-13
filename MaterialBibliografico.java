public abstract class MaterialBibliografico {
    private String titulo;

    public MaterialBibliografico(String titulo) {
        setTitulo(titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("Error: El título no puede estar vacío.");
            this.titulo = "Sin Título";
        } else {
            this.titulo = titulo;
        }
    }

    public abstract double calcularMulta(int diasRetraso);

    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
    }
}
