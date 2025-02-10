package edu.cesur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class GestorPpal {
    
    // Atributos
    protected static EntityManager entityManager;
    protected static EntityManagerFactory emf;

    // Constructor
    public GestorPpal() {
        entityManager = null;
        emf = null;
    }

    // Métodos
    protected void iniciar() {
        // Crear EntityManagerFactory y EntityManager

        emf = Persistence.createEntityManagerFactory("clientesPU");
        entityManager  = emf.createEntityManager();
    
    }

    protected void salir() {
        // Cerrar EntityManager y EntityManagerFactory

        if (entityManager != null) {
            entityManager.close();
        }

        if (emf != null) {
            emf.close();
        }
    }
}