package xyz.teamgravity.postsktorclient.domain.model

data class PostModel(
    val body: String,
    val title: String,
    val id: Int,
    val userId: Int
)
