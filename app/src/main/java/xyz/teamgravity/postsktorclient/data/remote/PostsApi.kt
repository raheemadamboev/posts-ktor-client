package xyz.teamgravity.postsktorclient.data.remote

import xyz.teamgravity.postsktorclient.data.remote.dto.PostDto
import xyz.teamgravity.postsktorclient.domain.model.PostModel

interface PostsApi {

    suspend fun getPosts(): List<PostDto>

    suspend fun postPost(post: PostModel): PostDto?
}