package com.shopbuyservice.dto.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest {
    @NotBlank(message = "Email không được trống")
    @Email(message = "Địa chỉ email không hợp lệ")
    private String email;
    @NotBlank(message = "Mật khẩu không được trống")
    @Size(min = 8, message = "Mật khẩu phải có ít nhất 8 ký tự")
    @Pattern.List({
            @Pattern(regexp = "^(?=.*[0-9]).*$", message = "Mật khẩu phải chứa ít nhất 1 ký tự số"),
            @Pattern(regexp = "^(?=.*[a-z]).*$", message = "Mật khẩu phải chứa ít nhất 1 ký tự viết thường"),
            @Pattern(regexp = "^(?=.*[A-Z]).*$", message = "Mật khẩu phải chứa ít nhất 1 ký tự viết hoa"),
            @Pattern(regexp = "^(?=.*[@#$%^&+=]).*$", message = "Mật khẩu phải chứa ít nhất 1 ký tự đặc biệt")
    })
    private String password;
    private String gender;
    @NotBlank(message = "Số điện thoại không được trống")
    @Pattern(regexp = "^[0-9]{10}$", message = "Số điện thoại phải là 10 chữ số")
    private String phoneNumber;
    private String fullName;
    private Date dateOfBirth;
    private Long RoleId;
}
