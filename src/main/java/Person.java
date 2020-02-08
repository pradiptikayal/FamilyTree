
import java.util.LinkedHashSet;

public class Person
{
    private Person father;
    private Person mother;
    private Person spouse;
    private String gender;
    private String uniqueName;
    private LinkedHashSet<Person> children = new LinkedHashSet<>();

    Person(String uniqueName, String gender, Person father, Person mother, Person spouse)
    {
        this.uniqueName = uniqueName;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
    }

    public void addChildren(Person child)
    {
        this.children.add(child);
    }
    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public LinkedHashSet<Person> getChildren() {
        return children;
    }

    public void setChildren(LinkedHashSet<Person> children) {
        this.children = children;
    }

    // getSiblings
    public LinkedHashSet<Person> getSiblings()
    {
        Person father = this.getFather();
        LinkedHashSet<Person> siblingsIncludingMe = father != null ? father.getChildren(): null;
        LinkedHashSet<Person> siblings = new LinkedHashSet<>();
        if(father != null) {
            for (Person present : siblingsIncludingMe) {
                if (present.getUniqueName().equalsIgnoreCase(this.getUniqueName())) {
                    continue;
                }
                siblings.add(present);
            }
        }
        return siblings;
    }

    // get sons
    public LinkedHashSet<Person> getSon()
    {
        LinkedHashSet<Person> myChild = this.getChildren();
        LinkedHashSet<Person> sons = new LinkedHashSet<>();
        for(Person present:myChild)
        {
            if(present.getGender().equalsIgnoreCase("Male"))
            {
                sons.add(present);
            }
        }
        return sons;
    }

    // get daughter
    public LinkedHashSet<Person> getDaughter()
    {
        LinkedHashSet<Person> myChild = this.getChildren();
        LinkedHashSet<Person> daughters = new LinkedHashSet<>();
        for(Person present:myChild)
        {
            if(present.getGender().equalsIgnoreCase("Female"))
            {
                daughters.add(present);
            }
        }
        return daughters;
    }

    // get brothers

    public LinkedHashSet<Person> getBrothers()
    {
        LinkedHashSet<Person> siblingsIncludingMe = this.father != null ? this.getFather().getChildren(): null;
        LinkedHashSet<Person> brothers = new LinkedHashSet<>();
        if(this.father != null) {
            for (Person present : siblingsIncludingMe) {
                if (present.getGender().equalsIgnoreCase("Male") &&
                        !present.getUniqueName().equalsIgnoreCase(this.getUniqueName())) {
                    brothers.add(present);
                }
            }
        }
        return brothers;
    }
    // get sisters
    public LinkedHashSet<Person> getSisters()
    {
        LinkedHashSet<Person> siblingsIncludingMe = this.father != null ? this.getFather().getChildren(): null;
        LinkedHashSet<Person> sisters = new LinkedHashSet<>();
        if(this.father != null) {
            for (Person present : siblingsIncludingMe) {
                if (present.getGender().equalsIgnoreCase("Female") &&
                        !present.getUniqueName().equalsIgnoreCase(this.getUniqueName())) {
                    sisters.add(present);
                }
            }
        }
        return sisters;
    }
    // get brother-in-law
    public LinkedHashSet<Person> getBrotherInLaw()
    {
        LinkedHashSet<Person> brother_in_law = new LinkedHashSet<>();
        //case1--> spouse's brothers
        if(this.getSpouse() != null)
        {
            brother_in_law.addAll(this.getSpouse().getBrothers());
        }
        //case 2--> husbands of siblings
        LinkedHashSet<Person> siblings = this.getSiblings();
        for(Person present: siblings)
        {
            if(present.getSpouse() != null && present.getSpouse().getGender().equalsIgnoreCase("Male"))
            {
                brother_in_law.add(present.getSpouse());
            }
        }
        return brother_in_law;

    }

