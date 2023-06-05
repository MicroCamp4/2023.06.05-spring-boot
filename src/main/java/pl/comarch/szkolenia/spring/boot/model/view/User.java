package pl.comarch.szkolenia.spring.boot.model.view;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String login;
    private String name;
    private String surname;
    private String city;
    private String street;
    private String country;
    private String age;
    private String password;
}
