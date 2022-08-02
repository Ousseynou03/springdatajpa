package com.org.springdata.service;

import com.org.springdata.model.Comment;
import com.org.springdata.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Iterable<Comment> getComments() {

        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentsById(Integer id){

        return commentRepository.findById(id);
    }

    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }

    //Suppression d'un Commentaire
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
