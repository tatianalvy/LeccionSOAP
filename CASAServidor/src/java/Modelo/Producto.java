/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author Asus
 */
public class Producto {
    private int id_producto;
    private int stock;
    private double precio_unitario;
    private String unidad;
    private int id_clasificacion;
    private int id_proveedor;
    private boolean iva;
    
    
    
    private List<Proveedores> tipoproveedor;
    private  List<Clasificacion> tipoclasificacion;

    public Producto() {
    }

    public Producto(int id_producto, int stock, double precio_unitario, String unidad, int id_clasificacion, int id_proveedor, boolean iva, List<Proveedores> tipoproveedor, List<Clasificacion> tipoclasificacion) {
        this.id_producto = id_producto;
        this.stock = stock;
        this.precio_unitario = precio_unitario;
        this.unidad = unidad;
        this.id_clasificacion = id_clasificacion;
        this.id_proveedor = id_proveedor;
        this.iva = iva;
        this.tipoproveedor = tipoproveedor;
        this.tipoclasificacion = tipoclasificacion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getId_clasificacion() {
        return id_clasificacion;
    }

    public void setId_clasificacion(int id_clasificacion) {
        this.id_clasificacion = id_clasificacion;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public boolean isIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    public List<Proveedores> getTipoproveedor() {
        return tipoproveedor;
    }

    public void setTipoproveedor(List<Proveedores> tipoproveedor) {
        this.tipoproveedor = tipoproveedor;
    }

    public List<Clasificacion> getTipoclasificacion() {
        return tipoclasificacion;
    }

    public void setTipoclasificacion(List<Clasificacion> tipoclasificacion) {
        this.tipoclasificacion = tipoclasificacion;
    }
}
