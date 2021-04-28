package com.springboot.fileupload.springbootblobuploadfiles.repository;

import com.springboot.fileupload.springbootblobuploadfiles.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document , Integer> {
}
