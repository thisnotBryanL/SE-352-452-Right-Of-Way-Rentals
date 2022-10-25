package edu.depaul.cdm.se452.RightOfWayRentals.data.repository.implementation;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {
    @Override
    public <S extends Vehicle> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Vehicle> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Vehicle> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Vehicle> findAll() {
        return null;
    }

    @Override
    public Iterable<Vehicle> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Vehicle entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Vehicle> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
