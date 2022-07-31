package com.portfolioAp.ap.Controller;

import com.portfolioAp.ap.Dto.dtoSkilldg;
import com.portfolioAp.ap.Entity.Skilldg;
import com.portfolioAp.ap.Security.Controller.Mensaje;
import com.portfolioAp.ap.Service.ServiceSkilldg;
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
@RequestMapping("skilldiseno")
@CrossOrigin(origins = "http://localhost:4200")
public class SkilldgController {
    @Autowired
    ServiceSkilldg serviceSkilldg;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skilldg>> list(){
        List<Skilldg> list = serviceSkilldg.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skilldg> getById(@PathVariable("id") int id){
        if(!serviceSkilldg.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        Skilldg skilldg = serviceSkilldg.getOne(id).get();
        return new ResponseEntity(skilldg, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkilldg dtoskill){
        if(StringUtils.isBlank(dtoskill.getNombreSkill()))
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(serviceSkilldg.existsByNombreSkill(dtoskill.getNombreSkill()))
            return new ResponseEntity(new Mensaje("Skill existente"), HttpStatus.BAD_REQUEST);
        
        Skilldg skilldg = new Skilldg(dtoskill.getNombreSkill(), dtoskill.getPorcentajeSkill(), dtoskill.getImgSkill());
        serviceSkilldg.save(skilldg);
        
        return new ResponseEntity(new Mensaje("Skill creada y almacenada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkilldg dtoskill){
        if(!serviceSkilldg.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(serviceSkilldg.existsByNombreSkill(dtoskill.getNombreSkill()) && serviceSkilldg.getByNombreSkill(dtoskill.getNombreSkill()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("El skill ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoskill.getNombreSkill()))
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skilldg skilldg = serviceSkilldg.getOne(id).get();
        skilldg.setNombreSkill(dtoskill.getNombreSkill());
        skilldg.setPorcentajeSkill(dtoskill.getPorcentajeSkill());
        skilldg.setImgSkill(dtoskill.getImgSkill());
        
        serviceSkilldg.save(skilldg);
        return new ResponseEntity(new Mensaje("Skill actualizada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!serviceSkilldg.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        serviceSkilldg.delete(id);
        
        return new ResponseEntity(new Mensaje("Skill eliminada correctamente"), HttpStatus.OK);
    }
}
