package com.portfolioAp.ap.Service;

import com.portfolioAp.ap.Entity.Skilldev;
import com.portfolioAp.ap.Repository.RepSkilldev;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceSkilldev {
    @Autowired
    RepSkilldev repSkilldev;
    
    public List<Skilldev> list(){
       return repSkilldev.findAll();
    }
    
    public Optional<Skilldev> getOne(int id){
        return repSkilldev.findById(id);
    }
    
    public Optional<Skilldev> getByNombreSkidev(String nombreSkidev){
        return repSkilldev.findByNombreSkidev(nombreSkidev);
    }
    
    public void save(Skilldev skilldev){
        repSkilldev.save(skilldev);
    }
    
    public void delete(int id){
        repSkilldev.deleteById(id);
    }
    
    public boolean existsById(int id){
        return repSkilldev.existsById(id);
    }
    
    public boolean existsByNombreSkidev(String nombreSkidev){
        return repSkilldev.existsByNombreSkidev(nombreSkidev);
    }
    
}
