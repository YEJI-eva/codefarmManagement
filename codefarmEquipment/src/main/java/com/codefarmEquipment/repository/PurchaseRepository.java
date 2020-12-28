package  com.codefarmEquipment.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.codefarmEquipment.model.Board;
import com.codefarmEquipment.model.Equipment;
import com.codefarmEquipment.model.Purchase;


public interface PurchaseRepository extends JpaRepository<Purchase, Long>  {

	Page<Purchase> findByManufacturerContainingOrDeviceNameContaining(String manufacturer, String deviceName, Pageable pageable);
}
