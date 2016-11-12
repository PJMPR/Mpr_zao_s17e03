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
    	
    	Address ad1 = new Address();
    	ad1.setCity("Manchester");
    	ad1.setStreet("Street1");
    	ad1.setHouseNumber(1);

    	repo.add(jan);
    	repo.add(ola);
    	repo.add(ala);
    	addressRepo.add(ad1);
    	
    	//Person janFromDb = repo.get(0);
    	//System.out.print(jan.getName().equals(janFromDb.getName()));
    	//Address ad1FromDb = addressRepo.get(0);
    	//System.out.println();
    	
    	//repo.delete(janFromDb);
    	
    	for(Person p: repo.getAll()){

        	System.out.println(p.getId()+" "+p.getName() +" "+p.getAge());
    	}
    	
    	System.out.print("Koniec");
    	
    }
}
