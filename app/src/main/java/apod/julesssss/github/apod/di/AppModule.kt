package apod.julesssss.github.apod.di

import apod.julesssss.github.apod.data.repo.ApodRepository
import apod.julesssss.github.apod.network.ServiceProvider
import apod.julesssss.github.apod.ui.photodetail.PhotoDetailViewModel
import apod.julesssss.github.apod.ui.photodetail.imagegallery.ImageViewModel
import apod.julesssss.github.apod.ui.photolist.PhotoListViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val appModule = module {

    single { ApodRepository(get()) }

    single { ServiceProvider.buildNasaApodApi() }

    viewModel<PhotoListViewModel>()

    viewModel<PhotoDetailViewModel>()

    viewModel<ImageViewModel>()
}