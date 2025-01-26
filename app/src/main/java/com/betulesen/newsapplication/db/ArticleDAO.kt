package com.betulesen.newsapplication.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.betulesen.newsapplication.models.Article

@Dao
interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article) : Long

    @Query("SELECT * FROM articles")
    fun getALLArticles() : LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}