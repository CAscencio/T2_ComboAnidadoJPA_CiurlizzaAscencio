package modelo.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entity.Provincia;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-11T08:47:43")
@StaticMetamodel(Distrito.class)
public class Distrito_ { 

    public static volatile SingularAttribute<Distrito, String> nomdist;
    public static volatile SingularAttribute<Distrito, Provincia> codprov;
    public static volatile SingularAttribute<Distrito, BigDecimal> coddist;

}