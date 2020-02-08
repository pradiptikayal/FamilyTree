import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelationshipTest {

    Relationship relationship = new Relationship();
    PopulateTree tree = new PopulateTree();

    @BeforeEach
    void setUp() {
        Person father = new Person("John",Enums.MALE,null,null,null);
        Person mother = new Person("Lisa",Enums.FEMALE,null,null,father);
        father.setSpouse(mother);

        Person son = new Person("Rick",Enums.MALE,father,mother,null);
        Person daughter = new Person("Riya",Enums.FEMALE,father,mother,null);

        father.addChildren(son);
        father.addChildren(daughter);

        mother.setChildren(father.getChildren());

        tree.addPersonInFamily(father);
        tree.addPersonInFamily(mother);
        tree.addPersonInFamily(son);
        tree.addPersonInFamily(daughter);
    }

    @AfterEach
    void tearDown() {
        tree = new PopulateTree();
    }

    @Test
    void getSiblingsTest() {
        Person expectedPerson = tree.getExpectedPerson("Riya");
        String relation = "Siblings";
        String actualOutput = relationship.getRelationshipFromFamilyTree(relation,expectedPerson);
        String  expected = "Rick";
        assertEquals(expected.trim(),actualOutput.trim());
    }

    @Test
    void addChildTest() {
        String arr[] = new String[4];
        arr[2] = "Ketu";
        arr[3] = "Male";
        Person expectedPerson = tree.getExpectedPerson("Lisa");
        String actualOutput = relationship.addChildInFamilyTree(tree,arr,expectedPerson);
        String expectedOutput = Enums.CHILD_ADDITION_SUCCEEDED;
        assertEquals(expectedOutput.trim(),actualOutput.trim());
    }
}