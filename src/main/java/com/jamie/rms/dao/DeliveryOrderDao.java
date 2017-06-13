package com.jamie.rms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jamie.rms.model.DeliveryOrder;


@Repository
@Transactional
public interface DeliveryOrderDao extends JpaRepository<DeliveryOrder,Long> {

}
