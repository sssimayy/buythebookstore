package com.buythebookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "kinds")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "books"})
public class Kind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "kind")
    private String kind;

    @OneToMany(mappedBy = "kind", cascade = CascadeType.REMOVE)
    private List<Book> books;
}

