import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Almacen almacen = new Almacen();

        Prenda playera = new Prenda("P001", "Playera básica", 10, "Playera de algodón",
                "img/playera.jpg", "S,M,L", "Blanco");
        Prenda jeans = new Prenda("J001", "Jeans slim", 5, "Mezclilla azul",
                "img/jeans.jpg", "28,30,32", "Azul");
        Prenda sudadera = new Prenda("S001", "Sudadera con capucha", 8, "Sudadera de felpa",
                "img/sudadera.jpg", "M,L,XL", "Negro");

        almacen.agregarNuevaPrenda(playera);
        almacen.agregarNuevaPrenda(jeans);
        almacen.agregarNuevaPrenda(sudadera);

        System.out.println("=== Inventario inicial ===");
        mostrarInventario(almacen);

        // 2. Registrar una venta (una playera y unos jeans)
        List<Prenda> productosVendidos = new ArrayList<>();
        productosVendidos.add(playera);
        productosVendidos.add(jeans);

        // Prenda no tiene precio, así que el total se indica al crear la venta
        Venta venta = new Venta("14:30", "27/09/2026", "Efectivo", productosVendidos, 650.00f);

        almacen.procesarVenta(venta);

        System.out.println("\n=== Venta realizada ===");
        System.out.println("Fecha: " + venta.getFecha() + " " + venta.getHora());
        System.out.println("Forma de pago: " + venta.getFormaPago());
        System.out.println("Productos:");
        for (Prenda p : venta.getProductosVendidos()) {
            System.out.println(" - " + p.getNombre() + " (" + p.getColor() + ")");
        }
        System.out.println("Total pagado: $" + venta.getTotalPagado());

        System.out.println("\n=== Inventario después de la venta ===");
        mostrarInventario(almacen);

        // 3. Devolución de los jeans
        System.out.println("\n=== Devolución de J001 ===");
        almacen.registrarDevolucion("J001");

        System.out.println("\n=== Inventario final ===");
        mostrarInventario(almacen);
    }

    // Método auxiliar para imprimir el inventario
    private static void mostrarInventario(Almacen almacen) {
        for (Prenda p : almacen.getInventario()) {
            System.out.println(p.getClave() + " | " + p.getNombre() + " | "
                    + p.getColor() + " | Tallas: " + p.getTallas()
                    + " | Stock: " + p.getCantidad());
        }
    }
}