package br.com.technews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.technews.domain.News;
import br.com.technews.repository.NewsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

  private final NewsRepository newsRepository;

  @Autowired
  public NewsService(NewsRepository newsRepository) {
    this.newsRepository = newsRepository;
  }

  public List<News> findAll() {
    List<News> news = newsRepository.findAll();
    return news;
  }

  public Optional<News> findById(Long id) {
    return newsRepository.findById(id);
  }
  
  public News save(News news) {
    return newsRepository.save(news);
  }

  public void delete(Long id) {
    newsRepository.deleteById(id);
  }
}
