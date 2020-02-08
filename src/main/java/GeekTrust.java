import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GeekTrust
{
    public static void main(String args[]) throws IOException{
        PopulateTree familyTree = new PopulateTree();
        familyTree.populateAlreadyGivenStructure();
        File file = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null)
        {
            String arr[] = st.split(" ");
            String command = arr[0];
            String uniqueNameToSearch = arr[1];
            Person expectedPerson = familyTree.getExpectedPerson(uniqueNameToSearch);
            if(expectedPerson == null)
            {
                System.out.println(Enums.PERSON_NOT_FOUND);
            }
            else
                {
                    //person found
                    Relationship relationship = new Relationship();
                    String toPrint = "";
                    switch(command)
                    {
                        case Enums.ADD_CHILD:
                            //handling of gender, is done in function addChildBasedOnMother
                             toPrint = relationship.addChildInFamilyTree(familyTree, arr, expectedPerson);
                            System.out.println(toPrint);
                            break;
                        case Enums.GET_RELATIONSHIP:
                             toPrint = relationship.getRelationshipFromFamilyTree(arr[2], expectedPerson);
                             System.out.println(toPrint);
                            break;
                        default:

                    }
            }
        }
    }


}
