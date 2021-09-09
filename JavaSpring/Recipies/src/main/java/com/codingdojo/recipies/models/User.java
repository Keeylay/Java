package com.codingdojo.recipies.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")	
public class User {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotEmpty(message="First name is required!")
	    @Size(min=3, max=30, message="First name must be between 3 and 30 characters")
	    private String firstName;
	    
	    @NotEmpty(message="Last name is required!")
	    @Size(min=3, max=30, message="Last name must be between 3 and 30 characters")
	    private String lastName;
	    
	    @NotEmpty(message="Email is required!")
	    @Email(message="Please enter a valid email!")
	    private String email;
	    
	    @NotEmpty(message="Location is required!")
	    @Size(min=2, max=50, message="Last name must be between 2 and 50 characters")
	    private String location;
	    
	    @NotEmpty(message="Password is required!")
	    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	    private String password;
	    
	    @Transient
	    @NotEmpty(message="Confirm Password is required!")
	    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	    private String confirm;
	    
	    @Column(updatable = false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date createdAt;
		
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date updatedAt;
		
		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
		
		//One to many
		@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
		private List<Recipe> recipes;
		
		// Many to Many
		@ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	            name = "users_liked_recipes", 
	            joinColumns = @JoinColumn(name = "user_id"), 
	            inverseJoinColumns = @JoinColumn(name = "recipe_id")
	        )
		private List<Recipe> recipesLiked;
	  
	    // empty constructor
	    public User() {
	    	
	    }
	    
	    //loaded constructor
	    public User(String firstName, String lastName, String email, String location, String password, 
	    		List<Recipe> recipes, List<Recipe> recipesLiked) {
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    	this.email = email;
	    	this.location = location;
	    	this.password = password;
	    	this.recipes = recipes;
			this.recipesLiked = recipesLiked;
	    }

	    // Getters and Setters
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirm() {
			return confirm;
		}

		public void setConfirm(String confirm) {
			this.confirm = confirm;
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

		public List<Recipe> getRecipie() {
			return recipes;
		}

		public void setRecipie(List<Recipe> recipie) {
			this.recipes = recipie;
		}

		public List<Recipe> getRecipes() {
			return recipes;
		}

		public void setRecipes(List<Recipe> recipes) {
			this.recipes = recipes;
		}

		public List<Recipe> getRecipesLiked() {
			return recipesLiked;
		}

		public void setRecipesLiked(List<Recipe> recipesLiked) {
			this.recipesLiked = recipesLiked;
		}
		

	   
		
}
