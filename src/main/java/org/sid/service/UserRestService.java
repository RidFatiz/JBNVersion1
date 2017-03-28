package org.sid.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.sid.dao.*;
import org.sid.entities.*;

import org.sid.metier.SimpleMessage;
import org.sid.metier.UserMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//@Secured(value={"ROLE_Candidat","ROLE_Recruteur"})
@RestController
public class UserRestService {
	
	@Autowired
	private UserMetier userMetier;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SimpleMessage simpleMessage;
	

	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List <Object> findAllUsers() {
		return userRepository.get();
	}
	
	
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public Object saveUser(@RequestBody @Valid User u, BindingResult bindingResult) throws Exception {
		//if(bindingResult.hasErrors()){
			//Map<String, Object> errors=new HashMap<>();
			//errors.put("errors", true);
			//for(FieldError fe: bindingResult.getFieldErrors()){
			//	errors.put(fe.getField(), fe.getDefaultMessage());
			//	return  errors;
			//}
		 //}
		//	String body = "<h1>bonjour, veuillez confirmer votre inscription à JobNetwork</h1><br/>"
		//		       +"vos informations<br/>votre nom :"+u.getUsername()+"<br/>mot de passe :"+u.getPassword()
		//		   //request.scheme://${request.serverName}:${request.serverPort}${request.contextPath}
		//		       + "<br/><form method='POST' action='http://127.0.0.1:8080/activerUser'><input type='submit' value='confirmer'/></form>";
		//	u.setPassword(passwordEncoder.encode(u.getPassword()));

		//	simpleMessage.send(u.getEmail(), "Mail de confirmation",body );
    		return userMetier.saveUser(u);
		
	}
	
	
	
	@RequestMapping(value="/user/{username}",method=RequestMethod.PUT)
	public void Update(@RequestParam User u, @PathVariable String username) {
		userMetier.Update(u, username);
	}



	@RequestMapping(value="/activerUser",method=RequestMethod.POST)
	public void activerUser(HttpServletResponse response,String username) throws IOException {
		userMetier.activerUser(username);
		response.sendRedirect("/index.html");
		
	}

	
	@RequestMapping(value="/u/{username}",method=RequestMethod.GET)
	
	public User findUser(@PathVariable String username) {
		return userMetier.findUser(username);
	}
	
	
	
	@RequestMapping(value="/getLogerUser")
	public User  getLogerUser(Model model, HttpServletRequest httpServletRequest){
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		String username=securityContext.getAuthentication().getName();
		List<String> roles=new ArrayList<>();
		for(GrantedAuthority ga:securityContext.getAuthentication().getAuthorities()){
			roles.add(ga.getAuthority());
		}
		 User user=userMetier.findUser(username);
		 
		 model.addAttribute("user", user);	
		 return user;
		
	}
	
	@RequestMapping(value="/MailUpdatePassword",method=RequestMethod.POST)
	public Boolean MailUpdatePassword(HttpServletResponse response, 
			                         @RequestParam(name="mail") String mail) throws MessagingException  {
		
		 String email=userMetier.getUserByEmail(mail).getEmail();
		if(email != null){
			String body = "<h1>bonjour, veuillez confirmer si vous voulez changer de mot de passe</h1><br/>"
				    
				   //request.scheme://${request.serverName}:${request.serverPort}${request.contextPath}
				       + "<br/><a href='http://localhost:8080/forgetPassword.html?name="+email+"'>"
				       + "changer le mot de passe</a>";
			

			simpleMessage.send(email, "Changer mot de passe",body );
			/*try {
				response.sendRedirect("/forgetPassword.html");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			return true;
			
		}else{
			return false;
		}	
		
	}
	
	@RequestMapping(value="/updatePassword" ,method=RequestMethod.POST)
	public String UpdatePassword(
			@RequestParam( name="old") String Oldpassword,
			@RequestParam( name="new") String Newpassword,HttpServletRequest httpServletRequest,HttpServletResponse response ) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		String username=securityContext.getAuthentication().getName();
		
		 User user=userMetier.findUser(username);
		System.out.println(user.getPassword());
		System.out.println(Newpassword);
		System.out.println(Oldpassword);
		if(user.getPassword().equals(Oldpassword)){
			
			user.setPassword(passwordEncoder.encode(Newpassword));
			
			userRepository.save(user) ;
		  return "valid";
	}
		
		else {
			return "invalid";
			
		}
		
		
	}
	
	@RequestMapping(value="/updatepasswordforget" ,method=RequestMethod.POST)
	public void mailChangePassword(@RequestParam( name="password")String password,
			                       @RequestParam( name="mail")String mail,
			HttpServletRequest httpServletRequest,HttpServletResponse response ) {
		
		User u=userMetier.getUserByEmail(mail);
		u.setPassword(passwordEncoder.encode(password));
		//u.setPassword(password);
		userRepository.save(u);
		try {
			response.sendRedirect("/login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@RequestMapping(value="/updateGmail" ,method=RequestMethod.POST)
	public String UpdateGmail(@RequestParam( name="NewGmail") String NewGmail,HttpServletRequest httpServletRequest,HttpServletResponse response ) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		String username=securityContext.getAuthentication().getName();
		 User user=userMetier.findUser(username);
		 
		
		 user.setEmail(NewGmail);
			
		userRepository.save(user) ;
		  return "valid";
	
		
	}
	
	
	
}


