package JBrischke.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


@Entity(name = "Role")
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int role_id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "username")
    private String userName;

    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "role_user_user_id_fk")
    )
    private User user;

    public Role() {
    }

    public Role(String roleName, String userName, User user) {
        this.roleName = roleName;
        this.userName = userName;
        this.user = user;
    }

    public Role(String roleName, User user) {
        this.roleName = roleName;
        this.user = user;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", roleName='" + roleName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", userName='" + userName + '\'' +
                ", user=" + user +
                '}';
    }
}
