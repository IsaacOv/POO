import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Receta {
    private String nombre;
    private List<String> ingredientes;
    private String pasos;
    private String imagenPlatillo;
    private List<String> utensiliosNecesarios;
    private Map<String, String> atributosExtra;

    public Receta(String nombre, List<String> ingredientes, String pasos, String imagenPlatillo, List<String> utensiliosNecesarios) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
        this.imagenPlatillo = imagenPlatillo;
        this.utensiliosNecesarios = utensiliosNecesarios;
        this.atributosExtra = new HashMap<>();
    }

    public Receta() {this.atributosExtra = new HashMap<>();}

    public void agregarAtributoExtra(String clave, String valor) {this.atributosExtra.put(clave, valor);}

    public String obtenerAtributoExtra(String clave) {return this.atributosExtra.get(clave);}

    public Map<String, String> getTodosLosAtributosExtra() {return atributosExtra;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public List<String> getIngredientes() {return ingredientes;}

    public void setIngredientes(List<String> ingredientes) {this.ingredientes = ingredientes;}

    public String getPasos() {return pasos;}

    public void setPasos(String pasos) {this.pasos = pasos;}

    public String getImagenPlatillo() {return imagenPlatillo;}

    public void setImagenPlatillo(String imagenPlatillo) {this.imagenPlatillo = imagenPlatillo;}

    public List<String> getUtensiliosNecesarios() {return utensiliosNecesarios;}

    public void setUtensiliosNecesarios(List<String> utensiliosNecesarios) {this.utensiliosNecesarios = utensiliosNecesarios;}
}
