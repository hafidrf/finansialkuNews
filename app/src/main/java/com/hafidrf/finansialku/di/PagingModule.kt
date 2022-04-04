package com.hafidrf.finansialku.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.disposables.CompositeDisposable
import com.hafidrf.finansialku.data.factory.Factory
import com.hafidrf.finansialku.data.factory.NewsFactory
import com.hafidrf.finansialku.data.factory.SearchFactory
import com.hafidrf.finansialku.data.network.ApiService
import com.hafidrf.finansialku.data.source.NewsSource
import com.hafidrf.finansialku.data.source.SearchSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PagingModule {
    @Provides
    @Singleton
    fun provideFactory(
        newsFactory: NewsFactory,
        searchFactory: SearchFactory
    ) : Factory = Factory(
            newsFactory,
            searchFactory
    )

    @Provides
    @Singleton
    fun provideNewsSource(
        apiService: ApiService,
        disposable: CompositeDisposable
    ) : NewsSource = NewsSource(apiService, disposable)

    @Provides
    @Singleton
    fun provideSearchSource(
        apiService: ApiService,
        disposable: CompositeDisposable
    ) : SearchSource = SearchSource(apiService, disposable)

    @Provides
    @Singleton
    fun provideNewsFactory(
        newsSource: NewsSource
    ) : NewsFactory = NewsFactory(newsSource)

    @Provides
    @Singleton
    fun provideSearchFactory(
        searchSource: SearchSource
    ) : SearchFactory = SearchFactory(searchSource)
}