v1.3 (CG4)

GUI:
+ Added Play log... and Save log... button.
+ Added Menu Bar with Game and Log buttons
+ Populated Game and Log buttons with individual buttons.
+ Added extra options in the options menu.

City:
* Changed equals() to function properly.
* Changed hashCode().
 
Country:
* Changed equals() to function properly.
* Changed hashCode().
 
BorderCity:
* Changed documentation of arrive().
- Removed variables.

CapitalCity:
* Changed documentation of arrive().
- Removed variables.

MafiaCountry:
- Removed variables.


v1.2 (CG3)

CountryTest:
+ Added an extra test to getRoads() (null check)
+ Added an extra test to getCities() (null check)
+ Added an extra test to addRoads() (null check)
+ Added some extra parameter checks to addRoads()
+ Added an extra test to readyToTravel() (null check)
+ Added some extra parameter checks to readyToTravel()
+ Added equals() tests
+ Added hashCode() tests

Country:
+ Added some extra null if statements in a few methods.
+ Added equals() method
+ Added hashCode() method
* Changed (and simplified) addRoads() method.

City:
+ Added arrive(Player p) method as dummy method.
+ Added equals() method
+ Added hashCode() method
* Changed arrive() method slightly.

CityTest:
+ Added equals() tests
+ Added hashCode() tests
+ Added an extra test to arrive() (MafiaCountry test)

BorderCity:
+ Implemented

BorderCityTest:
+ Implemented

CapitalCity:
+ Implemented

CapitalCityTest:
+ Implemented

MafiaCountry:
+ Implemented

MafiaCountryTest:
+ Implemented