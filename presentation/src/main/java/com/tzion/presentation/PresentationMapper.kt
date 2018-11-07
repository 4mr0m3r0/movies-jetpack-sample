package com.tzion.presentation

interface PresentationMapper<P, D> {

    fun mapToPresentation(domain: D): P

    fun mapFromPresentation(presentation: P): D

}