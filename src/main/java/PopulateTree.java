


import java.util.HashMap;

public class PopulateTree {

    // map stores uniqueName to Person Object
    private HashMap<String,Person> uniqueNameToPersonMap = new HashMap<>();

    public void populateAlreadyGivenStructure()
    {
        // populates Already Given Family Tree
        populateForKingAndQueen();
        populateForFirstGeneration();
        populateForSecondGeneration();
        populateForThirdGeneration();
    }

    private void populateForSecondGeneration() {
        populateForSecondGenerationForChit();
        populateForSecondGenerationForVichAndLika();
        populateForSecondGenerationForArasAndChitra();
        populateForSecondGenerationForSatyaAndVyan();
    }

    private void populateForKingAndQueen()
    {
        Person king = new Person("King Shan",Enums.MALE,null,null,null);
        Person queen = new Person("Queen Anga",Enums.FEMALE,null, null,king);
        king.setSpouse(queen);
        this.uniqueNameToPersonMap.put("King Shan",king);
        this.uniqueNameToPersonMap.put("Queen Anga",queen);
    }

    private void populateForFirstGeneration()
    {
        Person king = this.uniqueNameToPersonMap.get("King Shan");
        Person queen = this.uniqueNameToPersonMap.get("Queen Anga");
        Person chit = new Person("Chit",Enums.MALE,king, queen,null);
        Person amba = new Person("Amba",Enums.FEMALE,null,null,chit);
        chit.setSpouse(amba);

        this.uniqueNameToPersonMap.put("Chit",chit);
        this.uniqueNameToPersonMap.put("Amba",amba);

        Person ish = new Person("Ish",Enums.MALE,king, queen, null);

        this.uniqueNameToPersonMap.put("Ish",ish);

        Person vich = new Person("Vich",Enums.MALE,king, queen, null);
        Person lika = new Person("Lika",Enums.FEMALE,null, null,vich);
        vich.setSpouse(lika);

        this.uniqueNameToPersonMap.put("Vich",vich);
        this.uniqueNameToPersonMap.put("Lika",lika);

        Person aras = new Person("Aras",Enums.MALE,king,queen,null);
        Person chitra = new Person("Chitra",Enums.FEMALE,null, null,aras);
        aras.setSpouse(chitra);

        this.uniqueNameToPersonMap.put("Aras",aras);
        this.uniqueNameToPersonMap.put("Chitra",chitra);

        Person satya = new Person("Satya",Enums.FEMALE, king, queen, null);
        Person vyan = new Person("Vyan",Enums.MALE,null,null,satya);
        satya.setSpouse(vyan);

        this.uniqueNameToPersonMap.put("Satya",satya);
        this.uniqueNameToPersonMap.put("Vyan",vyan);

        setRelationOfFirstGenerationWithKingAndQueen(king, queen, chit, ish, vich, aras, satya);
    }

    private void setRelationOfFirstGenerationWithKingAndQueen(Person king, Person queen, Person chit, Person ish, Person vich, Person aras, Person satya) {
        king.addChildren(chit);
        king.addChildren(ish);
        king.addChildren(vich);
        king.addChildren(aras);
        king.addChildren(satya);

        queen.setChildren(king.getChildren());
    }

    private void populateForSecondGenerationForChit()
    {
        Person chit = this.uniqueNameToPersonMap.get("Chit");
        Person amba = this.uniqueNameToPersonMap.get("Amba");
        Person dritha = new Person("Dritha",Enums.FEMALE,chit,amba,null);
        Person jaya = new Person("Jaya",Enums.MALE,null,null,dritha);
        dritha.setSpouse(jaya);

        this.uniqueNameToPersonMap.put("Dritha",dritha);
        this.uniqueNameToPersonMap.put("Jaya",jaya);

        Person tritha = new Person("Tritha",Enums.FEMALE,chit,amba,null);
        Person vritha = new Person("Vritha",Enums.MALE,chit,amba,null);

        this.uniqueNameToPersonMap.put("Tritha",tritha);
        this.uniqueNameToPersonMap.put("Vritha",vritha);

        chit.addChildren(dritha);
        chit.addChildren(tritha);
        chit.addChildren(vritha);

        amba.setChildren(chit.getChildren());
    }

    private void populateForSecondGenerationForVichAndLika()
    {
        Person vich = this.uniqueNameToPersonMap.get("Vich");
        Person lika = this.uniqueNameToPersonMap.get("Lika");

        Person vila = new Person("Vila",Enums.FEMALE,vich,lika,null);
        Person chika = new Person("Chika",Enums.FEMALE,vich,lika,null);

        this.uniqueNameToPersonMap.put("Vila",vila);
        this.uniqueNameToPersonMap.put("Chika",chika);

        vich.addChildren(vila);
        vich.addChildren(chika);
        lika.setChildren(vich.getChildren());
    }

