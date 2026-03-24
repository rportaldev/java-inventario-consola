package com.inventario;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int opcion;
		
		GestorInventario gestor = new GestorInventario();
		
		do {
			
			System.out.println("\n===== SISTEMA DE INVENTARIO =====");
			System.out.println(); 
			System.out.println("1. Registrar Producto");
			System.out.println("2. Mostrar Inventario");
			System.out.println("3. Buscar Producto");
			System.out.println("4. Actualizar Stock");
			System.out.println("5. Eliminar Producto");
			System.out.println("6. Productos con bajo Stock");
			System.out.println("7. ===== SALIR =====");
			System.out.println("Ingrese una opción: ");
			
			if(sc.hasNextInt()) {
				opcion = sc.nextInt();
				sc.nextLine();
			}else {
				System.out.println("Entrada inválida. Por favor, ingrese un número.");
				sc.nextLine();
				opcion = 0;
			}
			
			
			switch (opcion) {
			case 1: {
				// PIDE DATOS DEL ESTUDIANTE
				System.out.print("Código: ");
				String codigo = sc.nextLine();
				
				
				System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                
                System.out.print("precio: ");
                double precio = sc.nextDouble();
                sc.nextLine(); 
                
                System.out.print("Stock: ");
                int stock = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Categoria: ");
                String categoria = sc.nextLine();
                
                Producto producto = new Producto(codigo, nombre, precio, stock, categoria);
                
                if(gestor.registrarProducto(producto)) {
                	 System.out.println("✅ Producto registrado exitosamente.");
                }else {
                	System.out.println("❌ Error: código duplicado o stock inválido.");
                }
                break;
                
			}
			
			case 2: {
				//LISTAR PRODUCTOS
				gestor.mostrarInventario();
				
				break;
							
			}
			
			case 3: {
				// PIDE EL CODIGO A BUSCAR
				System.out.print("Ingrese el código del Producto: ");
				String codigoBuscar = sc.nextLine();
				
				Producto encontrado = gestor.buscarProducto(codigoBuscar);
				
				if(encontrado != null) {
					System.out.println("\n===== PRODUCTO ENCONTRADO =====");
					System.out.println(encontrado.toString());
				}else {
					System.out.println("❌ Producto no encontrado.");
				}
				break;
			}
			
			case 4: {
				//ACTUALIZAR STOCK DE UN PRODUCTO
				System.out.print("Ingrese el código del Producto para ser actualizado: ");
				
				String codigo = sc.nextLine();
				
				System.out.print("Ingrese el stock del Producto para ser actualizado: ");
				int stockActual = sc.nextInt();
				sc.nextLine();
				
				Producto actualizar = gestor.buscarProducto(codigo);
				
				if(actualizar != null) {
                	gestor.buscarProducto(codigo);
                	System.out.println("✅ Producto Actualizado exitosamente.");
                	
                	
                	gestor.actualizarStock(codigo, stockActual);
                	gestor.mostrarInventario();
                }else {
                	System.out.println("❌ Producto no encontrado.");
                }
                break;
				
			}
			
			case 5: {
				//ELIMINAR PRODUCTO
				System.out.print("Ingrese el código del Producto a eliminar: ");
                String codigoEliminar = sc.nextLine();
                
                Producto aEliminar = gestor.buscarProducto(codigoEliminar);
                
                if(aEliminar != null) {
                	gestor.eliminarProducto(codigoEliminar);
                	System.out.println("✅ Producto eliminado exitosamente.");
                }else {
                	System.out.println("❌ Producto no encontrado.");
                }
                break;
				
			}
			case 6: {
				//PRODUCTOS BAJO EN STOCK
				System.out.println("\n===== PRODUCTO CON BAJO STOCK =====");
				gestor.productoBajoStock();
				break;
			}
			
			case 7: {
				System.out.println("👋 Saliendo del sistema...");
				break;	
				
			}
			
			default:
				System.out.println("❌ Opción inválida. Intente de nuevo.");
			}
			
			
		} while (opcion != 7);
			
		sc.close();

	}

}
