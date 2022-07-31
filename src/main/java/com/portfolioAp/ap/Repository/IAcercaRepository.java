package com.portfolioAp.ap.Repository;

import com.portfolioAp.ap.Entity.Acerca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAcercaRepository extends JpaRepository<Acerca, Long> {
    
}
