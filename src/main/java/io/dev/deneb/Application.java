package io.dev.deneb;

import io.dev.deneb.model.post.Post;
import io.dev.deneb.repo.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(PostRepository postRepository) {
    return args -> {
      var posts = new ArrayList<Post>();
      posts.add(new Post("title1", "content1"));
      posts.add(new Post("title2", "content2"));

      postRepository.saveAll(posts);

    };
  }

}
