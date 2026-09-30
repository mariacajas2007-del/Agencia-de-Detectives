public class Pista {

    private String codigo;
    private String descripcion;
    private String tipoEvidencia;
    private int nivelImportancia;
    private int nivelConfiabilidad;

    public Pista(
            String codigo,
            String descripcion,
            String tipoEvidencia,
            int nivelImportancia,
            int nivelConfiabilidad) {

        validarNivelImportancia(nivelImportancia);
        validarNivelConfiabilidad(nivelConfiabilidad);

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipoEvidencia = tipoEvidencia;
        this.nivelImportancia = nivelImportancia;
        this.nivelConfiabilidad = nivelConfiabilidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoEvidencia() {
        return tipoEvidencia;
    }

    public int getNivelImportancia() {
        return nivelImportancia;
    }

    public int getNivelConfiabilidad() {
        return nivelConfiabilidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipoEvidencia(String tipoEvidencia) {
        this.tipoEvidencia = tipoEvidencia;
    }

    public void setNivelImportancia(int nivelImportancia) {
        validarNivelImportancia(nivelImportancia);
        this.nivelImportancia = nivelImportancia;
    }

    public void setNivelConfiabilidad(
            int nivelConfiabilidad) {

        validarNivelConfiabilidad(nivelConfiabilidad);
        this.nivelConfiabilidad = nivelConfiabilidad;
    }

    private void validarNivelImportancia(
            int nivelImportancia) {

        if (nivelImportancia < 1
                || nivelImportancia > 10) {

            throw new IllegalArgumentException(
                    "El nivel de importancia debe estar entre 1 y 10."
            );
        }
    }

    private void validarNivelConfiabilidad(
            int nivelConfiabilidad) {

        if (nivelConfiabilidad < 0
                || nivelConfiabilidad > 100) {

            throw new IllegalArgumentException(
                    "El nivel de confiabilidad debe estar entre 0 y 100."
            );
        }
    }

    @Override
    public String toString() {
        return "\nCódigo: " + codigo
                + "\nDescripción: " + descripcion
                + "\nTipo de evidencia: " + tipoEvidencia
                + "\nNivel de importancia: " + nivelImportancia
                + "\nNivel de confiabilidad: "
                + nivelConfiabilidad + "%";
    }
}