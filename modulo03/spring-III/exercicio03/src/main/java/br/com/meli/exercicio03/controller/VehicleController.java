package br.com.meli.exercicio03.controller;

import br.com.meli.exercicio03.dto.VehicleDTO;
import br.com.meli.exercicio03.dto.VehicleFilteredDTO;
import br.com.meli.exercicio03.entity.Vehicle;
import br.com.meli.exercicio03.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController()
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/v1/api/vehicles")
    public ResponseEntity<VehicleDTO> save(@RequestBody VehicleDTO vehicle, UriComponentsBuilder uriBuilder) {
        Vehicle newVehicle = vehicle.convert();
        vehicleService.save(newVehicle);

        URI uri = uriBuilder.path("v1/api/vehicles/{id}").buildAndExpand(newVehicle.getId()).toUri();

        return ResponseEntity.created(uri).body(vehicle.convert(newVehicle));
    }

    @GetMapping("/v1/api/vehicles")
    public ResponseEntity<List<VehicleFilteredDTO>> getVehicles() {
        return ResponseEntity.ok().body(vehicleService.getVehicles());
    }

    @GetMapping("/v1/api/vehicles/dates")
    public ResponseEntity<List<VehicleFilteredDTO>> getVehiclesByManufacturingDate(@RequestParam(required = false) String since, @RequestParam(required = false) String to) {
        return ResponseEntity.ok().body(vehicleService.getVehiclesByManufacturingDate(since, to));
    }

    @GetMapping("/v1/api/vehicles/prices")
    public ResponseEntity<List<VehicleFilteredDTO>> getVehiclesByManufacturingDate(@RequestParam(required = false) Double since, @RequestParam(required = false) Double to) {
        return ResponseEntity.ok().body(vehicleService.getVehiclesByPrice(since, to));
    }

    @GetMapping("/v1/api/vehicles/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable int id) {
        return ResponseEntity.ok().body(vehicleService.getVehicleById(id));
    }
}
