package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.CompanyInfo

class CompanyInfoModel(
    val founder: String,
    val employees: String,
    val vehicles: String,
    val launchSites: String,
    val ceo: String,
    val cto: String,
    val coo: String,
    val ctoPropulsion: String,
    val valuation: String,
    val headquartersAddress: String,
    val headquartersCity: String,
    val headquartersState: String,
    val summary: String
)

object CompanyInfoModelMapper {

    fun map(companyInfo: CompanyInfo): CompanyInfoModel {
        return CompanyInfoModel(
            companyInfo.founder,
            companyInfo.employees.toString(),
            companyInfo.vehicles.toString(),
            companyInfo.launchSites.toString(),
            companyInfo.ceo,
            companyInfo.cto,
            companyInfo.coo,
            companyInfo.ctoPropulsion,
            companyInfo.valuation.toString(),
            companyInfo.headquartersAddress,
            companyInfo.headquartersCity,
            companyInfo.headquartersState,
            companyInfo.summary
        )
    }
}
