//package com.jamie.rms.dao;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.jamie.rms.model.InventorySum;
//import com.jamie.rms.model.Status;
//
//public interface InventorySumDao extends JpaRepository<InventorySum,String>{
//	
//	List<InventorySum> findByPartyIdAndStatus(String partyId, Status status);
//	
//	List<InventorySum> findByPartyIdAndStatusOrderByProductId(String partyId, Status status);
//}
