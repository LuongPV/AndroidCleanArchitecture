package com.pv.cleanarchitecture.data.mappers

interface ModelMapper<SourceType, DestType> {

    fun mapToDomain(sourceType: SourceType): DestType

}