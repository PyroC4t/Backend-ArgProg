package com.portfolioAp.ap.Controller;

import com.portfolioAp.ap.Dto.dtoSkilldev;
import com.portfolioAp.ap.Entity.Skilldev;
import com.portfolioAp.ap.Security.Controller.Mensaje;
import com.portfolioAp.ap.Service.ServiceSkilldev;
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
@RequestMapping("skilldeveloper")
@CrossOrigin(origins = "https://portfolioap-50c82.web.app")
public class SkilldevController {
    @Autowired
    ServiceSkilldev serviceSkilldev;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skilldev>> list(){
        List<Skilldev> list = serviceSkilldev.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skilldev> getById(@PathVariable("id") int id){
        if(!serviceSkilldev.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        Skilldev skilldev = serviceSkilldev.getOne(id).get();
        return new ResponseEntity(skilldev, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkilldev dtoski){
        if(StringUtils.isBlank(dtoski.getNombreSkidev()))
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(serviceSkilldev.existsByNombreSkidev(dtoski.getNombreSkidev()))
            return new ResponseEntity(new Mensaje("Skill existente"), HttpStatus.BAD_REQUEST);
        
        Skilldev skilldev = new Skilldev(dtoski.getNombreSkidev(), dtoski.getPorcentajeSkidev(), dtoski.getIconSkidev());
        serviceSkilldev.save(skilldev);
        
        return new ResponseEntity(new Mensaje ("Skill creada y almacenada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoSkilldev dtoski){
        if(!serviceSkilldev.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(serviceSkilldev.existsByNombreSkidev(dtoski.getNombreSkidev()) && serviceSkilldev.getByNombreSkidev(dtoski.getNombreSkidev()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("El skill ya existe"),HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoski.getNombreSkidev()))
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skilldev skilldev = serviceSkilldev.getOne(id).get();
        skilldev.setNombreSkidev(dtoski.getNombreSkidev());
        skilldev.setPorcentajeSkidev(dtoski.getPorcentajeSkidev());
        skilldev.setIconSkidev(dtoski.getIconSkidev());
        
        serviceSkilldev.save(skilldev);
        return new ResponseEntity(new Mensaje("Skill actualizada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!serviceSkilldev.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        serviceSkilldev.delete(id);
        
        return new ResponseEntity(new Mensaje("Skill eliminada correctamente"), HttpStatus.OK);
    }
}
