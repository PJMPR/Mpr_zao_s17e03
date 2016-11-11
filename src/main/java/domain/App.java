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
    	
    	Address adres_1 = new Address();
    	Address adres_2 = new Address();
    	Address adres_3 = new Address();
    	
    	jan.setName("jan");
    	jan.setSurname("kowalski");
    	jan.setAge(30);
    	
    	stefan.setName("stefan");
    	stefan.setSurname("nowak");
    	stefan.setAge(30);
    	
    	jacek.setName("jacek");
    	jacek.setSurname("pasek");
    	jacek.setAge(30);
    	
    	adres_1.setCity("Gdańsk");
    	adres_1.setStreetName("Długa");
    	adres_1.setStreetNumber(19);
    	adres_1.setHouseNumber("1");
    	adres_1.setPostcode("80-800");
    	
    	adres_2.setCity("Słupsk");
    	adres_2.setStreetName("Krótka");
    	adres_2.setStreetNumber(20);
    	adres_2.setHouseNumber("2");
    	adres_2.setPostcode("70-700");
    	
    	adres_3.setCity("Katowice");
    	adres_3.setStreetName("Ciemna");
    	adres_3.setStreetNumber(199);
    	adres_3.setHouseNumber("10");
    	adres_3.setPostcode("11-111");
    	
    	repo.add(jan);
    	repo.add(stefan);
    	repo.add(jacek);
    	
    	addressRepo.add(adres_1);
    	addressRepo.add(adres_2);
    	addressRepo.add(adres_3);
    	
    	//repo.delete(stefan);
    	//addressRepo.delete(adres_3);
    	
    	List<Person> people = repo.getAllPersons();
    	for(Person person: people){
       		System.out.println("id: "+person.getId()+"\tname: "+person.getName()+"\tsurname: "+person.getSurname()+"\tage: "+person.getAge());
    	}
    	
    	List<Address> addresses = addressRepo.getAllAddress();
        for(Address address: addresses){
    	     	System.out.println("id: "+address.getId()+"\tulica: "+address.getStreetName()+"\tnumer"+address.getStreetNumber()+"/"+address.getHouseNumber()
        	+"\tKod pocztowy: "+address.getPostcode()+"\tMiejscowość: "+address.getCity());
        }
    	
    	Person person1=repo.getPersonId(3);
    	System.out.println("Osoba o id: "+person1.getId()+"\tImię: "+person1.getName()+"\tNazwisko: "+person1.getSurname()+"\tWiek: "+person1.getAge());
    	
    	Address adres1=addressRepo.getAddressId(0);
    	System.out.println("Adres o id: "+adres1.getId()+"\tMiejscowość: "+adres1.getCity()+"\tUlica: "+adres1.getStreetName()+"\tNumer: "+adres1.getStreetNumber());
    	
    	System.out.println( "koniec!" );
    }
}
