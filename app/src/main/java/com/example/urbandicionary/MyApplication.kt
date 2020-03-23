package com.example.urbandicionary

import com.example.urbandicionary.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class MyApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication?>? {
        return DaggerApplicationComponent.builder().application(this).build()

    }

}