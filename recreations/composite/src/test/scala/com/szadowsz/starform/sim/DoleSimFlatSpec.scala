//package com.szadowsz.starform.sim
//
//import com.szadowsz.starform.config.dole.DoleProfile
//import com.szadowsz.starform.sim.calc.dole.planetismal.RandInsertStrat
//import java.util.Random
//import com.szadowsz.starform.sim.dole.DoleSimulation
//import org.scalatest.{FlatSpec, Matchers}
//
///**
//  * 03/10/2016.
//  */
//class DoleSimFlatSpec extends FlatSpec with Matchers {
//
//  behavior of "The Dole Implementation of Accrete Simulation"
//
//  it should "be able to replicate results" in {
//    val acrete = DoleSimulation(new DoleProfile())
//    val system1 = acrete.generateSystem()
//    val system2 = acrete.generateSystem(Option(system1.seed))
//
//    system2.seed should be (system1.seed)
//
//    system2.planets.length should be (system1.planets.length)
//
//    system2.planets should contain theSameElementsAs system1.planets
//  }
//}
