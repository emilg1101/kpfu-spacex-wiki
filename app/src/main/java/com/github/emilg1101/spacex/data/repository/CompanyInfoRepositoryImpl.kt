package com.github.emilg1101.spacex.data.repository

import com.github.emilg1101.spacex.data.repository.mapper.CompanyInfoMapper
import com.github.emilg1101.spacex.data.spacexapi.request.SpaceXApiRequest
import com.github.emilg1101.spacex.domain.entity.CompanyInfo
import com.github.emilg1101.spacex.domain.repository.CompanyInfoRepository
import io.reactivex.Single
import javax.inject.Inject

class CompanyInfoRepositoryImpl @Inject constructor() : CompanyInfoRepository {

    @field:Inject
    lateinit var api: SpaceXApiRequest

    override fun getCompanyInfo(): Single<CompanyInfo> {
        return api.getCompanyInfo()
            .map(CompanyInfoMapper::map)
    }
}
