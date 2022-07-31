package com.portfolioAp.ap.Controller;

import com.portfolioAp.ap.Dto.dtoUser;
import com.portfolioAp.ap.Entity.User;
import com.portfolioAp.ap.Security.Controller.Mensaje;
import com.portfolioAp.ap.Service.ServiceUser;
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
@RequestMapping("usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    ServiceUser serviceUser;
    
    @GetMapping("/lista")
    public ResponseEntity<List<User>> list(){
        List<User> list = serviceUser.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id){
        if(!serviceUser.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        User user = serviceUser.getOne(id).get();
        return new ResponseEntity(user, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoUser dtouse){
        if(StringUtils.isBlank(dtouse.getNombreUser()))
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(serviceUser.existsByNombreUser(dtouse.getNombreUser()))
            return new ResponseEntity(new Mensaje("Usuario existente"), HttpStatus.BAD_REQUEST);
        
        User user = new User(dtouse.getNombreUser(), dtouse.getApellidoUser(), dtouse.getImgUser());
        serviceUser.save(user);
        
        return new ResponseEntity(new Mensaje("Usuario creado y almacenado correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoUser dtouse){
        if(!serviceUser.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(serviceUser.existsByNombreUser(dtouse.getNombreUser()) && serviceUser.getByNombreUSer(dtouse.getNombreUser()).get().getId() !=id)
           return new ResponseEntity(new Mensaje("El usuario ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtouse.getNombreUser()))
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        User user = serviceUser.getOne(id).get();
        user.setNombreUser(dtouse.getNombreUser());
        user.setApellidoUser(dtouse.getApellidoUser());
        user.setImgUser(dtouse.getImgUser());
        
        serviceUser.save(user);
        return new ResponseEntity(new Mensaje("Usuario actualizado correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!serviceUser.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        serviceUser.delete(id);
        
        return new ResponseEntity(new Mensaje("Usuario eliminado correctamente"), HttpStatus.OK);
    }
    
}
