import java.util.List;

public class Venta {
    private String hora;
    private String fecha;
    private String formaPago;
    private List<Prenda> productosVendidos;
    private float totalPagado;

    public Venta(String hora, String fecha, String formaPago, List<Prenda> productosVendidos, float totalPagado){
        this.hora = hora;
        this. fecha = fecha;
        this. formaPago = formaPago;
        this.productosVendidos = productosVendidos;
        this.totalPagado = totalPagado;
    }

    //getters
    public String getHora() {return hora;}
    public String getFecha() {return fecha;}
    public String getFormaPago() {return formaPago;}
    public List<Prenda> getProductosVendidos() {return productosVendidos;}
    public float getTotalPagado() {return totalPagado;}

    //setters

    public void setHora(String hora) {this.hora = hora;}
    public void setFecha(String fecha) {this.fecha = fecha;}
    public void setFormaPago(String formaPago) {this.formaPago = formaPago;}
    public void setProductosVendidos(List<Prenda> productosVendidos) {this.productosVendidos = productosVendidos;}
    public void setTotalPagado(float totalPagado) {this.totalPagado = totalPagado;}
}
