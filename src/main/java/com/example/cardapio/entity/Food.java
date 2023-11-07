package com.example.cardapio.entity;

import com.example.cardapio.DTO.FoodRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "foods")
@Entity(name = "foods")
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Float price;
    @NotNull
    private String image;

public Food (FoodRequestDTO foodRequestDTO){
    this.image = foodRequestDTO.image();
    this.name = foodRequestDTO.name();
    this.price = foodRequestDTO.price();
}

public FoodRequestDTO toDto(Food food) {
   FoodRequestDTO foodRequestDTO = new FoodRequestDTO(this.getName(),
           this.getPrice(), this.getImage());
   return foodRequestDTO;
}
}
