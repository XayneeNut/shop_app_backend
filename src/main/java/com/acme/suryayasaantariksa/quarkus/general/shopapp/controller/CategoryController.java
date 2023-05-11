package com.acme.suryayasaantariksa.quarkus.general.shopapp.controller;

import java.util.List;

import com.acme.suryayasaantariksa.quarkus.general.shopapp.core.util.CommonStatic;
import com.acme.suryayasaantariksa.quarkus.general.shopapp.entity.CategoryEntity;
import com.acme.suryayasaantariksa.quarkus.general.shopapp.model.CategoryBody;
import com.acme.suryayasaantariksa.quarkus.general.shopapp.service.CategoryHandler;

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

@Path(CommonStatic.V1 + "/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryController {
    
    @Inject
    CategoryHandler categoryHandler;
    
    @GET
    @Path("/get/{id}")
    public CategoryEntity getCategoryEntityById(Long id){
        return categoryHandler.getCategoryEntityById(id);
    }

    @GET
    @Path("/get-all")
    public List<CategoryEntity> getAllCategoryEntity(){
        return categoryHandler.getAllCategoryEntity();
    }

    @POST
    @Path("/create")
    @Transactional
    public CategoryEntity createCategoryEntity(CategoryBody body){
        return categoryHandler.createCategoryEntity(body);
    }

    @PUT
    @Path("/update")
    @Transactional
    public CategoryEntity updateCategoryEntity(CategoryEntity entity){
        return categoryHandler.updateCategoryEntity(entity);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteCategoryEntityById(Long id){
        return categoryHandler.deleteCategoryEntity(id);
    }
}
