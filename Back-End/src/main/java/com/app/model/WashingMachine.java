package com.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "washing_machines")
public class WashingMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String type; // Front Load, Top Load, etc.

    @Column
    private double capacity; // In kilograms

    @Column
    private String hasDryer;

    @Column
    private String price;

    // Additional fields for washing machine repair service
    @Column
    private String isUnderWarranty;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public String getHasDryer() {
		return hasDryer;
	}

	public void setHasDryer(String hasDryer) {
		this.hasDryer = hasDryer;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getIsUnderWarranty() {
		return isUnderWarranty;
	}

	public void setIsUnderWarranty(String isUnderWarranty) {
		this.isUnderWarranty = isUnderWarranty;
	}

    
   }
