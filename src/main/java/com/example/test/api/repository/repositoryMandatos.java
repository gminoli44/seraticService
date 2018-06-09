/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.test.api.repository;


import com.example.test.api.vo.Mandatos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gersain
 */
@Transactional
@Repository
public class repositoryMandatos {
    @PersistenceContext
    private EntityManager em;
    
    public List<Mandatos> obtenerDatos(){
    StringBuilder consulta = new StringBuilder("SELECT * FROM mandatos");
        Query query = em.createNativeQuery(consulta.toString());
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(Mandatos.class));
      //  query.setParameter("radio", radio);
      //  query.setParameter("posicion", geomFac.createPoint(point));
        return  query.getResultList();
    }
    
    public void insertarDatos(Mandatos repository){
    StringBuilder consulta = new StringBuilder("INSERT INTO usuario (abreviacion, descripcion, fecha_creacion) VALUES(:id,:nombre,:password,:tipo)");
        Query query = em.createNativeQuery(consulta.toString());
        query.setParameter("nombre", repository.getAbreviacion());
        query.setParameter("password", repository.getDescripcion());
       // query.setParameter("tipo", repository.getTipo());
        query.setParameter("fecha", java.time.LocalDate.now() + " " + java.time.LocalTime.now());
        query.executeUpdate();
    }
    
    public void actualizarDatos(Mandatos repository){
    StringBuilder consulta = new StringBuilder("UPDATE usuario SET nombre=:nombre,pass=:password, tipo=:tipo WHERE userID=:id");
        Query query = em.createNativeQuery(consulta.toString());
        query.setParameter("nombre", repository.getAbreviacion());
        query.setParameter("password", repository.getDescripcion());
       // query.setParameter("tipo", repository.getTipo());
        query.setParameter("fecha", java.time.LocalDate.now() + " " + java.time.LocalTime.now());
      //  query.setParameter("fecha", java.time.LocalDate.now() + " " + java.time.LocalTime.now());
        query.executeUpdate();
    }
    
    public void eliminarDatos(Mandatos repository){
    StringBuilder consulta = new StringBuilder("DELETE FROM usuario WHERE userID=:id");
        Query query = em.createNativeQuery(consulta.toString());
        query.setParameter("id", repository.getManID());
      //  query.setParameter("posicion", geomFac.createPoint(point));
        query.executeUpdate();
    }
        
}
   


    
