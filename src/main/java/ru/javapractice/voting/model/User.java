package ru.javapractice.voting.model;

import org.hibernate.annotations.BatchSize;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
public class User extends AbstractNamedEntity {

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(name = "phone", nullable = false)
    @NotBlank
    @Size(min = 5, max = 15)
    private String phone;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    @NotNull
    private Date registered;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")//, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("dateTime DESC")
    protected List<Vote> votes;


    protected User(){}

    protected User(User u){
        this(u.getId(), u.getName(), u.getEmail(), u.getPhone(), u.getPassword(), u.getRegistered(), u.isEnabled(), u.getRoles());
    }

    public User(String name, String email, String phone, String password, Role role, Role... roles){
        this(null, name, email, phone, password, new Date(), true, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String email, String phone, String password, Date registered, boolean enabled, Collection<Role> roles) {
        super(id, name);
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.registered = registered;
        this.enabled = enabled;
        setRoles(roles);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> role) {
        this.roles = CollectionUtils.isEmpty(role)? Collections.emptySet() : EnumSet.copyOf(role);
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
