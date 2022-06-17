package controllers.user

import models.ProjectHistory

import java.time.LocalDate

final case class ProjectHistoryResponse(
    projectName: String,
    startDate: LocalDate,
    endDate: Option[LocalDate]
)

object ProjectHistoryResponse {

  def apply(p: ProjectHistory): ProjectHistoryResponse = apply(p.projectName, p.startDate, p.endDate)
}
