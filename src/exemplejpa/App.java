/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplejpa;

import Model.Departement;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


/**
 *
 * @author judith
 */
public class App{
    
    
    public static void main(String[] args){
    
      EntityManagerFactory emf = null;
      EntityManager em =null;
      EntityTransaction et =null;
      
      try{
          // INIZIALISATION DU PROCESS
          emf = Persistence.createEntityManagerFactory("ExempleJPAPU");
          em = emf.createEntityManager();
          et = em.getTransaction();
          
          //  BEGIN ET COMMIT DE L'INSTRUCTION  
          et.begin();
          Departement dpt = new Departement();
           
          dpt.setNom("Region Paca");
          em.persist(dpt);
//          Departement dpt1  = new Departement("Rhones Alpes");                    
//          Departement dpt2  = new Departement("Bouches du Rhones");
//          Departement dpt3  = new Departement("Ile de France");

        
//           Departement dpt4 = em.find(Departement.class, dpt.getId());
//          
//          System.out.println(dpt4.toString());
//          
//          em.remove(dpt4);
//                       System.out.println(dpt4.toString());
//       
          em.persist(dpt);
//          em.persist(dpt1);
//          em.persist(dpt2);
//          em.persist(dpt3);

          
           TypedQuery<Departement> query =
      em.createQuery("SELECT dp FROM Departement dp", Departement.class);     
      List<Departement> results = query.getResultList();

      for(Departement d: results){
               System.out.println(d.getNom());
                                 }
          et.commit();
          
     }catch(Exception e){
         System.out.println(e);
         throw e;
     }finally{
      if(em != null) em.close();
      if(emf != null) emf.close();
      }
    
    }
    
}