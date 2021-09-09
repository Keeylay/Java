package com.codingdojo.greatideas.models;

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
@Table(name="greatIdeas")
public class GreatIdea {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="Idea is required!")
    @Size(min=3, max=100, message="Idea must be between 1 and 100 characters")
    private String idea;
	
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
            name = "users_liked_greatIdeas", 
            joinColumns = @JoinColumn(name = "greatIdea_id"), 
            inverseJoinColumns = @JoinColumn(name = "user_id")
        )
	private List<User> usersLiked;
	
	public GreatIdea() {
		
	}
	
	public GreatIdea(String idea, String description, User user,
			List<User> usersLiked) {
		this.idea = idea;
		this.usersLiked = usersLiked;
	}
	
	 // Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
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
