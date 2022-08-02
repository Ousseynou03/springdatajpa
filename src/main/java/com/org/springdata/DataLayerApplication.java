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

import javax.transaction.Transactional;
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
	@Transactional
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

		System.out.println("---------------------------------------------Comments id=1-----------------------------------------------");
		Optional<Comment> optComment = commentService.getCommentsById(1);
		Comment comment = optComment.get();
		System.out.println(comment.getCommentId());

		//Récupération d'un produit associé à un commentaire
		System.out.println("---------------------------------------------Produit associé-----------------------------------------------");
		productId1.getComments().forEach(
				product -> System.out.println(product.getContent())
		);

		System.out.println("---------------------------------------------Liste des produits dans chaque categorie-----------------------------------------------");
        category1.getProducts().forEach(product -> System.out.println(product.getName()));

		productId1.getCategories().forEach(
				category -> System.out.println(category.getName())
		);

		System.out.println("---------------------------------------------Ajout de Categories-----------------------------------------------");
		//NB: A éviter . Ceci correspond à une liason forte. Ça n'aide pas à l'évolubilité de l'application.
		Category newCategory = new Category();
		newCategory.setName("Promotion");

		newCategory = categoryService.addCategory(newCategory);

		categoryService.getCategories().forEach(
				category -> System.out.println(category.getName()));

		System.out.println("---------------------------------------------Ajout de Produits-----------------------------------------------");
		Product newProduct = new Product();
		newProduct.setName("AssuranceAuTiersFidelite");
		newProduct.setDescription("Les garanties de l'assurance au tiers à un prix moindre grâce à votre fidélité!");
		newProduct.setCost(1100);
		newProduct = productService.addProduct(newProduct);

		newCategory.addProduct(newProduct);

		newProduct = productService.addProduct(newProduct);

		productService.getProducts().forEach(
				product -> System.out.println(product.getName()));

		newProduct.getCategories().forEach(
				category -> System.out.println(category.getName()));


		Comment newComment = new Comment();
		newComment.setContent("Assurance extraordinaire!");
		newProduct.addComment(newComment);

		commentService.addComment(newComment);

		//Update product
		Product existingProduct = productService.getProductById(1).get();
		System.out.println(existingProduct.getCost());

		//ON va changer la valeur du coût. on fait appel à la variable existingProduct avec l'encapsulation set pour la modification
		existingProduct.setCost(3000);
		productService.addProduct(existingProduct);

		existingProduct = productService.getProductById(1).get();
		System.out.println(existingProduct.getCost());









	}

	
}
