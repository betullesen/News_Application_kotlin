package com.betulesen.newsapplication.repository

import androidx.room.Query
import com.betulesen.newsapplication.api.RetrofitInstance
import com.betulesen.newsapplication.db.ArticleDatabase
import com.betulesen.newsapplication.models.Article
import java.util.Locale.IsoCountryCode

class NewsRepository(val db : ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String,pageNumber:Int) =
        RetrofitInstance.api.getHeadlines(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String,pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavoritesNews() = db.getArticleDao().getALLArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}