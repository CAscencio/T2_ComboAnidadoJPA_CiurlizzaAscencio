
package modelo.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.entity.Distrito;


@Stateless
public class DistritoFacade extends AbstractFacade<Distrito> {

    @PersistenceContext(unitName = "ComboAnidado")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DistritoFacade() {
        super(Distrito.class);
    }
    
    public List<Distrito> listaDistrito(int Codigo) {
        String jpql = "SELECT d FROM Distrito d JOIN d.codprov p WHERE p.codprov = :codprov";
        Query cq = em.createQuery(jpql, super.getClass());
        cq.setParameter("codprov", Codigo);
        return cq.getResultList();
    }
    
}
