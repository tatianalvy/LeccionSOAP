/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Asus
 */
import java.util.ArrayList;
import java.util.List;

public class Proveedores {
    private int id_proveedor;
    private String ruc;
    private String telefono;
    private String pais;
    private String correo;
    private String moneda;

    // Agregar la lista de productos
    private List<Producto> productos;

    public Proveedores() {
        // Inicializar la lista de productos
        this.productos = new ArrayList<>();
    }

    public Proveedores(int id_proveedor, String ruc, String telefono, String pais, String correo, String moneda) {
        this.id_proveedor = id_proveedor;
        this.ruc = ruc;
        this.telefono = telefono;
        this.pais = pais;
        this.correo = correo;
        this.moneda = moneda;
        // Inicializar la lista de productos
        this.productos = new ArrayList<>();
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    // Agregar métodos para la lista de productos
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}

