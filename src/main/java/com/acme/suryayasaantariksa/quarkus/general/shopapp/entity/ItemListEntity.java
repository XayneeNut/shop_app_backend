package com.acme.suryayasaantariksa.quarkus.general.shopapp.entity;

import java.util.List;
import java.util.Optional;

import com.acme.suryayasaantariksa.quarkus.general.shopapp.core.util.ManipulateUtil;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_list")
public class ItemListEntity extends PanacheEntityBase{
    
    @Id
    @GeneratedValue(generator = "gusanta_id_gen")
    @Column(name = "item_list_id")
    public Long itemListId;

    @Column(name = "name")
    public String name;

    @Column(name = "quantity")
    public Integer quantity;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    public CategoryEntity categoryEntity;

    public static Optional<ItemListEntity> findItemListEntityById(Long id){
        return find("id = ? 1", id).firstResultOptional();
    }

    public static List<ItemListEntity> findAllItemListEntity(){
        return ItemListEntity.listAll();
    }

    public ItemListEntity updateItemListEntity(ItemListEntity itemListEntity){
        itemListEntity.name = ManipulateUtil.changeItOrNot(name,  itemListEntity.name);
        itemListEntity.quantity = ManipulateUtil.changeItOrNot(quantity, itemListEntity.quantity);
        return itemListEntity;
    }
}
