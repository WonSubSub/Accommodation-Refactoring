package refactor.kamsung.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "user_table")
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String nickname;
    private String password;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user") // cascade 해야하나?
    private List<Like> likes = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_prefer_id")
    private UserPrefer userPrefer;

//    public void setUserPrefer(UserPrefer userPrefer) {
//        this.userPrefer = userPrefer;
//        userPrefer.setUser(this);
//    }  유저성향엔티티에 넣을지
}
