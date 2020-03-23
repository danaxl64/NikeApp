package com.example.urbandicionary.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.urbandicionary.endpoint.ApiCallInterface
import com.example.urbandicionary.factory.ViewModelFactory
import com.example.urbandicionary.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ViewModelModule {

    @Provides
    @Singleton
    fun providesRepository(apiCallInterface: ApiCallInterface): Repository {
        return Repository(apiCallInterface)
    }

    @Provides
    @Singleton
    fun providesViewModelFactory(myRepository: Repository): ViewModelProvider.Factory {
        return ViewModelFactory(myRepository)
    }


}