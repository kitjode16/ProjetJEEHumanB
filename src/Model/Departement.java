/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;

/**
 *
 * @author judith
 */
@Entity
public class Departement implements Serializable {

    EntityManagerFactory emf = null;
    EntityManager  em = null;
    EntityTransaction et = null;
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nom;
    private String lieu;
    
    @OneToMany(mappedBy = "departement")
    private List<Employe> employes;

    public Departement() {
    }

    public Departement(String nom, String lieu) {
        this.nom = nom;
        this.lieu =lieu;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    
    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

 
      public String getNom() {
        return nom;
    }
    
       public void setNom(String nom) {
        this.nom = nom;
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
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "exemplejpa.DepartementJode[ id=" + id + " ]";
    }
    
    
    public void addEmploye(Employe em){
    
        Departement dept = em.getDepartement();  
        // si l'employé existe dans la table departement
        if(dept != null){           
            dept.employes.remove(em);           
        }
       
        this.employes.add(em);
        em.setDepartement(dept);
    }
    
//    public void addEmploye(Employe emplo){
//    
//       try{
//           emf = Persistence.createEntityManagerFactory("ExempleJPAPU");
//           em = emf.createEntityManager();
//           et = em.getTransaction();
//           
//           Departement dpt = emplo.getDepartement();
//           
//           if(dpt != null){
//            dpt.getEmployes().remove(emplo);
//           }
//           
//           this.employes.add(emplo);
//           emplo.setDepartement(dpt);
//       
//       }catch (Exception e){
//      
//         throw e;
//       }finally{
//       if(em != null) em.close();
//      if(emf != null) emf.close();
//       }
//    }
//    
    
}
