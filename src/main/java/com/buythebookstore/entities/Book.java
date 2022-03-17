package com.buythebookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "orderDetail"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Book name cannot be empty.")
    @Size(min = 3, max = 50, message = "Book name length should be between 3 and 50.")
    @Column(name = "bookName", nullable = false)
    private String bookName;

    @NotBlank(message = "Book number cannot be empty.")
    @Column(name = "bookNumber", nullable = false)
    private String bookNumber;

    @NotBlank(message = "Book price cannot be empty.")
    @Column(name = "bookPrice", nullable = false)
    private String bookPrice;

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private List<OrderDetail> orderDetail;

    @ManyToOne
    @JoinColumn(name = "kind_id")
    private Kind kind;
}
