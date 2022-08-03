package com.blogapp.services;

import java.util.List;

import com.blogapp.payloads.PostDto;
import com.blogapp.payloads.PostResponse;

public interface PostService {

	// create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	// Update
	PostDto updatePost(PostDto postDto, Integer postId);

	// delete
	void deletePost(Integer postId);

	// Get all post

	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

	// getPostById

	PostDto getPostById(Integer id);

	// get by user
	List<PostDto> getPostByUser(Integer userId);

	// get by category

	List<PostDto> getPostByCategory(Integer categoryId);

	// search by keyword
	List<PostDto> searchPosts(String keyword);

}
