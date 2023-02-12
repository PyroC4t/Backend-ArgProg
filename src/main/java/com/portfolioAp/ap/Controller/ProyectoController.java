package com.portfolioAp.ap.Controller;

import com.portfolioAp.ap.Dto.dtoProyecto;
import com.portfolioAp.ap.Entity.Proyecto;
import com.portfolioAp.ap.Security.Controller.Mensaje;
import com.portfolioAp.ap.Service.ServiceProyecto;
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
@RequestMapping("proyectos")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolioap-50c82.web.app")
public class ProyectoController {
    @Autowired
    ServiceProyecto serviceProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = serviceProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!serviceProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = serviceProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtopro){
        if(StringUtils.isBlank(dtopro.getNombrePro()))
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(serviceProyecto.existsByNombrePro(dtopro.getNombrePro()))
            return new ResponseEntity(new Mensaje("Proyecto existente"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = new Proyecto(dtopro.getNombrePro(), dtopro.getDescripcionPro(), dtopro.getEnlacesitePro(), dtopro.getEnlacerepoPro(), dtopro.getImgPro());
        serviceProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto creado y almacenado correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtopro){
        if(!serviceProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(serviceProyecto.existsByNombrePro(dtopro.getNombrePro()) && serviceProyecto.getByNombrePro(dtopro.getNombrePro()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
       if(StringUtils.isBlank(dtopro.getNombrePro()))
           return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
       
       Proyecto proyecto = serviceProyecto.getOne(id).get();
       proyecto.setNombrePro(dtopro.getNombrePro());
       proyecto.setDescripcionPro(dtopro.getDescripcionPro());
       proyecto.setEnlacesitePro(dtopro.getEnlacesitePro());
       proyecto.setEnlacerepoPro(dtopro.getEnlacerepoPro());
       proyecto.setImgPro(dtopro.getImgPro());
       
       serviceProyecto.save(proyecto);
       return new ResponseEntity(new Mensaje("Proyecto actualizado correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!serviceProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
        }
        
        serviceProyecto.delete(id);
        
        return new ResponseEntity(new Mensaje("Proyecto eliminado correctamente"), HttpStatus.OK);
    }
    
}
