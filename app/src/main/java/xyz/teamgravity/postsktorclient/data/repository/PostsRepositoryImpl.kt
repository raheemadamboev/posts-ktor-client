package xyz.teamgravity.postsktorclient.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import xyz.teamgravity.postsktorclient.common.Resource
import xyz.teamgravity.postsktorclient.data.remote.PostsApi
import xyz.teamgravity.postsktorclient.data.remote.dto.PostDto
import xyz.teamgravity.postsktorclient.data.remote.dto.toPost
import xyz.teamgravity.postsktorclient.domain.model.PostModel
import xyz.teamgravity.postsktorclient.domain.repository.PostsRepository

class PostsRepositoryImpl(private val api: PostsApi) : PostsRepository {

    override fun getPosts(): Flow<Resource<List<PostModel>>> = flow {
        try {
            emit(Resource.Loading())
            val posts = api.getPosts().map { it.toPost() }
            emit(Resource.Success(data = posts))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message ?: "Error"))
        }
    }

    override fun postPost(post: PostDto): Flow<Resource<PostDto>> = flow {
        try {
            emit(Resource.Loading())
            val postResult = api.postPost(post)!!
            emit(Resource.Success(data = postResult))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error"))
        }
    }
}