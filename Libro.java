public class Libro extends MaterialBibliografico {
    private int numPaginas;
    private String autor;

    public Libro(String titulo, String autor, int numPaginas) {
        super(titulo);
        setAutor(autor);
        setNumPaginas(numPaginas);
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        if (numPaginas <= 0) {
            System.out.println("Error: El número de páginas debe ser positivo.");
            this.numPaginas = 1;
        } else {
            this.numPaginas = numPaginas;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            System.out.println("Error: El autor no puede estar vacío.");
            this.autor = "Anónimo";
        } else {
            this.autor = autor;
        }
    }

    @Override
    public double calcularMulta(int diasRetraso) {
        if (diasRetraso <= 0) {
            return 0;
        }
        return diasRetraso * 5000.0;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo: Libro");
        System.out.println("Autor: " + autor);
        System.out.println("Páginas: " + numPaginas);
        System.out.println("Días de préstamo permitidos: 14");
    }
}
