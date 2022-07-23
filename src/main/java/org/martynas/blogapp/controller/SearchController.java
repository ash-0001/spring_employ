package org.martynas.blogapp.controller;
import java.util.List;

import org.martynas.blogapp.model.Post;
import org.martynas.blogapp.repository.PostRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class SearchController {
  @Autowired
  private PostRepository postRepository;


  @GetMapping(value="/search/{query}")
  public ResponseEntity<?> search(@PathVariable("query") String query) {
    System.out.println(query);
    List<Post> post = this.postRepository.findBytitleContaining(query);
    return ResponseEntity.ok(post);
  }
  

}
