package xyz.teamgravity.postsktorclient.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import xyz.teamgravity.postsktorclient.common.Resource
import xyz.teamgravity.postsktorclient.domain.repository.PostsRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(repository: PostsRepository) : ViewModel() {

    private val _state = mutableStateOf(PostsState())
    val state: State<PostsState> = _state

    init {
        repository.getPosts().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PostsState(posts = result.data!!, loading = false, error = null)
                }

                is Resource.Loading -> {
                    _state.value = PostsState(posts = null, loading = true, error = null)
                }

                is Resource.Error -> {
                    _state.value = PostsState(posts = null, loading = false, error = result.message)
                }
            }
        }.launchIn(viewModelScope)
    }
}