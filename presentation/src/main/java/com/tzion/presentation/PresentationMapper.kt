package com.tzion.presentation

interface PresentationMapper<V, D> {

    fun mapToView(domain: D): V

    fun mapFromView(view: V): D

}