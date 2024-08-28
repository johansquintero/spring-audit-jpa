package com.audit.persistence.entities;

import com.audit.listeners.AuditProductListener;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "products")
@EntityListeners(AuditProductListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

//    private String operation;
//    @Column(name = "date_event")
//    private LocalDateTime dateEvent;


//    @PrePersist
//    public void onPrePersist(){
//        audit("INSERT");
//    }
//
//    @PreUpdate
//    public void onPreUpdate(){
//        audit("UPDATE");
//    }
//
//    public void audit(String operation){
//        setOperation(operation);
//        setDateEvent(LocalDateTime.now());
//    }
}