    private void populateForSecondGenerationForArasAndChitra()
    {
        Person aras = this.uniqueNameToPersonMap.get("Aras");
        Person chitra = this.uniqueNameToPersonMap.get("Chitra");

        Person jnki = new Person("Jnki",Enums.FEMALE,aras,chitra,null);
        Person arit = new Person ("Arit",Enums.MALE,null,null,jnki);
        jnki.setSpouse(arit);

        this.uniqueNameToPersonMap.put("Jnki",jnki);
        this.uniqueNameToPersonMap.put("Arit",arit);
        Person ahit = new Person("Ahit",Enums.MALE,aras, chitra, null);

        this.uniqueNameToPersonMap.put("Ahit",ahit);
        aras.addChildren(jnki);
        aras.addChildren(ahit);

        chitra.setChildren(aras.getChildren());
    }

    private void populateForSecondGenerationForSatyaAndVyan()
    {
        Person vyan = this.uniqueNameToPersonMap.get("Vyan");
        Person satya = this.uniqueNameToPersonMap.get("Satya");

        Person asva = new Person("Asva",Enums.MALE,vyan,satya,null);
        Person satvy = new Person("Satvy",Enums.FEMALE, null, null ,asva);
        asva.setSpouse(satvy);

        this.uniqueNameToPersonMap.put("Asva",asva);
        this.uniqueNameToPersonMap.put("Satvy",satvy);

        Person vyas = new Person("Vyas",Enums.MALE,vyan,satya,null);
        Person krpi = new Person("Krpi",Enums.FEMALE, null, null, vyas);
        vyas.setSpouse(krpi);

        this.uniqueNameToPersonMap.put("Vyas",vyas);
        this.uniqueNameToPersonMap.put("Krpi",krpi);
        Person atya = new Person("Atya",Enums.FEMALE, vyan, satya, null);

        this.uniqueNameToPersonMap.put("Atya",atya);
        vyan.addChildren(asva);
        vyan.addChildren(vyas);
        vyan.addChildren(atya);

        satya.setChildren(vyan.getChildren());
    }

    private void populateForThirdGeneration()
    {
        Person jaya = this.uniqueNameToPersonMap.get("Jaya");
        Person dritha = this.uniqueNameToPersonMap.get("Dritha");
        Person arit = this.uniqueNameToPersonMap.get("Arit");
        Person jnki = this.uniqueNameToPersonMap.get("Jnki");
        Person asva = this.uniqueNameToPersonMap.get("Asva");
        Person satvy = this.uniqueNameToPersonMap.get("Satvy");
        Person vyas = this.uniqueNameToPersonMap.get("Vyas");
        Person krpi = this.uniqueNameToPersonMap.get("Krpi");

        Person yodhan = new Person("Yodhan",Enums.MALE,jaya,dritha,null);

        this.uniqueNameToPersonMap.put("Yodhan",yodhan);
        dritha.addChildren(yodhan);
        jaya.setChildren(dritha.getChildren());

        Person laki = new Person ("Laki",Enums.MALE,arit,jnki,null);
        Person lavnya = new Person("Lavnya",Enums.FEMALE,arit, jnki, null);

        this.uniqueNameToPersonMap.put("Laki",laki);
        this.uniqueNameToPersonMap.put("Lavnya",lavnya);

        arit.addChildren(laki);
        arit.addChildren(lavnya);
        jnki.setChildren(arit.getChildren());

        Person vasa = new Person("Vasa",Enums.MALE,asva, satvy, null);
        this.uniqueNameToPersonMap.put("Vasa",vasa);
        asva.addChildren(vasa);
        satvy.setChildren(asva.getChildren());

        Person kriya = new Person("Kriya",Enums.MALE,vyas,krpi,null);
        Person krithi = new Person("Krithi",Enums.FEMALE,vyas,krpi, null);

        this.uniqueNameToPersonMap.put("Kriya",kriya);
        this.uniqueNameToPersonMap.put("Krithi",krithi);
        vyas.addChildren(kriya);
        vyas.addChildren(krithi);
        krpi.setChildren(vyas.getChildren());
    }


    public Person getExpectedPerson(String uniqueName)
    {
        return this.uniqueNameToPersonMap.getOrDefault(uniqueName,null);
    }

    public void addPersonInFamily(Person person)
    {
        this.uniqueNameToPersonMap.put(person.getUniqueName(),person);
    }

}
