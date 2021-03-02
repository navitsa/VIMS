package com.navitsa.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.Reports.EmissionDieselResult;
import com.navitsa.Reports.EmissionPetrolResultBean;
import com.navitsa.entity.ConfigSystem;
import com.navitsa.entity.EmissionDieselCertificateData;
import com.navitsa.entity.EmissionDieselCertificateReadings;
import com.navitsa.entity.EmissionPetrolCertificateData;
import com.navitsa.entity.TestValueFileDetail;
import com.navitsa.entity.TestValueFileHeader;
import com.navitsa.entity.VehicleRegistration;
import com.navitsa.entity.VisualChecklistMaster;
import com.navitsa.services.CenterService;
import com.navitsa.services.TestReportConfigService;
import com.navitsa.services.TestValueFileService;
import com.navitsa.services.VehicleService;
import com.navitsa.services.VisualInspectionServices;
import com.navitsa.utils.JDBCSingletonAVL;

@Controller
public class TestValueFileController {
	
	@Autowired
	private TestValueFileService testValueFileServices;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private CenterService centerService;
	
	@Autowired
	private TestReportConfigService testReportService;
	
	@Autowired
	private VisualInspectionServices inspectionServices;
	
	/*Load Test Value File Reading JSP */
	@RequestMapping("/testValueFile")
	public String loadTestValueFile() {
		
		//System.out.println("Helo nuwan i am calling");
		return "testValueFileReading";
	}

	
	@RequestMapping(value="/readingTestValues",method=RequestMethod.GET)
	public @ResponseBody List<TestValueFileHeader> readingTestValues(RedirectAttributes redirectAttributes,HttpSession session) {

		//String ESOUT_path = partnerService.getDefaultPartner().getEsOutPath();
		String centerid=(String) session.getAttribute("centerid");
		String ESOUT_path = centerService.getcenterById(centerid).getEsOutPath();
		
		try {
			downloadFromFTP(centerid,ESOUT_path,session);
		} catch (SQLException e1) {
			//e1.printStackTrace();
			System.out.println("FTP Connection problem "+e1);
		}

		
	      //Creating a File object for directory
	      File directoryPath = new File(ESOUT_path);
	      FilenameFilter textFilefilter = new FilenameFilter(){
	         public boolean accept(File dir, String name) {
	            String lowercaseName = name.toLowerCase();
	            if (lowercaseName.endsWith(".txt")) {
	               return true;
	            } else {
	               return false;
	            }
	         }
	      };
	      //List of all the text files
	      String filesList[] = directoryPath.list(textFilefilter);
	      
	      if(filesList.length<=0) {
	    	System.out.println("ES_OUT folder is Empty !");  
	      }

		      
		      for(String fileName : filesList) {
		    	  
			      try {
			    	  
			          File myObj = new File(ESOUT_path +"\\"+ fileName);
			          Scanner myReader = new Scanner(myObj);
			          Scanner myReader2 = new Scanner(myObj);
				         
		     		 String[] vehicleNo = new String[2];
		     		 String vehicleID = null;
		     		 String date_time  = null;
			          
			          while (myReader.hasNextLine()) {
			        	  
			        	  String rs = myReader.nextLine();
			        	  
			        	  if(rs.contains("10100="))
			        	  {
			        		 vehicleNo =  rs.split("=");
			        		 vehicleID = vehicleNo[1].replace(" ","");
			        	  }
			        	  
			        	  if(rs.contains("15001="))
			        	  {
			        		  String dateTime[] =  rs.split("=");
			        		  
			        		  date_time = dateTime[1];
			        		  //objHeader.setTime((String) dateTime[1].replace(" ", "").subSequence(9,17));
			        		  
			        	  }
			        	  
			          }
			          
			          String RegId = null;
			          try {
			        	  // get registration id 
			        	  //select * from vehicle_registration where vehicle_id=? && status="pending" order by vehicle_reg_id
			        	  RegId = vehicleService.getRegistrationID(vehicleID);

			          } catch (Exception e) {
						System.out.println(e.getMessage());
			          }

			          if(RegId !=null) {
			        	  VehicleRegistration vrobj = new VehicleRegistration();
				          vrobj.setVregID(RegId);
				          
				          TestValueFileHeader objHeader = new TestValueFileHeader();
					      String headerID =  testValueFileServices.getMaxHeaderID();
					      objHeader.setTest_value_file_id(Integer.valueOf(headerID));
					      objHeader.setTxtFileName(fileName);
					      objHeader.setStatus("pending");
					      objHeader.setVehicle_id(vehicleID);
					      objHeader.setDate(date_time);
				          objHeader.setVreg(vrobj);
				          
				          //vehicleNo[1].replace(" ","");
				          
				         List<TestValueFileDetail> testResultList = new ArrayList<TestValueFileDetail>();
			    
				          a:while (myReader2.hasNextLine()) {
				        	  
					            String data = myReader2.nextLine();
					            
					            if(data.contains("visual defects"))
					            {
					            	break a;
					            }
			 
			            		 if(data.contains("="))
			            		 {
			            			 String[] result = data.split("=");
			            			 
			            			 if(result[1].replace(" ","").isEmpty() != true 
			            					 && result[1].replace(" ","").equals("-----") !=true
			            					 && result[1].replace(" ","").length()<=20 )
			            			 {
			            				 
					            		TestValueFileDetail objDetail = new TestValueFileDetail();
					            		 objDetail.setTest_value_file_header(objHeader);
					            		 objDetail.setCode(result[0].replace(" ",""));
					            		 objDetail.setResult(result[1].replace(" ","")); 
			            				 testResultList.add(objDetail);
					            		 
			            			 }
				            		 
			            		 }

					       }
				          
				          myReader.close();
				          myReader2.close();
				          
				          testValueFileServices.saveTestValueHead(objHeader);
				          testValueFileServices.saveAllDetail(testResultList);
				          myObj.delete();
				         
				          String fuelType = vehicleService.getRegistraionInfo(RegId).getVid().getFtype().getFuel();
				          //String avlPath = vehicleService.getRegistraionInfo(RegId).getTestLaneHeadId().getAvlPath();
				          //readingEmissionResults(vehicleID,vrobj,fuelType,avlPath);
				          readingEmissionResults(vehicleID,RegId,fuelType);
			          }
			          

			        } catch (FileNotFoundException e) {
			          System.out.println("An error occurred.");
			          e.printStackTrace();
			        }
		      }  

	      
		 //return "redirect:/testValueFile";
		 List<TestValueFileHeader> result = testValueFileServices.listPendingHeaderInfo();
		 return result;
		
	}
	

