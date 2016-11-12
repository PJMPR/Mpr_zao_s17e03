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

    	repo.add(jan);
    	repo.add(ola);
    	repo.add(ala);
    	
    	Address firstAddress = new Address();
    	firstAddress.setCity("Tczew");
    	firstAddress.setStreet("Grunwaldzka");
    	firstAddress.setHouseNumber(5);
    	Address secondAddress = new Address();
    	secondAddress.setCity("Gdańsk");
    	secondAddress.setStreet("Gdańska");
    	secondAddress.setHouseNumber(22);

    	addressRepo.add(firstAddress);
    	addressRepo.add(secondAddress);
    	
    	Person janFromDb = repo.get(0);
    	System.out.print(jan.getName().equals(janFromDb.getName()));
    	
    	repo.delete(janFromDb);
    	
    	for(Person p: repo.getAll()){

        	System.out.println(p.getId()+" "+p.getName() +" "+p.getAge());
    	}
    	
    	System.out.print("Koniec");
    	
    }
}
