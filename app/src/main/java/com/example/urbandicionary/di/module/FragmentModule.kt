package com.example.urbandicionary.di.module

import com.example.urbandicionary.ui.fragment.DetailFragment
import com.example.urbandicionary.ui.fragment.DefinitionFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributesDefinitionFragment(): DefinitionFragment

    @ContributesAndroidInjector
    abstract fun contributesDetailFragment(): DetailFragment

}