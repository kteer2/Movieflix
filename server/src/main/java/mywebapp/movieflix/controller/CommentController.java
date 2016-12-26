package mywebapp.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mywebapp.movieflix.entities.CommentEntity;
import mywebapp.movieflix.service.CommentService;


@RestController
public class CommentController {
	
	@Autowired
	private CommentService service;
	
	@RequestMapping(method=RequestMethod.GET,value="/comments")
	public List<CommentEntity> showAll(){
		return service.showAll();
	}

	@RequestMapping(method=RequestMethod.GET,value="/comments/title/{id}")
	public List<CommentEntity> showCommentByMovie(@PathVariable("id") String mid){
		return service.showCommentsByMovie(mid);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="comments/user/{uid}/title/{mid}")
	public CommentEntity createComment(@PathVariable("uid") String userId,@PathVariable("mid") String movieId,@RequestBody CommentEntity entity){
		return service.createComment(userId, movieId, entity); 
	}

}
