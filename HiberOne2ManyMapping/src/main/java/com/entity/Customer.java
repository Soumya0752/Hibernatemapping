package com.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cust_id")
    private int id;
	
	@Column(name="cust_name")
    private String name;
	
	@Column(name="cust_email")
    private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Cart cart;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Address> addresses;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="customer_product", joinColumns=@JoinColumn(name="cust_id"),inverseJoinColumns=@JoinColumn(name="product_id"))
	private Set<Product> products;


	public Customer(int id, String name, String email, Cart cart, List<Address> addresses, Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cart = cart;
		this.addresses = addresses;
		this.products = products;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public List<Address> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", cart=" + cart + ", addresses="
				+ addresses + ", products=" + products + "]";
	}
	
	
	
    
}
