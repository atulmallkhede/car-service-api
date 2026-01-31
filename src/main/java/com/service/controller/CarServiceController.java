package com.service.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.service.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "*")
public class CarServiceController {

	private static final List<Car> carList = new ArrayList<>();
	private static Long carIdCounter = 0L;

	// Initialize with sample data
	static {
		carList.add(new Car(++carIdCounter, "TATA", "Nexon", 2024, "MH12AB1234", "Oil Change", 1500.00, "Ravi Patil",
				"COMPLETED"));
		carList.add(new Car(++carIdCounter, "MARUTI", "Swift", 2021, "MH12CD9876", "Brake Service", 3500.00,
				"Priya Sharma", "IN_PROGRESS"));
		carList.add(new Car(++carIdCounter, "MAHINDRA", "XUV700", 2023, "MH12EF5555", "Tire Rotation", 800.00,
				"Amit Desai", "PENDING"));
	}

	@GetMapping
	public ResponseEntity<List<Car>> getAllCars() {
		return ResponseEntity.ok(carList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable Long id) {
		Optional<Car> car = carList.stream().filter(c -> c.getId().equals(id)).findFirst();

		return car.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Car> createCarService(@Valid @RequestBody Car car) {
		car.setId(++carIdCounter);
		carList.add(car);
		return ResponseEntity.status(HttpStatus.CREATED).body(car);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Car> updateCarService(@PathVariable Long id, @Valid @RequestBody Car updatedCar) {
		Optional<Car> existingCar = carList.stream().filter(c -> c.getId().equals(id)).findFirst();

		if (existingCar.isPresent()) {
			Car car = existingCar.get();
			car.setMake(updatedCar.getMake());
			car.setModel(updatedCar.getModel());
			car.setYear(updatedCar.getYear());
			car.setLicensePlate(updatedCar.getLicensePlate());
			car.setServiceType(updatedCar.getServiceType());
			car.setServiceCost(updatedCar.getServiceCost());
			car.setCustomerName(updatedCar.getCustomerName());
			car.setServiceStatus(updatedCar.getServiceStatus());
			return ResponseEntity.ok(car);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCarService(@PathVariable Long id) {
		boolean removed = carList.removeIf(c -> c.getId().equals(id));

		if (removed) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/status/{status}")
	public ResponseEntity<List<Car>> getCarsByStatus(@PathVariable String status) {
		List<Car> filteredCars = carList.stream().filter(c -> c.getServiceStatus().equalsIgnoreCase(status))
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

		return ResponseEntity.ok(filteredCars);
	}

	@GetMapping("/customer/{customerName}")
	public ResponseEntity<List<Car>> getCarsByCustomer(@PathVariable String customerName) {
		List<Car> filteredCars = carList.stream()
				.filter(c -> c.getCustomerName().toLowerCase().contains(customerName.toLowerCase()))
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

		return ResponseEntity.ok(filteredCars);
	}
}