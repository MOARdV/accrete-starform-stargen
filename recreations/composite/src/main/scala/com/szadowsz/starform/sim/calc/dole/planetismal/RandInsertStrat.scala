package com.szadowsz.starform.sim.calc.dole.planetismal

import com.szadowsz.starform.rand.RandGenTrait
import com.szadowsz.starform.sim.bodies.DustBand
import com.szadowsz.starform.sim.calc.planetesimal.PlanetesimalInsertStrat
import com.szadowsz.starform.sim.constants.AccreteConstants

import scala.util.Random

/**
  * Default strategy to insert new planetismals into the system.
  *
  * @author zakski : 30/09/2016.
  */
class RandInsertStrat(protected override val aConst : AccreteConstants) extends PlanetesimalInsertStrat {

  /**
    * Function to produce the semi major axis of a planetesimal. Formula taken from "Formation of Planetary Systems by Aggregation: A Computer Simulation" in
    * "III. Experimental Simulation, section b) The Planetary Nuclei".
    *
    * @note made minor cosmetic change from 50Yi, where Yi is a random number and 50 is outer limit. Innermost limit is
    *       mentioned separately originally.
    * @note unit of return value is AU
    *
    * @see pp. 15-17, Formation of Planetary Systems by Aggregation: A Computer Simulation - Stephen H. Dole
    * @see method RandomPlanetismal, line 58 in Planetismal.java - Ian Burrell (accrete)
    * @see method distribute_planetary_masses, line 405 in accrete.c - Mat Burdick (accrete)
    * @see method ComputePlanetStats, lines 156-163 in Dole.c - Andrew Folkins (accretion)
    * @see method CreatePlanet, lines 211-223 in dole.c - Keris (accretion v1)
    * @see method CreatePlanet, line 301 in dole.cc - Keris (accretion v2)
    * @see method dist_planetary_masses, line 433 in accrete.c - Keris (starform)
    * @see method dist_planetary_masses, line 403 in accrete.c - Mat Burdick (starform)
    * @see constructor Protoplanet, line 150 in  Protoplanet.java - Carl Burke (starform)
    *
    * @param rand    - a random number generator to supply a value between 0.0 and 1.0
    * @param innermost the closest distance to the parent star that a planet can form at.
    * @param outermost the furthest distance from the parent star that a planet can form at.
    * @param bands   the current state of the accretion disc that the new planetismal will be inserted into.
    * @return the semi major axis of a planetismal orbiting a star in AU.
    */
  override def semiMajorAxis(rand: RandGenTrait, nucleiCount : Int, innermost: Double, outermost: Double, bands: List[DustBand]): Double = {
    innermost + (outermost - innermost) * rand.nextDouble()
  }
 }
