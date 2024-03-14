package com.anudiphibernate27304;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Address;
import com.entity.Cart;
import com.entity.Customer;
import com.entity.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 Configuration cfg=new Configuration();
         cfg.configure("hibernate.cfg.xml");
         
         SessionFactory sf=cfg.buildSessionFactory();
         Session session=sf.openSession();
         
         try
         {
        	 Product p1=new Product();
        	 p1.setName("Redmi mobile");
        	 p1.setPrice(24000);
        	 
        	 Product p2=new Product();
        	 p2.setName("dell laptop");
        	 p2.setPrice(80000);
        	 
        	 Product p3=new Product();
        	 p3.setName("ear pods");
        	 p3.setPrice(2000);
        	 
        	 Set<Product> productlist1=new HashSet<Product>();
        	 productlist1.add(p1);
        	 productlist1.add(p2);
        	 productlist1.add(p3);
        	 
        	 Set<Product> productlist2=new HashSet<Product>();
        	 productlist2.add(p1);
        	 productlist2.add(p2);
        	 
        	 
        	 
         	 Customer c1=new Customer();
         	 c1.setName("Ram");
         	 c1.setEmail("ram@gmail.com");
         	 c1.setProducts(productlist1);
         	 
         	 Customer c2=new Customer();
        	 c2.setName("priya");
        	 c2.setEmail("priya@gmail.com");
        	 c2.setProducts(productlist2);
        	 
        	 Customer c3=new Customer();
         	 c3.setName("harsh");
         	 c3.setEmail("harsh@gmail.com");
         	 c3.setProducts(productlist2);
         	 
         	 Set<Customer> customers=new HashSet<Customer>();
         	 customers.add(c1);
         	customers.add(c2);
         	customers.add(c3);
         	 
         	 Cart cart1=new Cart();
             cart1.setPrice(106000);
             cart1.setCustomer(c1);
             
             Cart cart2=new Cart();
             cart2.setPrice(104000);
             cart2.setCustomer(c2);
             
             Cart cart3=new Cart();
             cart3.setPrice(104000);
             cart3.setCustomer(c3);
             
             c1.setCart(cart1);
             c2.setCart(cart2);
             c3.setCart(cart3);
         	 
         	 Address a1=new Address();
         	 a1.setCity("Delhi");
         	 a1.setPincode("451678");
         	 a1.setCustomer(c1);
         	 
         	 Address a2=new Address();
        	 a2.setCity("Mumbai");
        	 a2.setPincode("123678");
        	 a2.setCustomer(c1);
        	 
        	 Address a3=new Address();
        	 a3.setCity("Hyderabad");
        	 a3.setPincode("123654");
        	 a3.setCustomer(c1);
        	 //p1.setCustomers(customers);
        
            List<Address> addresses=new ArrayList<Address>();
            addresses.add(a1);
            addresses.add(a2);
            addresses.add(a3);
            
      
            c1.setAddresses(addresses);
          // c2.setAddresses(addresses2);
          // c3.setAddresses(addresses2);
            
           
         	
         	 Transaction transaction=session.beginTransaction();
         	 session.save(p1);
         	 session.save(p2);
         	 session.save(p3);
         	 session.save(c1);
         	 session.save(c2);
         	 session.save(c3);
         	 transaction.commit();
         	 
         	 
         }
         catch(Exception e)
         {
           e.printStackTrace();	
         }
         finally 
         {
         	session.close();
         	sf.close();
         }
         
     }
    
}
