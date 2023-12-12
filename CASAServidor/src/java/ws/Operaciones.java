/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package ws;

import Modelo.Clasificacion;
import Modelo.Competencia;
import Modelo.Factura;
import Modelo.Item_Factura;
import Modelo.Persona;
import Modelo.Producto;
import Modelo.Proveedores;
import Modelo.Rol;
import Modelo.Tipo_Pago;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.swing.JTable;

/**
 *
 * @author Asus
 */
@WebService(serviceName = "Operaciones")
public class Operaciones {

    private ArrayList<Clasificacion> listaclasificacion = new ArrayList<>();
    private ArrayList<Proveedores> listaproveedor = new ArrayList<>();
    private ArrayList<Producto> listaproducto = new ArrayList<>();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";

    }

/////////////////CREA CLASIFICACION
    @WebMethod(operationName = "crearClasificacion")
    public String crearClasificacion(
            @WebParam(name = "idClasificacion") int idClasificacion,
            @WebParam(name = "grupo") String grupo) {
        if (existeClasificacionConID(idClasificacion)) {
            return "Error: Ya existe una clasificación con el ID " + idClasificacion + ".";
        }

        Clasificacion nuevaClasificacion = new Clasificacion(idClasificacion, grupo);
        listaclasificacion.add(nuevaClasificacion);

        return "Clasificación creada exitosamente con ID: " + nuevaClasificacion.getId_clasificacion();
    }

    private boolean existeClasificacionConID(int idClasificacion) {
        Set<Integer> idsExistentes = new HashSet<>();
        for (Clasificacion c : listaclasificacion) {
            idsExistentes.add(c.getId_clasificacion());
        }

        return idsExistentes.contains(idClasificacion);
    }

    @WebMethod(operationName = "listarClasificaciones")
    public List<Clasificacion> listarClasificaciones() {
        return listaclasificacion;
    }

////////////CREAR PROVEEDOR
    @WebMethod(operationName = "crearProveedor")
    public String crearProveedor(
            @WebParam(name = "idProveedor") int idProveedor,
            @WebParam(name = "ruc") String ruc,
            @WebParam(name = "telefono") String telefono,
            @WebParam(name = "pais") String pais,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "moneda") String moneda) {

        if (existeProveedorConID(idProveedor)) {
            return "Error: Ya existe un proveedor con el ID " + idProveedor + ".";
        }
        Proveedores nuevoProveedor = new Proveedores(idProveedor, ruc, telefono, pais, correo, moneda);
        listaproveedor.add(nuevoProveedor);

        return "Proveedor creado exitosamente con ID: " + nuevoProveedor.getId_proveedor();
    }

    private boolean existeProveedorConID(int idProveedor) {
        Set<Integer> idsExistentes = new HashSet<>();
        for (Proveedores p : listaproveedor) {
            idsExistentes.add(p.getId_proveedor());
        }

        return idsExistentes.contains(idProveedor);
    }

    ///LISTAR PROVEEDOR
    @WebMethod(operationName = "listarProveedores")
    public List<Proveedores> listarProveedores() {
        return listaproveedor;
    }

