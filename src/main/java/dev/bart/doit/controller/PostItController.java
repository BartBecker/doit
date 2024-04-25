package dev.bart.doit.controller;

import dev.bart.doit.model.PostIt;
import dev.bart.doit.model.Status;
import dev.bart.doit.repository.PostItCollectionRepository;
import dev.bart.doit.repository.PostItRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/postit")
@CrossOrigin
public class PostItController {

    private final PostItRepository repository;

    @Autowired
    public PostItController(PostItRepository repository) {
        this.repository = repository;
    }

   @GetMapping("")
   public List<PostIt> findAll() {
        return repository.findAll();
   }

   @GetMapping("{id}")
    public PostIt findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));
   }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody PostIt postIt) {
        repository.save(postIt);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody PostIt postIt, @PathVariable Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }
        repository.save(postIt);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<PostIt> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("filter/status/{status}")
    public List<PostIt> findByStatus(@PathVariable Status status) {
        return repository.listByStatus(status);
    }


}
