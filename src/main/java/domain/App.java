package domain;

import dao.PersonRepository;

import java.util.List;

import dao.AddressRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	PersonRepository repo = new PersonRepository();
    	AddressRepository addressRepo = new AddressRepository();
    	Person jan = new Person();
    	Person stefan = new Person();
    	Person jacek = new Person();
    	
    	jan.setName("jan");
    	jan.setSurname("kowalski");
    	jan.setAge(30);
    	
    	stefan.setName("stefan");
    	stefan.setSurname("nowak");
    	stefan.setAge(30);
    	
    	jacek.setName("jacek");
    	jacek.setSurname("pasek");
    	jacek.setAge(30);
    	
    	repo.add(jan);
    	repo.add(stefan);
    	repo.add(jacek);
    	
    	//repo.delete(stefan);
    	
    	List<Person> people = repo.getAllPersons();
    	for(Person person: people){
       		System.out.println("id: "+person.getId()+"\tname: "+person.getName()+"\tsurname: "+person.getSurname()+"\tage: "+person.getAge());
    	}
    	
    	
        
    	System.out.println( "koniec!" );
    	Person person1=repo.getPersonId(77);
    	System.out.println("id: "+person1.getId()+"\tname: "+person1.getName()+"\tsurname: "+person1.getSurname()+"\tage: "+person1.getAge());
    }
}
