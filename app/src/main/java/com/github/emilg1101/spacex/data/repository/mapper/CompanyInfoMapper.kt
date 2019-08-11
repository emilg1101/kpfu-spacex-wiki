package com.github.emilg1101.spacex.data.repository.mapper

import com.github.emilg1101.spacex.domain.entity.CompanyInfo

typealias CompanyInfoEntity = com.github.emilg1101.spacex.data.spacexapi.pojo.response.CompanyInfo

object CompanyInfoMapper {

    fun map(entity: CompanyInfoEntity): CompanyInfo {
        return CompanyInfo(
            entity.founder,
            entity.employees,
            entity.vehicles,
            entity.launchSites,
            entity.ceo,
            entity.cto,
            entity.coo,
            entity.ctoPropulsion,
            entity.valuation.toLong(),
            entity.headquarters.address,
            entity.headquarters.city,
            entity.headquarters.state,
            entity.summary
        )
    }
}
