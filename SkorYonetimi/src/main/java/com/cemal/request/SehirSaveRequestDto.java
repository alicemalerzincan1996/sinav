package com.cemal.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
public class SehirSaveRequestDto {

    @NotBlank(message = "Kullanıcı adı boş geçilemez.")
    @Size(min=3,max=30)
    String name;


    String Bolge;

    List<String> ozelikler;

    Integer nufus;

}
