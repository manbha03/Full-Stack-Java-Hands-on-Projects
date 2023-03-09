package com.medicare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medicare.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("Select p FROM Product p WHERE p.avail='yes' ORDER BY 'category'")
	List<Product> findIfAvail();
	
	@Query("SELECT p FROM Product p WHERE (p.avail LIKE 'yes') AND (p.name LIKE %?1%"
			+" OR p.des LIKE %?1%"
			+" OR p.price LIKE %?1%"
			+" OR p.category LIKE %?1%)")
	public List<Product> homeSearch(String keyword);
	
	@Query("SELECT p FROM Product p WHERE p.category LIKE 'pain killers' AND p.avail LIKE 'yes'")
	public List<Product> getPainkillers();
	
	@Query("SELECT p FROM Product p WHERE p.category LIKE 'acidity' AND p.avail LIKE 'yes'")
	public List<Product> getAcidity();
	
	@Query("SELECT p FROM Product p WHERE p.category LIKE 'cold' AND p.avail LIKE 'yes'")
	public List<Product> getCold();
	
	@Query("SELECT p FROM Product p WHERE p.category LIKE 'headache' AND p.avail LIKE 'yes'")
	public List<Product> getHeadache();
}
