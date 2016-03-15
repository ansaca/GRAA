/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        if (reservaHecha == null) {

            //Validacion fecha y hora ordenadas
            Calendar fInicio = Calendar.getInstance();
            fInicio.setTime(reservaAmbiente.getFechainicioreserva());
            Calendar fFin = Calendar.getInstance();
            fFin.setTime(reservaAmbiente.getFechafinreserva());
            //Se convirtio a tipo calendar para validar los datos de manera exacta ya que por date no arroja valores precisos de los atributos
            if (fInicio.get(Calendar.YEAR) == fFin.get(Calendar.YEAR)) {
                if (fInicio.get(Calendar.MONTH) == fFin.get(Calendar.MONTH)) {
                    if (fInicio.get(Calendar.DATE) <= fFin.get(Calendar.DATE)) {
                        String[] inicio = reservaAmbiente.getHorainicioreserva().split(":");
                        String[] fin = reservaAmbiente.getHorafinreserva().split(":");
                        int horai = Integer.parseInt(inicio[0]);
                        int horaf = Integer.parseInt(fin[0]);
                        int minutoi = Integer.parseInt(inicio[1]);
                        int minutof = Integer.parseInt(fin[1]);

                        if (horai <= horaf) {

                            //Validacion fecha actual
                            Calendar c = Calendar.getInstance();
                            //String fa = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DATE);
                            java.sql.Date fechaActual = new java.sql.Date(c.get(Calendar.YEAR) - 1900, c.get(Calendar.MONTH), c.get(Calendar.DATE));

                            if (fechaActual.before(reservaAmbiente.getFechainicioreserva())) {

                                //Validar Ambiente
                                List<Reservaambiente> listaConsultaA = reservaDAO.findxIdAmbiente(reservaAmbiente.getCodigoambiente().getCodigoambiente());
                                if (!listaConsultaA.isEmpty()) {
                                    
                                    //Validar fechas
                                    int coincide = 0, nocoincide = 0;
                                    for (int i = 0; i < listaConsultaA.size(); i++) {
                                        if (listaConsultaA.get(i).getFechafinreserva().before(reservaAmbiente.getFechainicioreserva()) && listaConsultaA.get(i).getFechafinreserva().before(reservaAmbiente.getFechafinreserva())) {
                                            nocoincide++;
                                        } else if (reservaAmbiente.getFechainicioreserva().before(listaConsultaA.get(i).getFechainicioreserva()) && reservaAmbiente.getFechafinreserva().before(listaConsultaA.get(i).getFechainicioreserva())) {
                                            nocoincide++;
                                        } else {
                                            coincide++;
                                        }
                                    }

                                    if (coincide == 0) {
                                        throw new Exception("REGISTRAR El ambiente si estaba en el registro, no coinciden en las "+nocoincide+" fechas que el ambiente esta reservado!! ");
                                    } else if (coincide >= 1) {
                                        throw new Exception("Error, El ambiente coincide con "+coincide+" fecha(s) reservadas");
                                    }

                                } else {
                                    //La reserva que se registra contiene un ambiente que no esta en el registro de reservas por eso no se valida fechas
                                    //reservaDAO.create(reservaAmbiente);
                                    throw new Exception("REGISTRAR  El ambiente no estaba en el registro");
                                }

                            } else {
                                throw new Exception("Se ha producido un error.\nDescripcion:La fecha ingresada debe corresponder a fechas despues de la fecha actual(" + fechaActual + ")");
                            }

                        } else {
                            throw new Exception("Se ha producido un error.\nDescripcion: La hora de inicio es mayor a la hora fin, por hora.");
                        }
                    } else {
                        throw new Exception("Se ha producido un error.\nDescripcion: La fecha de inicio es mayor a la fecha fin, por dia.");
                    }
                    
                    //Validacion mes inicio menor mes final
                }  else if (fInicio.get(Calendar.MONTH) < fFin.get(Calendar.MONTH)) {
                    String[] inicio = reservaAmbiente.getHorainicioreserva().split(":");
                        String[] fin = reservaAmbiente.getHorafinreserva().split(":");
                        int horai = Integer.parseInt(inicio[0]);
                        int horaf = Integer.parseInt(fin[0]);
                        int minutoi = Integer.parseInt(inicio[1]);
                        int minutof = Integer.parseInt(fin[1]);

                        if (horai <= horaf) {

                            //Validacion fecha actual
                            Calendar c = Calendar.getInstance();
                            //String fa = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DATE);
                            java.sql.Date fechaActual = new java.sql.Date(c.get(Calendar.YEAR) - 1900, c.get(Calendar.MONTH), c.get(Calendar.DATE));

                            if (fechaActual.before(reservaAmbiente.getFechainicioreserva())) {

                                //Validar Ambiente
                                List<Reservaambiente> listaConsultaA = reservaDAO.findxIdAmbiente(reservaAmbiente.getCodigoambiente().getCodigoambiente());
                                if (!listaConsultaA.isEmpty()) {
                                    
                                    //Validar fechas
                                    int coincide = 0, nocoincide = 0;
                                    for (int i = 0; i < listaConsultaA.size(); i++) {
                                        if (listaConsultaA.get(i).getFechafinreserva().before(reservaAmbiente.getFechainicioreserva()) && listaConsultaA.get(i).getFechafinreserva().before(reservaAmbiente.getFechafinreserva())) {
                                            nocoincide++;
                                        } else if (reservaAmbiente.getFechainicioreserva().before(listaConsultaA.get(i).getFechainicioreserva()) && reservaAmbiente.getFechafinreserva().before(listaConsultaA.get(i).getFechainicioreserva())) {
                                            nocoincide++;
                                        } else {
                                            coincide++;
                                        }
                                    }

                                    if (coincide == 0) {
                                        throw new Exception("REGISTRAR El ambiente si estaba en el registro, no coinciden en las "+nocoincide+" fechas que el ambiente esta reservado!! ");
                                    } else if (coincide >= 1) {
                                        throw new Exception("Error, El ambiente coincide con "+coincide+" fecha(s) reservadas");
                                    }

                                } else {
                                    //La reserva que se registra contiene un ambiente que no esta en el registro de reservas por eso no se valida fechas
                                    //reservaDAO.create(reservaAmbiente);
                                    throw new Exception("REGISTRAR  El ambiente no estaba en el registro");
                                }

                            } else {
                                throw new Exception("Se ha producido un error.\nDescripcion:La fecha ingresada debe corresponder a fechas despues de la fecha actual(" + fechaActual + ")");
                            }

                        } else {
                            throw new Exception("Se ha producido un error.\nDescripcion: La hora de inicio es mayor a la hora fin, por hora.");
                        }
                } else {
                    throw new Exception("Se ha producido un error.\nDescripcion: La fecha de inicio es mayor a la fecha fin, por mes.");
                }
            //Validacion año inicio menor año final    
            } else if (fInicio.get(Calendar.YEAR) < fFin.get(Calendar.YEAR)) {
                
                        String[] inicio = reservaAmbiente.getHorainicioreserva().split(":");
                        String[] fin = reservaAmbiente.getHorafinreserva().split(":");
                        int horai = Integer.parseInt(inicio[0]);
                        int horaf = Integer.parseInt(fin[0]);
                        int minutoi = Integer.parseInt(inicio[1]);
                        int minutof = Integer.parseInt(fin[1]);

                        if (horai <= horaf) {

                            //Validacion fecha actual
                            Calendar c = Calendar.getInstance();
                            //String fa = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DATE);
                            java.sql.Date fechaActual = new java.sql.Date(c.get(Calendar.YEAR) - 1900, c.get(Calendar.MONTH), c.get(Calendar.DATE));

                            if (fechaActual.before(reservaAmbiente.getFechainicioreserva())) {

                                //Validar Ambiente
                                List<Reservaambiente> listaConsultaA = reservaDAO.findxIdAmbiente(reservaAmbiente.getCodigoambiente().getCodigoambiente());
                                if (!listaConsultaA.isEmpty()) {
                                    
                                    //Validar fechas
                                    int coincide = 0, nocoincide = 0;
                                    for (int i = 0; i < listaConsultaA.size(); i++) {
                                        if (listaConsultaA.get(i).getFechafinreserva().before(reservaAmbiente.getFechainicioreserva()) && listaConsultaA.get(i).getFechafinreserva().before(reservaAmbiente.getFechafinreserva())) {
                                            nocoincide++;
                                        } else if (reservaAmbiente.getFechainicioreserva().before(listaConsultaA.get(i).getFechainicioreserva()) && reservaAmbiente.getFechafinreserva().before(listaConsultaA.get(i).getFechainicioreserva())) {
                                            nocoincide++;
                                        } else {
                                            coincide++;
                                        }
                                    }

                                    if (coincide == 0) {
                                        throw new Exception("REGISTRAR El ambiente si estaba en el registro, no coinciden en las "+nocoincide+" fechas que el ambiente esta reservado!! ");
                                    } else if (coincide >= 1) {
                                        throw new Exception("Error, El ambiente coincide con "+coincide+" fecha(s) reservadas");
                                    }

                                } else {
                                    //La reserva que se registra contiene un ambiente que no esta en el registro de reservas por eso no se valida fechas
                                    //reservaDAO.create(reservaAmbiente);
                                    throw new Exception("REGISTRAR  El ambiente no estaba en el registro");
                                }

                            } else {
                                throw new Exception("Se ha producido un error.\nDescripcion:La fecha ingresada debe corresponder a fechas despues de la fecha actual(" + fechaActual + ")");
                            }

                        } else {
                            throw new Exception("Se ha producido un error.\nDescripcion: La hora de inicio es mayor a la hora fin, por hora.");
                        }
                    
            } else
            {
                throw new Exception("Se ha producido un error.\nDescripcion: La fecha de inicio es mayor a la fecha fin, por año.");
            }

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
