/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "DEPARTAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d")
    , @NamedQuery(name = "Departamento.findByCoddepart", query = "SELECT d FROM Departamento d WHERE d.coddepart = :coddepart")
    , @NamedQuery(name = "Departamento.findByNomdepart", query = "SELECT d FROM Departamento d WHERE d.nomdepart = :nomdepart")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODDEPART")
    private int coddepart;
    
    @Size(max = 60)
    @Column(name = "NOMDEPART")
    private String nomdepart;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddepart")
    private List<Provincia> provinciaList;

    public Departamento() {
    }

    public Departamento(int coddepart) {
        this.coddepart = coddepart;
    }

    public int getCoddepart() {
        return coddepart;
    }

    public void setCoddepart(int coddepart) {
        this.coddepart = coddepart;
    }

    public String getNomdepart() {
        return nomdepart;
    }

    public void setNomdepart(String nomdepart) {
        this.nomdepart = nomdepart;
    }

    @XmlTransient
    public List<Provincia> getProvinciaList() {
        return provinciaList;
    }

    public void setProvinciaList(List<Provincia> provinciaList) {
        this.provinciaList = provinciaList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.coddepart;
        hash = 47 * hash + Objects.hashCode(this.nomdepart);
        hash = 47 * hash + Objects.hashCode(this.provinciaList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departamento other = (Departamento) obj;
        if (this.coddepart != other.coddepart) {
            return false;
        }
        if (!Objects.equals(this.nomdepart, other.nomdepart)) {
            return false;
        }
        if (!Objects.equals(this.provinciaList, other.provinciaList)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "modelo.entity.Departamento[ coddepart=" + coddepart + " ]";
    }
    
}
