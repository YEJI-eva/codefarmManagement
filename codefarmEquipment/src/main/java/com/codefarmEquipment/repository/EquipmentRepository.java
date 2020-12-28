package  com.codefarmEquipment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import  com.codefarmEquipment.model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long>  {

	List<Equipment> findByDeviceGbcd(String deviceGbcd);

}
