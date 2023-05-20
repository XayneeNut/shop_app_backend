package com.acme.suryayasaantariksa.quarkus.general.shopapp.entity;

import java.util.Optional;

import com.acme.suryayasaantariksa.quarkus.general.shopapp.core.util.ManipulateUtil;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "category")
public class CategoryEntity extends PanacheEntityBase{
    
    @Id
    @GeneratedValue(generator = "gusanta_id_gen")
    @Column(name = "category_id")
    public Long categoryId;

    @Column(name = "name")
    public String name;

    @Column(name = "color")
    public String color;

    public static Optional<CategoryEntity> findCategoryEntityById(Long id){
        return find("id = ? 1", id).firstResultOptional();
    }

    public static List<CategoryEntity> findAllCategoryEntity(){
        return CategoryEntity.listAll();
    }

    public CategoryEntity updateCategoryEntity(CategoryEntity categoryEntity){
        categoryEntity.name = ManipulateUtil.changeItOrNot(name, categoryEntity.name);
        categoryEntity.color = ManipulateUtil.changeItOrNot(color, categoryEntity.color);
        return categoryEntity;
    }
}
