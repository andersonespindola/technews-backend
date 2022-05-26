package br.com.technews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.technews.entity.News;


@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}