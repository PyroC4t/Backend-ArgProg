package com.portfolioAp.ap.Repository;

import com.portfolioAp.ap.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepProyecto extends JpaRepository<Proyecto, Integer> {
    public Optional<Proyecto> findByNombrePro(String nombrePro);
    public boolean existsByNombrePro(String nombrePro);
    
}
