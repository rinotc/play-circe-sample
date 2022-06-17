package controllers.user

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

import java.time.LocalDate

case class ProjectHistoryRequest(
    projectName: String,
    startDate: LocalDate,
    endDate: Option[LocalDate]
)

object ProjectHistoryRequest {
  implicit val decoder: Decoder[ProjectHistoryRequest] = deriveDecoder[ProjectHistoryRequest]
}
