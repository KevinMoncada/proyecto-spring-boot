package com.example.TurismoApp.servicio;

import com.example.TurismoApp.modelos.Compañia;
import com.example.TurismoApp.repositorio.EmpresaRepositorio;
import com.example.TurismoApp.validaciones.EmpresaValidacion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
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
            //FALTAN MAS VALIDACIONES


            //SI PASO TODOS LOS IF ESTOY LISTO PARA LLAMAR AL REPO
            return(this.empresaRepositorio.save(datosARegistrar));

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Compañia modificarEmpresa(Integer id, Compañia datosAModificar) throws Exception{
        try {
        //VALIDAMOS LA INFORMACION
            if (!this.empresaValidacion.validarNombre(datosAModificar.getNombre())){
                throw new Exception("Error en el dato entregado");
            }

            //BUSCAR QUE LA EMPRESA QUE TIENE EL ID QUE ENVIA EL USUARIO EXISTA EN BASES DE DATOS
            Optional<Compañia>empresaEncontrada=this.empresaRepositorio.findById(id);
            //PREGUNTO SI LO QUE BUSQUE ESTA VACIO
            if (empresaEncontrada.isEmpty()){
                throw new Exception("Empresa no encontrada");
            }
            //RUTINA POR SI LA ENCONTRE
            //1.CONVIERTO EL OPCIONAL EN LA ENTIDAD RESPECTIVA
            Compañia empresaQueExiste = empresaEncontrada.get();

            //2.A LA EMPRESA QUE EXISTE LE CAMBIO LA INFORMACION QUE EL USUARIO NECESITA
            empresaQueExiste.setNombre(datosAModificar.getNombre());

            //3.GUARDAR LA INFORMACION QUE SE ACABA DE EDITAR (SET)
            return (this.empresaRepositorio.save(empresaQueExiste));

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Compañia buscarCompañiaPorId(Integer id) throws Exception {
        try {
            Optional<Compañia> empresaOpcional = this.empresaRepositorio.findById(id);
            if (empresaOpcional.isEmpty()){
                throw new Exception("Empresa no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
        return null;
    }

    public List<Compañia> buscarTodasEmpresas() throws Exception{
        try {
            List<Compañia>listaEmpresa= this.empresaRepositorio.findAll();
            return listaEmpresa;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Boolean eliminarEmpresa (Integer id) throws Exception{
        try {
            Optional<Compañia> empresaOpcional = this.empresaRepositorio.findById(id);

            if (empresaOpcional.isPresent()){
                this.empresaRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Empresa no encontrada");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
