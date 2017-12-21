/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Departement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author judith
 * 
 * Cette classe me permettrait d'enregistrer les données
 * de département
 */
public class DepartementDAO {
    
    EntityManager em;

    public DepartementDAO(EntityManager em) {     
        this.em = em;
                                           }  
    
    public Departement persit( Departement dept){
      
        dept.getEmployes().forEach(emplo -> {
            em.persist(emplo);
                                            });         
            em.persist(dept);
    return dept;
    }
    
    public Departement findById(int id){
         
    return em.find(Departement.class, id);
                                      }
     
    public void remove(Departement dept){
     
         dept.getEmployes().forEach(emplo -> {
                             em.remove(emplo);
                                 });
         
           em.remove(dept);
                                             }
     
    public List<Departement> findByAll(){
           
         Query query = em.createQuery("SELECT dpt FROM Departement as dpt");
            List<Departement> departements = query.getResultList();
         
                     return departements;
                                      }
                                       
}
