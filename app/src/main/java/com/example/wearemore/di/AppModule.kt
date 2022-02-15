package com.example.wearemore.di

import com.example.wearemore.modal.apiRest.ApiServiceLogin
import com.example.wearemore.modal.dataSource.DataSourceLogin
import com.example.wearemore.modal.repository.LoginRepository
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://ongapi.alkemy.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideDataSourceLogin(retrofit: Retrofit):ApiServiceLogin{
        return retrofit.create(ApiServiceLogin::class.java)
    }

    @Singleton
    @Provides
    fun provideDataSourceLogin(postLogin:ApiServiceLogin):DataSourceLogin{
        return DataSourceLogin(postLogin)
    }

    @Singleton
    @Provides
    fun provideRepositoryLogin(dataSourceLogin:DataSourceLogin):LoginRepository{
        return LoginRepository(dataSourceLogin)
    }
}