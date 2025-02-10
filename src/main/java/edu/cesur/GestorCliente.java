package edu.cesur;

import java.util.Date;
import java.util.List;

public class GestorCliente {

    // CRUD

    public void create(String nombre, String apellido1, String apellido2, String comercialPrincipal, int idEmpresa) {

        // Crear un nuevo cliente

        Cliente nuevoCliente = new Cliente(nombre, apellido1, apellido2, comercialPrincipal, idEmpresa);

        GestorPpal.entityManager.getTransaction().begin();

        GestorPpal.entityManager.persist(nuevoCliente);

        GestorPpal.entityManager.getTransaction().commit();
    }

    public Cliente read(Long id) {

        // Leer un cliente

        return GestorPpal.entityManager.find(Cliente.class, id);

    }

    public void update(Long id, String nombre, String apellido1, String apellido2, String comercialPrincipal, Integer idEmpresa, Date nuevaCita) {

        // Actualizar un cliente

        Cliente mCliente = GestorPpal.entityManager.find(Cliente.class, id);

        if (nombre != null) {
            mCliente.setNombre(nombre);
        }

        if (apellido1 != null) {
            mCliente.setApellido1(apellido1);
        }

        if (apellido2 != null) {
            mCliente.setApellido2(apellido2);
        }

        if (comercialPrincipal != null) {
            mCliente.setComercialPrincipal(comercialPrincipal);
        }

        if (idEmpresa != null) {
            mCliente.setIdEmpresa(idEmpresa);
        }

        if (nuevaCita != null) {
            mCliente.insertarVisita(nuevaCita);
        }

        GestorPpal.entityManager.getTransaction().begin();
        GestorPpal.entityManager.merge(mCliente);
        GestorPpal.entityManager.getTransaction().commit();
    }

    public void delete(Long id) {

        // Borrar un cliente
        GestorPpal.entityManager.getTransaction().begin();
        GestorPpal.entityManager.remove(GestorPpal.entityManager.find(Cliente.class, id));
        GestorPpal.entityManager.getTransaction().commit();

    }

    public List<Cliente> readAll() {

        // Leer todos los clientes

        return GestorPpal.entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();

    }

}
