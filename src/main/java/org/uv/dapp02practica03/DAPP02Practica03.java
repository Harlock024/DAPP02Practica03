package org.uv.dapp02practica03;

import java.util.List;
import java.util.Scanner;
import org.uv.dapp02practica03.EmpleadoDAO;

public class DAPP02Practica03 {

    private static final EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenú de Empleados:");
            System.out.println("1. Crear Empleado");
            System.out.println("2. Actualizar Empleado");
            System.out.println("3. Eliminar Empleado");
            System.out.println("4. Buscar Empleado por ID");
            System.out.println("5. Listar Todos los Empleados");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 ->
                    crearEmpleado();
                case 2 ->
                    actualizarEmpleado();
                case 3 ->
                    eliminarEmpleado();
                case 4 ->
                    buscarEmpleadoPorId();
                case 5 ->
                    listarEmpleados();
                case 6 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default ->
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }

    private static void crearEmpleado() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese teléfono: ");
        String telefono = scanner.nextLine();

        EmpleadoPojo empleado = new EmpleadoPojo(nombre, direccion, telefono);
        empleadoDAO.create(empleado);
        System.out.println("Empleado creado exitosamente.");
    }

    private static void actualizarEmpleado() {
        System.out.print("Ingrese ID del empleado a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Ingrese nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese nueva dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese nuevo teléfono: ");
        String telefono = scanner.nextLine();

        EmpleadoPojo empleado = new EmpleadoPojo(nombre, direccion, telefono);
        if (empleadoDAO.update(empleado, id) != null) {
            System.out.println("Empleado actualizado correctamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void eliminarEmpleado() {
        System.out.print("Ingrese ID del empleado a eliminar: ");
        Long id = scanner.nextLong();
        if (empleadoDAO.delete(id)) {
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void buscarEmpleadoPorId() {
        System.out.print("Ingrese ID del empleado a buscar: ");
        Long id = scanner.nextLong();
        EmpleadoPojo empleado = empleadoDAO.fetch_by_id(id);
        if (empleado != null) {
            System.out.println("Empleado encontrado:");
            System.out.println("id " + empleado.getId() + "\nName " + empleado.getName());

        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void listarEmpleados() {
        List<EmpleadoPojo> empleados = empleadoDAO.fetch_all();
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (EmpleadoPojo empleado : empleados) {
                System.out.println("---------------------------------------");
                System.out.println("id " + empleado.getId() + "\nName " + empleado.getName());
               

            }
        }
    }
}
