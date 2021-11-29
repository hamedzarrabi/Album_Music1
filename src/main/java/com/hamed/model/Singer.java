package com.hamed.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "singers")
public class Singer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "firstname", length = 25)
	private String firstName;
	
	@Column(name = "lastname", length = 25)
	private String lastName;
	
	@Column(name = "nickname", length = 15, unique = true)
	private String nickName;

    @ManyToOne
    private Genre genre;


	@ManyToMany()
	@JoinTable(name = "singer_album")
	private List<Album> album;

}
