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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="recipes")
public class Recipe {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="Menu item is required!")
    @Size(min=3, max=30, message="Menu item must be between 3 and 30 characters")
    private String menuItem;
	
	@NotEmpty(message="Description is required!")
    @Size(min=3, max=30, message="Description must be between 3 and 30 characters")
    private String description;
	
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id") // Foreign Key
	public User user;
	
	// Many to Many
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_liked_recipes", 
            joinColumns = @JoinColumn(name = "recipe_id"), 
            inverseJoinColumns = @JoinColumn(name = "user_id")
        )
	private List<User> usersLiked;
	
	public Recipe() {
		
	}
	
	public Recipe(String menuItem, String description, User user,
			List<User> usersLiked) {
		this.menuItem = menuItem;
		this.description = description;
		this.usersLiked = usersLiked;
	}
	
	 // Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsersLiked() {
		return usersLiked;
	}

	public void setUsersLiked(List<User> usersLiked) {
		this.usersLiked = usersLiked;
	}
	
	

	
}
