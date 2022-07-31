package com.portfolioAp.ap.Repository;

import com.portfolioAp.ap.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepEducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombreEdu(String nombreEdu);
    public boolean existsByNombreEdu(String nombreEdu);
    
}
