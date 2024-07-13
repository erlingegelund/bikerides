package dk.eegelund.bikerides.core;

import dk.eegelund.bikerides.data.Category;
import dk.eegelund.bikerides.data.CategoryRepository;
import dk.eegelund.bikerides.exception.NotFoundException;
import dk.eegelund.bikerides.model.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDto createCategory(CategoryDto category) {
        final Category detached = categoryMapper.toEntity(category);
        return categoryMapper.toDto(categoryRepository.save(detached));
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDto> getCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).toList();
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto category) {
        final var existingCategory = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
        categoryMapper.updateEntity(category, existingCategory);
        return category;
    }
}
