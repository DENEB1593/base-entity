package io.dev.deneb.controller;

import io.dev.deneb.model.post.PostDto;
import io.dev.deneb.model.user.UserDto;
import io.dev.deneb.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController {

  private static final Logger log = LoggerFactory.getLogger(UserController.class);

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("{id}")
  public UserDto findById(@PathVariable Long id) {
    Assert.notNull(id, "user id must be provided");
    return userRepository
            .findById(id)
            .map(UserDto::new)
            .orElseThrow(() -> new RuntimeException("user not found"));
  }
}
