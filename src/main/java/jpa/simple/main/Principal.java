package jpa.simple.main;

import jpa.simple.modelo.Completo;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import jpa.simple.modelo.Completo;

//Comentarios adicionalaes.

public class Principal {

private static final String PERSISTENCE_UNIT_NAME = "tutorialJPA";

private static EntityManagerFactory factoria;


public static void main(String[] args) {


factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

EntityManager em = factoria.createEntityManager();
//Query q;
// leer las entradas existentes y escribir en la consola
/*
Completo cmp = new Completo();
cmp.setDescripcion("UnaDescripcion");
cmp.setResumen("UnResumen");

em.getTransaction().begin();
em.persist(cmp);
em.getTransaction().commit();
cmp.setDescripcion("UnaDescripcion2");
cmp.setResumen("UnResumen2");
em.getTransaction().begin();
em.persist(cmp);
em.getTransaction().commit();
*/
 //q = em.createQuery("select t from Completo t");
TypedQuery<Completo> q=em.createQuery("select t from Completo t",Completo.class);
List<Completo> listaCompleto = q.getResultList();
//Crearse una lista con template: "Completo" a la que asignameros el resultado de la consulta
//en la base de datos ("q.getResultList()"
//Iterar en la lista e imprimir las instancias "completo"
//Ahora imprimimos el numero de registros que tiene ya la base de datos






System.out.println("Tamano: " + listaCompleto.size());

for(int i=0;i<listaCompleto.size();i++){
	System.out.println("Resumen: "+listaCompleto.get(i).getResumen());
	System.out.println("Descripcion: "+listaCompleto.get(i).getDescripcion());
}



//Ahora vamos a trabajar con una transaccion en la base de datos
//em.getTransaction().begin();
//Crearse una instancia de completo y utilizar los metodos "setResumen()" y "setDescripcion()"
//Posteriormente hay que decir al gestor de entidad (em) que la instancia va a ser persistente;
//conseguir la transaccion ("em.getTransaction()") y hacerla definitiva ("commit()")


//Por ultimo, hay que cerrar al gestor de entidad

em.close();

}

}