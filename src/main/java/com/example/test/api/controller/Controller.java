/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.test.api.controller;

import com.example.test.api.repository.repository;
import com.example.test.api.vo.repositoryUser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GiosebsSeratic
 */
@RestController
@RequestMapping("/votacion")
public class Controller {
    
    @Autowired
    repository r;
    
    @RequestMapping(value = "/insertar")
    public @ResponseBody
    Map<String, Object> insertar(@RequestBody repositoryUser reVO) {
        Map<String, Object> retorno = null;
        try {
            r.insertarDatos(reVO);
            retorno = new HashMap(2);
            retorno.put("status", "success");
            retorno.put("message", "Se insertaron los datos correctamente");
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            retorno = new HashMap(2);
            retorno.put("status", "error");
            retorno.put("message", e.getMessage());
            return retorno;
        }
    }
    
    @RequestMapping(value = "/update")
    public @ResponseBody
    Map<String, Object> update(@RequestBody repositoryUser repoVO) {
        Map<String, Object> retorno = null;
        try {
            r.actualizarDatos(repoVO);
            retorno = new HashMap(2);
            retorno.put("status", "success");
            retorno.put("message", "Datos Actualizados Satisfactoriamente");
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            retorno = new HashMap(2);
            retorno.put("status", "error");
            retorno.put("message", e.getMessage());
            return retorno;
        }
    }
    
    @RequestMapping(value = "/eliminar")
    public @ResponseBody
    Map<String, Object> eliminar(@RequestBody repositoryUser repoVO) {
        Map<String, Object> retorno = null;
        try {
            r.eliminarDatos(repoVO);
            retorno = new HashMap(2);
            retorno.put("status", "success");
            retorno.put("message", "Datos Eliminados Correctamente");
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            retorno = new HashMap(2);
            retorno.put("status", "error");
            retorno.put("message", e.getMessage());
            return retorno;
        }
    }
    
    @RequestMapping(value = "/listar")
    public @ResponseBody
    Map<String, Object> listar() {
        Map<String, Object> retorno = null;
        try {
            Map<String,Map> listaObjeto = null;
            List<repositoryUser> resultado = r.obtenerDatos();
            retorno = new HashMap(2);
            retorno.put("status", "success");           
            retorno.put("message", resultado);
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            retorno = new HashMap(2);
            retorno.put("status", "error");
            retorno.put("message", e.getMessage());
            return retorno;
        }
    }
}
