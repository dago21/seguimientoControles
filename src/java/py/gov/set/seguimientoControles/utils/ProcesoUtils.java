    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.set.seguimientoControles.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import py.gov.set.seguimientoControles.pojos.DptoOperativo;
import py.gov.set.seguimientoControles.pojos.Obligaciones;
import py.gov.set.seguimientoControles.pojos.ProcesoCabecera;
import py.gov.set.seguimientoControles.pojos.ProcesoPeriodos;
import py.gov.set.seguimientoControles.pojos.TipoControl;

/**
 *
 * @author agomez
 */
public class ProcesoUtils {

    Session session = null;
    private static SessionFactory sessionFactory = null;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
    * Permite insertar un nuevo proceso, se encuentra distribuido en dos etapas
    * Primero la inserción de la cabecera en la tabla PROCESO_CABECERA
    * Segundo la inserción del detalle del proceso dentro de la tabla PROCESO_PERIODO
     */
    public boolean insertarProceso(ProcesoCabecera procesoCabecera, ProcesoPeriodos procesoPeriodo) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            ProcesoCabecera pc = new ProcesoCabecera();
            pc.setNroProceso(procesoCabecera.getNroProceso());
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    //lista todos los tipos de controles de la tabla TIPO_CONTROLES
    public List<TipoControl> listControles() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        //List<Usuarios> list = new ArrayList<Usuarios>();
        List<TipoControl> list = new ArrayList<TipoControl>();
        try {
            //Criteria cri = session.createCriteria(Usuarios.class);
            Criteria cri = session.createCriteria(TipoControl.class);
            list.addAll(cri.list());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("lista" + list.size());
        return list;
    }

    public TipoControl buscarTipoControl(int idTipoControl) {
        TipoControl t = new TipoControl();
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            Criteria cri = session.createCriteria(TipoControl.class);
            cri.add(Restrictions.eq("idTipo", idTipoControl));
            t = (TipoControl) cri.uniqueResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return t;
    }

    public List<DptoOperativo> listDepartamentos() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        //List<Usuarios> list = new ArrayList<Usuarios>();
        List<DptoOperativo> list = new ArrayList<DptoOperativo>();
        try {
            //Criteria cri = session.createCriteria(Usuarios.class);
            Criteria cri = session.createCriteria(DptoOperativo.class);
            list.addAll(cri.list());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("lista" + list.size());
        return list;
    }

    // LISTA LAS OBLIGACIONES DE LA TABLA DEL MISMO NOMBRE.
    public List<Obligaciones> listObligaciones() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        //List<Usuarios> list = new ArrayList<Usuarios>();
        List<Obligaciones> list = new ArrayList<Obligaciones>();
        try {
            //Criteria cri = session.createCriteria(Usuarios.class);
            Criteria cri = session.createCriteria(Obligaciones.class);
            list.addAll(cri.list());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("lista" + list.size());
        return list;
    }

    public Obligaciones buscarObligacion(BigDecimal codObligacion) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Obligaciones tax = new Obligaciones();
        try {
            //Criteria cri = session.createCriteria(Usuarios.class);
            Criteria cri = session.createCriteria(Obligaciones.class);
            cri.add(Restrictions.eq("codObligacion", codObligacion));
            tax = (Obligaciones) cri.uniqueResult();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return tax;
    }

    public ProcesoCabecera buscarProcesoCabecera(int nroProceso) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        ProcesoCabecera cabecera = new ProcesoCabecera();
        try {
            //Criteria cri = session.createCriteria(Usuarios.class);
            Criteria cri = session.createCriteria(Obligaciones.class);
            cri.add(Restrictions.eq("nroProceso", nroProceso));
            cabecera = (ProcesoCabecera) cri.uniqueResult();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return cabecera;
    }

    public DptoOperativo buscarDpto(int idDpto) {
        DptoOperativo dpto = new DptoOperativo();
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            Criteria cri = session.createCriteria(DptoOperativo.class);
            cri.add(Restrictions.eq("idDpto", idDpto));
            dpto = (DptoOperativo) cri.uniqueResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return dpto;
    }
    
    public boolean insertarProcesoCabecera(ProcesoCabecera pc) {
        boolean result = false;
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            session.save(pc);
            session.beginTransaction().commit();
            result = true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            result = false;
            ex.printStackTrace();
        } finally {
            session.close();
        }
        
        return result;
    }

}
