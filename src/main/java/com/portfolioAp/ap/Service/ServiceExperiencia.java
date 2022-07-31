package com.portfolioAp.ap.Service;

import com.portfolioAp.ap.Entity.Experiencia;
import com.portfolioAp.ap.Repository.RepExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceExperiencia {
    @Autowired
    RepExperiencia repExperiencia;
    
    public List<Experiencia> list(){
        return repExperiencia.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return repExperiencia.findById(id);
    }
    
    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return repExperiencia.findByNombreExp(nombreExp);
    }
    
    public void save(Experiencia experiencia){
        repExperiencia.save(experiencia);
    }
    
    public void delete(int id){
        repExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id){
        return repExperiencia.existsById(id);
    }
    
    public boolean existsByNombreExp(String nombreExp){
        return repExperiencia.existsByNombreExp(nombreExp);
    }
}
