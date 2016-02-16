/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Experiencia;

/**
 *
 * @author andres
 */
@Local
public interface ExperienciaFacadeLocal {

    void create(Experiencia experiencia);

    void edit(Experiencia experiencia);

    void remove(Experiencia experiencia);

    Experiencia find(Object id);

    List<Experiencia> findAll();

    List<Experiencia> findRange(int[] range);

    int count();
    
}
