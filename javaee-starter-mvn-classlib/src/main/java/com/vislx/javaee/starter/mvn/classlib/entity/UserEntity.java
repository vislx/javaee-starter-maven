package com.vislx.javaee.starter.mvn.classlib.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victor
 */

@Entity
@XmlRootElement // @XmlRootElement is for Jersey to serialize entity to JSON
@NamedQueries({
    @NamedQuery(name = "UserEntity.findAll",
            query = "SELECT x FROM UserEntity x"),
    @NamedQuery(name = "UserEntity.findByUsername",
            query = "SELECT x FROM UserEntity x WHERE x.username = :username")
})
public class UserEntity implements Serializable {
    
    /** 
     * ID: Use auto generated ID is a good practice.
     * Below is the default logic to auto generate ID.
     * Please be aware this id may not be from 1,2 ...
     * You may change GenerationType to use other strategy
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * All other parameters besides ID
     */
    private String username;
    private String email;
    
    // @Temporal tag is required for JDBC to decide what format of date to keep in db
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdAt;
    
    
    public UserEntity(){
        this.createdAt = new Date();
    }
    
    /**
     * Getters & Setters.
     */
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    /**
     * Override Methods.
     * Below are all override methods
     * It is a good practice to customize toString() method for easy debugging
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "entity.UserEntity[ id=" + id + " ]";
    }
    
}
