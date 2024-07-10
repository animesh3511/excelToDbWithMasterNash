package com.example.excelToDb.controller;

import com.example.excelToDb.model.response.CustomEntityResponse;
import com.example.excelToDb.model.response.EntityResponse;
import com.example.excelToDb.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    DemoService demoService;

    @PostMapping("/excelToDb")
    public ResponseEntity<?> excelToDb(@RequestPart("file")MultipartFile file, @RequestParam String fileType)
    {

     if (file.isEmpty())
     {

     return new ResponseEntity(new CustomEntityResponse("file is empty",0), HttpStatus.OK);


     }

    try {

   return new ResponseEntity(new EntityResponse(demoService.excelToDb(file.getInputStream(),fileType),0),HttpStatus.OK);

    }catch (Exception e)
    {

    return new ResponseEntity(new CustomEntityResponse(e.getMessage(),-1),HttpStatus.BAD_REQUEST);


    }




    }



  @GetMapping("/exportToExcel")
 public ResponseEntity<?> exportToExcel(HttpServletResponse response)
 {

     try {


     return new ResponseEntity(new EntityResponse(demoService.exportToExcel(response),0),HttpStatus.OK);

     }catch (Exception e)
     {


      return new ResponseEntity(new CustomEntityResponse(e.getMessage(),-1),HttpStatus.BAD_REQUEST);

     }




 }




}
