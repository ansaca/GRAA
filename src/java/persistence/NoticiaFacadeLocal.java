/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Noticia;

/**
 *
 * @author andres
 */
@Local
public interface NoticiaFacadeLocal {

    void create(Noticia noticia);

    void edit(Noticia noticia);

    void remove(Noticia noticia);

    Noticia find(Object id);

    List<Noticia> findAll();

    List<Noticia> findRange(int[] range);

    int count();
    
}
