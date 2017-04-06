Accrete/Starform/Stargen
========================

## Intro

Accrete's origin dates back to the late 60's when Stephen H. Dole published "Formation of Planetary Systems by Aggregation: A Computer Simulation". 

It grew to prominence in the 90's after a recreated version of the source code based on a susequent paper by Martyn J. Fogg was released into the fertile ground that was the now defunct USML mailing list.

Since then there have been numerous versions, and the work on this module is primarily focused on preserving the timeline of events that I have pieced together.

More detailed analysis can be found in the docs folder.

## Requirements

- Gradle 3.4.x+
- Visual Studio 2015 (any edition)

## Source Code

This section contains general comments about the recovered source code for each processed version.

### Folkins
***

Andrew Folkin's codeline was initial designed for the amiga, then hacked about by Keris. 

#### Accretion (C)

I have added c/visual studio support from Burdick's branch to gradle to accommodate these major revisions.

##### 1995 - Andrew Folkins - Accretion
This particular version is folkins' original code designed for the amiga. So naturally it does not compile without the amiga libraries.

##### 1999 - Keris - Accretion v1
Keris modified Folkins code to be less specific to the amiga. I had to add the random number routine as they were not included in the general windows c libs.

#### Accretion (C++)

##### 2000 - Keris - Accretion v2
Keris modified Folkins code even further. I am not sure how to compile this code with its dependency on a couple of scripts and a wierd .ch file.

## Papers

The Research Papers that inspired all the extant accrete code. 

At some point I hope to go back through these and find improvements / enhancements suggested by papers that cite these and add them to my recreation as 
options. 

### Formation of Planetary Systems by Aggregation: A Computer Simulation
***
This is the main paper that the accretion part of the simulation is based upon. It was written in 1969 by Stephen Dole.

#### Basic Assumptions:
- 1 star of 1 solar mass and 1 solar luminosity (basically equivalent to our own star)
- Planets can form between the radii 0.3 astronomical units (AU) and 50.0 AU.

#### Features
- Generates a Believable (for the 60s/70/s/80s) Sol-like Solar System.

#### Limitations:
- No way to recreate exact tests results; even with a seed listed in the sample run, the age of the computer hardware he used means that accurately recreating
the pseudo-random number sequence is a tall order without the original software to hand. (internal random number generator of an IBM 7044 PC).

- Collision calculations are less than accurate due to not taking into account any axial inclinations on the orbital plane.

- No consideration given to the accretion of satellites.

- Dust Density Calculation are in 2D

### Computer Simulation of the Formation of Planetary Systems
***
Stephen Dole's follow-up paper which was published in Icarus a year later. 

Its main usages are as a cross-reference for references found in the previous paper, its comparison of a small dataset against the available accurate (for 
the time) measurements of the solar system, and its slightly alternate look at some of the formula used.

The model seems to be identical to the one in the previous paper.

### Computer Simulations of Planetary Accretion Dynamics: Sensitivity to Initial Conditions
***
A review/critique of the initial parameters and formulae of Dole's model written in 1977 by R. Isaacman and Carl Sagan.

#### Looks At/Discusses/Mentions
 
- initial dust density distribution formula

- the choices of orbital eccentricity for the dust cloud

- parallel growth and injection of plantismals

- varying the planetismal seed mass

- altering the dust to gas mass ratio

-  alternative planetary distancing

#### Conclusions

that ACRETE is missing some of the essential physics of solar system cosmogony, or that planetary systems of our type are only one example in a rich array of
alternative varieties of planetary systems. 

Likewise, more fundamental changes in the nebular morphology (e.g. from an exponential to a power law density 
distribution function) generate planetary systems some of which, although they do not closely resemble our own, are not fundamentally objectionable.

### Extra-Solar Planetary Systems: A Microcomputer Simulation
***

This paper reconstitutes Dole's algorithm from his published works and condenses them into 2K of Basic code, able to be ran on microcomputers built at the time.

After that he adds his own improvements and enhancements to the model.

This paper is the one that Matt Burdick based his code on.

#### Changes

- varies mass of star between 0.7 & 1.3 solar masses. Spectral classes K5-F5.

- adjusts minimum and maximum planetary formation distance by luminosity of star.

- adjusts the planetary critical mass formula (limit at which planet begins to accrete gas as well as dust) by luminosity of the star.

- varies the central density parameter by the mass of the star.

#### Features

- calculates the Luminosity, Age, Main Sequence Lifespan and Habitual Zone of the Star. 

- calculates the "Zone", Density, Radius, Day Length, Orbit Period and Spin Resonance of the Planets.

- calculates the atmospheric conditions of the Planets.

- assesses Habitability and possibility of Life on each Planet.


#### Limitations:
- No way to recreate the exact accretion tests results; even with a seed listed in the sample run, the age of the computer hardware he used means that
accurately recreating the pseudo-random number sequence is a tall order without the original software to hand. However unlike Dole's paper we can try to
verify the modern ecosphere code is correct by comparing the non-random functions against the sample data he provides.

- No solution for Dole's less than stellar Collision calculations.

- No consideration given to the accretion of satellites.

- Atmosphere decision gates and terrestrial planet composition derivations are not explained in the paper, because of this burdick and co's source code
regresses in these areas.
