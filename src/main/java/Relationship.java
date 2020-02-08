import java.util.LinkedHashSet;

public class Relationship
{
    public static String getRelationshipFromFamilyTree(String relationShip, Person expectedPerson) {
        LinkedHashSet<Person> toReturn = new LinkedHashSet<>();
        toReturn = getPeopleFromRelationShip(expectedPerson, relationShip, toReturn);

        if(toReturn.isEmpty())
        {
            return Enums.NONE;
        }
        else
        {
            StringBuilder peoplePresent = new StringBuilder();
            for(Person present:toReturn)
            {
                peoplePresent.append(present.getUniqueName()).append(" ");
            }
            return peoplePresent.toString();
        }
    }

    public  static String addChildInFamilyTree(PopulateTree familyTree, String[] arr, Person expectedPerson) {
        String childName = arr[2];
        String childGender = arr[3];
        Person child = expectedPerson.addChildBasedOnMother(expectedPerson.getUniqueName(),childName,childGender);
        if(child == null)
        {
            return Enums.CHILD_ADDITION_FAILED;
        }
        else
        {
            familyTree.addPersonInFamily(child);
            return Enums.CHILD_ADDITION_SUCCEEDED;
        }
    }

    private static LinkedHashSet<Person> getPeopleFromRelationShip(Person expectedPerson, String relationShip, LinkedHashSet<Person> toReturn) {
        switch(relationShip)
        {
            case Enums.PATERNAL_UNCLE: toReturn = expectedPerson.getPaternalUncle();
                break;
            case Enums.PATERNAL_AUNT: toReturn = expectedPerson.getPaternalAunt();
                break;
            case Enums.MATERNAL_UNCLE: toReturn = expectedPerson.getMaternalUncle();
                break;
            case Enums.MATERNAL_AUNT: toReturn = expectedPerson.getMaternalAunt();
                break;
            case Enums.BROTHER_IN_LAW: toReturn = expectedPerson.getBrotherInLaw();
                break;
            case Enums.SISTER_IN_LAW: toReturn = expectedPerson.getSisterInLaw();
                break;
            case Enums.SON: toReturn = expectedPerson.getSon();
                break;
            case Enums.DAUGHTER: toReturn = expectedPerson.getDaughter();
                break;
            case Enums.SIBLINGS: toReturn = expectedPerson.getSiblings();
                break;
            default:
        }
        return toReturn;
    }
}
