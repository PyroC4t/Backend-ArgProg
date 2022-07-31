package com.portfolioAp.ap.Service;

import com.portfolioAp.ap.Entity.Proyecto;
import com.portfolioAp.ap.Repository.RepProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceProyecto {
    @Autowired
    RepProyecto repProyecto;
    
    public List<Proyecto> list(){
        return repProyecto.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return repProyecto.findById(id);
    }
    
    public Optional<Proyecto> getByNombrePro(String nombrePro){
        return repProyecto.findByNombrePro(nombrePro);
    }
    
    public void save(Proyecto proyecto){
        repProyecto.save(proyecto);
    }
    
    public void delete(int id){
        repProyecto.deleteById(id);
    }
    
    public boolean existsById(int id){
        return repProyecto.existsById(id);
    }
    
    public boolean existsByNombrePro(String nombrePro){
        return repProyecto.existsByNombrePro(nombrePro);
    }
    
}
