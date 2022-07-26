package com.org.springdata;

import com.org.springdata.model.Category;
import com.org.springdata.model.Comment;
import com.org.springdata.model.Product;
import com.org.springdata.service.CategoryService;
import com.org.springdata.service.CommentService;
import com.org.springdata.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.Optional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("---------------------------------------------Liste des Produits-----------------------------------------------");

		Iterable<Product> products = productService.getProducts();
		products.forEach(
				product -> {System.out.println(product.getName());});
		System.out.println("---------------------------------------------Liste des Categories-----------------------------------------------");

		Iterable<Category> categories = categoryService.getCategories();
		categories.forEach(category->{ System.out.println(category.getName());});
		System.out.println("---------------------------------------------Liste des Commentaires-----------------------------------------------");

		Iterable<Comment> comments = commentService.getComments();
		comments.forEach(comment -> {System.out.println(comment.getContent());});

		System.out.println("---------------------------------------------Produit id=1-----------------------------------------------");
		Optional<Product> optProduct = productService.getProductById(1);
		Product productId1 = optProduct.get();
		System.out.println(productId1.getName());

		System.out.println("---------------------------------------------Category id=1-----------------------------------------------");
		Optional<Category> optCategory = categoryService.getCategorieById(1);
		Category category1 = optCategory.get();
		System.out.println(category1.getName());


	}
}