    // get sister - in - law
    public LinkedHashSet<Person> getSisterInLaw()
    {
        LinkedHashSet<Person> sister_in_law = new LinkedHashSet<>();
        //case1--> spouse's sisters
        if(this.getSpouse() != null)
        {
            sister_in_law.addAll(this.getSpouse().getSisters());
        }
        // case 2--> wives of siblings
        LinkedHashSet<Person> siblings = this.getSiblings();
        for(Person present: siblings)
        {
            if(present.getSpouse() != null && present.getSpouse().getGender().equalsIgnoreCase("Female"))
            {
                sister_in_law.add(present.getSpouse());
            }
        }
        return sister_in_law;
    }

    // get maternal aunt
    public LinkedHashSet<Person> getMaternalAunt()
    {
        Person maternalGrandFather = this.getMother() != null? this.getMother().getFather(): null;
        LinkedHashSet<Person> maternalUnclesAndAunts = maternalGrandFather != null ? maternalGrandFather.getChildren(): null;
        LinkedHashSet<Person> maternalAunt = new LinkedHashSet<>();
        if(maternalUnclesAndAunts != null)
        {
            for(Person present: maternalUnclesAndAunts)
            {
                if(present.getGender().equalsIgnoreCase("Female") &&
                        !present.getUniqueName().equalsIgnoreCase(this.getMother().getUniqueName()))
                {
                    maternalAunt.add(present);
                }
            }
        }
        return maternalAunt;
    }

    // get maternal uncle
    public LinkedHashSet<Person> getMaternalUncle()
    {
        Person maternalGrandFather = this.getMother() != null? this.getMother().getFather(): null;
        LinkedHashSet<Person> maternalUnclesAndAunts = maternalGrandFather != null ? maternalGrandFather.getChildren(): null;
        LinkedHashSet<Person> maternalUncle = new LinkedHashSet<>();
        if(maternalUnclesAndAunts != null)
        {
            for(Person present: maternalUnclesAndAunts)
            {
                if(present.getGender().equalsIgnoreCase("Male"))
                {
                    maternalUncle.add(present);
                }
            }
        }
        return maternalUncle;
    }

    //get paternal Uncle
    public LinkedHashSet<Person> getPaternalUncle()
    {
        Person paternalGrandFather = this.getFather()!= null?this.getFather().getFather(): null;
        LinkedHashSet<Person> paternalUnclesAndAunts = paternalGrandFather != null ? paternalGrandFather.getChildren(): null;
        LinkedHashSet<Person> paternalUncle = new LinkedHashSet<Person>();
        if(paternalGrandFather != null)
        {
            for(Person present: paternalUnclesAndAunts)
            {
                if(present.getGender().equalsIgnoreCase("Male") &&
                !this.getFather().getUniqueName().equalsIgnoreCase(present.getUniqueName()))
                {
                    paternalUncle.add(present);
                }
            }
        }
        return paternalUncle;
    }

    //get paternal Aunt
    public LinkedHashSet<Person> getPaternalAunt()
    {
        Person paternalGrandFather = this.getFather()!= null?this.getFather().getFather(): null;
        LinkedHashSet<Person> paternalUnclesAndAunts = paternalGrandFather != null ? paternalGrandFather.getChildren(): null;
        LinkedHashSet<Person> paternalAunt = new LinkedHashSet<>();
        if(paternalGrandFather != null)
        {
            for(Person present: paternalUnclesAndAunts)
            {
                if(present.getGender().equalsIgnoreCase("Female"))
                {
                    paternalAunt.add(present);
                }
            }
        }
        return paternalAunt;
    }

    public Person addChildBasedOnMother(String motherUniqueNme, String childName, String childGender)
    {
        Person child = null;
        if(this.getGender().equalsIgnoreCase("Female") && this.getSpouse() != null &&
                this.getUniqueName().equalsIgnoreCase(motherUniqueNme))
        {
            child = new Person(childName,childGender,this.getSpouse(),this,null);
            this.addChildren(child);
            this.spouse.addChildren(child);
        }
        return child;
    }

    public String getGender() {
        return gender;
    }



    public String getUniqueName() {
        return uniqueName;
    }


}
