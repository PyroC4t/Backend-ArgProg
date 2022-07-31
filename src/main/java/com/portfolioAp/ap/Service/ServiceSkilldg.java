package com.portfolioAp.ap.Service;

import com.portfolioAp.ap.Entity.Skilldg;
import com.portfolioAp.ap.Repository.RepSkilldg;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceSkilldg {
    @Autowired
    RepSkilldg repSkilldg;
    
    public List<Skilldg> list(){
        return repSkilldg.findAll();
    }
    
    public Optional<Skilldg> getOne(int id){
        return repSkilldg.findById(id);
    }
    
    public Optional<Skilldg> getByNombreSkill(String nombreSkill){
        return repSkilldg.findByNombreSkill(nombreSkill);
    }
    
    public void save(Skilldg skilldg){
        repSkilldg.save(skilldg);
    }
    
    public void delete(int id){
        repSkilldg.deleteById(id);
    }
    
    public boolean existsById(int id){
        return repSkilldg.existsById(id);
    }
    
    public boolean existsByNombreSkill(String nombreSkill){
        return repSkilldg.existsByNombreSkill(nombreSkill);
    }
}
