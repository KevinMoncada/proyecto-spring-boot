package com.example.TurismoApp.servicio;

import com.example.TurismoApp.modelos.Compañia;
import com.example.TurismoApp.repositorio.EmpresaRepositorio;
import com.example.TurismoApp.validaciones.EmpresaValidacion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class EmpresaServicio {

    @Autowired
    EmpresaRepositorio empresaRepositorio;

    @Autowired
    EmpresaValidacion empresaValidacion;

    public Compañia registrarEmpresa(Compañia datosARegistrar) throws Exception{
        try{

            if (this.empresaValidacion.validarNombre(datosARegistrar.getNombre())){
                throw new Exception("Error en el servicio");
            }

            //SI PASO TODOS LOS IF ESTOY LISTO PARA LLAMAR AL REPO
            return(this.empresaRepositorio.save(datosARegistrar));

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Compañia modificarEmpresa(Integer id, Compañia datosAModificar) throws Exception{
        return null;
    }

    public Compañia buscarCompañiaPorId(Integer id) throws Exception {
        return null;
    }

    public List<Compañia> buscarTodasEmpresas() throws Exception{
        return null;
    }

    public Boolean eliminarEmpresa (Integer id) throws Exception{
        return null;
    }


}
