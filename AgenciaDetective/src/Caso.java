import java.util.ArrayList;

public class Caso {

    private String nombre;
    private String codigoIdentificacion;
    private String detectiveResponsable;
    private Ubicacion[] ubicaciones;
    private ArrayList<Pista> pistas;

    public Caso(String nombre, String codigoIdentificacion,
                String detectiveResponsable) {

        this.nombre = nombre;
        this.codigoIdentificacion = codigoIdentificacion;
        this.detectiveResponsable = detectiveResponsable;
        this.ubicaciones = new Ubicacion[5];
        this.pistas = new ArrayList<Pista>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public String getDetectiveResponsable() {
        return detectiveResponsable;
    }

    public Ubicacion[] getUbicaciones() {
        return ubicaciones;
    }

    public ArrayList<Pista> getPistas() {
        return pistas;
    }

    public void registrarUbicacion(
            int posicion, Ubicacion ubicacion) {

        validarPosicion(posicion);

        if (ubicaciones[posicion] != null) {
            throw new IllegalArgumentException(
                    "La posición ya está ocupada."
            );
        }

        if (ubicacion == null) {
            throw new IllegalArgumentException(
                    "La ubicación no puede estar vacía."
            );
        }

        ubicaciones[posicion] = ubicacion;
    }

    public Ubicacion consultarUbicacion(int posicion) {
        validarPosicion(posicion);

        if (ubicaciones[posicion] == null) {
            throw new IllegalArgumentException(
                    "No existe una ubicación en esa posición."
            );
        }

        return ubicaciones[posicion];
    }

    public void modificarUbicacion(
            int posicion, int nivelRiesgo, String estado) {

        Ubicacion ubicacion =
                consultarUbicacion(posicion);

        ubicacion.setNivelRiesgo(nivelRiesgo);
        ubicacion.setEstado(estado);
    }

    public void descartarUbicacion(int posicion) {
        validarPosicion(posicion);

        if (ubicaciones[posicion] == null) {
            throw new IllegalArgumentException(
                    "No existe una ubicación en esa posición."
            );
        }

        ubicaciones[posicion] = null;
    }

    private void validarPosicion(int posicion) {
        if (posicion < 0 || posicion >= ubicaciones.length) {
            throw new IndexOutOfBoundsException(
                    "La posición debe estar entre 1 y 5."
            );
        }
    }

    public int contarUbicaciones() {
        int cantidad = 0;

        for (Ubicacion ubicacion : ubicaciones) {
            if (ubicacion != null) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public int contarEspaciosDisponibles() {
        return ubicaciones.length - contarUbicaciones();
    }

    public Ubicacion obtenerUbicacionMayorRiesgo() {
        Ubicacion ubicacionMayor = null;

        for (Ubicacion ubicacion : ubicaciones) {
            if (ubicacion != null) {
                if (ubicacionMayor == null
                        || ubicacion.getNivelRiesgo()
                        > ubicacionMayor.getNivelRiesgo()) {

                    ubicacionMayor = ubicacion;
                }
            }
        }

        return ubicacionMayor;
    }

    public void registrarPista(Pista nuevaPista) {
        if (nuevaPista == null) {
            throw new IllegalArgumentException(
                    "La pista no puede estar vacía."
            );
        }

        if (buscarPista(nuevaPista.getCodigo()) != null) {
            throw new IllegalArgumentException(
                    "Ya existe una pista con ese código."
            );
        }

        pistas.add(nuevaPista);
    }

    public Pista buscarPista(String codigo) {
        for (Pista pista : pistas) {
            if (pista.getCodigo().equalsIgnoreCase(codigo)) {
                return pista;
            }
        }

        return null;
    }

    public void modificarPista(
            String codigo,
            String nuevaDescripcion,
            String nuevoTipoEvidencia,
            int nuevaImportancia,
            int nuevaConfiabilidad) {

        Pista pista = buscarPista(codigo);

        if (pista == null) {
            throw new IllegalArgumentException(
                    "No se encontró una pista con ese código."
            );
        }

        pista.setDescripcion(nuevaDescripcion);
        pista.setTipoEvidencia(nuevoTipoEvidencia);
        pista.setNivelImportancia(nuevaImportancia);
        pista.setNivelConfiabilidad(nuevaConfiabilidad);
    }

    public void eliminarPista(String codigo) {
        Pista pista = buscarPista(codigo);

        if (pista == null) {
            throw new IllegalArgumentException(
                    "No se encontró una pista con ese código."
            );
        }

        pistas.remove(pista);
    }

    public Pista obtenerPistaMayorImportancia() {
        if (pistas.isEmpty()) {
            return null;
        }

        Pista pistaMayor = pistas.get(0);

        for (Pista pista : pistas) {
            if (pista.getNivelImportancia()
                    > pistaMayor.getNivelImportancia()) {

                pistaMayor = pista;
            }
        }

        return pistaMayor;
    }

    public Pista obtenerPistaMayorConfiabilidad() {
        if (pistas.isEmpty()) {
            return null;
        }

        Pista pistaMayor = pistas.get(0);

        for (Pista pista : pistas) {
            if (pista.getNivelConfiabilidad()
                    > pistaMayor.getNivelConfiabilidad()) {

                pistaMayor = pista;
            }
        }

        return pistaMayor;
    }

    public double calcularPromedioImportancia() {
        if (pistas.isEmpty()) {
            return 0;
        }

        int suma = 0;

        for (Pista pista : pistas) {
            suma += pista.getNivelImportancia();
        }

        return (double) suma / pistas.size();
    }
}