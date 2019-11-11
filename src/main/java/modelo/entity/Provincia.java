/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PROVINCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p")
    , @NamedQuery(name = "Provincia.findByCodprov", query = "SELECT p FROM Provincia p WHERE p.codprov = :codprov")
    , @NamedQuery(name = "Provincia.findByNomprov", query = "SELECT p FROM Provincia p WHERE p.nomprov = :nomprov")})
public class Provincia implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPROV")
    private BigDecimal codprov;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOMPROV")
    private String nomprov;
    
    @JoinColumn(name = "CODDEPART", referencedColumnName = "CODDEPART")
    @ManyToOne(optional = false)
    private Departamento coddepart;
    
    @OneToMany(mappedBy = "codprov")
    private List<Distrito> distritoList;

    public Provincia() {
    }

    public Provincia(BigDecimal codprov) {
        this.codprov = codprov;
    }

    public Provincia(BigDecimal codprov, String nomprov) {
        this.codprov = codprov;
        this.nomprov = nomprov;
    }

    public BigDecimal getCodprov() {
        return codprov;
    }

    public void setCodprov(BigDecimal codprov) {
        this.codprov = codprov;
    }

    public String getNomprov() {
        return nomprov;
    }

    public void setNomprov(String nomprov) {
        this.nomprov = nomprov;
    }

    public Departamento getCoddepart() {
        return coddepart;
    }

    public void setCoddepart(Departamento coddepart) {
        this.coddepart = coddepart;
    }

    @XmlTransient
    public List<Distrito> getDistritoList() {
        return distritoList;
    }

    public void setDistritoList(List<Distrito> distritoList) {
        this.distritoList = distritoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprov != null ? codprov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.codprov == null && other.codprov != null) || (this.codprov != null && !this.codprov.equals(other.codprov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.Provincia[ codprov=" + codprov + " ]";
    }
    
}
