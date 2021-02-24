package com.ironhack.EdgeBasicAuthHystrix.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("ReportsService")
public interface ReportsClient {

    /**Get report of {thing} by {otherthing}	Admin	GET	/report/{thing}/by/{otherthing}		none
     * Get statistics of {thing} by {type} 	Admin	GET	/stats/{type}/{thing}		none
     * */

//    reportLeadBySalesrep
//    reportOpportunityBySalesrep
//    reportOpportunityByProduct
//    reportOpportunityByIndustry
//    reportOpportunityByCountry
//    reportOpportunityByCity
//    reportOpenBySalesrep
//    reportOpenByProduct
//    reportOpenByIndustry
//    reportOpenByCountry
//    reportOpenByCity
//    reportClosed-WonBySalesrep
//    reportClosed-WonByProduct
//    reportClosed-WonByIndustry
//    reportClosed-WonByCountry
//    reportClosed-WonByCity
//    reportClosed-LostBySalesrep
//    reportClosed-LostByProduct
//    reportClosed-LostByIndustry
//    reportClosed-LostByCountry
//    ReportClosed-LosBy City
//

}
