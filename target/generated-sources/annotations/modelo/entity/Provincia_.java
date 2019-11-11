package modelo.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entity.Departamento;
import modelo.entity.Distrito;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-06T20:38:09")
@StaticMetamodel(Provincia.class)
public class Provincia_ { 

    public static volatile SingularAttribute<Provincia, BigDecimal> codprov;
    public static volatile SingularAttribute<Provincia, String> nomprov;
    public static volatile SingularAttribute<Provincia, Departamento> coddepart;
    public static volatile ListAttribute<Provincia, Distrito> distritoList;

}