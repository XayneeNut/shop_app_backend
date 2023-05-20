package com.acme.suryayasaantariksa.quarkus.general.shopapp.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.acme.suryayasaantariksa.quarkus.general.shopapp.entity.CategoryEntity;
import com.acme.suryayasaantariksa.quarkus.general.shopapp.entity.ItemListEntity;
import com.acme.suryayasaantariksa.quarkus.general.shopapp.exception.response.MessageResponse;
import com.acme.suryayasaantariksa.quarkus.general.shopapp.model.ItemListBody;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ItemListHandler {

    public ItemListEntity getItemListEntityById(Long id) {
        return ItemListEntity.findItemListEntityById(id).orElseThrow(() -> MessageResponse.idNotFoundException(id));
    }

    public List<ItemListEntity> getAllItemListEntity() {
        return ItemListEntity.findAllItemListEntity().stream().collect(Collectors.toList());
    }

    public CategoryEntity fetchCategoryEntity(Long id) {
        return CategoryEntity.findCategoryEntityById(id)
                .orElseThrow(() -> MessageResponse.fetchMessageException(id, "category"));
    }

    private ItemListEntity checkingWithUpdate(ItemListEntity entity, CategoryEntity categoryEntity) {
        var itemList = getItemListEntityById(entity.itemListId);
        itemList.categoryEntity = categoryEntity;
        entity.updateItemListEntity(itemList);
        return itemList;
    }

    public ItemListEntity updateItemListEntity(ItemListEntity entity) {
        var category = fetchCategoryEntity(entity.categoryEntity.categoryId);
        return checkingWithUpdate(entity, category);
    }

    private ItemListEntity checkingWithCreate(ItemListBody body, CategoryEntity categoryEntity) {
        var itemList = body.mapItemListEntity();
        itemList.categoryEntity = categoryEntity;
        itemList.persist();
        return itemList;
    }

    public ItemListEntity createItemListEntity(ItemListBody body) {
        Objects.requireNonNull(body);
        var category = fetchCategoryEntity(body.categoryEntityId());
        return checkingWithCreate(body, category);
    }

    public Response deleteItemListEntityById(Long id){
        if(getItemListEntityById(id) != null){
            ItemListEntity.deleteById(id);
            return MessageResponse.deleteSucces(id);
        }else{
            return MessageResponse.idNotFound(id);
        }
    }
}
