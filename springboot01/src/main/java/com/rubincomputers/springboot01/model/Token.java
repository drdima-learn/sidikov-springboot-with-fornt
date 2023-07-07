package com.rubincomputers.springboot01.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Token extends BaseEntity {
    private String value;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
