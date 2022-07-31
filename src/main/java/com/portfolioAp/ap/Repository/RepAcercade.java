package com.portfolioAp.ap.Repository;

import com.portfolioAp.ap.Entity.Acercade;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepAcercade extends JpaRepository<Acercade, Integer>{
    public Optional<Acercade> findByTituloAc(String tituloAc);
    public boolean existsByTituloAc(String tituloAc);

}
