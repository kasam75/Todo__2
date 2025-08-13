package spring.todo__2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    //검색해보니 유니크 트루가 중복된 아이디를 막아 준다고 함
    private String email;

    private String password;
    //패스워드는 수정할 필요가 있는거 같아서 추가

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }//패스워드와 이메일은 변경할 수도 있으니 검색해서 추가함
}
