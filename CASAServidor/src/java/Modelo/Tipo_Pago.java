/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Tipo_Pago {
    private int id_tipo_pago;
    private String tipo;
    private String descrip;
    
    // Relaciones
    private ArrayList<Factura> listaFacturas;

    public Tipo_Pago() {
    }

    public Tipo_Pago(int id_tipo_pago, String tipo, String descrip) {
        this.id_tipo_pago = id_tipo_pago;
        this.tipo = tipo;
        this.descrip = descrip;
    }

    public Tipo_Pago(int id_tipo_pago, String tipo, String descrip, ArrayList<Factura> listaFacturas) {
        this.id_tipo_pago = id_tipo_pago;
        this.tipo = tipo;
        this.descrip = descrip;
        this.listaFacturas = listaFacturas;
    }
   

    public int getId_tipo_pago() {
        return id_tipo_pago;
    }

    public void setId_tipo_pago(int id_tipo_pago) {
        this.id_tipo_pago = id_tipo_pago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }
    
    
}
