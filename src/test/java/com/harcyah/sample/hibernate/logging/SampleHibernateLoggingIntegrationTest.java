package com.harcyah.sample.hibernate.logging;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.harcyah.sample.hibernate.logging.Assertions.assertThat;

@SpringBootTest
public class SampleHibernateLoggingIntegrationTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void testRepositoriesAreDefined() {
        assertThat(postRepository.count()).isEqualTo(0L);
    }

    @Test
    public void testFindCommentDetails() {
        Post post0 = new Post();
        post0.setAuthor("Author0");
        post0.setTitle("Title0");
        post0.setContent("Content0");

        Post post1 = new Post();
        post1.setAuthor("Author1");
        post1.setTitle("Title1");
        post1.setContent("Content1");

        postRepository.save(post0);
        postRepository.save(post1);

        assertThat(postRepository.count()).isEqualTo(2L);
    }

}
