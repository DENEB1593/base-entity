package io.dev.deneb.controller;

import io.dev.deneb.model.post.PostDto;
import io.dev.deneb.repo.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/post")
public class PostController {

  private static final Logger log = LoggerFactory.getLogger(PostController.class);

  private final PostRepository postRepository;

  public PostController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }


  @GetMapping("{id}")
  public PostDto findById(@PathVariable Long id) {
    Assert.notNull(id, "post id must be provided");
    return postRepository
            .findById(id)
            .map(PostDto::new)
            .orElseThrow(() -> new RuntimeException("post not found"));
  }


}
