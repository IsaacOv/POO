import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private List <Prenda> inventario;

    public Almacen(){
        this.inventario = new ArrayList<>();
    }

    //agregar prenda
    public void agregarNuevaPrenda(Prenda prenda){
        this.inventario.add(prenda);
    }

    //reducir cantidad al vender
    public void procesarVenta(Venta venta){
        for (Prenda productoVendido : venta.getProductosVendidos()) {
            for (Prenda prendaAlmacen : inventario) {
                if (prendaAlmacen.getClave().equals(productoVendido.getClave())) {
                    int nuevaCantidad = prendaAlmacen.getCantidad() - 1; // Ajustar según cantidad vendida
                    prendaAlmacen.setCantidad(nuevaCantidad);
                    break;
                }
            }
        }
    }

    //devolucion
    public void registrarDevolucion(String claveDevolucion) {
        for (Prenda prendaAlmacen : inventario) {
            if (prendaAlmacen.getClave().equals(claveDevolucion)) {
                prendaAlmacen.setCantidad(prendaAlmacen.getCantidad() + 1);
                System.out.println("Salida de dinero registrada como devolución para control interno.");
                break;
            }
        }
    }

    public List<Prenda> getInventario() {
        return inventario;
    }
}
