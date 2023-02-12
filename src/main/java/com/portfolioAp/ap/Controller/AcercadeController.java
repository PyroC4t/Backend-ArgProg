package com.portfolioAp.ap.Controller;

import com.portfolioAp.ap.Dto.dtoAcercade;
import com.portfolioAp.ap.Entity.Acercade;
import com.portfolioAp.ap.Security.Controller.Mensaje;
import com.portfolioAp.ap.Service.ServiceAcercade;
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
@RequestMapping("acercademi")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolioap-50c82.web.app")
public class AcercadeController {
    @Autowired
    ServiceAcercade serviceAcercade;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Acercade>> list(){
        List<Acercade> list = serviceAcercade.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Acercade> getById(@PathVariable("id") int id){
        if(!serviceAcercade.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        Acercade acercade = serviceAcercade.getOne(id).get();
        return new ResponseEntity(acercade, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercade dtoace){
        if(StringUtils.isBlank(dtoace.getTituloAc()))
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(serviceAcercade.existsByTituloAc(dtoace.getTituloAc()))
            return new ResponseEntity(new Mensaje("Informacion existente"), HttpStatus.BAD_REQUEST);
        
        Acercade acercade = new Acercade(dtoace.getTituloAc(), dtoace.getDescripcionAc(), dtoace.getLinkiAc(),dtoace.getLinkgAc(), dtoace.getLinklAc(), dtoace.getImgAc());
        serviceAcercade.save(acercade);
        
        return new ResponseEntity(new Mensaje("Información creada y almacenada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercade dtoace){
        if(!serviceAcercade.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(serviceAcercade.existsByTituloAc(dtoace.getTituloAc()) && serviceAcercade.getByTituloAc(dtoace.getTituloAc()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("La información ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoace.getTituloAc()))
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Acercade acercade = serviceAcercade.getOne(id).get();
        acercade.setTituloAc(dtoace.getTituloAc());
        acercade.setDescripcionAc(dtoace.getDescripcionAc());
        acercade.setLinkiAc(dtoace.getLinkiAc());
        acercade.setLinkgAc(dtoace.getLinkgAc());
        acercade.setLinklAc(dtoace.getLinklAc());
        acercade.setImgAc(dtoace.getImgAc());
        
        serviceAcercade.save(acercade);
        return new ResponseEntity(new Mensaje("Información actualizada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!serviceAcercade.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        serviceAcercade.delete(id);
        
        return new ResponseEntity(new Mensaje("Información eliminada correctamente"), HttpStatus.OK);
    }
}
