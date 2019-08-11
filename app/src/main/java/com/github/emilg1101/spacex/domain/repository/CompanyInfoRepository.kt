package com.github.emilg1101.spacex.domain.repository

import com.github.emilg1101.spacex.domain.entity.CompanyInfo
import io.reactivex.Single

interface CompanyInfoRepository {

    fun getCompanyInfo(): Single<CompanyInfo>
}
