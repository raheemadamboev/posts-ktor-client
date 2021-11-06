package xyz.teamgravity.postsktorclient.data.remote.dto

import kotlinx.serialization.Serializable
import xyz.teamgravity.postsktorclient.domain.model.PostModel

@Serializable
data class PostDto(
    val body: String,
    val title: String,
    val id: Int,
    val userId: Int
)

fun PostDto.toPost(): PostModel {
    return PostModel(
        body = body,
        title = title,
        userId = userId
    )
}