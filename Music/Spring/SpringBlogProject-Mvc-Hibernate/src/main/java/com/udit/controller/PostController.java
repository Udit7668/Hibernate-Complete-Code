package com.udit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udit.entity.Comment;
import com.udit.entity.Post;
import com.udit.entity.Tag;
import com.udit.entity.User;
import com.udit.service.CommentService;
import com.udit.service.LoginService;
import com.udit.service.PostService;
import com.udit.service.UserService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/newpost")
	public String addPost(Model model) {
		Post post=new Post();
		Tag tags=new Tag();
		model.addAttribute("tags", tags);
	    model.addAttribute("post",post);
		 return "newpost";
	}
	
	@RequestMapping("/login")
	public String loginForm(){
		return "login-form";
	}
	@RequestMapping("loginUser")
	public String loginUser(@RequestParam("email") String email,@RequestParam("password") String password) {
	boolean isValidUser=this.loginService.checkUser(email, password);
	System.out.println(isValidUser);
	if(isValidUser) {
		return "view-post";
	}
	else {
		return "redirect:/login";
	}
	}
	
	@RequestMapping("/register")
	public String signUp(Model model) {
		User user=new User();
	   model.addAttribute("user",user);
		return "signup-form";
	}
	@RequestMapping("/signup")
	public String createUser(@Valid @ModelAttribute("user") User user,BindingResult result) {
		System.out.println(user);
		if(result.hasErrors()) {
			System.out.println(result);
			return "signup-form";
		}
		this.userService.addUser(user);
		return "signup-form";
	}
	
	@RequestMapping("/createpost")
	public String createPost(@ModelAttribute("post") Post post,Model model,@ModelAttribute("check") Tag tags) {
		System.out.println(post);
		System.out.println(tags);
		this.postService.addTag(tags, post);
		this.postService.addPost(post);
		return "redirect:/";
	}
	
	@RequestMapping("/")
	public String showAllPost(Model model) {
	    List<Post> posts= this.postService.getAllPost();
	    model.addAttribute("posts",posts);
		return "post-confirmation";
	}
	
	@RequestMapping("/delete")
	public String deletePost(@RequestParam("deleteId") Integer id) {
		this.postService.deletePost(id);
		return "redirect:/";
	}
	
	@RequestMapping("/update")
	public String updatePost(@RequestParam("updateId") Integer id,Model model,@ModelAttribute("comments") List<String> comments) {
      Post post=this.postService.getPostById(id);
      Tag tags=new Tag();
      model.addAttribute("tags",tags);
      model.addAttribute("comments",comments);
      model.addAttribute("post",post);
		return "update-post";
	}
	
	@RequestMapping("/updatepost")
	public String updatePost(@ModelAttribute("post") Post post,Model model,@ModelAttribute("tags") Tag tags) {
		this.postService.addPost(post); 
		System.out.println(tags+"**********************");
		this.postService.addTag(tags, post);
	   return "redirect:/";
	}
	
	
	
	@RequestMapping("/search")
	public String searchCustomer(@RequestParam("title") String title,Model model) {
		List<Post> posts=this.postService.searchpost(title);
		model.addAttribute("posts",posts);
		return "post-confirmation";
	}
	
	@RequestMapping("/sort")
	public String sortCustomers(@RequestParam("sortby") String sortBy,Model model) {
		List<Post> posts=this.postService.sortCustomers(sortBy);
		model.addAttribute("posts",posts);
		return "post-confirmation";	
		}
	
	@RequestMapping("/view")
	public String viewPost(@RequestParam("viewId") Integer id,Model model){
		Post post=this.postService.getPostById(id);
		model.addAttribute("post",post);
		Comment comment=new Comment();
		model.addAttribute("comment",comment);
	   return "view-post";
	}
	
	@RequestMapping("/comment")
	public String addComment(@ModelAttribute("comments") Comment comment,Model model,@RequestParam("viewId") Integer id) {
		this.postService.addComment(comment,id);
		System.out.println(id);
		model.addAttribute("viewId", id);
		return "redirect:/view";
	}
	
	@RequestMapping("/deleteComment")
	public String deleteComment(@RequestParam("deleteId") Integer id,@RequestParam("postId") Integer postId,Model model) {
	   this.commentService.deleteComment(id,postId);
	   model.addAttribute("viewId",postId);
		return "redirect:/view";
	}
	
	
	@RequestMapping("/updateComment")
	public String updateComment(@RequestParam("updateId") Integer commentId,@RequestParam("postId") Integer postId,Model model) {
		Comment comment=this.commentService.getComment(commentId);
		this.commentService.addComment(comment);
		this.commentService.deleteComment(commentId, postId);
		model.addAttribute("comment",comment);
		Post post=this.postService.getPostById(postId);
		model.addAttribute("post",post);
		return "view-post";
	}
	@RequestMapping("/filter")
	public String filter(@RequestParam("author") String name,Model model) {
		List<Post> posts=this.postService.searchpost(name);
		model.addAttribute("posts",posts);
		return "post-confirmation";		
	}
	
	
	
}