///////////////CREAR PRODUCTO
    @WebMethod(operationName = "crearProducto")
    public String crearProducto(
            @WebParam(name = "idProducto") int idProducto,
            @WebParam(name = "stock") int stock,
            @WebParam(name = "precioUnitario") double precioUnitario,
            @WebParam(name = "unidad") String unidad,
            @WebParam(name = "idClasificacion") int idClasificacion,
            @WebParam(name = "idProveedor") int idProveedor,
            @WebParam(name = "iva") boolean iva) {

        if (existeProductoConID(idProducto)) {
            return "Error: Ya existe un producto con el ID " + idProducto + ".";
        }
        Clasificacion clasificacion = null;
        for (Clasificacion c : listaclasificacion) {
            if (c.getId_clasificacion() == idClasificacion) {
                clasificacion = c;
                break;
            }
        }

        if (clasificacion == null) {
            return "Error: La clasificación con ID " + idClasificacion + " no existe.";
        }

        // Proveedor existe
        Proveedores proveedor = null;
        for (Proveedores p : listaproveedor) {
            if (p.getId_proveedor() == idProveedor) {
                proveedor = p;
                break;
            }
        }
        if (proveedor == null) {
            return "Error: El proveedor con ID " + idProveedor + " no existe.";
        }

        Producto nuevoProducto = new Producto(idProducto, stock, precioUnitario, unidad, idClasificacion, idProveedor, iva, null, null);
        proveedor.getProductos().add(nuevoProducto);
        clasificacion.getProductos().add(nuevoProducto);

        listaproducto.add(nuevoProducto);
        return "Producto creado exitosamente con ID: " + nuevoProducto.getId_producto();
    }

    private boolean existeProductoConID(int idProducto) {
        Set<Integer> idsExistentes = new HashSet<>();
        for (Producto p : listaproducto) {
            idsExistentes.add(p.getId_producto());
        }
        return idsExistentes.contains(idProducto);
    }

    ///LISTADO PRODUCTOS
    @WebMethod(operationName = "listarProductos")
    public List<Producto> listarProductos() {
        return listaproducto;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private ArrayList<Usuario> bd_tabla_usuario = new ArrayList<>();
    private ArrayList<Rol> bd_tabla_rol = new ArrayList<>();
    private ArrayList<Tipo_Pago> bd_tabla_tipopago = new ArrayList<>();
    private ArrayList<Proveedores> bd_tabla_proveedores = new ArrayList<>();
    private ArrayList<Producto> bd_tabla_producto = new ArrayList<>();
    private ArrayList<Persona> bd_tabla_persona = new ArrayList<>();
    private ArrayList<Item_Factura> bd_tabla_itemfactura = new ArrayList<>();
    private ArrayList<Factura> bd_tabla_factura = new ArrayList<>();
    private ArrayList<Competencia> bd_tabla_competencia = new ArrayList<>();
    private ArrayList<Clasificacion> bd_tabla_clasificacion = new ArrayList<>();

    
    
    @WebMethod(operationName = "registrarUsuario")
    public boolean registrarUsuario(
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellido") String apellido,
            @WebParam(name = "dni") String dni,
            @WebParam(name = "celular") String celular,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "user") String user,
            @WebParam(name = "password") String password) {

        // Verificar si el usuario ya existe
        if (usuarioExiste(user)) {
            System.out.println("El usuario ya existe. No se puede registrar nuevamente.");
            return false;
        } else {

            // Generar un nuevo ID para la Persona y el Usuario
            int nuevoIdPersona = generarNuevoIdPersona();
            int nuevoIdUsuario = generarNuevoIdUsuario();

            // Crear una nueva Persona
            Persona nuevaPersona = new Persona();
            nuevaPersona.setId_persona(nuevoIdPersona);
            nuevaPersona.setNombre(nombre);
            nuevaPersona.setApellido(apellido);
            nuevaPersona.setDni(dni);
            nuevaPersona.setCelular(celular);
            nuevaPersona.setCorreo(correo);

            // Crear un nuevo Usuario
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setId_usuario(nuevoIdUsuario);
            nuevoUsuario.setUser(user);
            nuevoUsuario.setPassword(password);
            nuevoUsuario.setPersona(nuevaPersona);

            // Agregar el Usuario a la lista de Usuarios
            bd_tabla_usuario.add(nuevoUsuario);

            System.out.println("Usuario registrado exitosamente.");
            return true;
        }
    }

    private boolean usuarioExiste(String user) {
        // Buscar el usuario por nombre de usuario
        for (Usuario usuario : bd_tabla_usuario) {
            if (usuario.getUser().equals(user)) {
                return true;
            }
        }
        return false;  
    }

    private int generarNuevoIdPersona() {
        return bd_tabla_persona.size() + 1;
    }

    private int generarNuevoIdUsuario() {
        return bd_tabla_usuario.size() + 1;
    }

    @WebMethod(operationName = "Login")
    public Boolean Login(@WebParam(name = "usuario") String usuario, @WebParam(name = "contrasena") String contrasena) {
        if (usuario.equals("admin") && contrasena.equals("admin1")) {
            return true;
        }

        for (Usuario UsuarioExis : bd_tabla_usuario) {
            if (UsuarioExis.getUser().equals(usuario) && UsuarioExis.getPassword().equals(contrasena)) {
                return true;
            }
        }

        return false;
    }

}
