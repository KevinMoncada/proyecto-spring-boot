package com.example.TurismoApp.controlador;

import com.example.TurismoApp.modelos.Oferta;
import com.example.TurismoApp.servicio.OfertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ofertas")
public class OfertaControlador {
    @Autowired
    OfertaServicio ofertaServicio;

    @PostMapping
    public ResponseEntity<?> registrarOferta (@RequestBody Oferta datosOferta){
        return null;
    }

    @PutMapping
    public ResponseEntity<?> editarOferta(@RequestBody Oferta datosNuevosOferta, @PathVariable Integer idOferta){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> buscarUnaOferta(@PathVariable Integer idOferta){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> buscarTodasOfertas(){
        return null;
    }

    public ResponseEntity<?> borrarOferta(@PathVariable Integer id){
        return null;
    }
}
