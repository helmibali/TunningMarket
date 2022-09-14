package com.helmi.TunningMarket.controllers;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helmi.TunningMarket.entities.Brand;
import com.helmi.TunningMarket.requests.BarandRequest;
import com.helmi.TunningMarket.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BrandController {
    @Autowired
    BrandService brandService;

    @PostMapping("/brand")
    public Brand save(@RequestParam("file") MultipartFile file, @RequestParam("brand") String brand)
            throws JsonParseException, JsonMappingException, Exception
    {
        BarandRequest b = new ObjectMapper().readValue(brand, BarandRequest.class);
        return brandService.save(b,file);
    }



    /*
      @PostMapping("/articleWithImg")
    public Article createArticleWithImg (@RequestParam("file") MultipartFile file, @RequestParam("article") String article)
            throws JsonParseException, JsonMappingException, Exception
    {
        ArticleRequest a = new ObjectMapper().readValue(article, ArticleRequest.class);
        boolean isExit = new File(context.getRealPath("/ImagesArticle/")).exists();
        if (!isExit) { new File (context.getRealPath("/ImagesArticle/")).mkdir();}
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/ImagesArticle/"+File.separator+newFileName));
        try {FileUtils.writeByteArrayToFile(serverFile,file.getBytes());}
        catch(Exception e) {e.printStackTrace();}
        a.setFilename(newFileName);
        return articleService.saveArticleWithImg(a);
    }
     */
}
