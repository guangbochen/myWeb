package com.guangbo.web.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@NamedQueries({
    @NamedQuery(name = "user.findAll", query = "Select u From User u Order By u.id ASC"),
})
@SuppressWarnings("serial")
@Entity
public class User implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column
   private Long id = null;

   @Column
   @NotEmpty
   @NotNull
   private String name;

   @Column
   @NotEmpty
   @NotNull
   private String password;

   @Column
   @NotEmpty
   @NotNull
   @Email
   private String email;
   
   @Column
   @NotEmpty
   @NotNull
   private String DOB;

   @IndexedEmbedded
   private Address address = new Address();


   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public String getName()
   {
      return this.name;
   }

   public void setName(final String name)
   {
      this.name = name;
   }

   public String getPassword()
   {
      return this.password;
   }

   public void setPassword(final String password)
   {
      this.password = password;
   }

   public String getDOB()
   {
      return this.DOB;
   }

   public void setDOB(final String DOB)
   {
      this.DOB = DOB;
   }

   /**
    * @return the address
    */
   public Address getAddress()
   {
      return address;
   }

   /**
    * @param address the address to set
    */
   public void setAddress(Address address)
   {
      this.address = address;
   }

   public String getEmail()
   {
      return this.email;
   }

   public void setEmail(final String email)
   {
      this.email = email;
   }

}