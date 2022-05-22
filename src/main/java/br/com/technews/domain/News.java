package br.com.technews.domain;

import lombok.*;

import java.util.Date;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private String content;
    private Date createdAt;
    
}
