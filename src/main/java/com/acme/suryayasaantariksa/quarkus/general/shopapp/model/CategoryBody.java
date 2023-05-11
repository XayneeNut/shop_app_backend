package com.acme.suryayasaantariksa.quarkus.general.shopapp.model;

import com.acme.suryayasaantariksa.quarkus.general.shopapp.entity.CategoryEntity;

public record CategoryBody(
    Long id,
    String name,
    String color
) {
    public CategoryEntity mapCategoryEntity(){
        var categoryEntity = new CategoryEntity();
        categoryEntity.name = name;
        categoryEntity.color = color;
        return categoryEntity;
    }
}
