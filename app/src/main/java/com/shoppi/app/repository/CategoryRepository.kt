package com.shoppi.app.repository

import com.shoppi.app.model.Category

class CategoryRepository(
    private val remoteDataSource: CategoryRemoteDataSource
) {
    //suspend를 붙여서 비동기로 동작하도록 만들어준다.
    suspend fun getCategories(): List<Category> {
        return remoteDataSource.getCategories()
    }
}