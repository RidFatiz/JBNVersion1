package org.sid.service;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.sid.dao.CandidatRepository;
import org.sid.entities.Candidat;
import org.sid.entities.User;
import org.sid.metier.CandidatMetier;
import org.sid.metier.UserMetier;


@Secured(value={"ROLE_Candidat"})
@RestController
public class CandidatRestService {
	
@Autowired
private CandidatMetier candidatMetier;
@Autowired
private UserMetier userMetier;
@Autowired

private CandidatRepository candidatRepository;

@RequestMapping(value="/candidat" ,method=RequestMethod.GET)
public List<Candidat> getCandidat() {
	return candidatMetier.getCandidat();
}

@RequestMapping(value="/candidat" ,method=RequestMethod.POST)
public Candidat save(@RequestBody  Candidat c) {
	
	return candidatMetier.save(c);
}

@RequestMapping(value="/candidat/{username}" ,method=RequestMethod.GET)
public Candidat findcandidat(@PathVariable String username) {
	return candidatMetier.findcandidat(username);
}

@RequestMapping(value="/savecv" ,method=RequestMethod.POST )
public void SaveCv(HttpServletRequest httpServletRequest ,HttpServletResponse response,
        @RequestParam(value="fileUpload" ,required = true) MultipartFile[] fileUpload) throws Exception {
	HttpSession session=httpServletRequest.getSession(true);
	SecurityContext securityContext=(SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
	
	String login=securityContext.getAuthentication().getName();
	Candidat candidat=candidatMetier.findcandidat(login);
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
	String lienFichier="C:/Users/aicha/workspace123/jobnetworkVersion1/src/main/resources/static/image";

	
	candidat.setLienCv(lienFichier+fichier);
	candidatMetier.save(candidat);
     
     /* extraire l'Id du fichier enregistré*/
    

	/*Ici, nous pourrions très bien utiliser directement les flux de type InputStream et FileOutputStream, 
	* mais les objets BufferedInputStream et BufferedOutputStream permettent, 
	* via l'utilisation d'une mémoire tampon, 
	* une gestion plus souple de la mémoire disponible sur le serveur
	*/
	
	
	try {
        /* Ouvre les flux. */
        entree = new BufferedInputStream( file.getInputStream() );
        sortie = new BufferedOutputStream( new FileOutputStream(lienFichier+"/"+candidat.getUsername()+"."+extension));
 
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
	
	
	candidat.setLienCv("Cv_"+candidat.getNom()+"."+candidat.getPrenom()+".pdf");
	candidatMetier.save(candidat);
    
   response.sendRedirect("cand.html#/cvLettre");
    }}
	}


@RequestMapping(value="/savelettre" ,method=RequestMethod.POST )
public void SaveLettre(HttpServletRequest httpServletRequest ,HttpServletResponse response,
        @RequestParam(value="fileUpload" ,required = true) MultipartFile[] fileUpload) throws Exception {
	HttpSession session=httpServletRequest.getSession(true);
	SecurityContext securityContext=(SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
	
	String login=securityContext.getAuthentication().getName();
	Candidat candidat=candidatMetier.findcandidat(login);
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
	String lienFichier="C:/Users/aicha/workspace123/jobnetworkVersion1/src/main/resources/static/image";


	/*Ici, nous pourrions très bien utiliser directement les flux de type InputStream et FileOutputStream, 
	* mais les objets BufferedInputStream et BufferedOutputStream permettent, 
	* via l'utilisation d'une mémoire tampon, 
	* une gestion plus souple de la mémoire disponible sur le serveur
	*/
	
	
	try {
        /* Ouvre les flux. */
        entree = new BufferedInputStream( file.getInputStream() );
        sortie = new BufferedOutputStream( new FileOutputStream(lienFichier+"/"+candidat.getUsername()+"."+extension));
 
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
	
	
	candidat.setLettreMotiv("Lettre_"+candidat.getNom()+"."+candidat.getPrenom()+".pdf");
	candidatMetier.save(candidat);
    
   response.sendRedirect("cand.html#/cvLettre");
    }}
	}



@RequestMapping(value="/deletecv/{username}" ,method=RequestMethod.POST)
public void DeleteCv(HttpServletRequest httpServletRequest ,HttpServletResponse response,@PathVariable String username ) throws Exception {
	HttpSession session=httpServletRequest.getSession(true);
	SecurityContext securityContext=(SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
	username=securityContext.getAuthentication().getName();
	Candidat candidat=candidatMetier.findcandidat(username);
	String photo=candidat.getLienCv();
	candidat.setLienCv(null);
	candidatMetier.save(candidat);
	 
    response.sendRedirect("completerCandidat.html");
	}

@RequestMapping(value="/deletelettre/{username}" ,method=RequestMethod.POST)
public void DeleteLettre(HttpServletRequest httpServletRequest ,HttpServletResponse response,@PathVariable String username ) throws Exception {
	HttpSession session=httpServletRequest.getSession(true);
	SecurityContext securityContext=(SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
	username=securityContext.getAuthentication().getName();
	Candidat candidat=candidatMetier.findcandidat(username);
	String lettre=candidat.getLettreMotiv();
	candidat.setLettreMotiv(null);
	candidatMetier.save(candidat);
	 
    response.sendRedirect("completerCandidat.html");
	}


@RequestMapping(value="/noteProfil" ,method=RequestMethod.GET)
public int  ifExist(String usename,HttpServletRequest httpServletRequest) {
	
	HttpSession session=httpServletRequest.getSession(true);
	SecurityContext securityContext=(SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
	usename=securityContext.getAuthentication().getName();
	Candidat candidat=candidatMetier.findcandidat(usename);
	
	if((candidat.getLienCv()==null) && (candidat.getPhoto()==null))
	
	{  return 0;  }
	else if((candidat.getLienCv()==null) && (candidat.getPhoto()!=null))
	{ return 12;}
	else if ((candidat.getLienCv()!= null) && (candidat.getPhoto()==null))
	{return 12;}
	else 
	{return 25;}
	
}

@RequestMapping(value="/savephoto" ,method=RequestMethod.POST )
public void SavePhoto(HttpServletRequest httpServletRequest ,HttpServletResponse response,
        @RequestParam(value="fileUpload" ,required = true) MultipartFile[] fileUpload) throws Exception {
	
	HttpSession session=httpServletRequest.getSession(true);
	SecurityContext securityContext=(SecurityContext) session
			          .getAttribute("SPRING_SECURITY_CONTEXT");
	
	 String login=securityContext.getAuthentication().getName();
	 User user=userMetier.findUser(login);
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
	String lienFichier="C:/Users/aicha/workspace123/jobnetworkVersion1/src/main/resources/static/image";


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
    user.setPhoto("/image/"+user.getUsername()+"."+extension);
    userMetier.saveUser(user);
    
 response.sendRedirect("final.html");
    
    
    }}

	}
@RequestMapping(value="/deletephoto/{username}" ,method=RequestMethod.POST)
public void DeletePhoto(HttpServletRequest httpServletRequest ,HttpServletResponse response,@PathVariable String username ) throws Exception {
	
      
	
	HttpSession session=httpServletRequest.getSession(true);
	SecurityContext securityContext=(SecurityContext) session
			          .getAttribute("SPRING_SECURITY_CONTEXT");
	
	 username=securityContext.getAuthentication().getName();
	
	 User user=userMetier.findUser(username);
	 String photo=user.getPhoto();
	 
	 user.setPhoto(null);
	
	 userMetier.saveUser(user);
	 
	 
   
    
 response.sendRedirect("completerCandidat.html");
    
	}







}
