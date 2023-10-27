package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;
    private ClientDTO client;
    private PaymentDTO paymen;

    @NotEmpty(message = "Deve ter pelo menos um item")
    private List<OrdemItemDTO> items = new ArrayList<>();

    public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO paymen) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.paymen = paymen;
    }

    public OrderDTO(Order entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.status = entity.getStatus();
        this.client = new ClientDTO(entity.getClient());
        this.paymen = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());

        for(OrderItem item: entity.getItems()){
            OrdemItemDTO itemDTO = new OrdemItemDTO(item);
            items.add(itemDTO);
        }
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public PaymentDTO getPaymen() {
        return paymen;
    }

    public List<OrdemItemDTO> getItems() {
        return items;
    }

    public Double getTotal(){
        double sum = 0.0;

        for(OrdemItemDTO item: items){
            sum += item.getSubTotal();
        }
        return sum;
    }
}
