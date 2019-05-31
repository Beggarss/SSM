package com.hrms.service;

import com.hrms.mapper.DocumentMapper;
import com.hrms.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryService {
    @Autowired
    private DocumentMapper documentMapper;
    public int insertDir(String absolutePath){
        return documentMapper.insertDir(absolutePath);
    }
    public List<Document> selectAllDir(){
        return documentMapper.selectAllDir();
    }
}
