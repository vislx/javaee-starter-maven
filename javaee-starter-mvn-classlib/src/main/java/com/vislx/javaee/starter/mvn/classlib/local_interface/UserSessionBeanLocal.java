package com.vislx.javaee.starter.mvn.classlib.local_interface;


import com.vislx.javaee.starter.mvn.classlib.entity.UserEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victor
 */
@Local
public interface UserSessionBeanLocal {

    public UserEntity getUserByUsername(String username) throws Exception;

    public List<UserEntity> getAllUser() throws Exception;

    public UserEntity createUser(String username, String email) throws Exception;

    public void deleteUserByUsername(String username) throws Exception;
    
}
