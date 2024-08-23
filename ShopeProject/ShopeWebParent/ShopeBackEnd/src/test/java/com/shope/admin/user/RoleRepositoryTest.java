package com.shope.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shope.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// Rollback을 해줘야 database에 입력이 됨
@Rollback(false)
public class RoleRepositoryTest {

//	@Autowired
//	private RoleRepository repo;
//	
//	//JUnit test
//	@Test
//	public void testCreateFirstRole() {
//		Role roleAdmin = new Role("Admin", "manage everthing");
//		Role savedRole = repo.save(roleAdmin);
//		assertThat(savedRole.getId()).isGreaterThan(0); //input된값이 0보다 큰지 확인
//	}
//	
//	@Test
//	public void testCreateSecondRole() {
//		ArrayList<Role> addRole = new ArrayList<Role>();
//		addRole.add(new Role("Salesperson", "manage product price, customers, shipping, orders, and sales report"));
//		addRole.add(new Role("Editor", "manage categories, brands, products, articles and menus"));
//		addRole.add(new Role("Shipper", "view products, view orders and update order status"));
//		addRole.add(new Role("Assistant", "manage questions and reviews"));
//		repo.saveAll(addRole);
//	}
}
