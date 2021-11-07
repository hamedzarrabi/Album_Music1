package com.hamed.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "genre")
    private String genre;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<Album> albums;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<Singer> singers;
}
