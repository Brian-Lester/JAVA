package com.brianLester.exam2.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="houses")
public class House {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	    @NotEmpty(message="Address is required!")
	    @Size(min=3, max=100, message="Address must be between 3 and 100 characters")
	    private String address;
	    
	    
	    @NotNull
	    @Min(value =1)
	    private int price;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User user;
	    
	    @OneToMany(mappedBy="house", fetch = FetchType.LAZY, cascade =CascadeType.ALL )
	    private List<Messages> messages;
	    
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date listingDate;
	    
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    
	    public House () {}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}



		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public List<Messages> getMessages() {
			return messages;
		}

		public void setMessages(List<Messages> messages) {
			this.messages = messages;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		
		
		public Date getListingDate() {
			return listingDate;
		}

		public void setListingDate(Date listingDate) {
			this.listingDate = listingDate;
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
