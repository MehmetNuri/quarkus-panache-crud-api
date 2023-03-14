package com.mehmetnuri.resource;

import com.mehmetnuri.entity.Category;
import com.mehmetnuri.service.CategoryService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @Inject
    CategoryService categoryService;

    @GET
    @Path("/")
    public List<Category> findAll() {
        return (List<Category>) categoryService.getAll();
    }

    @GET
    @Path("/{id}")
    public Category findById(@PathParam("id") Long id) {
        return categoryService.get(id);
    }


    @POST
    @Path("/save")
    public Category save(Category category) {
        return categoryService.create(category);
    }

    @PUT
    @Path("/update/{id}")
    public Category update(@PathParam("id") Long id, Category category) {
        return categoryService.update(id, category);
    }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        categoryService.delete(id);
    }

    @GET
    @Path("/findbyname/{name}")
    public Category findByName(@PathParam("name") String name) {
        return categoryService.getByName(name);
    }
}
