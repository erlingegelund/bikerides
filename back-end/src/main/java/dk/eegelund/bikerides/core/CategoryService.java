package dk.eegelund.bikerides.core;


import dk.eegelund.bikerides.model.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto category);
    void deleteCategory(Long id);
    List<CategoryDto> getCategories();
    CategoryDto updateCategory(Long id, CategoryDto category);
}
