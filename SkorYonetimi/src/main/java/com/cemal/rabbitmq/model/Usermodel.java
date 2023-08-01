package com.cemal.rabbitmq.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder //bir sınifta nesne uretmeyi saglar
@Data // get set metodlarini otomatik tanimlar
@NoArgsConstructor //Bos constructor
@AllArgsConstructor //dolu constructor
@ToString // tostring


public class Usermodel {
    Long id;

    String username;

    Integer maxskor;

    Integer skor;
    @Builder.Default
    Integer oynanmasayisi=0; //burda toplam kackere oyndagınız yazar
}
