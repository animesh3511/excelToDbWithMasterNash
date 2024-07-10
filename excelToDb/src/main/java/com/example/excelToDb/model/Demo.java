package com.example.excelToDb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "demo")
public class Demo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sr_No")
    private Long srNo;

    @Column(name = "main_indication")
    private String mainIndication;

    @Column(name = "sub_indication")
    private String subIndication;

    @Column(name = "key_companies")
    private String keyCompanies;

    @Column(name = "company_logo")
    private String companyLogo;

    @Column(name = "company_website_links")
    private String companyWebsiteLinks;

    @Column(name = "key_products")
    private String keyProducts;

    @Column(name = "type")
    private String type;

    @Column(name = "phase")
    private String phase;

    @Column(name = "sub_phase")
    private String subPhase;

    @Column(name = "brief_profile",length = 1000)
    private String briefProfile;

    @Column(name = "product_lable_FDA")
    private String productLableFDA;

    @Column(name = "product_lable_EMA")
    private String productLableEMA;

    @Column(name = "target_population")
    private String targetPopulation;

    @Column(name = "moa")
    private String moa;

    @Column(name = "moa_acronym")
    private String moaAcronym;

    @Column(name = "drug_target")
    private String drugTarget;

    @Column(name = "drug_class")
    private String drugClass;

    @Column(name = "half_life")
    private String halfLife;

    @Column(name = "roa")
    private String roa;

    @Column(name = "dosing_regimen")
    private String dosingRegimen;

    @Column(name = "orphan_drug_designation",length = 1000)
    private String orphanDrugDesignation;

    @Column(name = "fast_track_designation")
    private String fastTrackDesignation;

    @Column(name = "break_through_designation")
    private String breakThroughDesignation;

    @Column(name = "estimated_approval")
    private String estimatedApproval;

    @Column(name = "SKU_approved")
    private String skuApproved;

    @Column(name = "first_approval")
    private String firstApproval;

    @Column(name = "In_Out_Of_Race")
    private String inOutOfRace;

    @Column(name = "reason_for_out_of_race")
    private String reasonForOutOfRace;




}
