package com.portfolioAp.ap.Repository;

import com.portfolioAp.ap.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepUser extends JpaRepository<User, Integer>{
    public Optional<User> findByNombreUser(String nombreUser);
    public boolean existsByNombreUser(String nombreUser);
    
    
}
