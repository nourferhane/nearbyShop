package com.mshops.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "shop" )
public class Shop {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String description;

    private String image;

    private Double location;


    public Shop() {
    }

    public Shop(int id, String name, String description, String image, Double location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    @Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image
				+ ", location=" + location + "]";
	}

	public Double getLocation() {
		return location;
	}

	public void setLocation(Double location) {
		this.location = location;
	}

	public void setImage(String image) {
        this.image = image;
    }

  


}
