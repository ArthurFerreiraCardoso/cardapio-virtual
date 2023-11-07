package com.example.cardapio.controller;

import com.example.cardapio.DTO.FoodRequestDTO;
import com.example.cardapio.DTO.FoodResponseDTO;
import com.example.cardapio.service.FoodService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/food", produces = {"application/json"})
@Tag(name = "food")
public class FoodController {

    @Autowired
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }


    @Operation(summary = "Busca da lista de alimentos do cardápio ", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/list")
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> list = foodService.getAll();
        return list;
    }

    @Operation(summary = "Realiza o cadastro de alimentos", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Upload de arquivo realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
    })
    @PostMapping(value = "/register" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FoodRequestDTO> registerFood(@RequestBody FoodRequestDTO food) {
        foodService.registerFood(food);
        return ResponseEntity.ok(food);
    }
}
