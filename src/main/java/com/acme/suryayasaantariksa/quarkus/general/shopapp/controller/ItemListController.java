package com.acme.suryayasaantariksa.quarkus.general.shopapp.controller;

import java.util.List;

import com.acme.suryayasaantariksa.quarkus.general.shopapp.core.util.CommonStatic;
import com.acme.suryayasaantariksa.quarkus.general.shopapp.entity.ItemListEntity;
import com.acme.suryayasaantariksa.quarkus.general.shopapp.model.ItemListBody;
import com.acme.suryayasaantariksa.quarkus.general.shopapp.service.ItemListHandler;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(CommonStatic.V1 + "/item-list")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemListController {
    
    @Inject
    ItemListHandler itemListHandler;

    @GET
    @Path("/get/{id}")
    public ItemListEntity getItemListEntityById(Long id){
        return itemListHandler.getItemListEntityById(id);
    }

    @GET
    @Path("/get-all")
    public List<ItemListEntity> getAllItemListEntity(){
        return itemListHandler.getAllItemListEntity();
    }

    @POST
    @Path("/create")
    @Transactional
    public ItemListEntity createItemListEntity(ItemListBody body){
        return itemListHandler.createItemListEntity(body);
    }

    @PUT
    @Path("/update")
    @Transactional
    public ItemListEntity updateItemListEntity(ItemListEntity entity){
        return itemListHandler.updateItemListEntity(entity);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteItemListEntityById(Long id){
        return itemListHandler.deleteItemListEntityById(id);
    }
}
