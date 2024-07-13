package com.example.comixnookbackend.Pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String token;
    private Long userId;
    private boolean isAdmin;
    private String userName;
    private String userEmail;
//    private String role;
}
