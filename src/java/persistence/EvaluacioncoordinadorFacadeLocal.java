/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Evaluacioncoordinador;

/**
 *
 * @author andres
 */
@Local
public interface EvaluacioncoordinadorFacadeLocal {

    void create(Evaluacioncoordinador evaluacioncoordinador);

    void edit(Evaluacioncoordinador evaluacioncoordinador);

    void remove(Evaluacioncoordinador evaluacioncoordinador);

    Evaluacioncoordinador find(Object id);

    List<Evaluacioncoordinador> findAll();

    List<Evaluacioncoordinador> findRange(int[] range);

    int count();
    
}
