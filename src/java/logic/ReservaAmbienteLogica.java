/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
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

    List<Reservaambiente> listaReservaValida;

    @Override
    public void crear(Reservaambiente reservaAmbiente) throws Exception {
        
        Reservaambiente reservaHecha = reservaDAO.find(reservaAmbiente.getCodigoreservambiente());
        if (reservaHecha == null) {
            
            //Validacion fecha y hora inicio menores a  fecha y hora fin
            if (reservaAmbiente.getFechainicioreserva().getYear()<= reservaAmbiente.getFechafinreserva().getYear()) {
                if (reservaAmbiente.getFechainicioreserva().getMonth()<=reservaAmbiente.getFechafinreserva().getMonth()) {
                    if (reservaAmbiente.getFechainicioreserva().getDay() <= reservaAmbiente.getFechafinreserva().getDay()) {
                        String[] inicio = reservaAmbiente.getHorainicioreserva().split(":");
                        String[] fin = reservaAmbiente.getHorafinreserva().split(":");
                        int  horai = Integer.parseInt(inicio[0]); 
                        int  horaf = Integer.parseInt(fin[0]);
                        int  minutoi = Integer.parseInt(inicio[1]);
                        int  minutof = Integer.parseInt(fin[1]);
                        
                        if (horai<= horaf) {
                            if (minutoi<=minutof) {
                                throw new Exception("REGISTRAR");
                                
                            }
                            else{
                                throw new Exception("Se ha producido un error.\nDescripcion: La hora de inicio es mayor a la hora fin, por minutos.");
                            }
                        }
                        else{
                            throw new Exception("Se ha producido un error.\nDescripcion: La hora de inicio es mayor a la hora fin, por hora.");
                        }
                    }
                    else{
                        throw new Exception("Se ha producido un error.\nDescripcion: La fecha de inicio es mayor a la fecha fin, por dia.");
                    }
                }
                else{
                    throw new Exception("Se ha producido un error.\nDescripcion: La fecha de inicio es mayor a la fecha fin, por mes.");
                }
            }
            else{
                throw new Exception("Se ha producido un error.\nDescripcion: La fecha de inicio es mayor a la fecha fin, por año.");
            }
            
            
            
            
            /*
            //VALIDAR AÑO
            //Recorrer lista por fila
            listaReservaValida = reservaDAO.findAll();
            for (int n = 0; n < listaReservaValida.size(); n++) {
                

                //Recorrer rango de año (columna)
                for (int i = listaReservaValida.get(n).getFechainicioreserva().getYear(); i <= listaReservaValida.get(n).getFechafinreserva().getYear(); i++) {
                    
                    throw new Exception("Validando años..."+reservaAmbiente.getFechainicioreserva().getYear()+"---"+reservaAmbiente.getFechafinreserva().getYear());
                    
                    if (reservaAmbiente.getFechainicioreserva().getYear() == i && reservaAmbiente.getFechafinreserva().getYear() == i) {
                        
                        
                        
                    } else {
                        throw new Exception("Registro invalido por coincidencia de años!!");
                    }
                }
            }
            */
            
            
            //reservaDAO.create(reservaAmbiente);
            
            
        } else {
            throw new Exception("La reserva ya  existe");
        }
    }

    @Override
    public void editar(Reservaambiente reservaAmbiente) throws Exception {
        Reservaambiente reservaHecha = reservaDAO.find(reservaAmbiente.getCodigoreservambiente());
        if (reservaHecha == null) {
            throw new Exception("La reserva no existe");
        } else {
            reservaDAO.edit(reservaAmbiente);
        }
    }

    @Override
    public void eliminar(Reservaambiente reservaAmbiente) throws Exception {
        Reservaambiente reservaHecha = reservaDAO.find(reservaAmbiente.getCodigoreservambiente());
        if (reservaHecha == null) {
            throw new Exception("La reserva no existe");
        } else {
            reservaDAO.edit(reservaAmbiente);
        }
    }

    @Override
    public Reservaambiente consultarCodigo(Integer idReservaAmbiente) throws Exception {
        if (idReservaAmbiente == null) {
            throw new Exception("Ingrese un numero");
        } else {
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
