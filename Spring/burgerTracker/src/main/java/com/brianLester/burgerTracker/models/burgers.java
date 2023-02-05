package com.brianLester.burgerTracker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name= "burgers")
public class burgers {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
    @Size(min = 1, max = 45, message="Character count for Burger name must be between 1 & 45")
    private String burgerName;
    @NotNull
    @Size(min=1, max = 50, message="Character count for Resturant must be between 1 & 50")
    private String restName;
    @NotNull
    @Min(value=1, message="Please provide a rating between 1 & 5")
    @Max(value=5, message="Please provide a rating between 1 & 5" )
    private Integer rating;
    @NotNull
    @Size(min = 5, max =2500, message="min character count for notes is 5")
    private String notes;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public burgers() {
    	
    }
    public burgers(String burgerName, String restName, Integer rating, String notes) {
		this.burgerName = burgerName;
		this.restName = restName;
		this.rating = rating;
		this.notes = notes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBurgerName() {
		return burgerName;
	}
	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	public Date getUpdatedAt() {
		return updatedAt;
	}
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    

}


