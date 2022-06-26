package sberSchool.homework1819.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products", schema = "public", catalog = "postgres")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column(name = "recipes_id")
    private Long recipesId;

    @ManyToMany
    @JoinColumn(name = "")
    private List<Recipe> recipes;
}
