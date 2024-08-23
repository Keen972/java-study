package com.shope.admin.user;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shope.admin.FileUploadUtil;
import com.shope.common.entity.Role;
import com.shope.common.entity.User;

@Controller
public class UserController {
 
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	   public String listUsers(Model model) {
//	       List<User> listUsers = userService.listAll();
//	       model.addAttribute("listUsers", listUsers);
//	       
//	       System.out.println(listUsers);
	       return listByPage(1, "email", "asc", null, model);
	   }
	
	@GetMapping("/users/page/{pageNum}")
	public String listByPage(@PathVariable(name="pageNum") int pageNum,
			@RequestParam("sortField") String sortField, 
			@RequestParam("sortDir") String sortDir,
			@Param("keyword") String keyword,  Model model) {
		Page<User> page = userService.listByPage(pageNum, sortField, sortDir, keyword);
	    List<User> listUsers = page.getContent();
	    
	    long startCount = (pageNum - 1) * UserService.USERS_PER_PAGE +1;
	    long endCount = startCount + UserService.USERS_PER_PAGE -1;
	    if(endCount > page.getTotalElements()) {
	    	endCount = page.getTotalElements();
	    }
	    
	    final long PartPage = 5; //최대 보여줄 페이지 수
	    long totalPage = page.getTotalPages();
	      
	    long endPartPage = (long) Math.ceil((double)pageNum /PartPage)*PartPage;
	    long startPartPage = endPartPage-PartPage+1;
	    if(endPartPage > totalPage) {
	         endPartPage = totalPage;
	    }
	    
	    model.addAttribute("startPartPage", startPartPage);
	    model.addAttribute("endPartPage", endPartPage);

	    model.addAttribute("currentPage", pageNum);
	    model.addAttribute("totalPages", totalPage);
	    model.addAttribute("startCount", startCount);
	    model.addAttribute("endCount", endCount);
	    model.addAttribute("totalItems", page.getTotalElements());
	    model.addAttribute("listUsers", listUsers);
	    
	    String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
	    model.addAttribute("reverseSortDir", reverseSortDir);
	    model.addAttribute("sortDir", sortDir);
	    model.addAttribute("sortField", sortField);
	    
	    model.addAttribute("keyword", keyword);
	    
	    return "users";
	}
	
	@GetMapping("/users/create")
	public String addUsers(Model model) {
		User listUsers = new User();
		listUsers.setEnabled(true);
		model.addAttribute("user", listUsers);
		List<Role> listRole = userService.roleList();
		model.addAttribute("listRole",listRole);
		model.addAttribute("pageTitle", "Create New User");
		return "user_form";
	}
	
	@PostMapping("/users/save")
	public String saveUser(@ModelAttribute("user") User user, 
			@RequestParam("image") MultipartFile multipartFile ,RedirectAttributes redirectAttributes) throws IOException{
		
		if(!multipartFile.isEmpty()) {
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			user.setPhotos(fileName);
			
			User savedUser = userService.save(user);
			
			String uploadDir = "user-photos/" + savedUser.getId();
			FileUploadUtil.clearDirectory(uploadDir);
			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		}else {
			if(user.getPhotos().isEmpty()) user.setPhotos(null);
			userService.save(user);
		}
		
		redirectAttributes.addFlashAttribute("message", "The user has been saved successfully");
		return "redirect:/users";
	}
	

	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable(name="id") Integer id, Model model, RedirectAttributes redirectAttributes){
		try {
			User user = userService.findById(id);
			List<Role> listRoles = userService.roleList();
			model.addAttribute("user", user);
			model.addAttribute("pageTitle", "Edit User (ID : " + id + ")");
			model.addAttribute("listRole", listRoles);
			return "user_form";
		}catch(UserNotFoundException ex) {
			redirectAttributes.addFlashAttribute("message", ex.getMessage());
			return "redirect:/users";
		}
		
	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes){
		try {
			userService.deleteById(id);
			redirectAttributes.addFlashAttribute("message", "The user ID "+id+" has been deleted successfully");
		}catch(UserNotFoundException ex) {
			redirectAttributes.addFlashAttribute("message", ex.getMessage());
			
		}
		return "redirect:/users";
	}
	
	@GetMapping("/users/{id}/enabled/{status}")
	public String editUserEnable(@PathVariable("id") Integer id, 
			@PathVariable("status") boolean enabled, RedirectAttributes redirectAttributes){
		try {
			userService.updateEnabedStatus(id, enabled);
			String status = enabled ? "enabled" : "disabled";
			
			String message = "The user ID " + id + " has been " + status;
			redirectAttributes.addFlashAttribute("message", message);
		}catch(UserNotFoundException ex) {
			redirectAttributes.addFlashAttribute("message", ex.getMessage());
		}
		
		return "redirect:/users";
	}
	
}
