package com.helmi.TunningMarket.services;

import com.helmi.TunningMarket.entities.Brand;
import com.helmi.TunningMarket.repositories.BrandRepository;
import com.helmi.TunningMarket.requests.BarandRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class BrandService {
    @Autowired
    BrandRepository brandRepository;

    public Brand save(BarandRequest barandRequest, MultipartFile file){
        Brand b = new Brand();
        b.setName(barandRequest.getName());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            b.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return brandRepository.save(b);

    }

     /*
    public void  saveProductToDB(MultipartFile file,String name,String description
            ,int price)
    {
        Product p = new Product();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.setDescription(description);

        p.setName(name);
        p.setPrice(price);

        productRepo.save(p);
    }

     */
}
