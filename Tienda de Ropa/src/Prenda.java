public class Prenda {
    private String clave;
    private String nombre;
    private int cantidad;
    private String descripcion;
    private String rutaImagen;
    private String tallas;
    private String color;
    private float precio;

    public Prenda(String clave, String nombre, int cantidad, String descripcion, String rutaImagen, String tallas, String color, float precio){
        this.clave = clave;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.tallas = tallas;
        this.color = color;
        this.precio = precio;
    }
    //getters
    public String getClave(){return clave;}
    public String getNombre(){return nombre;}
    public int getCantidad() {return cantidad;}
    public String getDescripcion(){return descripcion;}
    public String getRutaImagen(){return rutaImagen;}
    public String getTallas(){return tallas;}
    public String getColor(){return color;}
    public float getPrecio() {return precio;}

    //setters
    public void setClave(String clave) {this.clave = clave;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public void setRutaImagen(String rutaImagen) {this.rutaImagen = rutaImagen;}
    public void setTallas(String tallas) {this.tallas = tallas;}
    public void setColor(String color) {this.color = color;}
}
