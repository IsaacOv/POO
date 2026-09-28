import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crear el administrador y registrar recetas
        AdministradorRecetas admin = new AdministradorRecetas();

        Receta huevos = new Receta(
                "Huevos revueltos",
                Arrays.asList("huevo", "sal", "aceite"),
                "1. Bate los huevos con sal. 2. Calienta el aceite en un sartén. 3. Vierte los huevos y revuelve hasta que cuajen.",
                "img/huevos.jpg",
                Arrays.asList("sartén", "tenedor", "plato hondo"));
        huevos.agregarAtributoExtra("tiempo", "10 minutos");
        huevos.agregarAtributoExtra("dificultad", "Fácil");

        Receta quesadillas = new Receta(
                "Quesadillas",
                Arrays.asList("tortilla", "queso"),
                "1. Calienta la tortilla en el comal. 2. Agrega el queso. 3. Dobla y cocina hasta que el queso se derrita.",
                "img/quesadillas.jpg",
                Arrays.asList("comal", "espátula"));
        quesadillas.agregarAtributoExtra("tiempo", "15 minutos");
        quesadillas.agregarAtributoExtra("dificultad", "Fácil");

        Receta pasta = new Receta(
                "Pasta al ajo",
                Arrays.asList("pasta", "ajo", "aceite", "sal"),
                "1. Hierve la pasta con sal. 2. Dora el ajo en aceite. 3. Mezcla la pasta con el ajo.",
                "img/pasta.jpg",
                Arrays.asList("olla", "sartén", "colador"));
        pasta.agregarAtributoExtra("tiempo", "25 minutos");
        pasta.agregarAtributoExtra("dificultad", "Media");

        admin.agregarReceta(huevos);
        admin.agregarReceta(quesadillas);
        admin.agregarReceta(pasta);

        // Buscar recetas con los ingredientes que tiene el usuario
        //(el buscador ignora mayúsculas y espacios extra)
        List<String> ingredientesUsuario = Arrays.asList("Huevo", " Sal ", "Aceite", "Tortilla", "Queso");

        System.out.println("Ingredientes disponibles: " + ingredientesUsuario);
        System.out.println();

        List<Receta> sugeridas = admin.buscarPorIngredientes(ingredientesUsuario);
        admin.mostrarOpciones(sugeridas);

        //Mostrar el detalle de la primera receta sugerida
        if (!sugeridas.isEmpty()) {
            mostrarDetalle(sugeridas.get(0));
        }

        //Caso sin resultados
        System.out.println("\n--- Otra búsqueda ---");
        List<Receta> sinResultados = admin.buscarPorIngredientes(Arrays.asList("agua"));
        admin.mostrarOpciones(sinResultados);
    }

    // Imprime todos los datos de una receta
    private static void mostrarDetalle(Receta receta) {
        System.out.println("\n=== " + receta.getNombre() + " ===");
        System.out.println("Ingredientes: " + receta.getIngredientes());
        System.out.println("Utensilios: " + receta.getUtensiliosNecesarios());
        System.out.println("Pasos: " + receta.getPasos());
        System.out.println("Tiempo: " + receta.obtenerAtributoExtra("tiempo"));
        System.out.println("Dificultad: " + receta.obtenerAtributoExtra("dificultad"));
    }
}
