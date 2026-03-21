package com.inventario;

import java.util.HashMap;

public class GestorInventario {

	private HashMap<String, Producto> inventario = new HashMap<>();
	
	//METODOS
	
	//REGISTRAR PRODUCTO
	public boolean registrarProducto(Producto producto) {
		
		if(inventario.containsKey(producto.getCodigo())) {
	        return false;
	    }

	    if(producto.getPrecio() <= 0) {
	        return false;
	    }

	    if(producto.getStock() < 0) {
	        return false;
	    }

	    inventario.put(producto.getCodigo(), producto);
	    return true;
	}
	
	//MOSTRAR INVENTARIO
	public void mostrarInventario() {
		
		for(Producto p : inventario.values()) {
			System.out.println(p); 
		}
	}
	
	//BUSCAR UN PRODUCTO
	public Producto buscarProducto(String codigo) {
		
		return inventario.get(codigo);
	}
	
	//ACTUALIZAR EL STOCK
	public boolean actualizarStock(String codigo, int stock) {
		
		Producto producto = inventario.get(codigo);
		
		if(producto == null) {
	        return false;
	    }
		
		producto.setStock(stock);
	    return true;
	}
	
	//ELIMINAR UN PRODUCTO
	public void eliminarProducto(String codigo) {
		
		inventario.remove(codigo);		
			
	}
	
	//PRODUCTOS BAJO EN STOCK
	public void productoBajoStock() {
		
		for(Producto p : inventario.values()) {
			if(p.getStock() < 5) {
				System.out.println(p); 
			}
		}
	}
}
