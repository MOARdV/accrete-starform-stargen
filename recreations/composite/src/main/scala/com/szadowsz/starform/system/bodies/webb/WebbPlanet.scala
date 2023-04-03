package com.szadowsz.starform.system.bodies.webb


import com.szadowsz.starform.sim.calc.traveller.UWPCalc
import com.szadowsz.starform.system.bodies.Planetismal
import com.szadowsz.starform.system.bodies.fogg.FoggPlanet

/**
  * Created on 02/05/2017.
  */
class WebbPlanet(
                  proto: Planetismal,
                  eqRad: Double,
                  den: Double,
                  lengthOfOrbit: Double,
                  lengthOfDay: Double,
                  grav: Double,
                  surfPressure: Double,
                  water: Double,
                  clouds: Double,
                  ice: Double,
                  alb: Double,
                  surfTemp: Double,
                  tilt : Double
                ) extends FoggPlanet(proto,eqRad,den,lengthOfOrbit,lengthOfDay,grav,surfPressure,water,clouds,ice,alb,surfTemp,tilt) with UWPCalc {

  val uwp : String = "X-" + calcUWPSize(equatorialRadius) + calcUWPAtmos(surfacePressure) + calcUWPHydrographics(hydrosphere,iceCover) + "XXX-X"
}
