package xyz.teamgravity.postsktorclient.presentation

import xyz.teamgravity.postsktorclient.domain.model.PostModel

data class PostsState(
    val posts: List<PostModel>? = null,
    val loading: Boolean = false,
    val error: String? = null
)
