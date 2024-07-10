package com.example.excelToDb.serviceimpl;

import com.example.excelToDb.model.Demo;
import com.example.excelToDb.repository.DemoRepository;
import com.example.excelToDb.service.DemoService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DemoInterfaceImpl implements DemoService {

    @Autowired
    DemoRepository demoRepository;


    @Override
    public Object excelToDb(InputStream inputStream,String fileType) throws IOException
    {
        List<Demo> list = new ArrayList();



        if (fileType.equalsIgnoreCase("csv")) {


            //here,a 'BufferReader reader' is created to read the data from 'inputStream'.the 'inputStream'
            //is wrapped inside 'BufferReader' and 'InputStreamReader' to read the contents of 'inputStream'
            //line by line
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {


                //'CSVParser' is the part of "apache.commons" library. it is used to parse CSV files
                //'reader' is the BufferReader instance created and is used to read the contents of 'inputStream'.
                //'CSVFormat.DEFAULT.withFirstRecordAsHeader()' this arg tells parser that first row will be a header
                //row.it is used to map values to corresponding columns
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

                for (CSVRecord csvRecord : csvParser)
                {
                    Demo demo = new Demo();

                    demo.setSrNo(Long.valueOf(csvRecord.get("S. No")));

                    demo.setMainIndication(csvRecord.get("Main indication"));

                    demo.setSubIndication(csvRecord.get("Sub-indication"));

                    demo.setKeyCompanies(csvRecord.get("Key Companies"));

                    demo.setCompanyLogo(csvRecord.get("Company Logo"));

                    demo.setCompanyWebsiteLinks(csvRecord.get("Company Website Links"));

                    demo.setKeyProducts(csvRecord.get("Key Products"));

                    demo.setType(csvRecord.get("Type "));

                    demo.setPhase(csvRecord.get("Phase"));

                    demo.setSubPhase(csvRecord.get("Sub-Phase"));

                    demo.setBriefProfile(csvRecord.get("Brief Profile"));

                    demo.setProductLableFDA(csvRecord.get("Product Label- FDA"));

                    demo.setProductLableEMA(csvRecord.get("Product Label- EMA"));

                    demo.setTargetPopulation(csvRecord.get("Target Population"));

                    demo.setMoa(csvRecord.get("MoA"));

                    demo.setMoaAcronym(csvRecord.get("MoA acronym"));

                    demo.setDrugTarget(csvRecord.get("Drug Target"));

                    demo.setDrugClass(csvRecord.get("Drug Class"));

                    demo.setHalfLife(csvRecord.get("Half-Life"));

                    demo.setRoa(csvRecord.get("RoA"));

                    demo.setDosingRegimen(csvRecord.get("Dosing Regimen"));

                    demo.setOrphanDrugDesignation(csvRecord.get("Orphan Drug Designation"));

                    demo.setFastTrackDesignation(csvRecord.get("Fast Track Designation"));

                    demo.setBreakThroughDesignation(csvRecord.get("Breakthrough Designation"));

                    demo.setEstimatedApproval(csvRecord.get("Estimated Approval"));

                    demo.setSkuApproved(csvRecord.get("SKU Approved"));

                    demo.setFirstApproval(csvRecord.get("First Approval"));

                    demo.setInOutOfRace(csvRecord.get("In/Out of Race"));

                    demo.setReasonForOutOfRace(csvRecord.get("Reason for out of race"));

                    list.add(demo);
                }
            }
        }

     else
        {



        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> iterator = sheet.iterator();
        iterator.next();
        DataFormatter dataFormatter = new DataFormatter();

        while (iterator.hasNext()) {
            Row row = iterator.next();
            Demo demo = new Demo();

            String srNo = dataFormatter.formatCellValue(row.getCell(0));

            demo.setSrNo(Long.valueOf(srNo));

            demo.setMainIndication(dataFormatter.formatCellValue(row.getCell(1)));

            demo.setSubIndication(dataFormatter.formatCellValue(row.getCell(2)));

            demo.setKeyCompanies(dataFormatter.formatCellValue(row.getCell(3)));

            demo.setCompanyLogo(dataFormatter.formatCellValue(row.getCell(4)));

            demo.setCompanyWebsiteLinks(dataFormatter.formatCellValue(row.getCell(5)));

            demo.setKeyProducts(dataFormatter.formatCellValue(row.getCell(6)));

            demo.setType(dataFormatter.formatCellValue(row.getCell(7)));

            demo.setPhase(dataFormatter.formatCellValue(row.getCell(8)));

            demo.setSubPhase(dataFormatter.formatCellValue(row.getCell(9)));

            demo.setBriefProfile(dataFormatter.formatCellValue(row.getCell(10)));

            demo.setProductLableFDA(dataFormatter.formatCellValue(row.getCell(11)));

            demo.setProductLableEMA(dataFormatter.formatCellValue(row.getCell(12)));

            demo.setTargetPopulation(dataFormatter.formatCellValue(row.getCell(13)));

            demo.setMoa(dataFormatter.formatCellValue(row.getCell(14)));

            demo.setMoaAcronym(dataFormatter.formatCellValue(row.getCell(15)));

            demo.setDrugTarget(dataFormatter.formatCellValue(row.getCell(16)));

            demo.setDrugClass(dataFormatter.formatCellValue(row.getCell(17)));

            demo.setHalfLife(dataFormatter.formatCellValue(row.getCell(18)));

            demo.setRoa(dataFormatter.formatCellValue(row.getCell(19)));

            demo.setDosingRegimen(dataFormatter.formatCellValue(row.getCell(20)));

            demo.setOrphanDrugDesignation(dataFormatter.formatCellValue(row.getCell(21)));

            demo.setFastTrackDesignation(dataFormatter.formatCellValue(row.getCell(22)));

            demo.setBreakThroughDesignation(dataFormatter.formatCellValue(row.getCell(23)));

            demo.setEstimatedApproval(dataFormatter.formatCellValue(row.getCell(24)));

            demo.setSkuApproved(dataFormatter.formatCellValue(row.getCell(25)));

            demo.setFirstApproval(dataFormatter.formatCellValue(row.getCell(26)));

            demo.setInOutOfRace(dataFormatter.formatCellValue(row.getCell(27)));

            demo.setReasonForOutOfRace(dataFormatter.formatCellValue(row.getCell(28)));


            list.add(demo);

        }


        }


        demoRepository.saveAll(list);

        return "Data Saved";


    }

    @Override
    public Object exportToExcel(HttpServletResponse response) throws IOException
    {

             List<Demo> list = demoRepository.findAll();

             System.out.println(list);

             Workbook workbook = new XSSFWorkbook();

             Sheet sheet = workbook.createSheet("Master_Nash_Excel");

             Row headerRow = sheet.createRow(0);

             headerRow.createCell(0).setCellValue("S. No");

             headerRow.createCell(1).setCellValue("Main Indication");

             headerRow.createCell(2).setCellValue("Sub Indication");

             headerRow.createCell(3).setCellValue("Key Companies");

             headerRow.createCell(4).setCellValue("Company Logo");

             headerRow.createCell(5).setCellValue("Company Website Links");

             headerRow.createCell(6).setCellValue("Key Products");

             headerRow.createCell(7).setCellValue("Type");

             headerRow.createCell(8).setCellValue("Phase");

             headerRow.createCell(9).setCellValue("Sub-Phase");

             headerRow.createCell(10).setCellValue("Brief Profile");

             headerRow.createCell(11).setCellValue("Product Label- FDA");

             headerRow.createCell(12).setCellValue("Product Label- EMA");

             headerRow.createCell(13).setCellValue("Target Population");

             headerRow.createCell(14).setCellValue("MoA");

             headerRow.createCell(15).setCellValue("MoA acronym");

             headerRow.createCell(16).setCellValue("Drug Target");

             headerRow.createCell(17).setCellValue("Drug Class");

             headerRow.createCell(18).setCellValue("Half-Life");

             headerRow.createCell(19).setCellValue("RoA");

             headerRow.createCell(20).setCellValue("Dosing Regimen");

             headerRow.createCell(21).setCellValue("Orphan Drug Designation");

             headerRow.createCell(22).setCellValue("Fast Track Designation");

             headerRow.createCell(23).setCellValue("Breakthrough Designation");

             headerRow.createCell(24).setCellValue("Estimated Approval");

             headerRow.createCell(25).setCellValue("SKU approved");

             headerRow.createCell(26).setCellValue("First approval");

             headerRow.createCell(27).setCellValue("In/Out of Race");

             headerRow.createCell(28).setCellValue("Reason For Out Of Race");

         //created header row of sheet above


             int rowNum = 1;

             for (Demo demo : list)
             {

                Row row = sheet.createRow(rowNum++);

               row.createCell(0).setCellValue(demo.getSrNo());

               row.createCell(1).setCellValue(demo.getMainIndication());

               row.createCell(2).setCellValue(demo.getSubIndication());

               row.createCell(3).setCellValue(demo.getKeyCompanies());

               row.createCell(4).setCellValue(demo.getCompanyLogo());

               row.createCell(5).setCellValue(demo.getCompanyWebsiteLinks());

               row.createCell(6).setCellValue(demo.getKeyProducts());

               row.createCell(7).setCellValue(demo.getType());

               row.createCell(8).setCellValue(demo.getPhase());

               row.createCell(9).setCellValue(demo.getSubPhase());

               row.createCell(10).setCellValue(demo.getBriefProfile());

               row.createCell(11).setCellValue(demo.getProductLableFDA());

               row.createCell(12).setCellValue(demo.getProductLableEMA());

               row.createCell(13).setCellValue(demo.getTargetPopulation());

               row.createCell(14).setCellValue(demo.getMoa());

               row.createCell(15).setCellValue(demo.getMoaAcronym());

               row.createCell(16).setCellValue(demo.getDrugTarget());

               row.createCell(17).setCellValue(demo.getDrugClass());

               row.createCell(18).setCellValue(demo.getHalfLife());

               row.createCell(19).setCellValue(demo.getRoa());

               row.createCell(20).setCellValue(demo.getDosingRegimen());

               row.createCell(21).setCellValue(demo.getOrphanDrugDesignation());

               row.createCell(22).setCellValue(demo.getFastTrackDesignation());

               row.createCell(23).setCellValue(demo.getBreakThroughDesignation());

               row.createCell(24).setCellValue(demo.getEstimatedApproval());

               row.createCell(25).setCellValue(demo.getSkuApproved());

               row.createCell(26).setCellValue(demo.getFirstApproval());

               row.createCell(27).setCellValue(demo.getInOutOfRace());

               row.createCell(28).setCellValue(demo.getReasonForOutOfRace());



             }


        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition","attachment; filename=Master_Nash_Excel.xlsx");

        ServletOutputStream outputStream = response.getOutputStream();

        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        return "excel sheet download";




    }


}