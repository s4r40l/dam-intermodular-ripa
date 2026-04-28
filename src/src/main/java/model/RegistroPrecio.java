package model;

import java.time.LocalDate;

public class RegistroPrecio {

    private int id;
    private Producto producto;
    private Supermercado supermercado;
    private LocalDate fecha;
    private double precio;

    public RegistroPrecio() {
    }

    public RegistroPrecio(int id, Producto producto, Supermercado supermercado,
                          LocalDate fecha, double precio) {
        this.id = id;
        this.producto = producto;
        this.supermercado = supermercado;
        this.fecha = fecha;
        this.precio = precio;
    }

    public RegistroPrecio(Producto producto, Supermercado supermercado,
                          LocalDate fecha, double precio) {
        this.producto = producto;
        this.supermercado = supermercado;
        this.fecha = fecha;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Supermercado getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(Supermercado supermercado) {
        this.supermercado = supermercado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "RegistroPrecio{" +
                "id=" + id +
                ", producto=" + (producto != null ? producto.getNombre() : "null") +
                ", supermercado=" + (supermercado != null ? supermercado.getNombre() : "null") +
                ", fecha=" + fecha +
                ", precio=" + precio +
                '}';
    }
}

