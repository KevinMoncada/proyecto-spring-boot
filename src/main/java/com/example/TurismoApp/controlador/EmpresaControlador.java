package com.example.TurismoApp.controlador;


import com.example.TurismoApp.modelos.Compañia;
import com.example.TurismoApp.servicio.EmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaControlador {
    @Autowired
    EmpresaServicio empresaServicio;

    @PostMapping
    public ResponseEntity<?> registrarEmpresa (@RequestBody Compañia datosEmpresa){
        return null;
    }

    @PutMapping
    public ResponseEntity<?> editarEmpresa(@RequestBody Compañia datosNuevosEmpresa, @PathVariable Integer idCompañia){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> buscarUnaEmpresa(@PathVariable Integer idCompañia){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> buscarTodasEmpresas(){
        return null;
    }

    public ResponseEntity<?> borrarEmpresa(@PathVariable Integer id){
        return null;
    }
}
