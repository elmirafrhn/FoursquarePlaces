package com.farahani.elmira.domain.entity

/**
 * Created by elmira on 16, March, 2020
 */
data class CategoryObject(
    val id: String,
    val name: String,
    val pluralName: String,
    val shortName: String,
    val icon: IconObject,
    val primary: String
)