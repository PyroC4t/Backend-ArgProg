package com.portfolioAp.ap.Controller;

import com.portfolioAp.ap.Dto.dtoEducacion;
import com.portfolioAp.ap.Entity.Educacion;
import com.portfolioAp.ap.Security.Controller.Mensaje;
import com.portfolioAp.ap.Service.ServiceEducacion;
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
@RequestMapping("educacionprofesional")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    @Autowired
    ServiceEducacion serviceEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = serviceEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> grtById(@PathVariable("id") int id){
        if(!serviceEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = serviceEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu){
       if(StringUtils.isBlank(dtoedu.getNombreEdu()))
           return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
       if(serviceEducacion.existsByNombreEdu(dtoedu.getNombreEdu()))
           return new ResponseEntity(new Mensaje("Educacion existente"), HttpStatus.BAD_REQUEST);
       
       Educacion educacion = new Educacion(dtoedu.getNombreEdu(), dtoedu.getInstitutoEdu(), dtoedu.getTituloEdu(), dtoedu.getPeriodoEdu(), dtoedu.getImgEdu());
       serviceEducacion.save(educacion);
       
       return new ResponseEntity(new Mensaje("Educacion creada y almacenada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu){
        if(!serviceEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(serviceEducacion.existsByNombreEdu(dtoedu.getNombreEdu()) && serviceEducacion.getByNombreEdu(dtoedu.getNombreEdu()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("La educacion ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoedu.getNombreEdu()))
            return new ResponseEntity(new Mensaje ("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = serviceEducacion.getOne(id).get();
        educacion.setNombreEdu(dtoedu.getNombreEdu());
        educacion.setInstitutoEdu(dtoedu.getInstitutoEdu());
        educacion.setTituloEdu(dtoedu.getTituloEdu());
        educacion.setPeriodoEdu(dtoedu.getPeriodoEdu());
        educacion.setImgEdu(dtoedu.getImgEdu());
        
        serviceEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!serviceEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        serviceEducacion.delete(id);
        
        return new ResponseEntity(new Mensaje("Educacion eliminada correctamente"), HttpStatus.OK);
    }
    
}
