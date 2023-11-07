package com.example.cardapio.service;

import com.example.cardapio.DTO.FoodRequestDTO;
import com.example.cardapio.DTO.FoodResponseDTO;
import com.example.cardapio.entity.Food;
import com.example.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodService {

    @Autowired
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    //Início das lógicas
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();

        return foodList;
    }

    public FoodRequestDTO registerFood(FoodRequestDTO food) {
        if (Objects.isNull(food)) {
            throw new NullPointerException("O objeto nao pode ser nulo.");
        } else {
            Food foodData = new Food(food);
            foodRepository.save(foodData);
            return foodData.toDto(foodData);
        }
    }
}
