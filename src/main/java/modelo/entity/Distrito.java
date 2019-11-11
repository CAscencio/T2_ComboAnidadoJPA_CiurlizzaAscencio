/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "DISTRITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distrito.findAll", query = "SELECT d FROM Distrito d")
    , @NamedQuery(name = "Distrito.findByCoddist", query = "SELECT d FROM Distrito d WHERE d.coddist = :coddist")
    , @NamedQuery(name = "Distrito.findByNomdist", query = "SELECT d FROM Distrito d WHERE d.nomdist = :nomdist")})
public class Distrito implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODDIST")
    private BigDecimal coddist;
    
    @Size(max = 60)
    @Column(name = "NOMDIST")
    private String nomdist;
    
    @JoinColumn(name = "CODPROV", referencedColumnName = "CODPROV")
    @ManyToOne
    private Provincia codprov;

    public Distrito() {
    }

    public Distrito(BigDecimal coddist) {
        this.coddist = coddist;
    }

    public BigDecimal getCoddist() {
        return coddist;
    }

    public void setCoddist(BigDecimal coddist) {
        this.coddist = coddist;
    }

    public String getNomdist() {
        return nomdist;
    }

    public void setNomdist(String nomdist) {
        this.nomdist = nomdist;
    }

    public Provincia getCodprov() {
        return codprov;
    }

    public void setCodprov(Provincia codprov) {
        this.codprov = codprov;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddist != null ? coddist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distrito)) {
            return false;
        }
        Distrito other = (Distrito) object;
        if ((this.coddist == null && other.coddist != null) || (this.coddist != null && !this.coddist.equals(other.coddist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.Distrito[ coddist=" + coddist + " ]";
    }
    
}
