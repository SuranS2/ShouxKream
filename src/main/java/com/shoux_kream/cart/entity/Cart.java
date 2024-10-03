package com.shoux_kream.cart.entity;

import com.shoux_kream.item.entity.Item;
import com.shoux_kream.timestamp.BaseEntity;
import com.shoux_kream.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Table(name = "cart")
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "items_id", nullable = false)
    private Item item;

    public Cart (User user, Item item, int quantity) {
        this.user = user;
        this.item = item;
        this.quantity = quantity;
    }
}
