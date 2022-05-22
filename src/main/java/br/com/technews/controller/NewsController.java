package br.com.technews.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.technews.domain.News;
import br.com.technews.dto.NewsDto;
import br.com.technews.service.NewsService;

@RestController
public class NewsController {

  private NewsService newsService;

  public NewsController(NewsService newsService) {
    this.newsService = newsService;
  }

  @GetMapping("/news")
  public List<NewsDto> getAll() {
    List<News> news = newsService.findAll();
    return NewsDto.converter(news);
  }
  
  @PostMapping("/news")
  public ResponseEntity<NewsDto> save(@RequestBody NewsDto newsDto, UriComponentsBuilder uriComponentsBuilder) {
    News news = new News();
    news.setTitle(newsDto.getTitle());
    news.setImage(newsDto.getImage());
    news.setContent(newsDto.getContent());
    news.setCreatedAt(new Date());

    URI uri = uriComponentsBuilder.path("/news/{id}").buildAndExpand(news.getId()).toUri();
    return ResponseEntity.created(uri).body(new NewsDto(news));
  }

  @Transactional
  @DeleteMapping("/news/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    newsService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/news/{id}")
  public ResponseEntity<NewsDto> getById(@PathVariable Long id) {
    Optional<News> news = newsService.findById(id);
    return news.map(NewsDto::new).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }
}
