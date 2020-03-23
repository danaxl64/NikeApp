package com.example.urbandicionary.di.component

import android.app.Application
import com.example.urbandicionary.di.module.ActivityModule
import com.example.urbandicionary.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,ActivityModule::class,ViewModelModule::class])
interface ApplicationComponent: AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

}