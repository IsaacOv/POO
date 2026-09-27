import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdministradorRecetas {

    private List<Receta> catalogoRecetas;

    public AdministradorRecetas() {
        this.catalogoRecetas = new ArrayList<>();
    }


    public void agregarReceta(Receta receta) {
        catalogoRecetas.add(receta);
    }


    public List<Receta> buscarPorIngredientes(List<String> ingredientesUsuario) {
        List<Receta> recetasSugeridas = new ArrayList<>();
        Set<String> disponibles = new HashSet<>();
        for (String ingrediente : ingredientesUsuario) {
            disponibles.add(ingrediente.toLowerCase().trim());
        }

        for (Receta receta : catalogoRecetas) {
            boolean tieneTodoLoNecesario = true;

            for (String ingredienteReceta : receta.getIngredientes()) {
                if (!disponibles.contains(ingredienteReceta.toLowerCase().trim())) {
                    tieneTodoLoNecesario = false; // Falta un ingrediente, se descarta la receta
                    break;
                }
            }

            if (tieneTodoLoNecesario) {
                recetasSugeridas.add(receta);
            }
        }

        return recetasSugeridas;
    }


    public void mostrarOpciones(List<Receta> opciones) {
        if (opciones.isEmpty()) {
            System.out.println("Lo sentimos, no hay recetas que se puedan preparar solo con esos ingredientes.");
            return;
        }

        System.out.println("Con tus ingredientes puedes preparar:");
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i).getNombre());
        }
        System.out.println("¿Cuál de estas opciones prefieres preparar?");
    }
}