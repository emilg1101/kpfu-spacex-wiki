package com.github.emilg1101.spacex.domain.usecase.history

import com.github.emilg1101.spacex.domain.entity.CompanyInfo
import com.github.emilg1101.spacex.domain.repository.CompanyInfoRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCompanyInfoUseCase @Inject constructor() {

    @field:Inject
    lateinit var companyInfoRepository: CompanyInfoRepository

    fun getCompanyInfo(): Single<CompanyInfo> {
        return companyInfoRepository.getCompanyInfo()
    }
}
