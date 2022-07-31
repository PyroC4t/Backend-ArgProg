package com.portfolioAp.ap.Interface;

import com.portfolioAp.ap.Entity.Acerca;
import java.util.List;


public interface IAcercaService {
    
    public List<Acerca> getAcerca();
    
    public void saveAcerca(Acerca acerca);
    
    public void deleteAcerca(Long id);
    
    public Acerca findAcerca(Long id);
    
}
