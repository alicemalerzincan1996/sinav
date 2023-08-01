package com.cemal.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder// bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
@Entity
@Table(name = "tbluserprofile")
public class UserProfile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String username;
    String email;
    String password;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    Type type=Type.User;


    String telefon;
    Integer maxskor;
    @Builder.Default
    Integer oynanmasayisi=0; //burda toplam kackere oyndagınız yazar
}
