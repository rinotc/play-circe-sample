package controllers.user

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

case class AddUserRequest(
    name: String,
    role: String,
    projectHistories: Seq[ProjectHistoryRequest]
)

object AddUserRequest {
  implicit val decoder: Decoder[AddUserRequest] = deriveDecoder[AddUserRequest]
}
