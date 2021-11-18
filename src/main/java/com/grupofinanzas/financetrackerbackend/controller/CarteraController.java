package com.grupofinanzas.financetrackerbackend.controller;

import com.grupofinanzas.financetrackerbackend.domain.model.Cartera;
import com.grupofinanzas.financetrackerbackend.domain.service.CarteraService;
import com.grupofinanzas.financetrackerbackend.resource.wallet.CarteraResource;
import com.grupofinanzas.financetrackerbackend.resource.wallet.SaveCarteraResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CarteraController {
    @Autowired
    private CarteraService carteraService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/{userid}/carteras")
    public List<CarteraResource> getAllCarterasByUserId(@PathVariable Long userid){
        return carteraService.getAllCarterasByUserId(userid).stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/{userid}/carteras/{carteraid}")
    public CarteraResource getCarteraByIdAndUserId(@PathVariable Long userid,@PathVariable Long carteraid){
        Optional<Cartera> cartera = carteraService.getCarteraByIdAndByUserId(userid,carteraid);
        return cartera.map(this::convertToResource).orElse(null);
    }

    @PostMapping("/{userid}/carteras")
    public CarteraResource createCartera(@PathVariable Long userid, @RequestBody SaveCarteraResource carteraResource){
        Cartera cartera = convertToEntity(carteraResource);
        return convertToResource(carteraService.createCarteraByUserId(userid,cartera));
    }

    @DeleteMapping("/{userid}/carteras/{carteraid}")
    public ResponseEntity<?> deleteCartera(@PathVariable Long userid, @PathVariable Long carteraid){
        return carteraService.deleteCartera(userid,carteraid);
    }

    @PutMapping("/{userid}/carteras/{carteraid}")
    public CarteraResource updateCartera(@PathVariable Long userid,@PathVariable Long carteraid,@RequestBody SaveCarteraResource carteraResource){
        Cartera cartera = convertToEntity(carteraResource);
        return convertToResource(carteraService.updateCartera(userid,carteraid,cartera));
    }

    private Cartera convertToEntity(SaveCarteraResource resource){
        return mapper.map(resource, Cartera.class);
    }

    private CarteraResource convertToResource(Cartera entity){
        return mapper.map(entity, CarteraResource.class);
    }
}
