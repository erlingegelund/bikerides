package dk.eegelund.bikerides.rest;

import dk.eegelund.bikerides.api.CategoriesApi;
import dk.eegelund.bikerides.core.CategoryService;
import dk.eegelund.bikerides.model.CategoryDto;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;

@RestController
public class CategoriesController extends ApiController implements CategoriesApi {
    private final CategoryService categoryService;

    public CategoriesController(NativeWebRequest request, CategoryService categoryService) {
        super(request);
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto createCategory(CategoryDto category) {
        return categoryService.createCategory(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryService.deleteCategory(id);
    }

    @Override
    public List<CategoryDto> getCategories() {
        return categoryService.getCategories();
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto category) {
        return categoryService.updateCategory(id, category);
    }
}
