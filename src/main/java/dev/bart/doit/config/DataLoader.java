package dev.bart.doit.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.bart.doit.repository.PostItCollectionRepository;
import org.springframework.boot.CommandLineRunner;

//@Component
public class DataLoader implements CommandLineRunner {

    private final PostItCollectionRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(PostItCollectionRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }


    @Override
    public void run(String... args) throws Exception {
        //if(repository.count() == 0)
    }
}
