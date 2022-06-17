package models

import java.time.LocalDate

case class ProjectHistory(
    projectName: String,
    startDate: LocalDate,
    endDate: Option[LocalDate]
)
