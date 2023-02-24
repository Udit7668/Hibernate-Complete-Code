package com.udit.service;

import java.util.List;

import javax.transaction.Transactional;

import com.udit.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.udit.dao.PostDao;

@Component
public class PostService {

	@Autowired
	private PostDao postDao;

	public void addPost(Post post) {
		this.postDao.addPost(post);
		
	}
	
	public Post getPostById(Integer id) {
		Post post=this.postDao.getPostById(id);
		return post;
	}
	
	public List<Post> getAllPost(){
		List<Post> posts=this.postDao.getAllPost();
		return posts;
	}
	
	public List<Post> searchpost(String title){
      
		List<Post> posts=this.postDao.searchCustomer(title);
		return posts;
	}
	
	public List<Post> sortCustomers(String sortBy){
	   List<Post> posts=this.postDao.sortCustomers(sortBy);
	   return posts;
	}
	
	public List<Post> filterPost(String author){
		List<Post> post=this.postDao.filterPost(author);
		return post;
	}
	
	
	public void deletePost(Integer id) {
		this.postDao.deletePost(id);
	}
	
	public void addComment(Comment comment,Integer id) {
		this.postDao.addComment(comment,id);
	}
	
	 public void addTag(Tag tags,Post post) {
         this.postDao.addTag(tags, post);
	 }

}
