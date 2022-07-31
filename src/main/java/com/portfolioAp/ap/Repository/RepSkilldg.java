package com.portfolioAp.ap.Repository;

import com.portfolioAp.ap.Entity.Skilldg;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepSkilldg extends JpaRepository<Skilldg, Integer>{
    public Optional<Skilldg> findByNombreSkill(String nombreSkill);
    public boolean existsByNombreSkill(String nombreSkill);
    
}
