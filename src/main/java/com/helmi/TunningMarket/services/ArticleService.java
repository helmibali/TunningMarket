package com.helmi.TunningMarket.services;

import com.helmi.TunningMarket.entities.*;
import com.helmi.TunningMarket.repositories.ArticleRepository;
import com.helmi.TunningMarket.repositories.CommentRepository;
import com.helmi.TunningMarket.repositories.UserRepository;
import com.helmi.TunningMarket.requests.ArticleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;

    public void delete(Article article){articleRepository.delete(article);}

    public void deleteById(Long id){articleRepository.deleteById(id);}

    public Article getArticleById(Long id){return articleRepository.findById(id).get();}

    public List<Article> getAllArticles(){return articleRepository.findAll();}

    public Article saveArticle(ArticleRequest articleRequest){
        User user = userRepository.findByUsername(articleRequest.getUser());
        Article article = new Article();
        article.setTitle(articleRequest.getTitle());
        article.setDateCreation(articleRequest.getDateCreation());
        article.setFilename(articleRequest.getFilename());
        article.setText(articleRequest.getText());
        article.setUser(user);
        return articleRepository.save(article);}

    public Article updateArticle(ArticleRequest articleRequest, Long id){
        User user = userRepository.findByUsername(articleRequest.getUser());
        Article article = articleRepository.findById(id).get();
        article.setTitle(articleRequest.getTitle());
        article.setDateCreation(articleRequest.getDateCreation());
        article.setFilename(articleRequest.getFilename());
        article.setText(articleRequest.getText());
        article.setUser(user);
        return articleRepository.save(article);}

}
