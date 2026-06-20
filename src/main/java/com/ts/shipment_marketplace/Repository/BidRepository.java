package com.ts.shipment_marketplace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.shipment_marketplace.Entity.Bid;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

}
