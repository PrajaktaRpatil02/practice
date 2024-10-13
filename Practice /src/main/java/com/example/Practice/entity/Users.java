package com.example.Practice.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Address> addressList;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	@Column(name="emailId")
	private String emailId;
	
	@Column(name = "created_at")
	@CreationTimestamp
    private LocalDateTime craetedAt;
    
	@Column(name="updated_at")
	@UpdateTimestamp
    private LocalDateTime updatedAt;

	public Users() {
		super();
	
	}

	public Users(Long id, String userName, String password, String emailId, LocalDateTime craetedAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.craetedAt = craetedAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDateTime getCraetedAt() {
		return craetedAt;
	}

	public void setCraetedAt(LocalDateTime craetedAt) {
		this.craetedAt = craetedAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", addressList=" + addressList + ", userName=" + userName + ", password=" + password
				+ ", emailId=" + emailId + ", craetedAt=" + craetedAt + ", updatedAt=" + updatedAt + "]";
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	
	
	
	
	

}
