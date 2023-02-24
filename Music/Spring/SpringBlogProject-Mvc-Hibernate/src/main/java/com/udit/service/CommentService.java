package com.udit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udit.dao.CommentDao;
import com.udit.entity.Comment;

@Service
public class CommentService {

	@Autowired
	private CommentDao commentDao;
	
	
	public void addComment(Comment comment) {
		this.commentDao.addComment(comment);
	}
	
	public void deleteComment(Integer id,Integer postId) {
		this.commentDao.deleteComment(id,postId);
	}
	
	public Comment getComment(Integer commentId) {
		Comment comment=this.commentDao.getComment(commentId);
		return comment;
	}
	
}
