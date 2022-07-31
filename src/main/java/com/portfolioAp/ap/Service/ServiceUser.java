package com.portfolioAp.ap.Service;

import com.portfolioAp.ap.Entity.User;
import com.portfolioAp.ap.Repository.RepUser;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceUser {
    @Autowired
    RepUser repUser;
    
    public List<User> list(){
        return repUser.findAll();
    }
    
    public Optional<User> getOne(int id){
        return repUser.findById(id);
    }
    
    public Optional<User> getByNombreUSer(String nombreUser){
        return repUser.findByNombreUser(nombreUser);
    }
    
    public void save(User user){
        repUser.save(user);
    }
    
    public void delete(int id){
        repUser.deleteById(id);
    }
    
    public boolean existsById(int id){
        return repUser.existsById(id);
    }
    
    public boolean existsByNombreUser(String nombreUser){
        return repUser.existsByNombreUser(nombreUser);
    }
    
}
