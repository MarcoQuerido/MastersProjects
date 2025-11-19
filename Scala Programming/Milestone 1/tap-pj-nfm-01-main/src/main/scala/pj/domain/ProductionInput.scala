package pj.domain

final case class ProductionInput(
                            orders: List[Order],
                            products: List[Product],
                            tasks: List[Task],
                            humans: List[HumanResource],
                            physicals: List[PhysicalResource]
                          )
