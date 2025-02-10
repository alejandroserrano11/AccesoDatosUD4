package edu.cesur;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String comercialPrincipal;
    private int idEmpresa;
    private Date[] visitas;

    private final static int MAX_VISITAS = 5;

    // Constructores

    public Cliente() {
        this.visitas = new Date[MAX_VISITAS];
    }

    public Cliente(String nombre, String apellido1, String apellido2, String comercialPrincipal, int idEmpresa) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.comercialPrincipal = comercialPrincipal;
        this.idEmpresa = idEmpresa;
        this.visitas = new Date[MAX_VISITAS];
    }

    // getters y setters

    public Date[] getVisitas() {
        return visitas;
    }

    public void setVisitas(Date[] visitas) {
        this.visitas = visitas;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getComercialPrincipal() {
        return comercialPrincipal;
    }

    public void setComercialPrincipal(String comercialPrincipal) {
        this.comercialPrincipal = comercialPrincipal;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    // toString

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
                + ", comercialPrincipal=" + comercialPrincipal + ", idEmpresa=" + idEmpresa + "]";
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Métodos

    public boolean insertarVisita(Date nuevaVisita) {
        // se da por hecho que no hay huecos intermedios.
        eliminarVisitasPasadas();
        int hueco = 0;
        while (hueco < (visitas.length)) {
            if (visitas[hueco] == null) {
                visitas[hueco] = nuevaVisita;
                ordenarVisitas();
                return true;
            }
            hueco++;
        }
        return false;
    }

    public void eliminarVisitasPasadas() {
        Date fechaActual = new Date(System.currentTimeMillis());
        int contador = 0;
        while ((contador < visitas.length) && (visitas[contador] != null)) {
            if (visitas[contador].compareTo(fechaActual) < 0) {
                visitas[contador] = null;
            }
        }
    }

    public void ordenarVisitas() {

        // array ordenado de mas antiguo a mas moderno

        Date visitasTemp = new Date(2500, 1, 1);
        int i = 0;
        int j;
        
        while ((i < visitas.length) && (visitas[i] != null)) {
            j=1;
            while (j < (visitas.length) - i && visitas[j] != null) {
                if (visitas[j - 1].compareTo(visitas[j]) > 0) {
                    visitasTemp = visitas[j - 1];
                    visitas[j - 1] = visitas[j];
                    visitas[j] = visitasTemp;
                }
                j++;
            }
            i++;
        }
    }

    
}
