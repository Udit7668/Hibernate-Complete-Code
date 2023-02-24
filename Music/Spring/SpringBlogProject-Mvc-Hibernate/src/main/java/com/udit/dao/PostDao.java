package com.udit.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.udit.entity.Comment;
import com.udit.entity.Post;
import com.udit.entity.Tag;

@Component
public class PostDao {
  @Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void addPost(Post post) {
		this.hibernateTemplate.saveOrUpdate(post);
	}

	public Post getPostById(Integer id) {
		Post post = this.hibernateTemplate.get(Post.class, id);
		return post;
	}

	public List<Post> getAllPost() {  
		List<Post> posts = this.hibernateTemplate.loadAll(Post.class);
		return posts;
	}

	@Transactional
	public void deletePost(Integer id) {
		Post post = this.hibernateTemplate.get(Post.class, id);
		this.hibernateTemplate.delete(post);
	}

	public List<Post> searchCustomer(String title) {
		
		SessionFactory factory = this.hibernateTemplate.getSessionFactory();
		Session session = factory.openSession();
		Query query1=session.createQuery("from Tag where name like :s");
		query1.setParameter("s", title);
		List<Tag> tags=query1.getResultList();
		//System.out.println(tags);
		List<Post> posts=new ArrayList<Post>();
		if(!tags.isEmpty()) {
		for(Tag tag:tags) {
			if(tag.getName().equals(title)) {
			List<Post> list=tag.getPosts();
			for(Post post:list) {
				posts.add(post);
			}	
			}
		}
		return posts;
		}
		//System.out.println(list);

		Query query = session.createQuery("FROM Post where title like :c or content like :c or author like :c");
		query.setParameter("c", title);
		posts = query.getResultList();
		return posts;
	}

	public List<Post> sortCustomers(String sortBy) {
		SessionFactory factory = this.hibernateTemplate.getSessionFactory();
		Session session = factory.openSession();
		Query query = session.createQuery("from Post order by creationDate " + sortBy);
		List<Post> posts = query.getResultList();
		return posts;
	}

	@Transactional
	public void addComment(Comment comment, Integer id) {
		Post post = this.hibernateTemplate.get(Post.class, id);
		System.out.println(post);
		post.addComment(comment);
		comment.setPosts(post);
		this.hibernateTemplate.save(comment);
	}
	
	public List<Post> filterPost(String author) {

		SessionFactory factory = this.hibernateTemplate.getSessionFactory();
		Session session = factory.openSession();
		Query query1=session.createQuery("from Tag where name like :s");
		query1.setParameter("s", author);
		List<Tag> tags=query1.getResultList();
		//System.out.println(tags);
		List<Post> posts=new ArrayList<Post>();
		if(!tags.isEmpty()) {
		for(Tag tag:tags) {
			if(tag.getName().equals(author)) {
			List<Post> list=tag.getPosts();
			for(Post post:list) {
				posts.add(post);
			}	
			}
		}
	  return posts;
	}
		Query query = session.createQuery("FROM Post where  author like :c");
		query.setParameter("c", author);
		posts = query.getResultList();
		return posts;

	}

	@Transactional
	public void addTag(Tag tags, Post post) {
		post.addTag(tags);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