	 @ModelAttribute("testValueFileHeader")
	 	public List<TestValueFileHeader> getTestValueFileHeader(){
		 List<TestValueFileHeader> result = testValueFileServices.listPendingHeaderInfo();
		 return result;
	 }
	 
	 @ModelAttribute("previousReports")
	 	public List<TestValueFileHeader> getPreviousReports(){
		 List<TestValueFileHeader> result = testValueFileServices.listCompletedHeaderInfo();
		 return result;
	 }
	 
	 @RequestMapping("/previousTestReports")
	 public String previousResults() {
		 return "testReportReprint";
		 }
	 
	public void readingEmissionResults(String vehicleID, String RegId, String fuelType){
		
		if(fuelType.equalsIgnoreCase("Diesel"))
		{
/*			JDBCSingletonAVL jdbc= JDBCSingletonAVL.getInstance();
			try {
				
				EmissionDieselResult edresult = jdbc.pullDieselData(vehicleID, vrobj, avlPath, "DieselTest.mdb");				
				if(edresult.getEdcd() != null) {
					edresult.getEdcd().setId_no(avlPath+"/"+edresult.getEdcd().getId_no());
					testReportService.saveEmissionDieselCertificateData(edresult.getEdcd());
					
					List<EmissionDieselCertificateReadings> list = edresult.getList();
					for(EmissionDieselCertificateReadings edcr : list) {
						edcr.setEdc_id(edresult.getEdcd());
						testReportService.saveEmissionDieselCertificateReadings(edcr);
					}					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
*/			
			
			EmissionDieselCertificateData emd =null;
			
			try{
				emd = testReportService.getEmiDieselCerData(RegId);
				if(emd == null) {
					testReportService.insertIntoEDCData(vehicleID,RegId);
					int id_no = testReportService.getEDCDataID(RegId);
					testReportService.insertIntoEDCReadings(id_no);					
				}
				  
				}catch(Exception e){System.out.println("try catch /n reading diesel emmision results");}
	
		}
		else if(fuelType.equalsIgnoreCase("Petrol") || fuelType.equalsIgnoreCase("LPG") ) 
		{

/*			JDBCSingletonAVL jdbc= JDBCSingletonAVL.getInstance();
			
			try {
				EmissionPetrolResultBean epresult = jdbc.pullPetrolData(vehicleID, vrobj, avlPath, "PetrolTest.mdb");
				
				if(epresult.getEmpcdata() != null) {
					epresult.getEmpcdata().setId_no(avlPath+"/"+epresult.getEmpcdata().getId_no());
					testReportService.saveEmissionPetrolCertificateData(epresult.getEmpcdata());
					
					epresult.getEmpcgas().setId_no(epresult.getEmpcdata());
					testReportService.saveEmissionPetrolCertificateGas(epresult.getEmpcgas());
					
					epresult.getEmpclambda().setId_no(epresult.getEmpcdata());
					testReportService.saveEmissionPetrolCertificateLambda(epresult.getEmpclambda());
					
					epresult.getEmpcpetrol().setId_no(epresult.getEmpcdata());
					testReportService.saveEmissionPetrolCertificatePetrol(epresult.getEmpcpetrol());					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
*/			
			EmissionPetrolCertificateData empcdata = null;
			
			try {
				empcdata = testReportService.getEmiPetrolCerData(RegId);
				if(empcdata == null) {
					testReportService.insertIntoEPCData(vehicleID,RegId);
					int id_no = testReportService.getEPCDataID(RegId);
					testReportService.insertIntoEPCGas(id_no);
					testReportService.insertIntoEPCLambda(id_no);
					testReportService.insertIntoEPCPetrol(id_no);					
				}				
			} catch (Exception e) {System.out.println("try catch /n reading petrol emmision results");}
			
			
		}

	}
	
