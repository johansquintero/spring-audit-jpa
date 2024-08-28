package com.audit.listeners;

import com.audit.persistence.entities.History;
import com.audit.persistence.entities.Product;
import com.audit.persistence.repositories.IHistoryCrudRepository;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.naming.Context;
import java.time.LocalDateTime;

@Component
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class AuditProductListener {
//    private IHistoryCrudRepository historyCrudRepository;
//
//    @Lazy
//    public AuditProductListener(IHistoryCrudRepository historyCrudRepository){
//        this.historyCrudRepository = historyCrudRepository;
//    }

    private final IHistoryCrudRepository historyCrudRepository;

    @PrePersist
    public void prePersist(Product product) {
        saveHistory(product,"INSERT");
    }

    @PreUpdate
    public void preUpdate(Product product) {
        saveHistory(product,"UPDATE");
    }

    @PreRemove
    public void preRemove(Product product) {
        saveHistory(product,"DELETE");
    }

    public void saveHistory(Product product,String operation){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();

        History history = History.builder()
                .name(product.getName())
                .user(authentication.getName())
                .operation(operation)
                .dateEvent(LocalDateTime.now())
                .build();
        this.historyCrudRepository.save(history);
    }
}
