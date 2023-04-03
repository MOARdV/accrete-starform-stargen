// scalastyle:off method.name
package com.szadowsz.starform.sim.dole

import com.szadowsz.starform.config.dole.DoleProfile
import com.szadowsz.starform.sim.AccreteSimulation
import com.szadowsz.starform.system.bodies.dole.{DolePlanet, DoleStar}
import com.szadowsz.starform.system.dole.AccreteSystem

case class DoleSimulation(profile: DoleProfile, a: Option[Double] = None, k: Option[Double] = None, w: Option[Double] = None)
  extends AccreteSimulation[DoleStar,AccreteStats, DolePlanet, AccreteSystem](profile) {


  override val DUST_DENSITY_COEFF: Double = a.getOrElse(aConsts.DUST_DENSITY_COEFF)

  override val K: Double = k.getOrElse(aConsts.K)

  override val CLOUD_ECCENTRICITY: Double = w.getOrElse(aConsts.CLOUD_ECCENTRICITY)

  /**
    * Function to initialise a new instance at the beginning of each run.
    *
    * @return a new [[AccreteStats]] instance.
    */
  override protected def initStats(): AccreteStats = AccreteStats()

  /**
    * Function to generate the Planets via accretion. Separated out to allow for the generation of an atmosphere introduced in Martyn J. Fogg's paper.
    *
    * @return a new list of [[DolePlanet]] instances.
    */
  override protected def generatePlanets(): List[DolePlanet] = {
    star = new DoleStar()
    accrete()
    planetismals.map(new DolePlanet(_))
  }

  /**
    * Function to initialise a new solar system instance at the end of each run.
    *
    * @return a new [[AccreteSystem]] instance.
    */
  override protected def createSystem(seed: Long, stats: AccreteStats, planets: List[DolePlanet]): AccreteSystem = {
    AccreteSystem(star,seed, stats, planets)
  }
}