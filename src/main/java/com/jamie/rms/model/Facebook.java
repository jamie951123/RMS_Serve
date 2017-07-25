package com.jamie.rms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author jamie
 *
 */
@Entity(name = "Facebook")
@Table(name= "Facebook")
public class Facebook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",nullable = false, updatable=false)
	private Long id;
	
	@Column(name = "userProfileId",unique = true)
	private Long userProfileId;
	
	@Column(name = "facebookId",unique = true)
	private String facebookId;
	
	@Column(name = "lastModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	
	//FB Profile
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "gender")
    private String gender;
	
	@Column(name = "birthday")
    private String birthday;
	
	@Column(name = "picture")
    private String picture;
	
	@Column(name = "age")
    private String age;
    
    
	@OneToOne(fetch = FetchType.LAZY,
			cascade= {CascadeType.REMOVE,CascadeType.REFRESH},
			optional = true, orphanRemoval = true
			)
	@JsonBackReference
	@JoinColumn(name = "userProfileId", referencedColumnName="userProfileId", insertable=false, updatable =false)
	private UserProfile userProfile;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public String toString() {
		return "Facebook [id=" + id + ", facebookId=" + facebookId + "]";
	}

	
	

	

	

	
	
	
	
}
