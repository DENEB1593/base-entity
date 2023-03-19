package io.dev.deneb.repo;

import io.dev.deneb.config.JpaConfig;
import io.dev.deneb.model.post.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@Import(JpaConfig.class)
class PostRepositoryTest {

  @Autowired
  private PostRepository postRepository;

  @Test
  void baseEntityTest() {
    var given = new Post("test", "this is test");

    var saved = postRepository.save(given);

    assertThat(saved).isNotNull();
    assertThat(saved.getId()).isNotNull();
    assertThat(saved.getCreatedAt()).isNotNull();
    assertThat(saved.getUpdatedAt()).isNotNull();


  }


}