/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Departement;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author judith
 */
@Entity
public class Employe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double salaire;
    
    @ManyToOne
    private Departement departement;
    
    @ManyToOne
    private Superieur superieur;
    
    @OneToMany
    private List<Participation> participations;

    public Employe() {
    }

    public Superieur getSuperieur() {
        return superieur;
    }

    public void setSuperieur(Superieur superieur) {
        this.superieur = superieur;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

   
    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "exemplejpa.Employe[ id=" + id + " ]";
    }
    
//    public void addDepartement(Departement dpt){
//    
//        Employe emp = dpt.getEmployes().get(dpt.getId());
//        
//        if( emp != null){
//           dpt.getEmployes().remove(dpt.getId());       
//                        }
//        this.departement.addEmploye(emp);
//        
//    }
    
}
