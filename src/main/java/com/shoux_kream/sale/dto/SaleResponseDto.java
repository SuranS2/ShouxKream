package com.shoux_kream.sale.dto;

import com.shoux_kream.sale.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SaleResponseDto {
    private Long saleId;
    private Long userId;
    private Long itemId;

    private LocalDateTime dueDate;
    private int quantity;
    private Long sellingPrice;

    private String itemName;
    private String imageUrl;
    private String shortDescription;
    private String detailDescription;

    private double fee; // 수수료

    public SaleResponseDto(Sale sale) {
        this.saleId = sale.getId();
        this.userId = sale.getUser().getId();
        this.itemId = sale.getItem().getId();
        this.dueDate = sale.getDueDate();
        this.quantity = sale.getQuantity();
        this.sellingPrice = sale.getSellingPrice();
        this.itemName = sale.getItem().getTitle();
        this.imageUrl = sale.getItem().getImageKey();
        this.shortDescription = sale.getItem().getShortDescription();
        this.detailDescription = sale.getItem().getDetailDescription();
        this.fee = (sellingPrice * 0.10) * quantity;
    }

}
