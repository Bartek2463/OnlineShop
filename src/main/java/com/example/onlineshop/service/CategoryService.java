package com.example.onlineshop.service;

import com.example.onlineshop.dto.CategoryDTO;
import com.example.onlineshop.model.Category;
import com.example.onlineshop.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository videoAssettsRepository;

    public Optional<Category> findById(Long id){
        return videoAssettsRepository.findById(id);

    }
    public Iterable<Category> findAll(){
        return videoAssettsRepository.findAll();
    }
    public  Category save (CategoryDTO dto){
        Category newCategory = dto.toCategory(dto.getId(),findById(dto.getParentId()).orElse(null));
        return videoAssettsRepository.save(newCategory);
    }

}




