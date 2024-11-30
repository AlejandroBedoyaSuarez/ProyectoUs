package Project;

import java.util.List;

public class Factura {
    private Usuario usuario;
    private List<Producto> productos;
    private double valorTotal;

    public Factura(Usuario usuario, List<Producto> productos) {
        this.usuario = usuario;
        this.productos = productos;
        calcularValorTotal();
    }

    private void calcularValorTotal() {
        valorTotal = 0;
        for (Producto producto : productos) {
            valorTotal += producto.getPrecioUnitario() * producto.getCantidad();
        }
    }

    // Getters
    public Usuario getUsuario() { return usuario; }
    public List<Producto> getProductos() { return productos; }
    public double getValorTotal() { return valorTotal; }
}
