package com.app.model;

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
@Table(name = "laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String processor;

    @Column
    private int ramSize; // In gigabytes

    @Column
    private double storageSize; // In gigabytes

    @Column
    private String hasSSD;

    @Column
    private double screenSize; // In inches

    @Column
    private double price;

    // Additional fields for laptop repair service
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

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public int getRamSize() {
		return ramSize;
	}

	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}

	public double getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(double storageSize) {
		this.storageSize = storageSize;
	}

	public String getHasSSD() {
		return hasSSD;
	}

	public void setHasSSD(String hasSSD) {
		this.hasSSD = hasSSD;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsUnderWarranty() {
		return isUnderWarranty;
	}

	public void setIsUnderWarranty(String isUnderWarranty) {
		this.isUnderWarranty = isUnderWarranty;
	}

    
}
