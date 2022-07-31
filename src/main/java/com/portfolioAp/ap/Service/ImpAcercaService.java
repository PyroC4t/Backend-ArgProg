package com.portfolioAp.ap.Service;

import com.portfolioAp.ap.Entity.Acerca;
import com.portfolioAp.ap.Interface.IAcercaService;
import com.portfolioAp.ap.Repository.IAcercaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpAcercaService implements IAcercaService{
    @Autowired IAcercaRepository iacercaRepository;

    @Override
    public List<Acerca> getAcerca() {
        List<Acerca> acerca = iacercaRepository.findAll();
        return acerca;
    }

    @Override
    public void saveAcerca(Acerca acerca) {
        iacercaRepository.save(acerca);
    }

    @Override
    public void deleteAcerca(Long id) {
        iacercaRepository.deleteById(id);
    }

    @Override
    public Acerca findAcerca(Long id) {
        Acerca acerca = iacercaRepository.findById(id).orElse(null);
        return acerca;
    }
    
}
