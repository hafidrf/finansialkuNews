package com.hafidrf.finansialku.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.disposables.CompositeDisposable
import com.hafidrf.finansialku.data.factory.Factory
import com.hafidrf.finansialku.data.network.ApiService
import com.hafidrf.finansialku.data.repository.DataRepository
import com.hafidrf.finansialku.data.repository.remote.RemoteRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRemoteRepository(
        disposable: CompositeDisposable,
        apiService: ApiService,
        factory: Factory
    ) : RemoteRepository = RemoteRepository(disposable, apiService, factory)

    @Provides
    @Singleton
    fun provideDataRepository(
        remoteRepository: RemoteRepository
    ) : DataRepository = DataRepository(remoteRepository)
}