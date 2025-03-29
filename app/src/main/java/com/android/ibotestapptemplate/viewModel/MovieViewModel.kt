package com.android.ibotestapptemplate.viewModel

import androidx.lifecycle.ViewModel
import com.android.ibotestapptemplate.Reository.MovieRepository
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel(){

}