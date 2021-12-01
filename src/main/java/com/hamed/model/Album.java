package com.hamed.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "albums")
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "is required")
	@Column(name = "name", length = 25)
	private String name;

	@NotNull(message = "is required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datePublish;

	@NotNull(message = "is required")
	@Column(name = "price")
	private Double price;

	@NotNull(message = "is required")
	@ManyToOne
	private Genre genre;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
	private List<Order> order;

	@ManyToMany()
	@JoinTable(name = "singer_album")
	private List<Singer> singer;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
	private List<Votes> votes;

	@NotNull(message = "is required")
	private String music_album;
	private Long size;
}
