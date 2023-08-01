package com.cemal.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
public class UserProfileUpdate {
    @Builder.Default
    String email=null;
    @Builder.Default
    String telefon=null;

    @Builder.Default
    String password=null;
}
