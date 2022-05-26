package br.com.technews.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.technews.entity.News;
import br.com.technews.repository.NewsRepository;

@RestController
@RequestMapping("/")
public class NewsController {

  private NewsRepository newsRepository;

  public NewsController(NewsRepository newsRepository) {
    this.newsRepository = newsRepository;
  }

  @GetMapping
  public List<News> list() {
    return newsRepository.findAll();
  }

  @PostMapping
  public News save(News news) {
    return newsRepository.save(news);
  }

  @GetMapping("/{id}")
  public News findById(Long id) {
    return newsRepository.findById(id).get();
  }

  @DeleteMapping("/{id}")
  public void delete(Long id) {
    newsRepository.deleteById(id);
  }
}
