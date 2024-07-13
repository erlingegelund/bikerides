package dk.eegelund.bikerides.rest;

import dk.eegelund.bikerides.api.CategoriesApi;
import dk.eegelund.bikerides.core.CategoryService;
import dk.eegelund.bikerides.model.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class CategoriesController implements CategoriesApi {
    private final NativeWebRequest request;
    private final CategoryService categoryService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
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
