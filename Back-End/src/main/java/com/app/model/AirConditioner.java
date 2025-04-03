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
@Table(name = "air_conditioners")
public class AirConditioner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String type; // Split, Window, Central, etc.

    @Column
    private int capacity; // In BTU (British Thermal Units)

    @Column
    private String hasRemoteControl;

    @Column
    private double price;

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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getHasRemoteControl() {
		return hasRemoteControl;
	}

	public void setHasRemoteControl(String hasRemoteControl) {
		this.hasRemoteControl = hasRemoteControl;
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
