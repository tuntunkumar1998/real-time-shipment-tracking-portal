package com.ts.shipment_marketplace.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="bids")
public class Bid {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long bidId;

    private Double amount;

    private Integer estimatedDays;

    private String status;

    @ManyToOne
    @JoinColumn(name="shipment_id")
    private Shipment shipment;

    @ManyToOne
    @JoinColumn(name="carrier_id")
    private User carrier;
	
}
