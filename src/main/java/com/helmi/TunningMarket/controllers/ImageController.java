package com.helmi.TunningMarket.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helmi.TunningMarket.entities.Image;
import com.helmi.TunningMarket.entities.Marque;
import com.helmi.TunningMarket.repositories.ImageRepository;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    ServletContext context;

    @PostMapping("addImage")
    public Image createImage(@RequestParam("file") MultipartFile file,
                             @RequestParam("image") String image) throws JsonParseException, JsonMappingException, Exception
    {
        Image i = new ObjectMapper().readValue(image, Image.class);
        boolean isExit = new File(context.getRealPath("/ImagesG/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/Images/")).mkdir();
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+ FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        i.setFilename(newFileName);
        return imageRepository.save(i);
    }
}
