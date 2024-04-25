package dev.bart.doit.repository;

import dev.bart.doit.model.PostIt;
import dev.bart.doit.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface PostItRepository extends ListCrudRepository<PostIt, Integer> {

    List<PostIt> findAllByTitleContains(String keyword);

    @Query("""
            SELECT * FROM post_it
            WHERE status = :status
            """)
    List<PostIt> listByStatus(@Param("status") Status status);
}
