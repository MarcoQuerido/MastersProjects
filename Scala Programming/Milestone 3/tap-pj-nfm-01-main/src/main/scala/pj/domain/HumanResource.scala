package pj.domain

final case class HumanResource(id: HumanId, name: String, skills: Set[ResourceType])
