package uzuzjmd.competence.mapper.gui.filter

import uzuzjmd.competence.owl.dao.Competence
import uzuzjmd.competence.owl.ontology.CompObjectProperties

object Ont2SuggestedCompetencyGridFilter {
  def filterisSuggestedCompetency(pair: (Competence, Competence)): Boolean = {
    return pair._1.hasEdge(CompObjectProperties.SuggestedCompetencePrerequisiteOf, pair._2)
  }

  def sortCompetencePairs(a: (Competence, Competence), b: (Competence, Competence)): Boolean = {
    return filterisSuggestedCompetency((a._2, b._1)) || filterisSuggestedCompetency((b._2, a._1))
  }
}