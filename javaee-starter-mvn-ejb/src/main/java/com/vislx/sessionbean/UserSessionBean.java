package com.vislx.sessionbean;

import com.vislx.javaee.starter.mvn.classlib.local_interface.UserSessionBeanLocal;
import com.vislx.javaee.starter.mvn.classlib.entity.UserEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author victor
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {
    
    @PersistenceContext(unitName="com.vislx_javaee-starter-mvn-ejbPU")
    EntityManager em;

    public UserEntity getRandomUser(){
        UserEntity u = new UserEntity();
        u.setUsername("randomusername");
        u.setEmail("random@random.com");
        em.persist(u);
        return u;
    }
    
    @Override
    public UserEntity getUserByUsername(String username) throws Exception{
        List<UserEntity> rl =  (List<UserEntity>) em.createNamedQuery("UserEntity.findByUsername")
                .setParameter("username", username)
                .setMaxResults(1)
                .getResultList();
        try{
            return rl.get(0);
        } catch(ArrayIndexOutOfBoundsException ex){
            return null;
        }
    }
    
    @Override
    public List<UserEntity> getAllUser() throws Exception{
        List<UserEntity> result;
        result = em.createNamedQuery("UserEntity.findAll").getResultList();
        return result;
    }
    
    @Override
    public UserEntity createUser(String username, String email) throws Exception{
        UserEntity u = new UserEntity();
        u.setUsername(username);
        u.setEmail(email);
        em.persist(u);
        em.flush();
        
        return u;
    }
    
    @Override
    public void deleteUserByUsername(String username) throws Exception{
        UserEntity u = getUserByUsername(username);
        em.remove(u);
        em.flush();
    }
}
