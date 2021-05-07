package com.zunde.userManagement.registration;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
