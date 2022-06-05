package br.com.technews.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public News save(@RequestBody News news) {
    news.setCreatedAt(new Date());
    return newsRepository.save(news);
  }

  @GetMapping("/{id}")
  public News findById(@PathVariable Long id) {
    return newsRepository.findById(id).get();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    newsRepository.deleteById(id);
  }

  @PutMapping("/{id}")
  public News update(@PathVariable Long id, @RequestBody News news) {
    News newsOld = newsRepository.findById(id).get();
    newsOld.setTitle(news.getTitle());
    newsOld.setImage(news.getImage());
    newsOld.setContent(news.getContent());
    newsOld.setCreatedAt(news.getCreatedAt());
    return newsRepository.save(newsOld);
  }
}
