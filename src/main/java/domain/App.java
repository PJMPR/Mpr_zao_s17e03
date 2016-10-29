package domain;

import dao.PersonRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	PersonRepository repo = new PersonRepository();
    	
        System.out.println( "koniec!" );
    }
}
