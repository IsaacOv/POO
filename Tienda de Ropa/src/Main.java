//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crea el almacén y registrar prendas
        Almacen almacen = new Almacen();

        Prenda playera = new Prenda("P001", "Playera básica", 10, "Playera de algodón",
                "img/playera.jpg", "S,M,L", "Blanco", 199.90f);
        Prenda jeans = new Prenda("J001", "Jeans slim", 5, "Mezclilla azul",
                "img/jeans.jpg", "28,30,32", "Azul", 599.00f);
        Prenda sudadera = new Prenda("S001", "Sudadera con capucha", 8, "Sudadera de felpa",
                "img/sudadera.jpg", "M,L,XL", "Negro", 449.50f);

        almacen.agregarNuevaPrenda(playera);
        almacen.agregarNuevaPrenda(jeans);
        almacen.agregarNuevaPrenda(sudadera);

        System.out.println("=== Inventario inicial ===");
        mostrarInventario(almacen);

        //Armar la venta (una playera y unos jeans)
        List<Prenda> productosVendidos = new ArrayList<>();
        productosVendidos.add(playera);
        productosVendidos.add(jeans);

        //El total se calcula automáticamente sumando el precio de cada prenda
        float total = calcularTotal(productosVendidos);

        Venta venta = new Venta("14:30", "27/09/2026", "Efectivo", productosVendidos, total);

        //Descontar del inventario
        almacen.procesarVenta(venta);

        System.out.println("\n=== Venta realizada ===");
        System.out.println("Fecha: " + venta.getFecha() + " " + venta.getHora());
        System.out.println("Forma de pago: " + venta.getFormaPago());
        System.out.println("Productos:");
        for (Prenda p : venta.getProductosVendidos()) {
            System.out.printf(" - %s (%s) - $%.2f%n", p.getNombre(), p.getColor(), p.getPrecio());
        }
        System.out.printf("Total pagado: $%.2f%n", venta.getTotalPagado());

        System.out.println("\n=== Inventario después de la venta ===");
        mostrarInventario(almacen);

        // 3.Devolución de los jeans
        System.out.println("\n=== Devolución de J001 ===");
        almacen.registrarDevolucion("J001");

        System.out.println("\n=== Inventario final ===");
        mostrarInventario(almacen);
    }

    //Suma el precio de todas las prendas de la lista
    private static float calcularTotal(List<Prenda> prendas) {
        float total = 0;
        for (Prenda p : prendas) {
            total += p.getPrecio();
        }
        return total;
    }

    //Imprime el inventario
    private static void mostrarInventario(Almacen almacen) {
        for (Prenda p : almacen.getInventario()) {
            System.out.printf("%s | %s | %s | Tallas: %s | Precio: $%.2f | Stock: %d%n",
                    p.getClave(), p.getNombre(), p.getColor(), p.getTallas(),
                    p.getPrecio(), p.getCantidad());
        }
    }
}
