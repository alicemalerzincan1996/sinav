package com.cemal.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
public class UserProfileSaveRequestDto {

    @NotBlank(message = "Kullanıcı adı boş geçilemez.")
    @Size(min=3,max=30)
    String username;
    @Email(message = "Lütfen geçerli bir email adresi girin.")
    String email;

    @NotBlank(message = "Şifre boş geçilemez.")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,40}$",
            message = "Şifre en az 8 karakter olmalı. İçinde en az bir büyük, bir küçük karakter, bir sayı ve bir özel karakter olmalıdır")
    String password;
    String repassword;
}
