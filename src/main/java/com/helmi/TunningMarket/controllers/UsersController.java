package com.helmi.TunningMarket.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helmi.TunningMarket.entities.*;
import com.helmi.TunningMarket.repositories.RoleRepository;
import com.helmi.TunningMarket.repositories.UserRepository;
import com.helmi.TunningMarket.requests.UserRequest;
import com.helmi.TunningMarket.services.UserService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsersController {
    @Autowired
    UserRepository userRep;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private ServletContext context;
    @Autowired
    UserService userService;



    @RequestMapping(value ="/login/{username}",method = RequestMethod.GET)
    public User getUserByUsernamePassword(@PathVariable("username") String username) {
        return userService.userByUserName(username);
    }
    @GetMapping("/users/liste")
    public List<User> getAllUsers(){
        return userRep.findAll();

    }
    @PostMapping("/user/add")
    public User createArticle (@RequestParam("file") MultipartFile file,
                                  @RequestParam("user") String user) throws JsonParseException, JsonMappingException, Exception
    {
        System.out.println("Save User...");
        UserRequest u = new ObjectMapper().readValue(user, UserRequest.class);
        boolean isExit = new File(context.getRealPath("/ImagesUser/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/ImagesUser/")).mkdir();
            System.out.println("mk dir ImagesUser...");
        }
        System.out.println("Save User..2..");
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/ImagesUser/"+File.separator+newFileName));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Save User ..3..");
        u.setFilename(newFileName);
        return userService.saveUser(u);
    }


@PutMapping("/user/{id}")
public User updateUser(@RequestBody UserRequest u, @PathVariable Long id){
        return userService.updateUser(u,id);
}

@PutMapping("/userPw/{id}")
public User updatePwUser(@RequestParam("user") String user,
                         @PathVariable Long id)throws JsonParseException, JsonMappingException, Exception
{
    UserRequest u = new ObjectMapper().readValue(user, UserRequest.class);
    return userService.updatePassword(u,id);
}
@PutMapping("/userImg/{id}")
public User updateImageUser(@RequestParam("file") MultipartFile file,
                            @RequestParam("user") String user,
                            @PathVariable Long id)throws JsonParseException, JsonMappingException, Exception
{
    {
        System.out.println("Save User...");
        UserRequest u = new ObjectMapper().readValue(user, UserRequest.class);
        boolean isExit = new File(context.getRealPath("/ImagesUser/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/ImagesUser/")).mkdir();
            System.out.println("mk dir ImagesUser...");
        }
        System.out.println("Save User..2..");
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/ImagesUser/"+File.separator+newFileName));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Save User ..3..");
        u.setFilename(newFileName);
        return userService.updateImageUser(u,id);
    }
}


    @GetMapping(path="/ImgUser/{id}")
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        User User   = userRep.findById(id).get();
        return Files.readAllBytes(Paths.get(context.getRealPath("/ImagesUser/")+User.getFilename()));
    }
    @GetMapping(path="/ImgUser1/{username}")
    public byte[] getPhotoByUsername(@PathVariable("username") String username) throws Exception{
        User User   = userRep.findByUsername(username);
        return Files.readAllBytes(Paths.get(context.getRealPath("/ImagesUser/")+User.getFilename()));
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.userById(id);
    }



}
