package com.example.TurismoApp.servicio;

import com.example.TurismoApp.modelos.Compañia;
import com.example.TurismoApp.modelos.Oferta;
import com.example.TurismoApp.repositorio.RepositorioOferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
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

    public Oferta buscarOfertaPorId(Integer id) throws Exception {
        try {
            Optional<Oferta> ofertaOpcional = this.repositorioOferta.findById(id);
            if (ofertaOpcional.isEmpty()){
                throw new Exception("No se ha encontrado la oferta solicitada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
        return null;
    }

    public List<Oferta> buscarTodasLasOfertas() throws Exception{
        try {
            List<Oferta>listaOfertas= this.repositorioOferta.findAll();
            return listaOfertas;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Boolean eliminarOferta (Integer id) throws Exception{
        try {
            Optional<Oferta> ofertaOpcional = this.repositorioOferta.findById(id);

            if (ofertaOpcional.isPresent()){
                this.repositorioOferta.deleteById(id);
                return true;
            }else{
                throw new Exception("Empresa no encontrada");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
