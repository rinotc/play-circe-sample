package controllers.user

import io.circe.Json
import io.circe.generic.auto._
import io.circe.syntax._
import models.User

final class UserResponse(user: User) {
  import UserResponse._

  private val response = Response(
    userId = user.id.value,
    name = user.name,
    role = user.role.code,
    projectHistories = user.projectHistories.map(ProjectHistoryResponse.apply)
  )

  val json: Json = response.asJson
}

object UserResponse {

  def apply(user: User) = new UserResponse(user)

  private case class Response(
      userId: Int,
      name: String,
      role: String,
      projectHistories: Seq[ProjectHistoryResponse]
  )
}
