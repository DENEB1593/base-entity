package io.dev.deneb.model.user;

import io.dev.deneb.model.BaseEntity;
import jakarta.persistence.*;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(updatable = false, nullable = false)
  private Long id;

  private String email;

  private String nickname;

  public User() {
  }

  public User(String email, String nickname) {
    this.email = email;
    this.nickname = nickname;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("id", id)
            .append("email", email)
            .append("nickname", nickname)
            .toString();
  }
}
