package sberSchool.homework1819.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipes", schema = "public", catalog = "postgres")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ManyToMany
    private List<Product> products;

}
