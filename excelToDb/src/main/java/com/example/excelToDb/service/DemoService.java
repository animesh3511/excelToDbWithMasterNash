package com.example.excelToDb.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public interface DemoService {


    Object excelToDb(InputStream inputStream,String fileType) throws IOException;

    Object exportToExcel(HttpServletResponse response) throws IOException;
}
