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
    	
    	repo.add(jan);
    	System.out.print("Koniec");
    }
}
