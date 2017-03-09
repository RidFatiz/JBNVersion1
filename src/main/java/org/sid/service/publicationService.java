package org.sid.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.sid.dao.PublicationRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Publication;
import org.sid.entities.User;

//import com.example.entities.Text;

import org.sid.metier.PublicationMetier;
@Secured(value={"ROLE_Candidat","ROLE_Recruteur"})
@RestController
public class publicationService {
	
	@Autowired
	private PublicationMetier publicationMetier;
	
	
	@Autowired
	private UserRepository   userRepository ;
	
	@Autowired
	private PublicationRepository   publicationRepository ;
	

	@RequestMapping(value="/publication" ,method=RequestMethod.POST)
	
	public @ResponseBody void save( HttpServletRequest httpServletRequest,HttpServletResponse response,
			@RequestParam(value="file",required = true) MultipartFile [] fileUpload,
			@RequestParam(value="description",required = true) String description
           ) throws Exception{
		
		Publication p=new   Publication();
		
		p.setDatePublication(new Date());
	
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		String login=securityContext.getAuthentication().getName();
		
	  User user= userRepository.getUser(login);
	  
	  
	  if (fileUpload != null && fileUpload.length > 0) {
          for (MultipartFile file : fileUpload){
				
		 /*on Prépare les flux*/
	    BufferedInputStream entree = null;
	    BufferedOutputStream sortie = null;
	    
		//On peut ensuite récupérer quelques informations (comme son type et sa taille) sur le fichier distant
           String fileType = file.getContentType();
          double fileLength = file.getSize();
      
    /*extraire l'extension*/
      String fichier =file.getOriginalFilename();//récupère le nom du fichier
      String extension = fichier.substring(fichier.lastIndexOf(".")+1); //récupère l'extention 
     
      
   /*le lien de destination*/
  	String lienFichier="C:/Users/aicha/workspace123/jobnetworkVersion1/src/main/resources/static/imagePublication";
  /* on enregistre le fichier dans bdd*/	
  	
  
    
      
      /* extraire l'Id du fichier enregistré*/
      Long nom=p.getId();
  	
  	/*Ici, nous pourrions très bien utiliser directement les flux de type InputStream et FileOutputStream, 
  	* mais les objets BufferedInputStream et BufferedOutputStream permettent, 
  	* via l'utilisation d'une mémoire tampon, 
  	* une gestion plus souple de la mémoire disponible sur le serveur
  	*/
  	
  	
  	try {
  	 
          /* Ouvre les flux. */
          entree = new BufferedInputStream( file.getInputStream() );
          sortie = new BufferedOutputStream( new FileOutputStream(lienFichier+"/"+user.getUsername()+"."+extension));
          /*
           * Lit le fichier reçu et écrit son contenu dans un fichier sur le
           * disque.
           */
          byte[] buffer = new byte[1024];
          int read;
          while ((read = entree.read(buffer)) > 0)
      		sortie.write(buffer, 0, read);
          
        //libérer les ressources
          
          /*toujours ouvrir les flux dans un bloc try, et les fermer dans le bloc finally associé. 
           *Ainsi, nous nous assurons, quoi qu'il arrive, que la fermeture de nos flux sera bien effectuée
          */
      }finally {
          try {
                sortie.close();
              } catch ( IOException ignore ) { }
          
          try {
                entree.close();
              } catch ( IOException ignore ) { }
         }
		
  	
      //modifier les données dans la bdd du fichier actuel
  
      p.setLien("/imagePublication/"+user.getUsername()+".jpg");
      p.setDescription(description);
      p.setUser(user);
	  publicationMetier.save(p);
		
      //System.out.println(user.getRole());
     if(user.getRole().equals("Candidat"))
        {response.sendRedirect("final.html");
        }
     else 
    	 {response.sendRedirect("FinalR.html");}

     

      
      }}
	
		}
	
	@RequestMapping(value="/publication" ,method=RequestMethod.GET)
	public List<Publication> find(String username,HttpServletRequest httpServletRequest) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		username=securityContext.getAuthentication().getName();
		return publicationMetier.find(username);
	}
	
	@RequestMapping(value="/publicationUser" ,method=RequestMethod.GET)
	public List<Publication> findbyMembre( HttpServletRequest httpServletRequest) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		String login=securityContext.getAuthentication().getName();
		
	  
		
		
		return publicationMetier.findbyMembre(login);
	}

	@RequestMapping(value="/myPub/{id}" ,method=RequestMethod.GET)
	public Publication findPublication(@PathVariable Long id) {
		return publicationMetier.findPublication(id);
	}

	@RequestMapping(value="deletePublication/{id}" ,method=RequestMethod.DELETE)
	public void delete(@PathVariable  Long id) {
		
		
		
		publicationMetier.delete(id);
	}

	@RequestMapping(value="/count/{username}" ,method=RequestMethod.GET)
	public String findCountParUser(@PathVariable String username,HttpServletRequest httpServletRequest) {
		
		
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
	username=securityContext.getAuthentication().getName();
		
		
		return publicationRepository.findCountParUser(username);
	}
	
	
	
	
	
	
	
}
