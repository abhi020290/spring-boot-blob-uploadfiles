package com.springboot.fileupload.springbootblobuploadfiles.Service;

import com.springboot.fileupload.springbootblobuploadfiles.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.springboot.fileupload.springbootblobuploadfiles.repository.DocumentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository docRepository;

    public Document saveFile(MultipartFile file) {
        String docName = file.getOriginalFilename();
        String extension = docName.split(".")[1];
        try {
            Document doc = new Document();
            doc.setDocumentName(docName);
            doc.setData(file.getContentType().getBytes());
            doc.setDocumentType(extension);
            return docRepository.save(doc);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Optional<Document> getFile(Integer fileId) {
        return docRepository.findById(fileId);
    }
    public List<Document> getFiles(){
        return docRepository.findAll();
    }


}
