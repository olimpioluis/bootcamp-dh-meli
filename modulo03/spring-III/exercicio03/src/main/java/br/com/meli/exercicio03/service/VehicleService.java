package br.com.meli.exercicio03.service;

import br.com.meli.exercicio03.dto.VehicleDTO;
import br.com.meli.exercicio03.dto.VehicleFilteredDTO;
import br.com.meli.exercicio03.entity.Vehicle;
import br.com.meli.exercicio03.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<VehicleFilteredDTO> getVehicles() {
        return VehicleFilteredDTO.convert(vehicleRepository.getVehicles());
    }

    public List<VehicleFilteredDTO> getVehiclesByManufacturingDate(String since, String to) {
        return VehicleFilteredDTO.convert(vehicleRepository.getVehiclesByManufacturingDate(since, to));
    }

    public List<VehicleFilteredDTO> getVehiclesByPrice(Double since, Double to) {
        return VehicleFilteredDTO.convert(vehicleRepository.getVehiclesByPrice(since, to));
    }

    public VehicleDTO getVehicleById(int id) {
        return new VehicleDTO().convert(vehicleRepository.getVehicleById(id));
    }
}
