package xyz.teamgravity.postsktorclient.data.remote

import xyz.teamgravity.postsktorclient.data.remote.dto.PostDto
import xyz.teamgravity.postsktorclient.domain.model.PostModel

interface PostsApi {

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val POSTS_URL = "$BASE_URL/posts"
    }

    suspend fun getPosts(): List<PostDto>

    suspend fun postPost(post: PostDto): PostDto?
}