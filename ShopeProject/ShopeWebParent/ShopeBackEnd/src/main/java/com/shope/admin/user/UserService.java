package com.shope.admin.user;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shope.common.entity.Role;
import com.shope.common.entity.User;

@Service
@Transactional
public class UserService {
	public static final int USERS_PER_PAGE = 4;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleReop;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> listAll() {
		return (List<User>) userRepo.findAll();
	}
	
	public Page<User> listByPage(int pageNum, String sortField, String sortDir, String keyword) {
		Sort sort = Sort.by(sortField);
		sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
		Pageable pageable = PageRequest.of(pageNum -1, USERS_PER_PAGE, sort);
		if(keyword != null) {
			return userRepo.findAll(keyword, pageable);
		}
		return userRepo.findAll(pageable);
	}
	
	public List<Role> roleList(){
		return (List<Role>) roleReop.findAll();
	}
	
	public List<User> checkDupEmail(String checkEmail) {
		return (List<User>) userRepo.findByEmail(checkEmail);
	}
	
//	public void save(User user) {
//		encodePassword(user);
//		userRepo.save(user);	
//	}
	
	public User save(User user) {
		boolean isUpdatingUser = (user.getId() != null);
		if(isUpdatingUser) {
			User existingUser = userRepo.findById(user.getId()).get();
			if(user.getPassword().isEmpty()) {
				user.setPassword(existingUser.getPassword());
			}else {
				encodePassword(user);
			}
		}else {
			encodePassword(user);
		}
		return userRepo.save(user);	
	}
	
	
	public void encodePassword(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
	}

	public boolean isEmailUnique(Integer id, String email) {
		User userByEmail = userRepo.getUserbyEmail(email);
		if(userByEmail == null) return true;
		
		boolean isCreatingNew = (id == null); //신규생성은 id == null -> true
		
		if(isCreatingNew) {                         //==========신규생성==========
			if(userByEmail != null) return false;  //신규생성시 email 중복
		}else {                                    //=========기존유저 정보수정========
			if (userByEmail.getId() != id) {  
				return false;
			}
		}
		return true;
	}

	public User findById(Integer id) throws UserNotFoundException{
		try {
			return userRepo.findById(id).get();
		}catch(NoSuchElementException ex) {
			throw new UserNotFoundException("Could not find any user with ID " + id);
		}
		
	}

	public void deleteById(Integer id) throws UserNotFoundException{
		Long countById = userRepo.countById(id);
		if(countById == null || countById == 0) {
			throw new UserNotFoundException("Could not find any user with ID " + id);
		}
		userRepo.deleteById(id);
	}

	public void updateEnabedStatus(Integer id, boolean userEndabled)  throws UserNotFoundException{
		try {
			userRepo.updateEnabedStatus(id, userEndabled);
		}catch(NoSuchElementException ex) {
			throw new UserNotFoundException("Could not find any user with ID " + id);
		}
	}

	


	
}
