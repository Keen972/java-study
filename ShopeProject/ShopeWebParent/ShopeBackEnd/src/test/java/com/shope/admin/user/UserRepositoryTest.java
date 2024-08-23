package com.shope.admin.user;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.CALLS_REAL_METHODS;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import com.shope.common.entity.Role;
import com.shope.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// Rollback을 해줘야 database에 입력이 됨
@Rollback(false)
public class UserRepositoryTest {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
//	
//	//JUnit test
//	@Test
//	public void testCreateUserwithOneRole() {
//		//Role에 첫번째(Admin) 가져와서 roleAdmin에 담는다
//	    Role roleAdmin = entityManager.find(Role.class,1);
//	     
//	    User userDavid = new User("david@email.com", "david2023", "David", "Juda");
//	    userDavid.addRole(roleAdmin);       
//	     
//	    User savedUser = repo.save(userDavid);
//	    assertThat(savedUser.getId()).isGreaterThan(0);
//	}
//	
//	@Test
//	public void testCreateUserwithTwoRole() {
//		//Role에 3,5번째 가져와서 각 변수에 담는다(2가지 방법)
//	    Role roleEditor = entityManager.find(Role.class,3);
//	    Role roleAssistant = new Role(5);
//	     
//	    User userMaria = new User("maria@email.com", "maria2023", "Maria", "Magdaline");
//	    userMaria.addRole(roleEditor);     
//	    userMaria.addRole(roleAssistant);  
//	     
//	    User savedUser = repo.save(userMaria);
//	    assertThat(savedUser.getId()).isGreaterThan(0);
//	}
//	
//	@Test
//	public void testListAllUsers() {
//		Iterable<User> listUsers = repo.findAll();
//		listUsers.forEach(user -> System.out.println(user));
//	}
//	
//	@Test
//	public void testGetUserById() {
//		//3가지 방법
//		User userDavid = repo.findById(1).get();
////		User userDavid = repo.findById(1).orElse(null);
////		Optional<User> userDavid = repo.findById(1);
//		System.out.println(userDavid);
//		assertThat(userDavid).isNotNull();
//	}
//	
//	@Test
//	public void testUpdateUserDetails() {
//		User userDavid = repo.findById(1).get();
//		userDavid.setEnabled(true);
//		userDavid.setEmail("sadfsadf@email.com");
//	    repo.save(userDavid);
//	}
//	
//	@Test
//	public void testUpdateUserRoles() {
//		User userMaria = repo.findById(2).get();
//		Role roleShipper = new Role(4);
//		Role roleEditor = entityManager.find(Role.class,3);
//		userMaria.getRoles().remove(roleShipper);
////		userMaria.deleteRole(roleEditor);
//		userMaria.addRole(roleEditor);
//		
//	    repo.save(userMaria);
//	}
//	
//	@Test
//	public void testDeleteUser() {
//		User userMaria = repo.findById(2).get();
//		Iterable<User> roleUser = repo.findAll();
//	    userMaria.deleteRole(roleUser);
//	     
//	    repo.delete(userMaria);
//	}
	
//	@Test
//	public void testCheckDupEmail() {
//		String checkEmail = "test@email.com";
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>" + repo.findByEmail(checkEmail).isEmpty());
//		assertThat(repo.findByEmail(checkEmail)).isEmpty();
//	}
	
//	@Test
//	public void testGetUserByEmail() {
//		String email = "test@email.com";
//		User user = repo.getUserbyEmail(email);
//		assertThat(user).isNotNull();
//	}
	
//	@Test
//	public void testCountById() {
//		Integer id = 1;
//		Long countById = repo.countById(id);
//		assertThat(countById).isNotNull().isGreaterThan(0);
//	}
//
//	@Test
//	public void testUpdateEnabedStatus() {
//		Integer id = 5;
//		boolean enabled = true;
//		repo.updateEnabedStatus(id, enabled);
//		
//	}
//	
//	@Test
//	public void testListFirstPage() {
//		
//		int pageNumber = 1;
//		
//		int pageSize = 4;
//		
//		Pageable pageable = PageRequest.of(pageNumber, pageSize);
//		Page<User> page = repo.findAll(pageable);
//		
//		List<User> listUsers = page.getContent();
//		listUsers.forEach(System.out::println);
//		assertThat(listUsers.size()).isEqualTo(pageSize);
//	}
	
	@Test
	public void testSearchUsers() {
		String keyword = "First";
		
		int pageNum = 0;
		int pageSize = 4;
		
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		Page<User> page = repo.findAll(keyword, pageable);
		
		List<User> listUsers = page.getContent();
		
		listUsers.forEach(user -> System.out.println(user));
		
		assertThat(listUsers.size()).isGreaterThan(0);

	}
	

	
}
