package com.portfolioAp.ap.Repository;

import com.portfolioAp.ap.Entity.Skilldev;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepSkilldev extends JpaRepository<Skilldev, Integer>{
    public Optional<Skilldev> findByNombreSkidev(String nombreSkidev);
    public boolean existsByNombreSkidev(String nombreSkidev);
    
}
