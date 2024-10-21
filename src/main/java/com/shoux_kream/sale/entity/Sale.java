package com.shoux_kream.sale.entity;

import com.shoux_kream.item.entity.Item;
import com.shoux_kream.timestamp.BaseEntity;
import com.shoux_kream.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "sale")
public class Sale extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "selling_price", nullable = false)
    private Long sellingPrice;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "due_date", nullable = false)
    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "items_id", nullable = false)
    private Item item;

    public Sale(Long sellingPrice, int quantity, int daysToAdd, User user, Item item) {
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
        this.dueDate = LocalDateTime.now().plusDays(daysToAdd);
        this.user = user;
        this.item = item;
    }
}
