package org.sid.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import org.sid.dao.GroupeUserRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Groupe;
import org.sid.entities.GroupeUser;
import org.sid.entities.User;

import org.sid.metier.GroupeUserMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupeUserService {
	
	
	@Autowired
	private GroupeUserMetier groupeUserMetier;
	
	@Autowired
	private GroupeUserRepository groupeUserRepository;
	
	@Autowired
	private UserRepository   userRepository ;
	
	
	
	@RequestMapping(value="/Groupeuser/{groupe}",method=RequestMethod.POST)
	public GroupeUser save( GroupeUser groupeuser,Long id,HttpServletRequest httpServletRequest,@PathVariable Groupe groupe ) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		String login=securityContext.getAuthentication().getName();
		User user= userRepository.getUser(login);
		groupeuser.setDate(new Date());
		groupeuser.setUser(user);
		groupeuser.setGroupe(groupe);
		return groupeUserMetier.save(groupeuser);
	}
	
	@RequestMapping(value="/AccepterGroupeUser/{id}",method=RequestMethod.PUT)
	public GroupeUser AccepterUser(@PathVariable Long id) {
		return groupeUserMetier.AccepterUser(id);
	}

	
	
	@RequestMapping(value="/findUser",method=RequestMethod.GET)
	public List<GroupeUser> findUserGroupe(String username,HttpServletRequest httpServletRequest) {
		
		
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		
	 username=securityContext.getAuthentication().getName();
	 

	 
		return groupeUserMetier.findUserGroupe(username);
	}

	@RequestMapping(value="/deleteInvitation/{id}",method=RequestMethod.DELETE)
	public void deleteInvitation(@PathVariable Long id) {
		groupeUserMetier.deleteInvitation(id);
	}

	
	@RequestMapping(value="/groupeInvitation/{id}",method=RequestMethod.GET)
	public String  groupeInvitationExists( @PathVariable Long id ,String username,HttpServletRequest httpServletRequest) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		username=securityContext.getAuthentication().getName();
		return groupeUserMetier.groupeInvitationExists(id,username);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