	@RequestMapping("/downloadFromFTP")
	public void downloadFromFTP(String centerid,String ESOUT_path,HttpSession session) throws SQLException {

		List<ConfigSystem> rs = testValueFileServices.getFTPServerInfo(centerid,"FTP");
		for (ConfigSystem obj : rs) {

	        String server = obj.getIpaddress();
	        int port = Integer.valueOf(obj.getPort());
	        String user = obj.getUserName();
	        String pass = obj.getPassword();
	        String esout_path = obj.getFtpEsOut();
	        String download_path = ESOUT_path;
	        
	        
	        // Create an instance of FTPClient 
	        FTPClient ftp = new FTPClient();
	        FileOutputStream fos = null;
	        try { 
	            // Establish a connection with the FTP URL 
	            ftp.connect(server,port); 
	            // Enter user details : user name and password 
	            boolean isSuccess = ftp.login(user, pass); 
	  
	            if (isSuccess) { 
	            	
	                // Fetch the list of names of the files. In case of no files an 
	                // empty array is returned 
	                String[] filesFTP = ftp.listNames(esout_path);
	                int count = 1; 
	                // Iterate on the returned list to obtain name of each file 
	                for (String file : filesFTP) { 
	                    System.out.println("File " + count + " :" + file); 
	                    count++;
	                    
	                    // Create an OutputStream for the file
	                    String filename = download_path+"\\"+file;
	                    fos = new FileOutputStream(filename);
	                    
	                 // Fetch file from server 
	                    ftp.retrieveFile(esout_path+"\\"+file, fos);
	                 // move file
	                    ftp.rename(esout_path+"\\"+file, esout_path+"\\New folder\\"+file);
	                 // delete file
	                    ftp.deleteFile(esout_path+"\\"+file);
	                    
	                } 
	                

	            } 
	  
	            ftp.logout(); 
	        } 
	        catch (IOException e) { 
	            e.printStackTrace(); 
	        } 
	        finally { 
	            try {
	                if (fos != null) {fos.close();}
	            	
	                ftp.disconnect(); 
	            } 
	            catch (IOException e) { 
	                e.printStackTrace(); 
	            } 
	        } 
			
		}
	}
	
	@RequestMapping(value = "/checkAvailableTestResults", method = RequestMethod.GET)
	public @ResponseBody Map<Integer, String> checkAvailableTestResults(@RequestParam("regID") String regID) {
		
		VisualChecklistMaster vi = null;
		EmissionDieselCertificateData emd = null;
		EmissionPetrolCertificateData empcdata = null;
		
		try {
			VehicleRegistration vr =  vehicleService.getRegistraionInfo(regID);
			//String avlPath = vr.getTestLaneHeadId().getAvlPath();
			//readingEmissionResults(vr.getVid().getVehicleID(),vr,vr.getVid().getFtype().getFuel(),avlPath);
			readingEmissionResults(vr.getVid().getVehicleID(),regID,vr.getVid().getFtype().getFuel());
			
			vi = inspectionServices.getChecklistMasterData(regID);
			emd = testReportService.getEmiDieselCerData(regID);
			empcdata = testReportService.getEmiPetrolCerData(regID);
		} catch (Exception e) {
			System.out.println("Something went wrong when checking available test results /n checkAvailableTestResults try catch");
		}
	
		Map<Integer,String> a = new TreeMap<Integer,String>();
		
		
		if(vi == null)
			a.put(1, "Not Available !");
		else
			a.put(1, "Available");
		if(emd == null && empcdata ==null)
			a.put(2, "Not Available !");
		else
			a.put(2, "Available");
//		if(empcdata == null)
//			a.put(3, "Not Available !");
//		else
//			a.put(3, "Available");
		
		return a;

	}

}
