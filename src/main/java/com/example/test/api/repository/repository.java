/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.test.api.repository;


import com.example.test.api.vo.repositoryUser;
import java.sql.Date;
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
public class repository {
    @PersistenceContext
    private EntityManager em;
    
    public List<repositoryUser> obtenerDatos(){
    StringBuilder consulta = new StringBuilder("SELECT * FROM usuario");
        Query query = em.createNativeQuery(consulta.toString());
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(repositoryUser.class));
      //  query.setParameter("radio", radio);
      //  query.setParameter("posicion", geomFac.createPoint(point));
        return  query.getResultList();
    }
    
    public void insertarDatos(repositoryUser repository){
    StringBuilder consulta = new StringBuilder("INSERT INTO usuario (userID ,nombre, pass, tipo) VALUES(:id,:nombre,:password,:tipo)");
        Query query = em.createNativeQuery(consulta.toString());
        query.setParameter("id", repository.getUserID());
        query.setParameter("nombre", repository.getNombre());
        query.setParameter("password", repository.getPass());
        query.setParameter("tipo", repository.getTipo());
       // query.setParameter("fecha", java.time.LocalDate.now() + " " + java.time.LocalTime.now());
        query.executeUpdate();
    }
    
    public void actualizarDatos(repositoryUser repository){
    StringBuilder consulta = new StringBuilder("UPDATE usuario SET nombre=:nombre,pass=:password, tipo=:tipo WHERE userID=:id");
        Query query = em.createNativeQuery(consulta.toString());
        query.setParameter("id", repository.getUserID());
        query.setParameter("nombre", repository.getNombre());
        query.setParameter("password", repository.getPass());
        query.setParameter("tipo", repository.getTipo());
      //  query.setParameter("fecha", java.time.LocalDate.now() + " " + java.time.LocalTime.now());
        query.executeUpdate();
    }
    
    public void eliminarDatos(repositoryUser repository){
    StringBuilder consulta = new StringBuilder("DELETE FROM usuario WHERE userID=:id");
        Query query = em.createNativeQuery(consulta.toString());
        query.setParameter("id", repository.getUserID());
      //  query.setParameter("posicion", geomFac.createPoint(point));
        query.executeUpdate();
    }
        
}
   


    
