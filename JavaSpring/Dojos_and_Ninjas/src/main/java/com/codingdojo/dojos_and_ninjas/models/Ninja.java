package com.codingdojo.dojos_and_ninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull(message="First name must be between 2-50 characters")
    @Size(min = 2, max = 50, message="Name must be between 2-50 characters")
    private String first_name;
	
	@NotNull(message="Last name must be between 2-50 characters")
    @Size(min = 2, max = 50, message="Name must be between 2-50 characters")
    private String last_name;
	
	@NotNull
    @Min(value = 0, message = "There is no way you are 0 grow up... ")
	@Max(value = 150, message="Must Be less than 150")
    private Integer age;

	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id") //key
    private Dojo dojo; //State = referencing State object, state = variable -> mappedBy in State.java
    
    public Ninja() {	
    }
    
    public Ninja(String first_name, String last_name, Integer age) {
    	this.first_name = first_name;
    	this.last_name = last_name;
    	this.age = age;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
    
    
}
