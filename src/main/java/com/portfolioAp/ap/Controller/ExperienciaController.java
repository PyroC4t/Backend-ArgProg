package com.portfolioAp.ap.Controller;

import com.portfolioAp.ap.Dto.dtoExperiencia;
import com.portfolioAp.ap.Entity.Experiencia;
import com.portfolioAp.ap.Security.Controller.Mensaje;
import com.portfolioAp.ap.Service.ServiceExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("experiencialaboral")
@CrossOrigin(origins = "https://portfolioap-50c82.web.app")
public class ExperienciaController {
    @Autowired
    ServiceExperiencia serviceExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = serviceExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!serviceExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = serviceExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreExp()))
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(serviceExperiencia.existsByNombreExp(dtoexp.getNombreExp()))
            return new ResponseEntity(new Mensaje("Experiencia existente"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoexp.getNombreExp(),dtoexp.getEmpresaExp(),dtoexp.getCargoExp(), dtoexp.getDescripcionExp(), dtoexp.getImgExp());
        serviceExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia creada y almacenada correctamente"), HttpStatus.OK);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        if(!serviceExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(serviceExperiencia.existsByNombreExp(dtoexp.getNombreExp()) && serviceExperiencia.getByNombreExp(dtoexp.getNombreExp()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoexp.getNombreExp()))
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = serviceExperiencia.getOne(id).get();
        experiencia.setNombreExp(dtoexp.getNombreExp());
        experiencia.setEmpresaExp(dtoexp.getEmpresaExp());
        experiencia.setCargoExp(dtoexp.getCargoExp());
        experiencia.setDescripcionExp(dtoexp.getDescripcionExp());
        experiencia.setImgExp(dtoexp.getImgExp());
        
        serviceExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada correctamente"), HttpStatus.OK);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!serviceExperiencia.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        serviceExperiencia.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada correctamente"), HttpStatus.OK);
    }
}
