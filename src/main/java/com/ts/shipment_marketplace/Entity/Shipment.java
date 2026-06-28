package com.ts.shipment_marketplace.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name = "shipments")
public class Shipment {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long shipmentId;

    private String title;

    private String sourceLocation;

    private String destinationLocation;

    private Double weight;

    private Double budget;

    private String status;

    @ManyToOne
    @JoinColumn(name="shipper_id")
    private User shipper;
	
}
