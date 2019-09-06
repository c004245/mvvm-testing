package com.example.test_mvvm_git.service.model

import java.util.*

data class Project(
    val id: Long,
    val name: String,
    val description: String,
    val created_at: Date,
    val updated_at: Date,
    val git_url: String,
    val clone_url: String,
    val language: String,
    val open_issues: Int,
    val watchers: Int)