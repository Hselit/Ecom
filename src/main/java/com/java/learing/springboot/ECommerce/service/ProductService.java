package com.java.learing.springboot.ECommerce.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.learing.springboot.ECommerce.model.Product;
import com.java.learing.springboot.ECommerce.repo.ProductRepo;

@Service
public class ProductService {
    
    private ProductRepo repo;

    public ProductService(ProductRepo repo){
        this.repo = repo;
    }

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product,MultipartFile imagefile) throws IOException{
        product.setImageName(imagefile.getOriginalFilename());
        product.setImagetype(imagefile.getContentType());
        product.setImageData(imagefile.getBytes());
        return repo.save(product);
    }
    
    public Product updateProduct(int id,Product product,MultipartFile imagFile) throws IOException
    {
        product.setImageData(imagFile.getBytes());
        product.setImageName(imagFile.getOriginalFilename());
        product.setImagetype(imagFile.getContentType());
        return repo.save(product);
    }


    public void deleteProduct(int id){
        repo.deleteById(id);
    }

    public List<Product> searchProduct(String keyword){
        return repo.searchProduct(keyword);
    }
}


