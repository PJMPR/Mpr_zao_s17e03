package domain;

import dao.PersonRepository;
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
    	
        System.out.println( "koniec!" );
    }
}
