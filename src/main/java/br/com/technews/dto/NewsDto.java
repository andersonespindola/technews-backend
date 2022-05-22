package br.com.technews.dto;

import br.com.technews.domain.News;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    
    private Long id;
    private String title;
    private String image;
    private String content;
    private Date createdAt;

    public NewsDto(News news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.image = news.getImage();
        this.content = news.getContent();
        this.createdAt = news.getCreatedAt();
    }

    public static List<NewsDto> converter(List<News> news){
        return news.stream().map(NewsDto::new).collect(Collectors.toList());
    }

}
