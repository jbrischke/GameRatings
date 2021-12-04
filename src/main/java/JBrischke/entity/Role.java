package JBrischke.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "Role")
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int role_id;

    @Column(name = "type")
    private String roleType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roles", nullable = false)
    private User user;

    public Role() {
    }

    public Role(String roleType, User user) {
        this.roleType = roleType;
        this.user = user;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
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
                ", roleType='" + roleType + '\'' +
                ", user=" + user +
                '}';
    }
}
