/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Reservaambiente;
import persistence.ReservaambienteFacadeLocal;

/**
 *
 * @author andres
 */
@Stateless
public class ReservaAmbienteLogica implements ReservaAmbienteLogicaLocal {
    @EJB
    private ReservaambienteFacadeLocal reservaDAO;

    @Override
    public void crear(Reservaambiente reservaAmbiente) throws Exception {
        Reservaambiente reservaHecha = reservaDAO.find(reservaAmbiente.getCodigoreservambiente());
        if (reservaHecha==null) {
            reservaDAO.create(reservaAmbiente);
        }else{
            throw new Exception("La reserva ya esta existe");
        }
    }

    @Override
    public void editar(Reservaambiente reservaAmbiente) throws Exception {
        Reservaambiente reservaHecha = reservaDAO.find(reservaAmbiente.getCodigoreservambiente());
        if (reservaHecha==null) {
            throw new Exception("La reserva no existe");
        }else{
            reservaDAO.edit(reservaAmbiente);
        }
    }

    @Override
    public void eliminar(Reservaambiente reservaAmbiente) throws Exception {
        Reservaambiente reservaHecha = reservaDAO.find(reservaAmbiente.getCodigoreservambiente());
        if (reservaHecha==null) {
            throw new Exception("La reserva no existe");
        }else{
            reservaDAO.edit(reservaAmbiente);
        }
    }

    @Override
    public Reservaambiente consultarCodigo(Integer idReservaAmbiente) throws Exception {
        if (idReservaAmbiente==null) {
            throw new Exception("Ingrese un numero");
        }else{
            return reservaDAO.find(idReservaAmbiente);
        }
    }

    @Override
    public List<Reservaambiente> consultarTodo() throws Exception {
        return reservaDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
