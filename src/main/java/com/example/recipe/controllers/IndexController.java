package com.example.recipe.controllers;

import com.example.recipe.domain.Category;
import com.example.recipe.domain.UnitOfMeasure;
import com.example.recipe.repositories.CategoryRepository;
import com.example.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

/**
 * Created by haripri on 6/8/18.
 */
@Controller
public class IndexController {

  private CategoryRepository categoryRepository;
  private UnitOfMeasureRepository unitOfMeasureRepository;

  public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
    this.categoryRepository = categoryRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }

  @RequestMapping({"", "/", "/index"})
  public String getIndexPage() {
    Optional<Category> category = categoryRepository.findByDescription("American");
    Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");
    System.out.println("ca id is"+ category.get().getId());
    System.out.println("uom id is"+ unitOfMeasure.get().getId());
    return "index";
  }
}
