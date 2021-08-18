package com.dojo.exam1.models;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;





@Entity
@Table(name="ideas")
public class Idea {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=1, message = "Cannot submit empty idea")
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_liked_ideas", 
        joinColumns = @JoinColumn(name = "idea_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> usersLiked;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
	
    
    public Idea() {
		super();
	}


	

	public Idea(Long id, @NotNull(message = "Cannot submit empty idea") String content, User user,
			List<User> usersLiked, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.content = content;
		this.user = user;
		this.usersLiked = usersLiked;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
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
    
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }



    
    
}