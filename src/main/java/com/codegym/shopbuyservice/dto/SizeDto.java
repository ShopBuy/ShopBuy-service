package com.codegym.shopbuyservice.dto;

import com.codegym.shopbuyservice.entity.Variant;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SizeDto {
    private long id;
    private String name;
    private boolean isDeleted;
    private List<VariantDto> variantListDto;
}
