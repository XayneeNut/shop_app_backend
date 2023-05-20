package com.acme.suryayasaantariksa.quarkus.general.shopapp.model;

import com.acme.suryayasaantariksa.quarkus.general.shopapp.entity.ItemListEntity;

public record ItemListBody(
        Long itemListId,
        String name,
        Integer quantity,
        Long categoryEntityId) {

    public ItemListEntity mapItemListEntity() {
        var itemListEntity = new ItemListEntity();
        itemListEntity.name = name;
        itemListEntity.quantity = quantity;
        return itemListEntity;
    }

}
