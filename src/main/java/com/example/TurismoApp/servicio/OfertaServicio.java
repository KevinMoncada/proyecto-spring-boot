package com.example.TurismoApp.servicio;

import com.example.TurismoApp.modelos.Compañia;
import com.example.TurismoApp.modelos.Oferta;
import com.example.TurismoApp.repositorio.RepositorioOferta;
import org.springframework.beans.factory.annotation.Autowired;


public class OfertaServicio {
@Autowired
    RepositorioOferta repositorioOferta;


    public Oferta registrarOferta(Oferta datosARegistrar) throws Exception{
        try{
            return (this.repositorioOferta.save(datosARegistrar));
    }catch (Exception error){
            throw new Exception(error.getMessage());
        }
}}
