package org.sid.service;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.sid.dao.PublicationRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Publication;
import org.sid.entities.User;
import org.sid.metier.PublicationMetier;
import org.sid.metier.UserMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Publication2 {
	
	@Autowired
	private PublicationMetier publicationMetier;
	@Autowired
	private UserMetier userMetier;
	
	@Autowired
	private PublicationRepository   publicationRepository;
	

	@RequestMapping(value="/treyb" ,method=RequestMethod.POST)
	
	public void SavePhoto(HttpServletRequest httpServletRequest ,HttpServletResponse response,
	        @RequestParam(value="fileUpload" ,required = true) MultipartFile[] fileUpload) throws Exception {
		
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		String login=securityContext.getAuthentication().getName();
		
		 User user=userMetier.findUser(login);		
		
		
	    if (fileUpload != null && fileUpload.length > 0) {
	        for (MultipartFile file : fileUpload){
				
	        	
	        	Publication p=new Publication();
		 /*on Prépare les flux*/
	    BufferedInputStream entree = null;
	    BufferedOutputStream sortie = null;
	    
		//On peut ensuite récupérer quelques informations (comme son type et sa taille) sur le fichier distant
	         String fileType = file.getContentType();
	        double fileLength = file.getSize();
	    
	  /*extraire l'extension*/
	    String fichier =file.getOriginalFilename();//récupère le nom du fichier
	    String extension = fichier.substring(fichier.lastIndexOf(".")+1); //récupère l'extention 
	   
	    System.out.println(extension);
	 /*le lien de destination*/
		String lienFichier="C:/Users/aicha/workspace123/jobnetworkVersion1/src/main/resources/static/image";


		/*Ici, nous pourrions très bien utiliser directement les flux de type InputStream et FileOutputStream, 
		* mais les objets BufferedInputStream et BufferedOutputStream permettent, 
		* via l'utilisation d'une mémoire tampon, 
		* une gestion plus souple de la mémoire disponible sur le serveur
		*/
		
		
		try {
	        /* Ouvre les flux. */
	        entree = new BufferedInputStream( file.getInputStream());
	        sortie = new BufferedOutputStream(new FileOutputStream(lienFichier+"/"+user.getUsername()+"."+extension));
	        System.out.println(extension);
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
	    p.setLien("/image/"+user.getUsername()+".jpg");
	
	    publicationMetier.save(p);
	 response.sendRedirect("final.html");
	    
	    
	    }}

		
		
		
		
		
		
		}
			
			
			
}