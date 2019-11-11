package modelo.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entity.Provincia;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-11T08:47:43")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> nomdepart;
    public static volatile SingularAttribute<Departamento, Integer> coddepart;
    public static volatile ListAttribute<Departamento, Provincia> provinciaList;

}