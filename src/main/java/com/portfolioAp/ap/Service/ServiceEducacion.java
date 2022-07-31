package com.portfolioAp.ap.Service;

import com.portfolioAp.ap.Entity.Educacion;
import com.portfolioAp.ap.Repository.RepEducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceEducacion {
    @Autowired
    RepEducacion repEducacion;
    
    public List<Educacion> list(){
       return repEducacion.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return repEducacion.findById(id);
    }
    
    public Optional<Educacion> getByNombreEdu(String nombreEdu){
        return repEducacion.findByNombreEdu(nombreEdu);
    }
    
    public void save(Educacion educacion){
        repEducacion.save(educacion);
    }
    
    public void delete(int id){
        repEducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return repEducacion.existsById(id);
    }
    
    public boolean existsByNombreEdu(String nombreEdu){
        return repEducacion.existsByNombreEdu(nombreEdu);
    }
    
}
