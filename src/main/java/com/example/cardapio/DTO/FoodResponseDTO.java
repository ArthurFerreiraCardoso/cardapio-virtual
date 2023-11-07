package com.example.cardapio.DTO;

import com.example.cardapio.entity.Food;

public record FoodResponseDTO(Long id, String name, Float price, String image) {

    public FoodResponseDTO(Food food) {
        this(food.getId(), food.getName(), food.getPrice(), food.getImage());


    }
}
