package com.usermanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "city")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CountryEntity country;
}
