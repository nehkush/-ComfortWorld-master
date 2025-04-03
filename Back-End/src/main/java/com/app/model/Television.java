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
@Table(name = "televisions")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String type; // LED, LCD, Plasma, etc.

    @Column
    private double screenSize; // In inches

    @Column
    private String isSmartTV;

    // Additional fields for TV repair service
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

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public String getIsSmartTV() {
		return isSmartTV;
	}

	public void setIsSmartTV(String isSmartTV) {
		this.isSmartTV = isSmartTV;
	}

	public String getIsUnderWarranty() {
		return isUnderWarranty;
	}

	public void setIsUnderWarranty(String isUnderWarranty) {
		this.isUnderWarranty = isUnderWarranty;
	}

    
}
