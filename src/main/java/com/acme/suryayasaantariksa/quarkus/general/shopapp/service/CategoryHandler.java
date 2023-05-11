package com.acme.suryayasaantariksa.quarkus.general.shopapp.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.acme.suryayasaantariksa.quarkus.general.shopapp.entity.CategoryEntity;
import com.acme.suryayasaantariksa.quarkus.general.shopapp.exception.response.MessageResponse;
import com.acme.suryayasaantariksa.quarkus.general.shopapp.model.CategoryBody;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class CategoryHandler {

    public CategoryEntity getCategoryEntityById(Long id) {
        return CategoryEntity.findCategoryEntityById(id).orElseThrow(() -> MessageResponse.idNotFoundException(id));
    }

    public List<CategoryEntity> getAllCategoryEntity() {
        return CategoryEntity.findAllCategoryEntity().stream().collect(Collectors.toList());
    }

    public CategoryEntity updateCategoryEntity(CategoryEntity entity) {
        var validatingId = getCategoryEntityById(entity.id);
        entity.updateCategoryEntity(validatingId);
        return validatingId;
    }

    public CategoryEntity createCategoryEntity(CategoryBody body) {
        Objects.requireNonNull(body);
        var category = body.mapCategoryEntity();
        category.persist();
        return category;
    }

    public Response deleteCategoryEntity(Long id) {
        if (getCategoryEntityById(id) != null) {
            CategoryEntity.deleteById(id);
            return MessageResponse.deleteSucces(id);
        } else {
            return MessageResponse.idNotFound(id);
        }
    }
}
