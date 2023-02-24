package com.udit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.udit.entity.Comment;
import com.udit.entity.Post;

@Component
public class CommentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addComment(Comment comment) {
		this.hibernateTemplate.saveOrUpdate(comment);
	}
	@Transactional
	public void deleteComment(Integer id,Integer postId) {
		Comment comment=this.hibernateTemplate.get(Comment.class, id);
		Post post=this.hibernateTemplate.get(Post.class, postId);
		post.getComments().remove(comment);
	    this.hibernateTemplate.delete(comment);
		
	}
	
	
	public Comment getComment(Integer commentId) {
	Comment comment=this.hibernateTemplate.get(Comment.class, commentId);
	return comment;
	}
	
}
