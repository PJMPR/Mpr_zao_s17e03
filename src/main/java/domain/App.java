package domain;

import dao.AddressRepository;
import dao.PersonRepository;

public class App 
{
    public static void main( String[] args )
    {
    	PersonRepository repo = new PersonRepository();
    	AddressRepository addressRepo = new AddressRepository();
    	
    	Person jan = new Person();
    	jan.setName("Jan");
    	jan.setSurname("Kowalski");
    	jan.setAge(30);
    	Person ola = new Person();
    	ola.setName("Ola");
    	ola.setSurname("Kowalska");
    	ola.setAge(22);
    	Person ala = new Person();
    	ala.setName("Ala");
    	ala.setSurname("Kowalska");
    	ala.setAge(44);
    	
    	Address adres1 = new Address();
    	adres1.setCity("Gdańsk");
    	adres1.setStreet("Długa");
    	adres1.setHouseNumber(12);
    	
    	Address adres2 = new Address();
    	adres2.setCity("Gdańsk");
    	adres2.setStreet("Jakaś");
    	adres2.setHouseNumber(32);

    	Address adres3 = new Address();
    	adres3.setCity("Płock");
    	adres3.setStreet("Ciemna");
    	adres3.setHouseNumber(32);
    	
    	repo.add(jan);
    	repo.add(ola);
    	repo.add(ala);
    	
    	addressRepo.add(adres1);
    	addressRepo.add(adres2);
    	addressRepo.add(adres3);
    	
    	Person janFromDb = repo.get(0);
    	System.out.print(jan.getName().equals(janFromDb.getName()));
    	
    	repo.delete(janFromDb);
    	
    	for(Person p: repo.getAll()){

        	System.out.println(p.getId()+" "+p.getName() +" "+p.getAge());
    	}
    	
    	System.out.print("Koniec");
    	
    }
}
