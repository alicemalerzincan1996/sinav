package com.cemal.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ÖNEMLİ!!!
 * RabbitMQ'ya gönderilecek modeller mutlaka serileştirilmelidir. (implements Serializable)
 * Ayrıca package adı dahil olmak üzere bu sınıfın aynısı iletilen serviste de olmalıdır.
 */
@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
public class SaveAuthModel implements Serializable {
    Long authid;
    String username;
    String email;
}
