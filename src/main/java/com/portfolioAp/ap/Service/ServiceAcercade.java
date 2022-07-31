package com.portfolioAp.ap.Service;

import com.portfolioAp.ap.Entity.Acercade;
import com.portfolioAp.ap.Repository.RepAcercade;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceAcercade {
    @Autowired
    RepAcercade repAcercade;
    
    public List<Acercade> list(){
        return repAcercade.findAll();
    }
    
    public Optional<Acercade> getOne(int id){
        return repAcercade.findById(id);
    }
    
    public Optional<Acercade> getByTituloAc(String tituloAc){
        return repAcercade.findByTituloAc(tituloAc);
    }
    
    public void save(Acercade acercade){
        repAcercade.save(acercade);
    }
    
    public void delete(int id){
        repAcercade.deleteById(id);
    }
    
    public boolean existsById(int id){
        return repAcercade.existsById(id);
    }
    
    public boolean existsByTituloAc(String tituloAc){
        return repAcercade.existsByTituloAc(tituloAc);
    }
    
}
