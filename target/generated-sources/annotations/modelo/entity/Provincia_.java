package modelo.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entity.Departamento;
import modelo.entity.Distrito;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-11T08:47:43")
@StaticMetamodel(Provincia.class)
public class Provincia_ { 

    public static volatile SingularAttribute<Provincia, Integer> codprov;
    public static volatile SingularAttribute<Provincia, String> nomprov;
    public static volatile SingularAttribute<Provincia, Departamento> coddepart;
    public static volatile ListAttribute<Provincia, Distrito> distritoList;

}