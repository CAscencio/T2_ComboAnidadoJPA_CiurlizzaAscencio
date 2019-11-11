
package modelo.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    
}
