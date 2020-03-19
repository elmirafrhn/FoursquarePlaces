package com.farahani.elmira.data.entity.dto

import com.farahani.elmira.data.entity.dto.IconEntity

/**
 * Created by elmira on 16, March, 2020
 */
data class CategoryEntity(
    val id: String,
    val name: String,
    val pluralName: String,
    val shortName: String,
    val icon: IconEntity,
    val primary: String
)