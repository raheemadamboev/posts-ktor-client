package xyz.teamgravity.postsktorclient.domain.repository

import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.postsktorclient.common.Resource
import xyz.teamgravity.postsktorclient.data.remote.dto.PostDto
import xyz.teamgravity.postsktorclient.domain.model.PostModel

interface PostsRepository {

    fun getPosts(): Flow<Resource<List<PostModel>>>

    fun postPost(post: PostDto): Flow<Resource<PostDto>>
}