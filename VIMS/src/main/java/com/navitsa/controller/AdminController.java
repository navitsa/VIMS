package com.navitsa.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navitsa.entity.CenterMaster;
import com.navitsa.entity.ConfigSystem;
import com.navitsa.entity.DocumentCheckDetails;
import com.navitsa.entity.IssueTicket;
import com.navitsa.entity.OcrDetails;
import com.navitsa.entity.TestLaneHead;
import com.navitsa.entity.TicketClose;
import com.navitsa.entity.Users;
import com.navitsa.entity.VehicleMaster;
import com.navitsa.entity.VehicleRegistration;
import com.navitsa.services.AdminServices;
import com.navitsa.services.CenterService;
import com.navitsa.services.UsersService;
import com.navitsa.services.VehicleService;
import com.navitsa.utils.FTPUploader;



@Controller
public class AdminController {

	@Autowired
	private AdminServices adminServices;
	@Autowired
	VehicleService vehicleService;
	@Autowired
	CenterService centerService;
	@Autowired
	UsersService usersService;
	
	 @RequestMapping(value = "/esin", method=RequestMethod.GET) 
	 public String esINCreate(Map<String, Object> model) { 
    	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
    	 Date date = new Date(); 
		 List<OcrDetails> ocrDetails=adminServices.completedVehiclesPayment(formatter.format(date));
		 model.put("completedVehiclesPayment", ocrDetails);
		 return "esin";
	  } //creaateEsin
	 
	
		@RequestMapping(value="/creaateEsin" ,method=RequestMethod.POST)
		public @ResponseBody String creaateEsin(@RequestParam String ocrid,HttpSession session) {
		
	        	try {
	        		
	        		VehicleRegistration vehiclereg=vehicleService.getRegistrationByRegisterId(ocrid);
	        		
	        		CenterMaster centerMaster=centerService.getcenterById(vehiclereg.getCentermaster().getCenter_ID());
	        	
	        		VehicleMaster vehicleMaster = vehicleService.getVMasterById(vehiclereg.getVid().getVehicleID());
	        		
	        		String checkTextFilePath=centerMaster.getEsInPath();
		            String checkXmlFilePath=centerMaster.getEsInXmlPath();
		        	File texEsin = new File(checkTextFilePath);  
		        	File xmlEsin = new File(checkXmlFilePath);  		
		        	OcrDetails ocrDetails=vehicleService.getOcrDetailsById(vehiclereg.getOcrid().getOcrid());
		        	
		        	
		        	
		        	if (session.getAttribute("username")==null) {
		        		return "1";	
		        	}else if (ocrDetails.getNoimage().length==0) {
	        			return "2";  	 
		        	}else if (!texEsin.isDirectory()) {
	        			return "3";  	 
		        	}else if (!xmlEsin.isDirectory()) {
	        			return "4";  	 
		        	}else  {
		        		
		        		List<ConfigSystem> configSystem=vehicleService.getConfigSystemByCenter(vehiclereg.getCentermaster().getCenter_ID(),vehiclereg.getTestLaneHeadId().getTestLaneHeadId());	
		        		
		                boolean correct=false;
		                String hostname="";
		                String username="";
		                String password="";
		                String rootpath="";
		                String xmlPath="";
		                InetAddress inet = null;
		             
		                for(ConfigSystem conSys:configSystem) {
		                	
		                	 System.out.println("fff="+conSys.getIpaddress());
		                	
		                     inet = InetAddress.getByName(conSys.getIpaddress());
		                     if(inet.isReachable(0)==true) {
		                    	 correct=true; 
		                    	 System.out.println("fff="+true);
		                     }else {
		                    	 correct=true; 
		                    	 System.out.println("fff="+false);
		                    	// break;
		                     }

		                }
		                if((configSystem.size()==0)) {
		                 	correct=true;
		                 }
		                if(correct) {
		                
		                	Users user=usersService.searchUser(vehiclereg.getUser().getUserId());
		                	
		                	
							String path1 = this.getClass().getClassLoader().getResource("").getPath();
							String fullPath = URLDecoder.decode(path1, "UTF-8");		
							String pathArr[] = fullPath.split("/WEB-INF/classes/");
							String textFilePath=centerMaster.getEsInPath()+"\\"+vehiclereg.getVid().getVehicleID()+".txt";
		                	
							File file = new File(textFilePath);	                	
					        if (!file.exists()) {
					           file.createNewFile();
					         }
		                	
		                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
		                    BufferedWriter bw = new BufferedWriter(fw);
		                    bw.write("[HEADER]");
			                bw.write("\r\n"); 
			                bw.write("10100="+vehiclereg.getVid().getVehicleID());
			                bw.write("\r\n"); 
			                bw.write("15012="+user.getUserName());
			                bw.write("\r\n"); 
			                bw.write("10190="+vehicleMaster.getNoWheel());	                
			                bw.write("\r\n"); 
			                bw.write("10191="+vehicleMaster.getVmodel().getVehicleClass().getCategoryID().getCategoryID());                
			                
			                
			                
			                bw.write("\r\n");
			                bw.write("\r\n");
			                bw.write("[ENDOFFILE]");
			               
			                
		                    bw.close();
					        
					        
		                    //  String xpath= pathArr[0]+"/Upload/XML_ES_IN/";	
		                   	String xmlFilePath=centerMaster.getEsInXmlPath()+"\\"+vehiclereg.getVid().getVehicleID()+".xml";
		                   	
		                   	File xmlfile = new File(xmlFilePath);
		                   	if (!xmlfile.exists()) {
		    	        	   xmlfile.createNewFile();
		    	            }
					        
		                   	FileWriter fwX = new FileWriter(xmlfile.getAbsoluteFile());
	                        BufferedWriter bwx = new BufferedWriter(fwX);
	                        bwx.write("<?xml version=\"1.0\"?>"
	                        		+ "\r\n");
	                        
	                        bwx.write("<Report>"); 
	                        bwx.write("\r\n"); 
	                        bwx.write("<ROW num=\"Vehicle Registration No\">"
	                        		+ "\r\n<CODE>10100</CODE>");
	                        bwx.write("\r\n"); 
	                        bwx.write("<DATA>"+vehiclereg.getVid().getVehicleID()+"</DATA>");
	                        bwx.write("\r\n"); 
	                        bwx.write("</ROW>");
	                        bwx.write("\r\n"); 
	                        
	                        bwx.write("<ROW num=\"User\">"
	                        		+ "\r\n<CODE>15012</CODE>");
	                        bwx.write("\r\n"); 
	                        bwx.write("<DATA>"+user.getUserName()+"</DATA>");
	                        bwx.write("\r\n"); 
	                        bwx.write("</ROW>");                       
	                        bwx.write("\r\n"); 
	                        
	                        bwx.write("<ROW num=\"Make\">"
	                        		+ "\r\n<CODE>15015</CODE>");
	                        bwx.write("\r\n"); 
	                        bwx.write("<DATA>"+vehicleMaster.getVmodel().getVehicleMakeID().getVehicleMake()+"</DATA>");
	                        bwx.write("\r\n"); 
	                        bwx.write("</ROW>");                       
	                        bwx.write("\r\n"); 
	                        
	                        bwx.write("<ROW num=\"Model\">"
	                        		+ "\r\n<CODE>15016</CODE>");
	                        bwx.write("\r\n"); 
	                        bwx.write("<DATA>"+vehicleMaster.getVmodel().getVehicleModel()+"</DATA>");
	                        bwx.write("\r\n"); 
	                        bwx.write("</ROW>");  
	                        bwx.write("\r\n"); 
	                        
	                        bwx.write("<ROW num=\"Fuel Type\">"
	                        		+ "\r\n<CODE>15017</CODE>");
	                        bwx.write("\r\n"); 
	                        bwx.write("<DATA>"+vehicleMaster.getFtype().getFuel()+"</DATA>");
	                        bwx.write("\r\n"); 
	                        bwx.write("</ROW>");  
	                        bwx.write("\r\n"); 
	                        
	                        bwx.write("<ROW num='Engine Stroke'>"
	                        		+ "<CODE>15018</CODE>");
	                        bwx.write("<DATA>4 Stroke</DATA>");
	                        bwx.write("</ROW>");  
	                        bwx.write("\r\n"); 
	       
	                        bwx.write("<ROW num=\"Category\">"
	                        		+ "\r\n<CODE>10191</CODE>");
	                        bwx.write("\r\n"); 
	                        bwx.write("<DATA>"+vehicleMaster.getVmodel().getVehicleClass().getVehicleClass()+"</DATA>");
	                        bwx.write("\r\n"); 
	                        bwx.write("</ROW>"); 
	                        bwx.write("\r\n"); 
	                        
	                        bwx.write("<ROW num=\"Date of Mfg\">"
	                        		+ "\r\n<CODE>10199</CODE>");
	                        bwx.write("\r\n"); 
	                        bwx.write("<DATA>01-Jan-"+vehicleMaster.getManufactureYear()+"</DATA>");
	                        bwx.write("\r\n"); 
	                        bwx.write("</ROW>"); 
	                        bwx.write("\r\n");  
	                        
	                        
	                        bwx.write("<ROW num=\"Emission Norms\">"
	                        		+ "\r\n<CODE>10190</CODE>");
	                        bwx.write("\r\n"); 
	                        bwx.write("<DATA>"+vehicleMaster.getEmissionNorms()+"</DATA>");
	                        bwx.write("\r\n"); 
	                        bwx.write("</ROW>");
	                        bwx.write("\r\n"); 
	        
	                        bwx.write("<ROW num=\"Wheel\">"
	                        		+ "\r\n<CODE>10192</CODE>");
	                        bwx.write("\r\n"); 
	                        bwx.write("<DATA>"+vehicleMaster.getNoWheel()+"</DATA>");
	                        bwx.write("\r\n"); 
	                        bwx.write("</ROW>");
	                        bwx.write("\r\n"); 
	                        bwx.write("</Report>");  
	                        bwx.close(); 
					        
	                        if(configSystem.size()!=0) {
	                        System.out.println("ftp");
	         	                   for(ConfigSystem conSys:configSystem) {
	         	                     hostname=conSys.getIpaddress();
	         	                     username=conSys.getUserName();
	         	                     password=conSys.getPassword();  
	         	                     rootpath=conSys.getRootPath();
	         	                     xmlPath=conSys.getXmlPath();
	         	                     inet = InetAddress.getByName(hostname);
	         	                 
	         	
	         	                   
	         	                    FTPUploader ftpUploader = new FTPUploader(hostname, username, password);
	         	
	         	                    //FTP server path is relative. So if FTP account HOME directory is "/home/pankaj/public_html/" and you need to upload
	         	                    // files to "/home/pankaj/public_html/wp-content/uploads/image2/", you should pass directory parameter as "/wp-content/uploads/image2/"
	         	                    ftpUploader.uploadFile(textFilePath, vehiclereg.getVid().getVehicleID()+".txt", rootpath+"/");//public_ftp
	         	                   
	         	                    //sava FTp to xml
	         	                    ftpUploader.uploadFile(xmlFilePath, vehiclereg.getVid().getVehicleID()+".xml", xmlPath+"/");//public_ftp
	         	                    
	         	                    
	         	                    ftpUploader.disconnect();
	         	                    file.delete();
	         	                    xmlfile.delete();
	         	                    
	         	                   }
	         	            }	
	                        
	      
	                        
	                		return "0";
		                	
		                }else {
		  	        	  return "6"; 
		  		          
		  	          }
		        	}
	        		
	        	} catch (Exception e) {
	        		e.printStackTrace();
	        		return "7";
	        	}
	        
					
		 }

	  	@RequestMapping(value="getCreateEsinVehicle", method=RequestMethod.GET)		
		public  @ResponseBody VehicleRegistration getCreateEsinVehicle(@RequestParam  int ocrid){
	  		
	  		VehicleRegistration vehicleRegistration=vehicleService.getRegistrationVehicleByOcrid(ocrid);
	  		
			return vehicleRegistration;
		}


}
