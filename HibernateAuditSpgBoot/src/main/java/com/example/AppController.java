package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@Autowired
	BookDao dao;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)	
	public ResponseEntity addBook()
	{
		int randomInt= (int) Math.random() * 10;
		String bookName = "Book_"+randomInt;
		String authorName = "Author_"+randomInt;
		
		Book b = new Book();
		b.setBookName(bookName);
		b.setAuthorName(authorName);
		
		try
		{
			dao.save(b);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity(b, HttpStatus.OK);
	}

	/*
	@RequestMapping(value="/update", method=RequestMethod.POST)	
	public ResponseEntity updateUser(@RequestBody User user)
	{
		try
		{
			dao.save(user);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity(user, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)	
	public ResponseEntity deleteUser(@RequestBody User user)
	{
		try
		{
			dao.delete(user);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity(user, HttpStatus.OK);
	}
	*/
	
}
