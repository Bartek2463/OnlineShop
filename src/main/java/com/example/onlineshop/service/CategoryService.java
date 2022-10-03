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

    public Category findById(Long id){
       return videoAssettsRepository.findById(id).orElseThrow();

    }
    public List<Category> findAll(){
        return videoAssettsRepository.findAll();
    }
    public  Category save (CategoryDTO dto){
        Category newCategory = dto.toCategory(dto.getId(),findById(dto.getParentId()));
        return videoAssettsRepository.save(newCategory);
    }
    public void deleteCategory(Long id){
        videoAssettsRepository.deleteById(id);
    }
    public Category edit(Category category){
       return videoAssettsRepository.save(category);
    }

}




