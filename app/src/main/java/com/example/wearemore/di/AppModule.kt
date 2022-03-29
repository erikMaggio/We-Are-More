package com.example.wearemore.di

import com.example.wearemore.modal.apiRest.ApiServiceLogin
import com.example.wearemore.modal.dataSource.DataSourceLogin
import com.example.wearemore.modal.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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
    fun provideRepositoryLogin(apiServiceLogin: DataSourceLogin):LoginRepository{
        return LoginRepository(apiServiceLogin)
    }
    @Provides
    fun provideDataSource(apiServiceLogin: ApiServiceLogin): DataSourceLogin {
        return DataSourceLogin(apiServiceLogin)
    }
}