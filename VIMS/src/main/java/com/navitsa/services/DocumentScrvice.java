package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.navitsa.entity.Document;
import com.navitsa.entity.DocumentCheckDetails;
import com.navitsa.entity.DocumentCheckHead;
import com.navitsa.repository.DocumentCheckDetailsRepository;
import com.navitsa.repository.DocumentCheckHeadRepository;
import com.navitsa.repository.DocumentRepository;

@Service
public class DocumentScrvice {
	
	
		@Autowired
		DocumentRepository documentRepository;

		@Autowired
		DocumentCheckHeadRepository documentCheckHeadRepo;
		
		@Autowired
		DocumentCheckDetailsRepository documentCheckDetailsRepo;
		
		
		public List<Document> getAllActiveDocument(){	
			return documentRepository.getAllActiveDocument();
		}
		
		public String maxDocumentCheckHeadID(){	
			if(documentCheckHeadRepo.maxDocumentCheckHeadID()==null) {
				return "1";	
			}else {
			return documentCheckHeadRepo.maxDocumentCheckHeadID();
			}
		}
		
		
		public void saveDocumentCheckHead(DocumentCheckHead documentCheckHead){	
			 documentCheckHeadRepo.save(documentCheckHead);
		}
		
		public void saveAllDocumentCheckDetails(List<DocumentCheckDetails> documentCheckDetails){	
			 documentCheckDetailsRepo.saveAll(documentCheckDetails);
		}
		public void saveDocumentCheckDetails(DocumentCheckDetails documentCheckDetails){	
			 documentCheckDetailsRepo.save(documentCheckDetails);
		}
		public void saveDocument(Document document){	
			documentRepository.save(document);
		}
		public List<Document> listAllDocument(){	
			return (List<Document>)documentRepository.findAll();
		}
		
		public Document listDocumentById(int id){	
			return documentRepository.findById(id).get();
		}
		public DocumentCheckDetails getCheckDocumentDetailsByid(int headid){
			return documentCheckDetailsRepo.findById(headid).get();
			
		}
		
		public List<DocumentCheckDetails> getCheckDocumentDetails(int ocrid){
			return documentCheckDetailsRepo.getCheckDocumentDetails(ocrid);
			
		}
}
