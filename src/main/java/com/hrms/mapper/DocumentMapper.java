package com.hrms.mapper;

import com.hrms.model.Document;

import java.util.List;

public interface DocumentMapper {
    int insertDir(String dir);
    List<Document> selectAllDir();
}
