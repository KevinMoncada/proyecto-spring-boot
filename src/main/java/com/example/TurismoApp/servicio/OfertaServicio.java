package com.example.TurismoApp.servicio;

import com.example.TurismoApp.modelos.Compañia;
import com.example.TurismoApp.modelos.Oferta;
import com.example.TurismoApp.repositorio.RepositorioOferta;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class OfertaServicio {
    @Autowired
    RepositorioOferta repositorioOferta;


    public Oferta registrarOferta(Oferta datosARegistrar) throws Exception {
        try {
            return (this.repositorioOferta.save(datosARegistrar));
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


    public Oferta modificarOferta(Integer id, Oferta datosAModificar) throws Exception {
        try {
            Optional<Oferta> ofertaEncontrada = this.repositorioOferta.findById(id);
            if (ofertaEncontrada.isEmpty()) {
                throw new Exception("Oferta no encontrada");
            }

            Oferta ofertaExiste = ofertaEncontrada.get();
            ofertaExiste.setTitulo(datosAModificar.getTitulo());
            ofertaExiste.setDescripcion(datosAModificar.getDescripcion());

            return (this.repositorioOferta.save(ofertaExiste));

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}