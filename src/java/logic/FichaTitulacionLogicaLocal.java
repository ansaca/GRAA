/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import model.Fichatitulacion;

/**
 *
 * @author andres
 */
@Local
public interface FichaTitulacionLogicaLocal {
    void crear(Fichatitulacion fichatitulacion) throws Exception;
    void modificar(Fichatitulacion fichatitulacion) throws Exception;
    void eliminar(Fichatitulacion fichatitulacion) throws Exception;
    Fichatitulacion consultarCodigo(Integer idFichatitulacion) throws Exception;
    List<Fichatitulacion>consultarTodo() throws Exception;

}
