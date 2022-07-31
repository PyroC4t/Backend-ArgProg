package com.portfolioAp.ap.Controller;

import com.portfolioAp.ap.Entity.Acerca;
import com.portfolioAp.ap.Interface.IAcercaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AcercaController {
    @Autowired IAcercaService iacercaService;
    
    @GetMapping("acerca/traer")
    public List<Acerca> getAcerca(){
        return iacercaService.getAcerca();
    }
    
    @PostMapping("/acerca/crear")
    public String createAcerca(@RequestBody Acerca acerca){
        iacercaService.saveAcerca(acerca);
        return "La informacion fue creada correctamente";
    }
    
    @DeleteMapping("/acerca/borrar/{id}")
    public String deleteAcerca(@PathVariable Long id){
        iacercaService.deleteAcerca(id);
        return "El elemento fue eliminado correctamente";
    }
    
    @PutMapping("/acerca/editar/{id}")
    public Acerca editAcerca(@PathVariable Long id,
                             @RequestParam("titulo") String nuevoTitulo,
                             @RequestParam("descripcion") String nuevoDescripcion,
                             @RequestParam("img") String nuevoImg){
        Acerca acerca = iacercaService.findAcerca(id);
        
        acerca.setTitulo(nuevoTitulo);
        acerca.setDescripcion(nuevoDescripcion);
        acerca.setImg(nuevoImg);
        
        iacercaService.saveAcerca(acerca);
        return acerca;
    }
    
    @GetMapping("/acerca/traer/perfil")
    public Acerca findAcerca(){
        return iacercaService.findAcerca((long)1);
    }
}
