/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.entity.Departamento;
import modelo.entity.Provincia;

/**
 *
 * @author Usuario
 */
@Stateless
public class ProvinciaFacade extends AbstractFacade<Provincia> {

    @PersistenceContext(unitName = "ComboAnidado")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProvinciaFacade() {
        super(Provincia.class);
    }

    public List<Provincia> listaDepartamento(int Codigo) {
        String jpql = "SELECT p FROM Provincia p JOIN p.coddepart d WHERE d.coddepart = :coddepart";
        Query cq = em.createQuery(jpql, super.getClass());
        System.out.println("RECIBO EL CODIGO :" + Codigo);
        cq.setParameter("coddepart", Codigo);
        return cq.getResultList();
    }

}
