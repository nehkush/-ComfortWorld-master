package com.app.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String orderNumber;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Define the date-time format
    private LocalDateTime orderDateTime = LocalDateTime.now(); 
    
    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String state;

    @Column
    private String pincode;

    @Column
    private String city;

    @Column
    private String country = "India";  // Set default value to "India"

    @Column
    private String mobileNumber;

    @Column
    private String productCategory;

    @Column
    private String issueDescription;
    
    @Column
    private String payment;
    
    
    @JsonBackReference  //You need to use @JsonManagedReference and @JsonBackReference to
                             //allow Jackson to better handle the relationship.
    @ManyToOne
    @JoinColumn(name = "user_id") // This column will store the foreign key referencing the user
    private User user;
    
   
    public Order() {
        // Generate a random 4-digit order number
        this.orderNumber = String.format("%04d", (int) (Math.random() * 10000));
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}





	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}


	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public String getIssueDescription() {
		return issueDescription;
	}


	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}


	public String getPayment() {
		return payment;
	}


	public void setPayment(String payment) {
		this.payment = payment;
	}
    
    
}
