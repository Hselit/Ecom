package com.java.learing.springboot.ECommerce.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String desc;
    private String brand;
    private BigDecimal price;
    private String category;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private Date releaseDate;
    private int quantity;

    private String imageName;
    private String imagetype;
    @Lob
    private byte[] imageData;
    
}
