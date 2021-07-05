package com.enviyo.staj.demo.food;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public void saveFood(FoodDto foodDto) {

        final Food food = FoodMapper.FOOD_MAPPER.convertToFood(foodDto);

        foodRepository.save(food);

    }

    public Optional<Food> findFood(Long foodId) {

        return foodRepository.findById(foodId);
    }

    public Collection<Food> findAll() {

        return foodRepository.findAll();
    }
}
