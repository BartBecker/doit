package dev.bart.doit.repository;

import dev.bart.doit.model.Difficulty;
import dev.bart.doit.model.PostIt;
import dev.bart.doit.model.Status;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostItCollectionRepository {

    private final List<PostIt> postItList = new ArrayList<>();

    public PostItCollectionRepository() {

    }

    public List<PostIt> findAll() {
        return postItList;
    }

    public Optional<PostIt> findById(Integer id) {
        return postItList.stream()
                .filter(p -> p.id().equals(id)).findFirst();
    }

    public void save(PostIt postIt) {
        postItList.removeIf(p -> p.id().equals(postIt.id()));
        postItList.add(postIt);
    }

    @PostConstruct
    private void init() {
        PostIt p = new PostIt(0,
                "My first post",
                "my first post",
                Status.TODO,
                Difficulty.EASY,
                5,
                LocalDateTime.now(),
                null
                );

        postItList.add(p);
    }

    public boolean existsById(Integer id) {
        return postItList.stream().filter(p -> p.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        postItList.removeIf(p -> p.id().equals(id));
    }
}
