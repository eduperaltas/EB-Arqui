package com.example.appbientMicroserviceEvento.api.controllers;

import com.example.appbientMicroserviceEvento.api.domain.service.ActividadesEventoService;
import com.example.appbientMicroserviceEvento.api.mapping.ActividadesEventoMapper;
import com.example.appbientMicroserviceEvento.api.resource.ActividadesEvento.ActividadesEventoResource;
import com.example.appbientMicroserviceEvento.api.resource.ActividadesEvento.CreateActividadesEventoResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/eventos/{eventoId}/detallesEvento/actividades")
@Tag(name = "ActividadesEvento")
public class ActividadesEventoController {
    @Autowired
    private ActividadesEventoService actividadesEventoService;
    @Autowired
    private ActividadesEventoMapper mapper;

    @GetMapping
    public Page<ActividadesEventoResource> getAllActividadesEnEvento(@PathVariable Long eventoId, Pageable pageable){
        return mapper.modelListToPage(actividadesEventoService.getAll(), pageable);
    }
    @PostMapping("/{detallesEventoId}")
    public ActividadesEventoResource createActividadesEnEvento(@PathVariable Long detallesEventoId, @RequestBody CreateActividadesEventoResource resource){
        return mapper.toResource(actividadesEventoService.create(detallesEventoId, resource));
    }
    @DeleteMapping("/{id}")
    public void deleteActividadesEvento(@PathVariable Long id){
        actividadesEventoService.delete(id);
    }
}
