package com.example.appbient_microservice_usuarios.api.controllers;

import com.example.appbient_microservice_usuarios.api.domain.service.OngService;
import com.example.appbient_microservice_usuarios.api.mapping.OngMapper;
import com.example.appbient_microservice_usuarios.api.resource.Ong.CreateOngResource;
import com.example.appbient_microservice_usuarios.api.resource.Ong.OngResource;
import com.example.appbient_microservice_usuarios.api.resource.Ong.UpdateOngResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
@RestController
@RequestMapping("/api/v1/ong")
@Tag(name = "ONG")
public class OngController {
    @Autowired
    private OngService ongService;

    @Autowired
    private OngMapper mapper;

    @GetMapping
    public Page<OngResource> getAllOngs(Pageable pageable) {
        return mapper.modelListToPage(ongService.getAll(), pageable);
    }

    @PostMapping
    public OngResource createOng(@RequestBody CreateOngResource resource) {
        return mapper.toResource(ongService.create(resource));
    }

    @PutMapping("/{id}")
    public OngResource updateOng(@PathVariable Long id, UpdateOngResource resource) {
        return mapper.toResource(ongService.update(id, mapper.toModel(resource)));
    }

    @DeleteMapping("/{id}")
    public void deleteOng(@PathVariable Long id) {
        ongService.delete(id);
    }
}
