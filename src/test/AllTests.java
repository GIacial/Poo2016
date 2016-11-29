package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Test_Exit.class, Test_Place.class, Test_Inventory.class, Test_EquipementSet.class,Test_FinalDoor.class})

public class AllTests {

}
