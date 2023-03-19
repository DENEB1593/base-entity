package io.dev.deneb.model.user;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class UserDto {
  private Long id;

  private String email;

  private String nickname;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  public UserDto() {
  }

  public UserDto(Long id, String email, String nickname, LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.email = email;
    this.nickname = nickname;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public UserDto(User user) {
    BeanUtils.copyProperties(user, this);
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

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("id", id)
            .append("email", email)
            .append("nickname", nickname)
            .append("createdAt", createdAt)
            .append("updatedAt", updatedAt)
            .toString();
  }
}
